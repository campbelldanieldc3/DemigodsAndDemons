package com.example.demigodsanddemons.block;

import com.example.demigodsanddemons.entity.DDTileEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AltarBlock extends Block{

    public AltarBlock(){
        super(AbstractBlock.Properties.create(Material.ROCK)
                .hardnessAndResistance(5)
                .harvestTool(ToolType.PICKAXE).sound(SoundType.BASALT)
                .setRequiresTool());
    }

    @Override
    public boolean hasTileEntity(BlockState state){

        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world){

        return DDTileEntities.ANIMA_STORAGE_ENTITY.get().create();

    }



}
