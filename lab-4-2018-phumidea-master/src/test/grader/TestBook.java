package test.grader;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import B2S.Game;
import B2S.B2Splus;
import B2S.Inventory;
import B2S.Book;
import B2S.Stationary;

public class TestBook {

	private static final double EPSILON = 0.00000001;
	
	Book book1,book2,book3,book4;
	
	@BeforeEach
	public void setUp() throws Exception {
		B2Splus.date = 1;
		Book.idCount = 1;
		book1 = new Book(Inventory.bookNames[0],Inventory.bookPrices[0]);
		book2 = new Book(Inventory.bookNames[1],Inventory.bookPrices[1]);
		book3 = new Book(Inventory.bookNames[2],Inventory.bookPrices[2]);
		book4 = new Book(Inventory.bookNames[3],Inventory.bookPrices[3]);
	}
	
	@Test
	public void testConstructor(){
		assertEquals(1, book1.getId());
		assertEquals(Inventory.bookNames[0], book1.getName());
		assertEquals(Inventory.bookPrices[0], book1.getPrice(), EPSILON);
		assertEquals(true, book1.isInStock());
		assertEquals("", book1.getRenterName());
		assertEquals(false, book1.isRented());
		
		assertEquals(2, book2.getId());
		assertEquals(Inventory.bookNames[1], book2.getName());
		assertEquals(Inventory.bookPrices[1], book2.getPrice(), EPSILON);
		assertEquals(true, book2.isInStock());
		assertEquals("", book2.getRenterName());
		assertEquals(false, book2.isRented());
		
		assertEquals(5, Book.idCount);
	}

	@Test
	public void testRent() {
		//It should set related fields correctly.
		book1.rent("Earth");
		assertEquals(false, book1.isInStock());
		assertEquals(true, book1.isRented());
		assertEquals("Earth",book1.getRenterName());
	}

	@Test
	public void testReturnItem() {
		//It should set related fields correctly.
		book1.rent("Earth");
		double rentalFee = book1.returnItem();
		assertEquals(true, book1.isInStock());
		assertEquals(false, book1.isRented());
		assertEquals("",book1.getRenterName());

		
		book1.rent("Earth");
		B2Splus.date += 5;
		rentalFee = book1.returnItem();
		assertEquals(16.8, rentalFee,0.01);
	}

}
