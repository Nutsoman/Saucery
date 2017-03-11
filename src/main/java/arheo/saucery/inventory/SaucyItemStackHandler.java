package arheo.saucery.inventory;

import arheo.saucery.util.StackUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public abstract class SaucyItemStackHandler<T extends SaucyItemStackHandler.IProvider> extends ItemStackHandler {

    protected final T provider;

    public SaucyItemStackHandler(T provider) {
        this(provider, 1);
    }

    public SaucyItemStackHandler(T provider, int size) {
        super(size);
        this.provider = provider;
    }

    public SaucyItemStackHandler(T provider, NonNullList<ItemStack> stacks) {
        super(stacks);
        this.provider = provider;
    }

    public boolean canInsert(ItemStack stack, int slot) {
        return this.provider.canInsertItem(stack, slot);
    }

    public boolean canExtract(ItemStack stack, int slot) {
        return this.provider.canExtractItem(stack, slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (!this.canInsert(stack, slot)) {
            return stack;
        }

        return super.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (!this.canExtract(this.getStackInSlot(slot), slot)) {
            return ItemStack.EMPTY;
        }

        return super.extractItem(slot, amount, simulate);
    }

    @Override
    public int getSlotLimit(int slot) {
        return this.provider.getStackSizeLimit(slot);
    }

    //######################################################################################

    public static void readInventory(ItemStackHandler inventory, NBTTagCompound tag) {
        if (inventory == null || inventory.getSlots() <= 0) {
            return;
        }
        NBTTagList list = tag.getTagList("items", 10);
        for(int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound entry = list.getCompoundTagAt(i);
            int id = entry.getInteger("id");
            NBTTagCompound item = entry.getCompoundTag("item");
            if(item != null && item.hasKey("id")) {
                ItemStack stack = new ItemStack(item);
                inventory.setStackInSlot(id, stack);
            }
        }
    }

    public static void writeInventory(ItemStackHandler inventory, NBTTagCompound tag) {
        if (inventory == null || inventory.getSlots() <= 0) {
            return;
        }
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (StackUtils.isValid(stack)) {
                NBTTagCompound entry = new NBTTagCompound();
                entry.setInteger("id", i);
                NBTTagCompound item = new NBTTagCompound();
                stack.writeToNBT(item);
                entry.setTag("item", item);
                list.appendTag(entry);
            }
        }
        tag.setTag("items", list);
    }

    public interface IProvider {

        default boolean canInsertItem(ItemStack stack, int slot) {
            return true;
        }

        default boolean canExtractItem(ItemStack stack, int slot) {
            return true;
        }

        default int getStackSizeLimit(int slot) {
            return 64;
        }
    }
}
