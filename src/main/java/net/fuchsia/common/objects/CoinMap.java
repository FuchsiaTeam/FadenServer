package net.fuchsia.common.objects;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.fuchsia.common.init.FadenItems;
import net.fuchsia.common.objects.item.coin.CoinItem;
import net.fuchsia.datagen.FadenDataItem;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoinMap {

	public static TreeMap<Integer, Item> COINS = new TreeMap<>(Collections.reverseOrder());

	public static void reloadCoins() {
		COINS.clear();
		for (FadenDataItem item : FadenItems.ITEMS) {
			if(item.item() instanceof CoinItem coinItem) {
				COINS.put(coinItem.getValue(), item.item());
			}
		}
	}

	/*
	 * ordered is faster, but gives higher coins
	 */
	public static void removeCurrency(World world, BlockPos pos, Inventory inventory, int amount, boolean order) {
		if (order) {
			int currentAmount = countCurrency(inventory);
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.getStack(i).getItem() instanceof CoinItem) {
					inventory.setStack(i, Items.AIR.getDefaultStack());
				}
			}
			addCurrency(world, pos, inventory, currentAmount - amount);
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				if (amount == 0) {
					break;
				}
				if (inventory.getStack(i).getItem() instanceof CoinItem coinItem) {
					ItemStack itemStack = inventory.getStack(i);
					int value = coinItem.getValue();
					int count = itemStack.getCount();
					int total = value * count;
					if (amount >= total) {
						inventory.setStack(i, Items.AIR.getDefaultStack());
						amount -= total;
					} else {
						int numCoins = Math.floorDiv(amount, value);
						itemStack.setCount(count - numCoins);
						inventory.setStack(i, itemStack);
						amount -= (numCoins*value);
					}
				}
			}
			if(amount > 0){
				for (int i = 0; i < inventory.size(); i++) {
					if (inventory.getStack(i).getItem() instanceof CoinItem coinItem) {
						ItemStack itemStack = inventory.getStack(i);
						int value = coinItem.getValue();
						int count = itemStack.getCount();
						if (amount < value) {
							itemStack.setCount(count - 1);
							inventory.setStack(i, itemStack);
							amount -= value;
							addCurrency(world, pos, inventory, -amount);
							break;
						}
					}
				}
			}
		}
	}

	public static void sortCurrency(World world, BlockPos pos, Inventory inventory) {
		int amount = countCurrency(inventory);
		removeCurrency(world, pos, inventory, amount, true);
		addCurrency(world, pos, inventory, amount);
	}


	public static void addCurrency(World world, BlockPos pos, Inventory inventory, int amount) {
		if(amount < 1) return;
		Map<Item, Integer> itemStacks = generateCoinItemStacks(amount);
		boolean drop = false;
		for (Item item : itemStacks.keySet()) {
			ItemStack itemStack = item.getDefaultStack();
			itemStack.setCount(itemStacks.get(item));
			if(inventory instanceof PlayerInventory playerInventory) {
				playerInventory.offerOrDrop(itemStack);
			} else {
				for (int i = 0; i < inventory.size(); i++) {
					if(i >= inventory.size()) {
						drop = true;
					}
					if (inventory.getStack(i) == null || inventory.getStack(i).getItem() == Items.AIR) {
						inventory.setStack(i, itemStack);
						break;
					}
				}
				if(drop && world != null & pos != null) {
					world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), itemStack));
				}
			}

		}
	}
	
	public static void dropCoins(World world, BlockPos pos, int amount) {
		if(amount < 1) return;
		Map<Item, Integer> itemStacks = generateCoinItemStacks(amount);
		for (Item item : itemStacks.keySet()) {
			ItemStack itemStack = item.getDefaultStack();
			itemStack.setCount(itemStacks.get(item));
			world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), itemStack));
		}
	}

	/*
	* Generates the ItemStacks of Coins given the Currency Amount
	* */
	public static Map<Item, Integer> generateCoinItemStacks(int amount) {
		Map<Item, Integer> itemStacks = new HashMap<>();
		while(amount > 0) {
			for (Integer i : COINS.keySet()) {
				if(i <= amount) {
					itemStacks.put(COINS.get(i), itemStacks.getOrDefault(COINS.get(i), 0) + 1);
					amount -= i;
					break;
				}
			}
		}
		return itemStacks;
	}

	/*
	* Counts Currency Value of the Inventory
	* */
	public static int countCurrency(Inventory inventory) {
		int amount = 0;
		for (Item value : COINS.values()) {
			amount += inventory.count(value) * getCoinValue(value);
		}
		return amount;
	}

	/*
	* Returns Currency Value of the Coin
	* */
	public static Integer getCoinValue(Item value) {
		for (Map.Entry<Integer, Item> entry : COINS.entrySet()) {
			if(entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return 0;
	}


	/*
	* Counts which Coints and which Amount the player has in Inventory
	* */
	public static TreeMap<Item, Integer> countCoinItems(Inventory inventory){
		TreeMap<Item, Integer> coinCounts = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack itemStack = inventory.getStack(i);
			Item item = itemStack.getItem();
			if (item instanceof CoinItem) {
				if(coinCounts.containsKey(item)){
					coinCounts.put(item, coinCounts.get(item)+itemStack.getCount());
				}
				else{
					coinCounts.put(item, itemStack.getCount());
				}
			}
		}
		return coinCounts;
	}
}
