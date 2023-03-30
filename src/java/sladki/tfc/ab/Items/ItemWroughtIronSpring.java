package sladki.tfc.ab.Items;

import com.dunk.tfc.Core.TFCTabs;
import com.dunk.tfc.Items.ItemTerra;
import com.dunk.tfc.api.Enums.EnumSize;
import com.dunk.tfc.api.Enums.EnumWeight;
import net.minecraft.client.renderer.texture.IIconRegister;
import sladki.tfc.ab.AutomatedBellows;

public class ItemWroughtIronSpring extends ItemTerra {

    public ItemWroughtIronSpring() {
        super();
        setCreativeTab(TFCTabs.TFC_MISC);
        setWeight(EnumWeight.MEDIUM);
        setSize(EnumSize.MEDIUM);
        maxStackSize = 16;
    }

    @Override
    public void registerIcons(IIconRegister registerer) {
        itemIcon = registerer.registerIcon(AutomatedBellows.MODID + ":wroughtIronSpring");
    }

    @Override
    public boolean canStack() {
        return true;
    }
}
