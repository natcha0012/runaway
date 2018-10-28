package test.grader;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import B2S.B2Splus;
import B2S.Inventory;
import B2S.Stationary;

class TestStationary {
	
	private static final double EPSILON = 0.00000001;
	
	Stationary sta1,sta2,sta3,sta4;

	@BeforeEach
	void setUp() throws Exception {
		B2Splus.date = 1;
		Stationary.idCount = 1;
		sta1 = new Stationary(Inventory.stationaryNames[0], Inventory.stationaryPrices[0]);
		sta2 = new Stationary(Inventory.stationaryNames[1], Inventory.stationaryPrices[1]);
		sta3 = new Stationary(Inventory.stationaryNames[2], Inventory.stationaryPrices[2]);
		sta4 = new Stationary(Inventory.stationaryNames[3], Inventory.stationaryPrices[3]);
	}

	@Test
	public void testConstructor() {
		assertEquals(1, sta1.getId());
		assertEquals(Inventory.stationaryNames[0], sta1.getName());
		assertEquals(Inventory.stationaryPrices[0], sta1.getPrice(), EPSILON);
		assertEquals(true, sta1.isInStock());
		assertEquals("", sta1.getBuyerName());
		assertEquals(false, sta1.isBought());
		assertEquals(true, sta1.isBuyable());
		
		assertEquals(2, sta2.getId());
		assertEquals(Inventory.stationaryNames[1], sta2.getName());
		assertEquals(Inventory.stationaryPrices[1], sta2.getPrice(), EPSILON);
		assertEquals(true, sta2.isInStock());
		assertEquals("", sta2.getBuyerName());
		assertEquals(false, sta2.isBought());
		assertEquals(true, sta2.isBuyable());
		
		assertEquals(5, Stationary.idCount);
		
	}
	
	@Test
	public void testBuy() {
		//It should set related fields correctly.
		double buyPrice = sta1.buy("Earth");
		assertEquals(false, sta1.isInStock());
		assertEquals(true, sta1.isBought());
		assertEquals("Earth", sta1.getBuyerName());
		assertEquals(false, sta1.isBuyable());
		assertEquals(Inventory.stationaryPrices[0], buyPrice, 0.01);
	}

}
