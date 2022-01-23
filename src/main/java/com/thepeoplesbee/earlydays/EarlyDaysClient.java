package com.thepeoplesbee.earlydays;

import com.thepeoplesbee.earlydays.client.model.CatfishEntityModel;
import com.thepeoplesbee.earlydays.client.render.CatfishEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EarlyDaysClient implements ClientModInitializer {
    public static final EntityModelLayer CATFISH_MODEL_LAYER = new EntityModelLayer(new Identifier(EarlyDays.MODID, "catfish"), "main");
    public static void registerColors(){}
    private static void registerBlockColors(){}
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.WICKER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.BAMBOO_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.DRIED_BAMBOO_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.WICKER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.BAMBOO_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.DRIED_BAMBOO_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.BLUEBELLS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.WEEPING_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.RED_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.SELF_HEAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.RAFFLESIA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.THORNS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.WILD_ALOE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.WITHERCAP_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.BARGAIN_BELL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.GREEN_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.EARTHSTAR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.GLOWSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.MILKCAP_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.BROWN_MUSHROOMS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.RED_MUSHROOMS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.ASSORTED_MUSHROOMS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.AMETHYST_DECEIVERS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.PEPPERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.COTTON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.FLAX, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.GINGERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.ALOE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDays.OBSIDIAN_ROOTS, RenderLayer.getCutout());

        EntityRendererRegistry.register(EarlyDays.CATFISH_ENTITY, (context) -> {return new CatfishEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(CATFISH_MODEL_LAYER, CatfishEntityModel::getTexturedModelData);
    }
}