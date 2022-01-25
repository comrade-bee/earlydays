package cafe.ferret.mc.earlydays.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CatfishEntityModel<T extends Entity> extends SinglePartEntityModel<T> {
    private static final String BODY_FRONT = "body_front";
    private static final String BODY_BACK = "body_back";
    private final ModelPart root;
    private final ModelPart tail;

    public CatfishEntityModel(ModelPart root) {
        this.root = root;
        this.tail = root.getChild("body_back");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        //upper_back
        ModelPartData modelPartData2 = modelPartData.addChild("body_front", ModelPartBuilder.create().uv(0, 7).cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 4.0F, 8.0F), ModelTransform.pivot(0.0F, 20.0F, 0.0F));
        modelPartData2.addChild("top_fin1", ModelPartBuilder.create().uv(0, 11).cuboid(0f, -4.5f, 6f, 0f, 2f, 2f), ModelTransform.pivot(0f, 0f, 0f));
        modelPartData2.addChild("left_front_fin", ModelPartBuilder.create().uv(16, 19).cuboid(0.0F, -1.0F, 0.0F, 3.0F, 0.0F, 2.0F), ModelTransform.of(2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.7854F));
        modelPartData2.addChild("right_front_fin", ModelPartBuilder.create().uv(16, 21).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 0.0F, 2.0F), ModelTransform.of(-2.0F, 1.0F, 2.0F, 0.0F, 0.0F, -0.7854F));
        //lower_back
        ModelPartData modelPartData3 = modelPartData.addChild("body_back", ModelPartBuilder.create().uv(0, 19).cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 4.0F, 8.0F), ModelTransform.pivot(0.0F, 20.0F, 8.0F));
        modelPartData3.addChild("tail", ModelPartBuilder.create().uv(18, 4).cuboid(0f, -10f, -4, 0f, 5f, 6f), ModelTransform.pivot(0.0f, 6.0f, 12.0f));
        modelPartData3.addChild("top_fin2", ModelPartBuilder.create().uv(0, 6).cuboid(0f, -4.5f, 0f, 0f, 2f, 3f), ModelTransform.pivot(0f, 0f, 0f));
        modelPartData3.addChild("top_fin3", ModelPartBuilder.create().uv(4, 11).cuboid(0f, -4.5f, 3f, 0f, 2f, 2f), ModelTransform.pivot(0f, 0f, 0f));
        modelPartData3.addChild("left_back_fin", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 0.0F, 2.0F), ModelTransform.of(2.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.7854F));
        modelPartData3.addChild("right_back_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 0.0F, 2.0F), ModelTransform.of(-2.0F, 1.0F, 5.0F, 0.0F, 0.0F, -0.7854F));
        //head
        ModelPartData modelPartData4 = modelPartData2.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5f, -2f, -4f, 5f, 3f, 4f), ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        modelPartData2.addChild("left_barb", ModelPartBuilder.create().uv(12, 0).cuboid(-1.7071F, -1.0F, -0.7071F, 4.0F, 0.0F, 2.0F), ModelTransform.of(3.7247F, 1.0F, -2.8411F, 0.0F, -0.2618F, 0.0F));
        modelPartData2.addChild("right_barb", ModelPartBuilder.create().uv(12, 2).cuboid(-4.7071F, -1.0F, -0.7071F, 4.0F, 0.0F, 2.0F), ModelTransform.of(-1.3928F, 1.0F, -3.4659F, 0.0F, 0.2618F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float f = 1.0F;
        float g = 1.0F;
        if (!entity.isTouchingWater()) {
            f = 1.3F;
            g = 1.7F;
        }

        this.tail.yaw = -f * 0.25F * MathHelper.sin(g * 0.6F * animationProgress);
    }
}
