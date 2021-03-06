package com.teambrmodding.assistedprogression.managers;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * This file was created for Assisted-Progression
 * <p>
 * Assisted-Progression is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 *
 * @author Paul Davis - pauljoda
 * @since 1/16/2017
 */
public class CraftingRecipeManager {

    public static void preInit() {
        // Crafter
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockCrafter()),
                new ItemStack(Blocks.CRAFTING_TABLE), new ItemStack(Blocks.CHEST), new ItemStack(Blocks.CRAFTING_TABLE));

        // Player Plate
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockPlayerPlate()),
                new ItemStack(Items.BRICK), new ItemStack(Items.BRICK));

        // Redstone Clock
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockRedstoneClock()),
                "SRS",
                "SBS",
                "SRS", 'S', Blocks.STONE, 'R', Items.REDSTONE, 'B', Blocks.REDSTONE_BLOCK);

        // Cheap Magnet
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemManager.itemCheapMagnet()),
                "I I",
                "I I",
                " I ", 'I', "ingotIron"));

        // Electro Magnet
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemManager.itemElectroMagnet()),
                "I I",
                "IRI",
                " I ", 'I', "ingotIron", 'R', "blockRedstone"));

        // Flushable Chest
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockFlushableChest()),
                Blocks.CHEST, Items.FLINT_AND_STEEL);

        // Trash Bags
        GameRegistry.addRecipe(new ItemStack(ItemManager.itemTrashBag(), 1),
                "S S",
                "L L",
                "LLL", 'L', Items.LEATHER, 'S', Items.STRING);

        GameRegistry.addRecipe(new ItemStack(ItemManager.itemHeftyBag(), 1),
                "S S",
                "L L",
                "LLL", 'L', Items.LEATHER, 'S', Items.IRON_INGOT);

        // Grinder
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockGrinder()),
                "SSS",
                "WFW",
                "CCC", 'S', Blocks.STONE, 'F', Items.FLINT, 'C', Blocks.COBBLESTONE, 'W', Blocks.COBBLESTONE_WALL);

        // Spawner Relocator
        GameRegistry.addRecipe(new ItemStack(ItemManager.itemSpawnerRelocator()),
                "  I",
                " S ",
                "E  ", 'I', Items.IRON_INGOT, 'S', Items.STICK, 'E', Items.ENDER_PEARL);

        // Pipette
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemManager.itemPipette()),
                "P  ",
                " P ",
                "  G", 'P', "paneGlass", 'G', "blockGlass"));

        // Block Exchanger
        GameRegistry.addRecipe(new ItemStack(ItemManager.itemExchanger()),
                "  E",
                " S ",
                "G  ", 'E', Items.ENDER_PEARL, 'S', Items.BLAZE_ROD, 'G', Items.GOLD_INGOT);
    }
}
