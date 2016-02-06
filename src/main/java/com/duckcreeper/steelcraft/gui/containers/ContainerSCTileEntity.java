package com.duckcreeper.steelcraft.gui.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com.duckcreeper.steelcraft.gui.GuiSCTileEntity;
//import com.duckcreeper.steelcraft.gui.slots.SlotSCTile;
import com.duckcreeper.steelcraft.tileentity.SCTileEntity;

public class ContainerSCTileEntity extends Container
{
	private IInventory SCInventory;
    private EntityPlayer player;

	public ContainerSCTileEntity(IInventory playerInventory, IInventory scInventory, int xSize, int ySize)
	{
		this.SCInventory = scInventory;
		scInventory.openInventory(null);
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				this.addSlotToContainer(new Slot(scInventory, j + i * 5, j * 18 + 44, i * 18 + 18));
			}
		}

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 85));
			}
		}

		for (int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(playerInventory, i, i * 18 + 8, 143));
		}
	}


	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer)
	{
		return this.SCInventory.isUseableByPlayer(entityPlayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotNum)
	{
		ItemStack itemCopy = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNum);

		if (slot != null && slot.getHasStack())
		{
			ItemStack item = slot.getStack();
			itemCopy = item.copy();

			if (slotNum < 15)
			{
				if (!this.mergeItemStack(item, 15, this.inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(item, 0, 15, false))
			{
				return null;
			}

			if (item.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}

		return itemCopy;
	}

	@Override
	public void onContainerClosed(EntityPlayer entityPlayer)
	{
		super.onContainerClosed(entityPlayer);
		this.SCInventory.closeInventory(entityPlayer);
	}
	
    public EntityPlayer getPlayer()
    {
        return player;
    }
}