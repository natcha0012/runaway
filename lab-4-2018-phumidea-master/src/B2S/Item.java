package B2S;

public abstract class Item implements Comparable<Item>{
	protected int id = 1;
	protected boolean isInStock;
	protected double price;
	protected String name;
	
	public Item(String name,double price) {
		this.name = name;
		this.price = price;
		this.isInStock = true;
	}
	public abstract String toString();
	public int compareTo(Item o) {
		if (this.price < o.price) {
			return 1;
		}
		if (this.price==o.price) {
			return (this.name).compareTo(o.name);
				
			}
		
		return -1;
	}
	//--------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}