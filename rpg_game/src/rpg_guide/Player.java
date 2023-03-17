package rpg_guide;

import java.util.ArrayList;

public class Player {
	public static int money;

	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();

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

	public static void guildMenu() {
		guild.guildMenu();
	}

	public static void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.getGuildList();
	}

	static public ArrayList<Item> getItemList() {
		return inven.getItemList();
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.getGuildList().size();
	}

	static public int getItemSize() {
		return inven.getItemList().size();
	}

	public static void changeJob() {
		guild.jobMenu();
	}
}