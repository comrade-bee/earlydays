package com.thepeoplesbee.earlydays.util;

import java.util.Map;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMap;

import com.thepeoplesbee.earlydays.EarlyDays;
import com.thepeoplesbee.earlydays.mixin.MatchingStackAccessor;
import com.thepeoplesbee.earlydays.mixin.RecipeFieldAccessor;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame

public class RecipeRemover {
    public static void removeRecipe() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            final RecipeManager mgr = server.getRecipeManager();
            if (!EarlyDays.CONFIG.crafting.enableVanillaTools)
                removeRecipes(mgr, EarlyDays.VANILLA_TOOLS);
        });
    }

    /**
     * Removes all crafting recipes with an output item contained in the specified
     * tag.
     *
     * @param recipeManager The recipe manager
     * @param stack         The ItemStack output of the recipe to remove
     */
    private static void removeRecipes(final RecipeManager recipeManager, final ItemStack stack) {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getOutput();
            return !recipeOutput.isEmpty() && (!stack.isEmpty() && recipeOutput.getCount() == stack.getCount() && recipeOutput.getItem() == stack.getItem() &&ItemStack.areEqual(recipeOutput, stack));
        });
    }

    /**
     * Removes all crafting recipes with an output item contained in the specified
     * tag.
     *
     * @param recipeManager The recipe manager
     * @param tag           The tag
     */
    private static void removeRecipes(final RecipeManager recipeManager, final Tag<Item> tag) {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getOutput();
            return !recipeOutput.isEmpty() && recipeOutput.isIn(tag);
        });
    }

    /**
     * Removes all plank recipes if an ingredient is a log.
     *
     * @param recipeManager The recipe manager
     */
    private static void removePlankRecipes(final RecipeManager recipeManager) {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getOutput();
            for (Ingredient ing : recipe.getIngredients()) {
                for (ItemStack stack : ((MatchingStackAccessor) (Object) ing).getMatchingStacks()) {
                    if (ItemTags.LOGS.contains(stack.getItem())) {
                        return !recipeOutput.isEmpty() && recipeOutput.isIn(ItemTags.PLANKS);
                    }
                }
            }
            return false;
        });
    }

    /**
     * Remove all crafting recipes that match the specified predicate.
     *
     * @param recipeManager The recipe manager
     * @param predicate     The predicate
     * @return The number of recipes removed
     */
    private static int removeRecipes(final RecipeManager recipeManager, final Predicate<Recipe<?>> predicate) {

        final Map<RecipeType<?>, Map<Identifier, Recipe<?>>> existingRecipes;

        final Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipesMap = ((RecipeFieldAccessor) recipeManager).getRecipeField();
        existingRecipes = recipesMap;

        final Object2IntMap<RecipeType<?>> removedCounts = new Object2IntOpenHashMap<>();
        final ImmutableMap.Builder<RecipeType<?>, Map<Identifier, Recipe<?>>> newRecipes = ImmutableMap
                .builder();

        // For each recipe type, create a new map that doesn't contain the recipes to be removed
        existingRecipes.forEach((recipeType, existingRecipesForType) -> {
            // noinspection UnstableApiUsage

            final ImmutableMap<Identifier, Recipe<?>> newRecipesForType = existingRecipesForType.entrySet()
                    .stream().filter(entry -> !predicate.test(entry.getValue()))
                    .collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, Map.Entry::getValue));

            removedCounts.put(recipeType, existingRecipesForType.size() - newRecipesForType.size());
            newRecipes.put(recipeType, newRecipesForType);
        });

        final int removedCount = removedCounts.values().stream().reduce(0, Integer::sum);

        ((RecipeFieldAccessor) recipeManager).setRecipeField(newRecipes.build());

        return removedCount;
    }
}