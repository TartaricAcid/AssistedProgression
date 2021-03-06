package com.teambrmodding.assistedprogression.managers

import com.teambrmodding.assistedprogression.common.items._
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.OreDictionary

/**
  * This file was created for Assisted-Progression
  *
  * Assisted-Progression is licensed under the
  * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
  * http://creativecommons.org/licenses/by-nc-sa/4.0/
  *
  * @author Paul Davis - pauljoda
  * @since 1/16/2017
  */
object ItemManager {

    // Magnets
    val itemCheapMagnet  = new ItemMagnet(true, "itemCheapMagnet")
    val itemElectroMagnet = new ItemMagnet(false, "itemElectroMagnet")

    // Trash Bags
    val itemTrashBag = new ItemTrashBag("itemTrashBag", 1)
    val itemHeftyBag = new ItemTrashBag("itemHeftyBag", 18)

    // Spawner Relocator
    val itemSpawnerRelocator = new ItemSpanwerRelocator

    // Block Exchanger
    val itemExchanger = new ItemExchanger

    // Pipette
    val itemPipette = new ItemPipette

    def preInit(): Unit = {
        registerItem(itemCheapMagnet, "itemCheapMagnet")
        registerItem(itemElectroMagnet, "itemElectroMagnet")

        registerItem(itemTrashBag, "itemTrashBag")
        registerItem(itemHeftyBag, "itemHeftyBag")

        registerItem(itemSpawnerRelocator, "itemSpawnerRelocator")

        registerItem(itemExchanger, "itemExchanger")

        registerItem(itemPipette, "itemPipette")
    }

    /**
      * Helper method to register items
      *
      * @param item The item to register
      * @param name The name of the item
      * @param oreDict The ore dict tag
      */
    def registerItem(item: Item, name: String, oreDict: String) : Item = {
        GameRegistry.registerItem(item, name)
        if (oreDict != null) OreDictionary.registerOre(oreDict, item)
        item
    }

    def registerItem(item: Item, name: String) : Item = {
        registerItem(item, name, null)
    }

    def registerItem(item: Item, name: String, oreDict: String, itemDamage: Int) : Item = {
        GameRegistry.registerItem(item, name)
        if (oreDict != null) OreDictionary.registerOre(oreDict, new ItemStack(item, 1, itemDamage))
        item
    }
}
