package com.example.demigodsanddemons.block;

import com.example.demigodsanddemons.entity.DDTileEntities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

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

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType onBlockActivated(BlockState state, final World world, BlockPos pos, PlayerEntity playerEntity, Hand handIn, BlockRayTraceResult hit){

        ItemStack held = playerEntity.getHeldItem(handIn);
        if(held.equals(ItemStack.EMPTY)){
            System.out.println("He touched the butt.");
            //create a new GUI for Anima Storage + Blessings System
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand){

    }





}
