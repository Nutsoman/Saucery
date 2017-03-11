package arheo.saucery.inventory;

import arheo.saucery.blocks.tile.SaucyTileContainer;

public class TileItemStackHandler extends SaucyItemStackHandler<SaucyTileContainer> {
    public TileItemStackHandler(SaucyTileContainer provider, int size) {
        super(provider, size);
    }

    @Override protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);
        provider.markDirty();
    }
}
