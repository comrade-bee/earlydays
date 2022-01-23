package com.thepeoplesbee.earlydays.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame

@Mixin(RecipeManager.class)
public interface RecipeFieldAccessor {
    @Accessor("recipes")
    public Map<RecipeType<?>, Map<Identifier, Recipe<?>>> getRecipeField();

    @Accessor("recipes")
    public void setRecipeField(Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipe);
}