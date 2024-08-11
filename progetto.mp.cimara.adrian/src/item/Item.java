package item;

public interface Item {
	
	public double getPrice();
	public int getId();
	public void addItem(Item item);
	public void removeItem(Item item);
	public String toString();
	public String getName();
	
}
