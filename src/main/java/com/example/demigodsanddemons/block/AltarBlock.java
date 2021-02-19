package com.example.demigodsanddemons.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AltarBlock extends Block {

    public AltarBlock(){
        super(AbstractBlock.Properties.create(Material.ROCK)
                .hardnessAndResistance(5)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }
}
