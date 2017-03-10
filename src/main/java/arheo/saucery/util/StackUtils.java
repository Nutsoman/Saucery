package arheo.saucery.util;

import net.minecraft.item.ItemStack;

public final class StackUtils {
    public static boolean isValid(ItemStack stack) {
        return stack != null && !stack.isEmpty();
    }
}
