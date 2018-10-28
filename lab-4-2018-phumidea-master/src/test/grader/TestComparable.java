package test.grader;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import B2S.Game;
import B2S.B2Splus;
import B2S.Inventory;
import B2S.Book;
import B2S.Stationary;

public class TestComparable {
	
	Game game1,game2,game3,game4;
	Book book1,book2,book3,book4;
	Stationary sta1,sta2,sta3,sta4;
	
	@BeforeEach
	public void setUp() throws Exception {
		game1 = new Game("AB",29.99);
		game2 = new Game("AD",29.99);
		game3 = new Game("BD",9.99);
		game4 = new Game("AC",19.99);
		
		book1 = new Book("AB",29.99);
		book2 = new Book("AD",29.99);
		book3 = new Book("BD",9.99);
		book4 = new Book("AC",19.99);
		
		sta1 = new Stationary("AB", 29.99);
		sta2 = new Stationary("AD", 29.99);
		sta3 = new Stationary("BD", 9.99);
		sta4 = new Stationary("AC", 19.99);
	}

	/*
	 * Comparison between Game and Game
	 */
	@Test
	public void testCompareTo1() {
		assertEquals(true, game1.compareTo(game1) == 0);
		assertEquals(true, game1.compareTo(game2) < 0);
		assertEquals(true, game3.compareTo(game2) > 0);
		assertEquals(true, game2.compareTo(game4) < 0);
	}
	
	/*
	 * Comparison between book and book
	 */
	@Test
	public void testCompareTo2() {
		assertEquals(true, book1.compareTo(book1) == 0);
		assertEquals(true, book1.compareTo(book2) < 0);
		assertEquals(true, book3.compareTo(book2) > 0);
		assertEquals(true, book2.compareTo(book4) < 0);
	}
	
	/*
	 * Comparison between Game and book
	 */
	@Test
	public void testCompareTo3() {
		assertEquals(true, game1.compareTo(book1) == 0);
		assertEquals(true, game4.compareTo(book1) > 0);
		assertEquals(true, game2.compareTo(book3) < 0);
	}
	
	/*
	 * Comparison between book and Game
	 */
	@Test
	public void testCompareTo4() {
		assertEquals(true, book1.compareTo(game1) == 0);
		assertEquals(true, book1.compareTo(game4) < 0);
		assertEquals(true, book3.compareTo(game2) > 0);
	}
	
	/*
	 * Comparison between stationary and stationary
	 */
	@Test
	public void testCompareTo5() {
		assertEquals(true,	sta1.compareTo(sta1) == 0);
		assertEquals(true, sta1.compareTo(sta2) < 0);
		assertEquals(true, sta3.compareTo(sta2) > 0);
		assertEquals(true, sta2.compareTo(sta4) < 0);
	}
	
	/*
	 * Comparison between stationary and Game
	 */
	@Test
	public void testCompareTo6() {
		assertEquals(true, sta1.compareTo(game1) == 0);
		assertEquals(true, sta1.compareTo(game4) < 0);
		assertEquals(true, sta3.compareTo(game2) > 0);
	}
	
	/*
	 * Comparison between stationary and book
	 */
	@Test
	public void testCompareTo7() {
		assertEquals(true, sta1.compareTo(book1) == 0);
		assertEquals(true, sta1.compareTo(book4) < 0);
		assertEquals(true, sta3.compareTo(book2) > 0);
	}
}
