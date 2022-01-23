package com.thepeoplesbee.earlydays.item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import java.util.function.Supplier;

public enum EarlyDaysToolMaterials implements ToolMaterial {
    FLINT(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.ofItems(Items.FLINT);
    }),
    BONE(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.ofItems(Items.BONE);
    }),
    COPPER(1, 131, 4.0F, 1.0F, 15, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    });
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;
    private EarlyDaysToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }
    public int getDurability() {
        return this.itemDurability;
    }
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }
    public float getAttackDamage() {
        return this.attackDamage;
    }
    public int getMiningLevel() {
        return this.miningLevel;
    }
    public int getEnchantability() {
        return this.enchantability;
    }
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
