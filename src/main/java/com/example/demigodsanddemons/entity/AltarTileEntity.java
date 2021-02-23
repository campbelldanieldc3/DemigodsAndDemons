package com.example.demigodsanddemons.entity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeTileEntity;


public class AltarTileEntity extends TileEntity implements IForgeTileEntity {


    public AltarTileEntity(TileEntityType<?> tileEntityTypeIn) {

        super(tileEntityTypeIn);

    }

    @Override
    public CompoundNBT getUpdateTag(){

        return write(new CompoundNBT());
    }


    public AltarTileEntity(){
        this(DDTileEntities.ANIMA_STORAGE_ENTITY.get());
    }




}
