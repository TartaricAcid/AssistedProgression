package com.teambrmodding.assistedprogression.client

import com.teambrmodding.assistedprogression.client.models.ModelPipette
import com.teambrmodding.assistedprogression.client.renderers.tiles.{TileFlushableChestRenderer, TileGrinderRenderer}
import com.teambrmodding.assistedprogression.common.CommonProxy
import com.teambrmodding.assistedprogression.common.tiles.TileGrinder
import com.teambrmodding.assistedprogression.common.tiles.storage.TileFlushableChest
import com.teambrmodding.assistedprogression.managers.{BlockManager, ItemManager}
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.ItemMeshDefinition
import net.minecraft.client.renderer.block.model.{ModelBakery, ModelManager}
import net.minecraft.item.ItemStack
import net.minecraftforge.client.model.{ModelLoader, ModelLoaderRegistry}
import net.minecraftforge.fml.client.registry.ClientRegistry

/**
  * This file was created for AssistedProgression
  *
  * AssistedProgression is licensed under the
  * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
  * http://creativecommons.org/licenses/by-nc-sa/4.0/
  *
  * @author Dyonovan
  * @since 1/16/2017
  */
class ClientProxy extends CommonProxy {

    override def preInit(): Unit = {
        ItemRenderManager.preInit()

        // Pipette Models

        ModelLoader.setCustomMeshDefinition(ItemManager.itemPipette, new ItemMeshDefinition {
            override def getModelLocation(stack: ItemStack) = ModelPipette.LOCATION
        })
        ModelBakery.registerItemVariants(ItemManager.itemPipette, ModelPipette.LOCATION)

        ModelLoaderRegistry.registerLoader(ModelPipette.LoaderDynPipette.INSTANCE)
    }

    override def init(): Unit = {
        ItemRenderManager.registerItemRenderers()

        // Flushable Chest
        Minecraft.getMinecraft.getRenderItem.getItemModelMesher.getModelManager.getBlockModelShapes.registerBuiltInBlocks(BlockManager.blockFlushableChest)
        ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileFlushableChest], new TileFlushableChestRenderer[TileFlushableChest])

        // Grinder
        ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileGrinder], new TileGrinderRenderer[TileGrinder])
    }

    override def postInit(): Unit = { }
}
