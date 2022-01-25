package cafe.ferret.mc.earlydays.mixin;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

//CODE USED UNDER THE MIT LICENSE FROM RECIPE IMPROVER https://github.com/antlilja/recipe_improver
@Mixin(Recipe.class)
public interface IgnoreAirRecipesMixin<C extends Inventory> {

    /**
     * @reason ModifyConstant can't be used on interfaces :(
     * @author signekatt (Anton Lilja)
     */
    @SuppressWarnings("unchecked")
    @Overwrite
    default boolean isIgnoredInRecipeBook() {
        return ((Recipe<C>) this).getOutput().getItem() == Items.AIR;
    }
}