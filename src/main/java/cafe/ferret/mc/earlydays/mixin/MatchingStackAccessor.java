package cafe.ferret.mc.earlydays.mixin;


import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame
@Mixin(Ingredient.class)
public interface MatchingStackAccessor {
    @Accessor("matchingStacks")
    ItemStack[] getMatchingStacks();
}