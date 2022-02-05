package com.example.demigodsanddemons.container;

import com.example.demigodsanddemons.block.DDBlocks;
import com.example.demigodsanddemons.entity.AltarTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nullable;
import java.util.Objects;

public class AltarBlockContainer extends Container {

    public final AltarTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;

    public AltarBlockContainer(final int windowID, final PlayerInventory playerInventory, final AltarTileEntity te){

        super(DDContainerTypes.ALTAR_CONTAINER.get(), windowID);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());

        this.addSlot(new Slot((IInventory) te, 0, 80, 35));
        //main layer inventory

        for(int row = 0; row < 3; row++){

            for(int col = 0; col < 9; col++){

                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));

            }
        }

        for(int col = 0; col < 9; col++){

            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }

    }

    public AltarBlockContainer(final int windowID, final PlayerInventory pLayerInventory, final PacketBuffer data){

       this(windowID, pLayerInventory, getTileEntity(pLayerInventory, data));

    }

    private static AltarTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data){

        Objects.requireNonNull(playerInventory, "Inv is null");
        Objects.requireNonNull(data, "Data is null");
        final TileEntity t = playerInventory.player.world.getTileEntity(data.readBlockPos());

        if(t instanceof  AltarTileEntity){

            return (AltarTileEntity) t;

        }
        else{
            throw new IllegalStateException("Tile Entity is not Correct");
        }

    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, DDBlocks.ALTAR_BLOCK.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;

        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()){
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();
            if(index < AltarTileEntity.slots && !this.mergeItemStack(stack1, AltarTileEntity.slots, this.inventorySlots.size(), true)){
                return ItemStack.EMPTY;
            }

            if(!this.mergeItemStack(stack1, 0, AltarTileEntity.slots, false)){
                return ItemStack.EMPTY;
            }
            if(stack1.isEmpty()){
                slot.putStack(ItemStack.EMPTY);
            }
            else{
                slot.onSlotChanged();
            }
        }
        return stack;
    }
}
