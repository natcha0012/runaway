package B2S;

public class Game extends Item implements Rentable,Saleable{
	public static int idCount = 1;
	private boolean isRented;
	private String renterName;
	private int giveBackDate;
	private String buyerName;
	private boolean isBought;
	private boolean isBuyable;
	
	public Game(String name,double price) {
		super(name,price);
		this.setId(idCount);
		idCount++;
		this.isBought=false;
		this.isBuyable=true;
		this.buyerName="";
		this.renterName="";
		this.isInStock = true;
		this.giveBackDate = 0;
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
		if (this.isRented) {
			statusString="rented by "+this.renterName;
		}
		
		return String.format("#%d\t%s\t$%.2f\t%s\t%s", id, name, price,buyableString, statusString);
		
	}
	public void rent(String renterName) {
		this.setRenterName(renterName);
		this.setInStock(false);//
		this.setRented(true);
		this.setGiveBackDate(B2Splus.date);
		this.setBuyable(false);
	}
	public double returnItem() {
		this.setRenterName("");
		this.setInStock(true);
		this.setRented(false);
		int time = B2Splus.date-giveBackDate;
		this.setGiveBackDate(0);
		return this.price*0.07*(time +1); //return this.price*0.07*(B2Splus.date-giveBackDate +1);
	}
	public double buy(String buyerName) {
		this.setBuyerName(buyerName);
		this.setInStock(false);
		this.setBought(true);
		this.setBuyable(false);
		return this.getPrice();
	}
	
	//--------------------------
	
	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public int getGiveBackDate() {
		return giveBackDate;
	}

	public void setGiveBackDate(int giveBackDate) {
		this.giveBackDate = giveBackDate;
	}

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