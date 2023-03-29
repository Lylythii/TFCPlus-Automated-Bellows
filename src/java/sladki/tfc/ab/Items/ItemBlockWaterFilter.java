package sladki.tfc.ab.Items;

import com.dunk.tfc.Core.TFCTabs;
import com.dunk.tfc.Items.ItemBlocks.ItemTerraBlock;
import com.dunk.tfc.api.Enums.EnumSize;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockWaterFilter extends ItemTerraBlock {
	
	public ItemBlockWaterFilter(Block block) {
		super(block);
		this.setCreativeTab(TFCTabs.TFC_DEVICES);
	}

	@Override
	public EnumSize getSize(ItemStack is) {
		return EnumSize.HUGE;
	}

}