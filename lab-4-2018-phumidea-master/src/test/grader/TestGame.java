package test.grader;


import B2S.Game;
import B2S.Inventory;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import B2S.B2Splus;
import B2S.Book;
import B2S.Stationary;

public class TestGame {

	private static final double EPSILON = 0.00000001;
	
	Game game1,game2,game3,game4;
	
	@BeforeEach
	public void setUp() throws Exception {
		B2Splus.date = 1;
		Game.idCount = 1;
		game1 = new Game(Inventory.gameNames[0],Inventory.gamePrices[0]);
		game2 = new Game(Inventory.gameNames[1],Inventory.gamePrices[1]);
		game3 = new Game(Inventory.gameNames[2],Inventory.gamePrices[2]);
		game4 = new Game(Inventory.gameNames[3],Inventory.gamePrices[3]);
	}
	
	@Test
	public void testConstructor(){
		assertEquals(1, game1.getId());
		assertEquals(Inventory.gameNames[0], game1.getName());
		assertEquals(Inventory.gamePrices[0], game1.getPrice(), EPSILON);
		assertEquals(true, game1.isInStock());
		assertEquals("", game1.getRenterName());
		assertEquals("", game1.getBuyerName());
		assertEquals(false, game1.isBought());
		assertEquals(false, game1.isRented());
		assertEquals(0, game1.getGiveBackDate());
		assertEquals(true, game1.isBuyable());
		
		assertEquals(2, game2.getId());
		assertEquals(Inventory.gameNames[1], game2.getName());
		assertEquals(Inventory.gamePrices[1], game2.getPrice(), EPSILON);
		assertEquals(true, game2.isInStock());
		assertEquals("", game2.getRenterName());
		assertEquals("", game2.getBuyerName());
		assertEquals(false, game2.isBought());
		assertEquals(false, game2.isRented());
		assertEquals(0, game2.getGiveBackDate());
		assertEquals(true, game2.isBuyable());
		
		assertEquals(5, Game.idCount);
	}
	
	@Test
	public void testBuy() {
		//It should set related fields correctly.
		double buyPrice = game1.buy("Earth");
		assertEquals(false, game1.isInStock());
		assertEquals(true, game1.isBought());
		assertEquals("Earth", game1.getBuyerName());
		assertEquals(false, game1.isBuyable());
		assertEquals(Inventory.gamePrices[0], buyPrice, 0.01);
	}

	@Test
	public void testRent() {
		
		//It should set related fields correctly.
		game1.rent("Earth");
		assertEquals(false, game1.isInStock());
		assertEquals(true, game1.isRented());
		assertEquals("Earth",game1.getRenterName());
		assertEquals(1, game1.getGiveBackDate());
		assertEquals(false, game1.isBuyable());
		
	}

	@Test
	public void testGiveBack() {
		//It should set related fields correctly.
		game1.rent("Earth");
		double rentalFee = game1.returnItem();
		assertEquals(true, game1.isInStock());
		assertEquals(false, game1.isRented());
		assertEquals("",game1.getRenterName());
		assertEquals(0, game1.getGiveBackDate());
		assertEquals(2.1,rentalFee,0.01);
		

	}
}
