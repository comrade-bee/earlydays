package cafe.ferret.mc.earlydays.client.render;

import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.client.EarlyDaysClient;
import cafe.ferret.mc.earlydays.client.model.CatfishEntityModel;
import cafe.ferret.mc.earlydays.entity.CatfishEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CatfishEntityRenderer extends MobEntityRenderer<CatfishEntity, CatfishEntityModel<CatfishEntity>> {
    private static final Identifier TEXTURE = new Identifier(EarlyDays.MODID, "textures/entity/fish/catfish.png");

    public CatfishEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CatfishEntityModel<>(context.getPart(EarlyDaysClient.CATFISH_MODEL_LAYER)), 0.3f);
    }

    @Override
    public Identifier getTexture(CatfishEntity catfishEntity) {
        return TEXTURE;
    }
}