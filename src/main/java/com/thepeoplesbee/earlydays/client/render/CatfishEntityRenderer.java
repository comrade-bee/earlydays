package com.thepeoplesbee.earlydays.client.render;

import com.thepeoplesbee.earlydays.EarlyDays;
import com.thepeoplesbee.earlydays.EarlyDaysClient;
import com.thepeoplesbee.earlydays.client.model.CatfishEntityModel;
import com.thepeoplesbee.earlydays.entity.CatfishEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
@Environment(EnvType.CLIENT)
public class CatfishEntityRenderer extends MobEntityRenderer<CatfishEntity, CatfishEntityModel<CatfishEntity>> {
    private static final Identifier TEXTURE = new Identifier(EarlyDays.MODID, "textures/entity/fish/catfish.png");

    public CatfishEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CatfishEntityModel(context.getPart(EarlyDaysClient.CATFISH_MODEL_LAYER)), 0.3f);
    }
    @Override
    public Identifier getTexture(CatfishEntity catfishEntity) {
        return TEXTURE;
    }
}