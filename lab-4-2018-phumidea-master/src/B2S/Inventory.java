package B2S;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
	
	private List<Item> items;
	
	public static String bookNames[] = {"Hobbit","Star War","Harry Potter","Imitation Game","Social Network","Big Hero 6","Gone Girl","Automata","Iron man","Avengers"};
	public static double bookPrices[] = {40.00,30.00,30.00,50.00,40.00,50.00,50.00,50.00,30.00,30.00};
	public static String gameNames[] = {"Dragon Quest","The Sim","Final Fantasy","Super Mario","Donkey Kong","Sonic","Megaman","Kirby","Monopoly","Mario Kart"};
	public static double gamePrices[] = {30.00,30.00,30.00,10.00,10.00,10.00,20.00,10.00,20.00,20.00};
	public static String stationaryNames[] = {"Pen","Pencil","Erase","Ruler","Notebook","Glue","Highlighter","Tape","Drawing pins","Calculator"};
	public static double stationaryPrices[] = {15.00,5.00,5.00,7.00,25.00,8.00,12.00,8.00,16.00,20.00};
	public static int initialSize = 10;
	
	public Inventory(){
		this.items = new ArrayList<Item>();
		
		this.initailize();
	}
	
	public void initailize(){
		for (int i = 0;i < initialSize ; i++)
		{
			this.addItem(new Book(bookNames[i],bookPrices[i]));
		}
		
		for (int i = 0;i < initialSize; i++)
		{
			this.addItem(new Game(gameNames[i],gamePrices[i]));
		}
		
		for (int i = 0;i < initialSize; i++)
		{
			this.addItem(new Stationary(stationaryNames[i],stationaryPrices[i]));
		}
		this.sortItems();
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public void listGames()
	{
		for (Item item : this.items) {
			if (item instanceof Game){
				System.out.println(item);
			}
		}
	}
	
	public void listBooks(){
		for (Item item : this.items) {
			if (item instanceof Book){
				System.out.println(item);
			}
		}
	}
	
	public void listStationaries(){
		for (Item item : this.items) {
			if (item instanceof Stationary){
				System.out.println(item);
			}
		}
	}
	
	public void sortItems(){
		Boolean isSwap = true;
		int end = this.items.size() - 1;
		Item temp;
		while(isSwap)
		{
			isSwap = false;
			for (int i = 0 ; i < end; i++)
			{
				if (this.items.get(i).compareTo(this.items.get(i+1)) > 0)
				{
					temp = this.items.get(i);
					this.items.set(i, this.items.get(i+1));
					this.items.set(i+1, temp);
					isSwap = true;
				}
			}
		}
	}
	
	public int searchForRentableGame(String gameName){
		for (int i = 0; i < items.size(); i++){
			if (items.get(i) instanceof Game && items.get(i).getName().equals(gameName)&& items.get(i).isInStock() )
			{
				return i; 
			}
		}
		return -1;
	}
	
	public int searchForRentableBook(String bookName){
		for (int i = 0; i < items.size(); i++){
			if (items.get(i) instanceof Book && items.get(i).getName().equals(bookName)&& items.get(i).isInStock() )
			{
				return i; 
			}
		}
		return -1;
	}
	
	public int searchForBuyableGame(String gameName){
		for (int i = 0; i < items.size(); i++){
			Item item = items.get(i);
			if (item instanceof Game && item.getName().equals(gameName) && ((Game) item).isBuyable())
			{
				return i; 
			}
		}
		return -1;
	}
	
	public int searchForBuyableStationary(String stationaryName){
		for (int i = 0; i < items.size(); i++){
			Item item = items.get(i);
			if (item instanceof Stationary && item.getName().equals(stationaryName) && ((Stationary) item).isBuyable())
			{
				return i; 
			}
		}
		return -1;
	}
	
	public Game searchForGameByID(int gameID)
	{
		for (int i = 0; i < items.size(); i++){
			if (items.get(i) instanceof Game && items.get(i).id == gameID)
			{
				return (Game) items.get(i); 
			}
		}
		return null;
	}
	
	public Book searchForBookByID(int bookID)
	{
		for (int i = 0; i < items.size(); i++){
			if (items.get(i) instanceof Book && items.get(i).id == bookID)
			{
				return (Book) items.get(i);
			}
		}
		return null;
	}
	
	public Stationary searchForStationaryByID(int stationaryID)
	{
		for (int i = 0; i < items.size(); i++){
			if (items.get(i) instanceof Stationary && items.get(i).id == stationaryID)
			{
				return (Stationary) items.get(i);
			}
		}
		return null;
	}
	
	public int getTotalGames(){
		return (int) this.items.stream().filter(item -> item instanceof Game).count();
	}
	
	public int getTotalBooks(){
		return (int) this.items.stream().filter(item -> item instanceof Book).count();
	}
	
	public int getTotalStationaries(){
		return (int) this.items.stream().filter(item -> item instanceof Stationary).count();
	}
	
	//Getter&Setter
	public List<Item> getItems() {
		return items;
	}
}