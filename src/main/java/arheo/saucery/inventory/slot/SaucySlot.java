package arheo.saucery.inventory.slot;

import arheo.saucery.inventory.SaucyItemStackHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SaucySlot extends SlotItemHandler {
    protected boolean saucy = false;

    public SaucySlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);

        // mmm-mm! delicious.
        if (itemHandler instanceof SaucyItemStackHandler) {
            saucy = true;
        }
    }

    public SaucyItemStackHandler getItemHandlerSaucy() {
        return this.saucy ? (SaucyItemStackHandler)this.getItemHandler() : null;
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        if (saucy) {
            return this.getItemHandlerSaucy().canInsert(stack, this.getSlotIndex()) && super.isItemValid(stack);
        }
        return super.isItemValid(stack);
    }

    @Override
    public void putStack(@Nonnull ItemStack stack) {
        super.putStack(stack);
    }

    @Override
    public int getSlotStackLimit() {
        return super.getSlotStackLimit();
    }

    @Override
    public boolean canTakeStack(EntityPlayer playerIn) {
        return super.canTakeStack(playerIn);
    }
}
