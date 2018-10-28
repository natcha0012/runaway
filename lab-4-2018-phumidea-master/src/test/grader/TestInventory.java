package test.grader;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import B2S.Game;
import B2S.Inventory;
import B2S.Book;
import B2S.Stationary;


public class TestInventory {

	private Inventory inventory;
	
	@BeforeEach
	public void setUp() throws Exception {
		Inventory.initialSize = 10;
		Game.idCount = 1;
		Book.idCount = 1; 
		Stationary.idCount = 1; 
		inventory = new Inventory();
	}
	
	@Test
	public void testConstructor() {
		//Items inside should be initialized
		assertEquals(true, inventory.getItems() != null);
		//initialize() should be called
		assertEquals(30, inventory.getItems().size());
	}
	
	@Test
	public void testSortItems1() {
		//All games should be correctly sorted after inventory is initialized.
		assertEquals(8,inventory.getItems().get(0).getId());
		assertEquals(6,inventory.getItems().get(1).getId());
		assertEquals(7,inventory.getItems().get(2).getId());
		assertEquals(4,inventory.getItems().get(3).getId());
		assertEquals(1,inventory.getItems().get(4).getId());
		assertEquals(5,inventory.getItems().get(5).getId());
		assertEquals(10,inventory.getItems().get(6).getId());
		assertEquals(1,inventory.getItems().get(7).getId());
		assertEquals(3,inventory.getItems().get(8).getId());
		assertEquals(3,inventory.getItems().get(9).getId());	
	}
	
	@Test
	public void testSortItems2() {
		//All books should be correctly sorted after inventory is initialized.
		assertEquals(9, inventory.getItems().get(10).getId());
		assertEquals(2, inventory.getItems().get(11).getId());
		assertEquals(2, inventory.getItems().get(12).getId());
		assertEquals(5, inventory.getItems().get(13).getId());
		assertEquals(10, inventory.getItems().get(14).getId());
		assertEquals(10, inventory.getItems().get(15).getId());
		assertEquals(7, inventory.getItems().get(16).getId());
		assertEquals(9, inventory.getItems().get(17).getId());
		assertEquals(9, inventory.getItems().get(18).getId());
		assertEquals(1, inventory.getItems().get(19).getId());
	}
	
	@Test
	public void testSortItems3() {
		//All stationaries should be correctly sorted after inventory is initialized.
		assertEquals(7, inventory.getItems().get(20).getId());
		assertEquals(5, inventory.getItems().get(21).getId());
		assertEquals(8, inventory.getItems().get(22).getId());
		assertEquals(6, inventory.getItems().get(23).getId());
		assertEquals(4, inventory.getItems().get(24).getId());
		assertEquals(6, inventory.getItems().get(25).getId());
		assertEquals(8, inventory.getItems().get(26).getId());
		assertEquals(4, inventory.getItems().get(27).getId());
		assertEquals(3, inventory.getItems().get(28).getId());
		assertEquals(2, inventory.getItems().get(29).getId());
	}
	
	@Test
	public void testSortItems4() {
		//The added games should be correctly sorted after sortGames() is called.
		inventory.addItem(new Game("Ninja Gaiden",19.99));
		inventory.addItem(new Game("Bomberman",9.99));
		inventory.sortItems();
		
		assertEquals(1,inventory.getItems().get(4).getId());
		assertEquals(3,inventory.getItems().get(8).getId());
	}
	
	@Test
	public void testSortItems5() {
		//The added books should be correctly sorted after sortBooks() is called.
		inventory.addItem(new Book("Ant man",45.99));
		inventory.addItem(new Book("World War Z",29.99));
		inventory.sortItems();
		
		
		assertEquals(7, inventory.getItems().get(18).getId());
		assertEquals(2, inventory.getItems().get(12).getId());
	}
	
	@Test
	public void testSortItems6() {
		//The added stationaries should be correctly sorted after sortStationary() is called.
		inventory.addItem(new Stationary("Ruler",1.00));
		inventory.addItem(new Stationary("Pin",2.00));
		inventory.sortItems();
		
		assertEquals(3, inventory.getItems().get(28).getId());
		assertEquals(2, inventory.getItems().get(12).getId());
	}


	@Test
	public void testSearchForRentableGame() {
		
		inventory.addItem(new Game(Inventory.gameNames[0],Inventory.gamePrices[0]));
		
		//The index of rentable game which has the same name as user mentioned should be returned.  
		int index1 = inventory.searchForRentableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getItems().get(index1).getName());
		assertEquals(true, inventory.getItems().get(index1).getId() == 1 || inventory.getItems().get(index1).getId() == 11);
		
		((Game)inventory.getItems().get(index1)).rent("Earth");
		
		//The first "Dragon Quest" game is rented,the second "Dragon Quest" game index should be returned. 
		int index2 = inventory.searchForRentableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getItems().get(index2).getName());
		assertEquals(true, index1 != index2);
		assertEquals(true, (inventory.getItems().get(index1).getId() == 1 && inventory.getItems().get(index2).getId() == 11) || (inventory.getItems().get(index1).getId() == 11 && inventory.getItems().get(index2).getId() == 1));
		
		((Game)inventory.getItems().get(index2)).rent("John");
		
		//-1 should be returned because all "Dragon Quest" games are rented.
		int index3 = inventory.searchForRentableGame("DragonQuest");
		assertEquals(-1, index3);
		
		//The second "Dragon Quest" game is returned so the index returned from calling searchForRentableGame should be the same as index2.
		((Game)inventory.getItems().get(index2)).returnItem();
		int index4 = inventory.searchForRentableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getItems().get(index4).getName());
		assertEquals(true, index4 == index2);
	
	}

	@Test
	public void testSearchForRentableBook() {
		
		inventory.addItem(new Book(Inventory.bookNames[0],Inventory.bookPrices[0]));
		
		//The index of rentable book which has the same name as user mentioned should be returned.
		int index1 = inventory.searchForRentableBook("Hobbit");
		assertEquals("Hobbit", inventory.getItems().get(index1).getName());
		assertEquals(true, inventory.getItems().get(index1).getId() == 1 || inventory.getItems().get(index1).getId() == 11);
		
		((Book)inventory.getItems().get(index1)).rent("Earth");
		
		//The first "Hobbit" book is rented,the second "Hobbit" movie index should be returned. 
		int index2 = inventory.searchForRentableBook("Hobbit");
		assertEquals("Hobbit", inventory.getItems().get(index2).getName());
		assertEquals(true, index1 != index2);
		assertEquals(true, (inventory.getItems().get(index1).getId() == 1 && inventory.getItems().get(index2).getId() == 11) || (inventory.getItems().get(index1).getId() == 11 && inventory.getItems().get(index2).getId() == 1));
		
		((Book)inventory.getItems().get(index2)).rent("John");
		
		//-1 should be returned because all "Hobbit" book are rented.
		int index3 = inventory.searchForRentableBook("Hobbit");
		assertEquals(-1, index3);
		
		//The second "Hobbit" book is returned so the index returned from calling searchForRentableGame should be the same as index2.
		((Book)inventory.getItems().get(index2)).returnItem();
		int index4 = inventory.searchForRentableBook("Hobbit");
		assertEquals("Hobbit", inventory.getItems().get(index4).getName());
		assertEquals(true, index4 == index2);
	}
	
	

	@Test
	public void testSearchForBuyableGame() {
		
		inventory.addItem(new Game(Inventory.gameNames[0],Inventory.gamePrices[0]));
		
		//The index of buyable game which has the same name as user mentioned should be returned.  
		int index1 = inventory.searchForBuyableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getItems().get(index1).getName());
		assertEquals(true, inventory.getItems().get(index1).getId() == 1 || inventory.getItems().get(index1).getId() == 11);
		
		((Game)inventory.getItems().get(index1)).buy("Earth");
		
		//The first "Dragon Quest" game is bought,the second "Dragon Quest" game index should be returned. 
		int index2 = inventory.searchForBuyableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getItems().get(index2).getName());
		assertEquals(true, index1 != index2);
		assertEquals(true, (inventory.getItems().get(index1).getId() == 1 && inventory.getItems().get(index2).getId() == 11) || (inventory.getItems().get(index1).getId() == 11 && inventory.getItems().get(index2).getId() == 1));
		
		((Game)inventory.getItems().get(index2)).rent("John");
		
		//Once the game is rented,it won't be able to buy. So -1 should be returned because there is no buyable "Dragon Quest" game in the inventory.
		int index3 = inventory.searchForBuyableGame("Dragon Quest");
		assertEquals(-1, index3);
	}
	
	@Test
	public void testGetTotalGame1() {
		assertEquals(10, inventory.getTotalGames());
	}
	@Test
	public void testGetTotalBook1() {
		assertEquals(10, inventory.getTotalBooks());
	}
	
	@Test
	public void testGetTotalStationary() {
		assertEquals(10, inventory.getTotalStationaries());
	}
	
	@Test
	public void testGetTotalGame2() {
		inventory.addItem(new Book("Ant man",45.99));
		inventory.addItem(new Game("Ninja Gaiden",19.99));
		inventory.addItem(new Stationary("Pin",9.99));
		
		assertEquals(11, inventory.getTotalGames());
		assertEquals(11, inventory.getTotalBooks());
		assertEquals(11, inventory.getTotalStationaries());
	}
	
	
}
