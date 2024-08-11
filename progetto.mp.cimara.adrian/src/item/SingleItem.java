package item;

public class SingleItem implements Item {

	private double price;
	private String name;
	private int id;

	public SingleItem(double price, String name, int id) {
		this.price = price;
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void addItem(Item item) {
	}

	@Override
	public void removeItem(Item item) {
	}

	@Override
	public String getName() {
		return this.name;
	}
}
