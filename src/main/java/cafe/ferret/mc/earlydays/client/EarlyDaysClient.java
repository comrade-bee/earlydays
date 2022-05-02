package cafe.ferret.mc.earlydays.client;

import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.client.model.CatfishEntityModel;
import cafe.ferret.mc.earlydays.client.render.CatfishEntityRenderer;
import cafe.ferret.mc.earlydays.init.EarlyDaysBlocks;
import cafe.ferret.mc.earlydays.init.EarlyDaysEntities;
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

    public static void registerColors() {
    }

    private static void registerBlockColors() {
    }

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.WICKER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.BAMBOO_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.DRIED_BAMBOO_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.WICKER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.BAMBOO_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.DRIED_BAMBOO_TRAPDOOR, RenderLayer.getCutout());

        //BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.WHEEL_LOOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.DRYING_RACK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.FLOWER_BUNDLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.TRANS_BUNDLE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.WEEPING_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.SELF_HEAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.RAFFLESIA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.THORNS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.WILD_ALOE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.WITHERCAP_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.BARGAIN_BELL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.PEPPERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.FLAX, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.GINGERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.ALOE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EarlyDaysBlocks.OBSIDIAN_ROOTS, RenderLayer.getCutout());

        EntityRendererRegistry.register(EarlyDaysEntities.CATFISH_ENTITY, CatfishEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CATFISH_MODEL_LAYER, CatfishEntityModel::getTexturedModelData);
    }
}