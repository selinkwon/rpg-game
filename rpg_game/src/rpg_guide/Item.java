package rpg_guide;

public class Item {
	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int RING = 3;
	private int kind;
	private String name;
	private int power;
	private int price;

	public void setItem(int k, String n, int p, int pr) {
		this.kind = k;
		this.name = n;
		this.power = p;
		this.price = pr;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKind() {
		return this.kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
