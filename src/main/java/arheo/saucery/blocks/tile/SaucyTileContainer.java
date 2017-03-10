package arheo.saucery.blocks.tile;

import arheo.saucery.util.StackUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.ILockableContainer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SaucyTileContainer extends SaucyTile {
    public final ItemStackHandler inventory;

    public SaucyTileContainer(int slots) {
        super();
        inventory = new ItemStackHandler(slots);
    }

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        this.readInventory(tag);
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tag) {
        this.writeInventory(tag);
    }

    public void writeInventory(NBTTagCompound tag) {
        if (inventory == null || inventory.getSlots() <= 0) {
            return;
        }
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (StackUtils.isValid(stack)) {
                NBTTagCompound entry = new NBTTagCompound();
                entry.setInteger("id", i);
                NBTTagCompound thing = new NBTTagCompound();
                stack.writeToNBT(thing);
                entry.setTag("thingy", thing);
                list.appendTag(entry);
            }
        }
        tag.setTag("items", list);
    }

    public void readInventory(NBTTagCompound tag) {
        if (inventory == null || inventory.getSlots() <= 0) {
            return;
        }
        NBTTagList list = tag.getTagList("items", 10);
        for(int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound entry = list.getCompoundTagAt(i);
            int id = entry.getInteger("id");
            NBTTagCompound thing = entry.getCompoundTag("thingy");
            if(thing != null && thing.hasKey("id")) {
                ItemStack stack = new ItemStack(thing);
                inventory.setStackInSlot(id, stack);
            }
        }
    }

    @Override
    public IItemHandler getItemHandler(EnumFacing facing) {
        return inventory;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

}

