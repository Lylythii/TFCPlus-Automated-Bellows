package sladki.tfc.ab.Handlers.Anvil;

import com.dunk.tfc.api.Constant.Global;
import com.dunk.tfc.api.Crafting.AnvilManager;
import com.dunk.tfc.api.Crafting.AnvilRecipe;
import com.dunk.tfc.api.Crafting.AnvilReq;
import com.dunk.tfc.api.Events.AnvilCraftEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import sladki.tfc.ab.Items.Armor.ItemRoundShield;

public class AnvilCraftEventHandler {

    private static final AnvilRecipe shieldRecipeDummy = new AnvilRecipe(null, null, false, AnvilReq.STONE).addRecipeSkill(Global.SKILL_ARMORSMITH);

    @SubscribeEvent
    public void onAnvilCraftEvent(AnvilCraftEvent event) {
        if(event.result != null && event.result.getItem() instanceof ItemRoundShield) {
            AnvilManager.setDurabilityBuff(event.result, shieldRecipeDummy.getSkillMult((EntityPlayer) event.entity));
        }
    }

}
