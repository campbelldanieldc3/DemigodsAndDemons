package com.example.demigodsanddemons.entity;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.container.AltarBlockContainer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.extensions.IForgeTileEntity;


public class AltarTileEntity extends LockableLootTileEntity {

    public static int slots = 1;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    public AltarTileEntity(TileEntityType<?> tileEntityTypeIn) {

        super(tileEntityTypeIn);

    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("containter." + DemigodsAndDemons.MODID + ".altar_block");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new AltarBlockContainer(id, player, this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    @Override
    public CompoundNBT getUpdateTag(){

        return write(new CompoundNBT());
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt){
        super.write(nbt);

        if(!this.checkLootAndWrite(nbt)){
            ItemStackHelper.saveAllItems(nbt, this.items);
        }

        return nbt;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt){

        super.read(state, nbt);

        this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);

        if(!this.checkLootAndRead(nbt)){
            ItemStackHelper.loadAllItems(nbt, this.items);
        }

    }


    public AltarTileEntity(){
        this(DDTileEntities.ANIMA_STORAGE_ENTITY.get());
    }


    @Override
    public int getSizeInventory() {
        return slots;
    }
}
