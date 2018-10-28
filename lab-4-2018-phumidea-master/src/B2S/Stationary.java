package B2S;

public class Stationary extends Item implements Saleable {
	public static int idCount=1;
	private String buyerName;
	private boolean isBought;
	private boolean isBuyable;
	public Stationary(String name,double price){
		super(name ,price);
		this.setId(idCount);
		idCount++;
		this.buyerName="";
		this.isBought=false;
		this.isBuyable=true;
	}
	public String toString() {
		String buyableString="";
		String statusString="";
		if (this.isBuyable) {
			buyableString = "Buyable";
		}else {
			buyableString = "Not Buyable";
		}
		if (this.isBought) {
			statusString="bought by "+this.buyerName;
		}
		
		
		return String.format("#%d\t%s\t$%.2f\t%s\t%s", id, name, price,buyableString, statusString);
	}
	public double buy(String buyerName) {
		this.setBuyerName(buyerName);
		this.setInStock(false);
		this.setBought(true);
		this.setBuyable(false);
		return this.getPrice();
	}
	
	//--------------------------
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public boolean isBought() {
		return isBought;
	}
	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}
	public boolean isBuyable() {
		return isBuyable;
	}
	public void setBuyable(boolean isBuyable) {
		this.isBuyable = isBuyable;
	}
	
	
}