package arheo.saucery.blocks.tile;

import arheo.saucery.Saucery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;


import java.util.Random;

public class TileCore extends SaucyTileContainer implements ITickable {

    protected static final Random rand = new Random();

    public TileCore() {
        super(1);
    }

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        super.readCustomNBT(tag);
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tag) {
        super.writeCustomNBT(tag);
    }

    @Override
    public void update()
    {
        this.updateBook();
    }

    // ############### slots ############### //

    @Override
    public boolean canInsertItem(ItemStack stack, int slot) {
        return stack.getItem() == Items.BOOK;
    }



    @Override
    public int getStackSizeLimit(int slot) {
        return 1;
    }

    // ############### book stuff ############### //

    public int tickCount;
    public float pageFlip;
    public float pageFlipPrev;
    public float flipT;
    public float flipA;
    public float bookSpread;
    public float bookSpreadPrev;
    public float bookRotation;
    public float bookRotationPrev;
    public float tRot;

    protected void updateBook() {
        this.bookSpreadPrev = this.bookSpread;
        this.bookRotationPrev = this.bookRotation;
        EntityPlayer entityplayer = this.world.getClosestPlayer((double)((float)this.pos.getX() + 0.5F), (double)((float)this.pos.getY() + 0.5F), (double)((float)this.pos.getZ() + 0.5F), 3.0D, false);

        if (entityplayer != null)
        {
            double d0 = entityplayer.posX - (double)((float)this.pos.getX() + 0.5F);
            double d1 = entityplayer.posZ - (double)((float)this.pos.getZ() + 0.5F);
            this.tRot = (float) MathHelper.atan2(d1, d0);
            this.bookSpread += 0.1F;

            if (this.bookSpread < 0.5F || rand.nextInt(40) == 0)
            {
                float f1 = this.flipT;

                while (true)
                {
                    this.flipT += (float)(rand.nextInt(4) - rand.nextInt(4));

                    if (f1 != this.flipT)
                    {
                        break;
                    }
                }
            }
        }
        else
        {
            this.tRot += 0.02F;
            this.bookSpread -= 0.1F;
        }

        while (this.bookRotation >= (float)Math.PI)
        {
            this.bookRotation -= ((float)Math.PI * 2F);
        }

        while (this.bookRotation < -(float)Math.PI)
        {
            this.bookRotation += ((float)Math.PI * 2F);
        }

        while (this.tRot >= (float)Math.PI)
        {
            this.tRot -= ((float)Math.PI * 2F);
        }

        while (this.tRot < -(float)Math.PI)
        {
            this.tRot += ((float)Math.PI * 2F);
        }

        float f2;

        for (f2 = this.tRot - this.bookRotation; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F))
        {
            ;
        }

        while (f2 < -(float)Math.PI)
        {
            f2 += ((float)Math.PI * 2F);
        }

        this.bookRotation += f2 * 0.4F;
        this.bookSpread = MathHelper.clamp(this.bookSpread, 0.0F, 1.0F);
        ++this.tickCount;
        this.pageFlipPrev = this.pageFlip;
        float f = (this.flipT - this.pageFlip) * 0.4F;
        float f3 = 0.2F;
        f = MathHelper.clamp(f, -0.2F, 0.2F);
        this.flipA += (f - this.flipA) * 0.9F;
        this.pageFlip += this.flipA;
    }

    //TEMPSTUFF

    public int findMyAltars(){
        int bx = pos.getX();
        int by = pos.getY();
        int bz = pos.getZ();
        //int altarnum = 0;
        int altars = 0;

        for(int x = -2; x < 3; x++){
            for(int z = -2; z < 3; z++){
                if(x != -1 && x != 0 && x != 1 && z != -1 && z != 0 && z != 1) {
                    BlockPos bpos = new BlockPos(bx+x, by, bz+z);
                    if(world.getBlockState(bpos).getBlock() == Blocks.COBBLESTONE) {
                        altars++;
                    }
                }
            }
        }
        Saucery.logger.info(altars);
        return altars;

    }

    //TEMPSTUFF

}
