package sladki.tfc.ab;

import com.dunk.tfc.api.Armor;
import com.dunk.tfc.api.Constant.Global;
import com.dunk.tfc.api.Crafting.AnvilManager;
import com.dunk.tfc.api.Crafting.AnvilRecipe;
import com.dunk.tfc.api.Crafting.AnvilReq;
import com.dunk.tfc.api.Crafting.PlanRecipe;
import com.dunk.tfc.api.Enums.RuleEnum;
import com.dunk.tfc.api.TFCBlocks;
import com.dunk.tfc.api.TFCItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import sladki.tfc.ab.Blocks.*;
import sladki.tfc.ab.Config.ModConfig;
import sladki.tfc.ab.Handlers.Anvil.AnvilPlayerTickEventHandler;
import sladki.tfc.ab.Items.Armor.ItemRoundShield;
import sladki.tfc.ab.Items.*;
import sladki.tfc.ab.TileEntities.TEPotteryKiln;
import sladki.tfc.ab.TileEntities.TESteamBoiler;

import java.util.Map;

public class ModManager {

	//Blocks
	public static Block bellowsDriverBlock;
	public static Block steamBoilerBlock;
	
	public static Block potteryKilnBlock;
	public static Block potteryKilnChamberBlock;
	
	public static Block waterFilterBlock;
	
	//Items
	public static Item[] shieldRegistry = new Item[16];	//16 - 2 is wooden

	public static Item shepherdStaff;

	// Mechanical Parts
	public static Item bellowPiston;
	public static Item wroughtIronSpring;
	public static Item wroughtIronCanister;
	public static Item clothFilter;

	private static AnvilPlayerTickEventHandler playerAnvilTickEventHandler = new AnvilPlayerTickEventHandler();
	
	
	
	public static void loadBlocks() {
		if(ModConfig.ABEnabled) {
			bellowsDriverBlock = new BlockBellowsDriver(Material.iron).setBlockName("BellowsDriver").setHardness(8).setResistance(8);
			steamBoilerBlock = new BlockSteamBoiler(Material.iron).setBlockName("SteamBoiler").setHardness(8).setResistance(8);
		}
		
		if(ModConfig.PKEnabled) {
			potteryKilnBlock = new BlockPotteryKiln(Material.rock).setBlockName("PotteryKiln").setHardness(8).setResistance(8);
			potteryKilnChamberBlock = new BlockPotteryKilnChamber(Material.rock).setBlockName("PotteryKilnChamber").setHardness(8).setResistance(8);
		}
		
		if(ModConfig.WFEnabled) {
			waterFilterBlock = new BlockWaterFilter(Material.iron).setBlockName("WaterFilter").setHardness(8).setResistance(8);
		}
	}
	
	public static void registerBlocks() {
		if(ModConfig.ABEnabled) {
			GameRegistry.registerBlock(bellowsDriverBlock, ItemBlockAutomatedBellows.class, "BellowsDriver");
			GameRegistry.registerBlock(steamBoilerBlock, ItemBlockSteamBoiler.class, "SteamBoiler");
		}
		
		if(ModConfig.PKEnabled) {
			GameRegistry.registerBlock(potteryKilnBlock, ItemBlockPotteryKiln.class, "PotteryKiln");
			GameRegistry.registerBlock(potteryKilnChamberBlock, ItemBlockPotteryKilnChamber.class, "PotteryKilnChamber");
		}
		
		if(ModConfig.WFEnabled) {
			GameRegistry.registerBlock(waterFilterBlock, ItemBlockWaterFilter.class, "WaterFilter");
		}
	}
	
	public static void registerTileEntities() {
		if(ModConfig.ABEnabled) {
			GameRegistry.registerTileEntity(TESteamBoiler.class, "SteamBoiler");
		}
		
		if(ModConfig.PKEnabled) {
			GameRegistry.registerTileEntity(TEPotteryKiln.class, "PotteryKiln");
		}
	}
	
	public static void loadItems() {
		if(ModConfig.shieldsEnabled) {
			int id = 0;
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.bismuthBronzePlate, 0.5f, 0.6f, 0.4f).setUnlocalizedName("bismuthBronzeShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.blackBronzePlate, 0.55f, 0.40f, 0.6f).setUnlocalizedName("blackBronzeShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.blackSteelPlate, 0.25f, 0.25f, 0.25f).setUnlocalizedName("blackSteelShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.blueSteelPlate, 0.35f, 0.4f, 0.9f).setUnlocalizedName("blueSteelShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.bronzePlate, 0.6f, 0.55f, 0.45f).setUnlocalizedName("bronzeShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.copperPlate, 0.7f, 0.4f, 0.3f).setUnlocalizedName("copperShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.wroughtIronPlate, 0.85f, 0.85f, 0.85f).setUnlocalizedName("wroughtIronShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.redSteelPlate, 0.85f, 0.0f, 0.0f).setUnlocalizedName("redSteelShield");
			shieldRegistry[id] = new ItemRoundShield(id++, Armor.steelPlate, 0.45f, 0.5f, 0.55f).setUnlocalizedName("steelShield");

			shieldRegistry[14] = new ItemRoundShield(14, 400, true).setUnlocalizedName("woodenShield");
		}

		if(ModConfig.shepherdStaffEnabled) {
			shepherdStaff = new ItemShepherdStaff().setUnlocalizedName("shepherdStaff");
		}

			// Mechanical Parts
			bellowPiston = new ItemBellowPiston().setUnlocalizedName("bellowPiston");
			wroughtIronSpring = new ItemWroughtIronSpring().setUnlocalizedName("wroughtIronSpring");
			wroughtIronCanister = new ItemWroughtIronCanister().setUnlocalizedName("wroughtIronCanister");
			clothFilter = new ItemClothFilter().setUnlocalizedName("clothFilter");

	}
	
	public static void registerItems() {
		if(ModConfig.shieldsEnabled) {
			int id = 0;
			GameRegistry.registerItem(shieldRegistry[id++], "bismuthBronzeShield");
			GameRegistry.registerItem(shieldRegistry[id++], "blackBronzeShield");
			GameRegistry.registerItem(shieldRegistry[id++], "blackSteelShield");
			GameRegistry.registerItem(shieldRegistry[id++], "blueSteelShield");
			GameRegistry.registerItem(shieldRegistry[id++], "bronzeShield");
			GameRegistry.registerItem(shieldRegistry[id++], "copperShield");
			GameRegistry.registerItem(shieldRegistry[id++], "wroughtIronShield");
			GameRegistry.registerItem(shieldRegistry[id++], "redSteelShield");
			GameRegistry.registerItem(shieldRegistry[id++], "steelShield");
			
			GameRegistry.registerItem(shieldRegistry[14], "woodenShield");
		}

		if(ModConfig.shepherdStaffEnabled) {
			GameRegistry.registerItem(shepherdStaff, "shepherdStaff");
		}
		
			// Mechanical Parts
			GameRegistry.registerItem(bellowPiston, "bellowPiston");
			GameRegistry.registerItem(wroughtIronSpring, "wroughtIronSpring");
			GameRegistry.registerItem(wroughtIronCanister, "wroughtIronCanister");
			GameRegistry.registerItem(clothFilter, "clothFilter");

	}
	
	
	public static void registerRecipes() {
		
		if(ModConfig.ABEnabled) {
			/* ---- Bellows Driver ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bellowsDriverBlock, 1, 0), " W ", "SPS", " W ",
					Character.valueOf('S'), new ItemStack(TFCItems.wroughtIronSheet),
					Character.valueOf('P'), new ItemStack(bellowPiston),
					Character.valueOf('W'), new ItemStack(wroughtIronSpring)
			));
			
			/* ---- Steam Boiler ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(steamBoilerBlock, 1, 0), " C ", "SBS", " C ",
					Character.valueOf('C'), new ItemStack(wroughtIronCanister),
					Character.valueOf('S'), new ItemStack(TFCItems.wroughtIronSheet),
					Character.valueOf('B'), new ItemStack(TFCBlocks.fireBrick)
			));
		}
		
		if(ModConfig.WFEnabled) {
			/* ---- Water Filter ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(waterFilterBlock, 1, 0), " S ", "BCB", " S ",
					Character.valueOf('S'), new ItemStack(TFCItems.burlapCloth, 0, 1),
					Character.valueOf('B'), new ItemStack(TFCItems.bronzeSheet),
					Character.valueOf('C'), new ItemStack(clothFilter)
			));
		}
		
		if(ModConfig.PKEnabled) {
			/* ---- Pottery Kiln ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(potteryKilnBlock, 1, 0), "BBB", "C C", "BBB",
					Character.valueOf('C'), new ItemStack(TFCItems.copperSheet, 0, 1),
					Character.valueOf('B'), new ItemStack(TFCItems.fireBrick, 0, 1)
			));
			
			/* ---- Pottery Kiln Chamber ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(potteryKilnChamberBlock, 1, 0), "B B", "C C", "B B",
					Character.valueOf('C'), new ItemStack(TFCItems.copperSheet, 0, 1),
					Character.valueOf('B'), new ItemStack(TFCItems.fireBrick, 0, 1)
			));
		}
		
		if(ModConfig.shieldsEnabled) {
			/* ---- Wooden Shield ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shieldRegistry[14], 1, 0), " L ", "LAL", " L ",
					Character.valueOf('L'), "logWood",
					Character.valueOf('A'), "itemAxe"
			));
		}
		
		if(ModConfig.shepherdStaffEnabled) {
			/* ---- Shepherd's Staff ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shepherdStaff, 1, 0), "K", "S",
					Character.valueOf('K'), "itemKnife",
					Character.valueOf('S'), new ItemStack(TFCItems.woodenStaff)
			));
		}
		
			/* ---- Bellow Piston ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bellowPiston, 1, 0), " W ", "SPS", " W ",
					Character.valueOf('W'), new ItemStack(TFCItems.wroughtIronSheet),
					Character.valueOf('S'), new ItemStack(wroughtIronSpring),
					Character.valueOf('P'), new ItemStack(Blocks.piston)
			));
			/* ---- Wrought Iron Canister ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wroughtIronCanister, 1, 0), " W ", "WGW", " W ",
					Character.valueOf('W'), new ItemStack(TFCItems.wroughtIronSheet),
					Character.valueOf('G'), new ItemStack(Blocks.glass)
			));
			/* ---- Wrought Iron Spring ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wroughtIronSpring, 4, 0), "K", "W",
					Character.valueOf('W'), new ItemStack(TFCItems.wroughtIronSheet),
					Character.valueOf('K'), "itemKnife"
			));
			/* ---- Burlap Cloth Filter ---- */
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(clothFilter, 1, 0), "K", "B", "K",
					Character.valueOf('B'), new ItemStack(TFCItems.burlapCloth, 0, 1),
					Character.valueOf('K'), "itemKnife"
			));
	}

	public static void registerAnvilRecipes() {
		String metalShieldSmithingPlan = "metalShield";

		Map map = AnvilManager.getInstance().getPlans();
		if(map.containsKey(metalShieldSmithingPlan)) {
			return;
		}

		if(AnvilManager.world == null) {
			return;
		}

		AnvilManager manager = AnvilManager.getInstance();
		manager.addPlan(metalShieldSmithingPlan, new PlanRecipe(new RuleEnum[]{RuleEnum.DRAWANY, RuleEnum.HITSECONDFROMLAST, RuleEnum.PUNCHLAST}));
		manager.addPlan(metalShieldSmithingPlan, new PlanRecipe(new RuleEnum[]{RuleEnum.DRAWANY, RuleEnum.HITSECONDFROMLAST, RuleEnum.PUNCHLAST}));

		int id = 0;
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.BISMUTHBRONZE,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.BLACKBRONZE,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.BLACKSTEEL,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.BLUESTEEL,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.BRONZE,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.COPPER,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.WROUGHTIRON,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.REDSTEEL,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
		manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, metalShieldSmithingPlan, false, AnvilReq.STEEL,
				new ItemStack(shieldRegistry[id++], 1)).addRecipeSkill(Global.SKILL_ARMORSMITH));
	}

	public static AnvilPlayerTickEventHandler getAnvilPlayerTickEventHandler() {
		return playerAnvilTickEventHandler;
	}
	
	public static void sendMessage(EntityPlayer player, IChatComponent message) {
		message.getChatStyle().setColor(EnumChatFormatting.GRAY);
		player.addChatComponentMessage(message);
	}
	
}