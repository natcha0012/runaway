package B2S;

public class Book extends Item implements Rentable {
	
	public static int idCount=1;
	private boolean isRented;
	private String renterName;
	private int giveBackDate;
	
	public Book (String name,double price) {
		super(name,price);
		this.setId(idCount);
		idCount++;
		this.isRented=false;
		this.renterName="";
	}
	public String toString() {
		
		String statusString="";
		
		
		if (this.isRented) {
			statusString="rented by "+this.renterName;
		}
		
		return String.format("#%d\t%s\t$%.2f%s", id, name, price, statusString);
	}
	public void rent(String renterName) {
		this.setRenterName(renterName);
		this.setInStock(false);
		this.setRented(true);
		this.setGiveBackDate(B2Splus.date);
	}
	public double returnItem() {
		this.setRenterName("");
		this.setInStock(true);
		this.setRented(false);
		int time = B2Splus.date-giveBackDate;
		this.setGiveBackDate(0);
		return this.price*0.07*(time +1); //return this.price*0.07*(B2Splus.date-giveBackDate +1);
	}
	//--------------------
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
	
}