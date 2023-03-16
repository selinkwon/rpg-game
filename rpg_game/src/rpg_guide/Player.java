package rpg_guide;

import java.util.ArrayList;

public class Player {
	private static int money;

	static Guild guild = new Guild();
	static Inventory inven = new Inventory();

	public Player() {
		money = 100000;
		guild.setGuild();
	}
	
	public static int getMoney() {
		return money;
	}
	
	public static void setMoney(int money) {
		Player.money = money;
	}

	public void guildMenu() {
		guild.guildMenu();
	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.guildList;
	}

	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.guildList.size();
	}

	static public int getItemSize() {
		return inven.itemList.size();
	}
}