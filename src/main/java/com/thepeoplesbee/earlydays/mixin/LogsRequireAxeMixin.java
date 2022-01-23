package com.thepeoplesbee.earlydays.mixin;

import com.thepeoplesbee.earlydays.item.EarlyDaysAxeItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.tag.BlockTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class LogsRequireAxeMixin extends LivingEntity {
    @Shadow
    @Final
    private PlayerInventory inventory;
    @Inject(
            method = "canHarvest(Lnet/minecraft/block/BlockState;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void canHarvest(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Item heldItem = this.inventory.getMainHandStack().getItem();
        if (BlockTags.LOGS.contains(state.getBlock())){
            cir.setReturnValue(false);
            if (heldItem instanceof AxeItem){
                cir.setReturnValue(true);
            }
            if (heldItem instanceof EarlyDaysAxeItem){
                cir.setReturnValue(true);
            }
        }
    }
    public LogsRequireAxeMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
}