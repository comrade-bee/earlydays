package cafe.ferret.mc.earlydays.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class EarlyDaysFoodComponents {
    public static final FoodComponent MEAT_BITS = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 1), 1.0f).meat().build();
    public static final FoodComponent PEPPER = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent GINGER = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.2F).build();
    public static final FoodComponent COFFEE = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 1.0f).alwaysEdible().build();
    public static final FoodComponent TEA = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.1F).build();
    public static final FoodComponent HERBAL_TEA = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.1F).build();
    public static final FoodComponent CHILI = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 300, 0), 1.0f).build();
    public static final FoodComponent CORRODING_SOLUTION = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.0f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 6, 1), 1.0f).alwaysEdible().build();
    public static final FoodComponent TANNING_SOLUTION = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.0f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 3, 1), 1.0f).alwaysEdible().build();
    public static final FoodComponent ELIXIR = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 150, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 0), 1.0f).alwaysEdible().build();
    public static final FoodComponent HEARTY_ELIXIR = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 0), 1.0f).alwaysEdible().build();
    public static final FoodComponent ENLIGHTENING_ELIXIR = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 150, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 0), 1.0f).alwaysEdible().build();

    public static final FoodComponent SALVE = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 0), 1.0f).alwaysEdible().build();
}