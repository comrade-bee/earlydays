package cafe.ferret.mc.earlydays.block;

import net.minecraft.block.CropBlock;

public class EarlyDaysWildCrop extends CropBlock {
    public EarlyDaysWildCrop(Settings settings) {
        super(settings);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}
