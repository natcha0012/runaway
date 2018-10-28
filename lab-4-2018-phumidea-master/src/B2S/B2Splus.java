package B2S;


import java.util.List;
import java.util.Scanner;

public class B2Splus {

	private static final String Static = null;
	public static Scanner KEYBOARD = new Scanner(System.in);
	public static Inventory inventory;
	public static int date = 1;

	public static void main(String[] args) {
		String command;
		inventory = new Inventory();
		while (true) {
			showMenu();
			command = KEYBOARD.nextLine();

			System.out.println();

			switch (command) {
			case "LM":
				printListItemMenu();
				break;
			case "RP":
				printTopTenMostExpensiveItem();
				break;
			case "RB":
				rentBook();
				break;
			case "RG":
				rentGame();
				break;
			case "RTB":
				returnBook();
				break;
			case "RTG":
				returnGame();
				break;
			case "BG":
				buyGame();
				break;
			case "BS":
				buyStationary();
				break;
			case "E":
				System.out.println("Program terminated");
				System.exit(0);
				break;
			case "T":
				printTimePassingMenu();
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}

			System.out.println();
		}

	}

	private static void showMenu() {
		System.out.println("########################################");
		System.out.println("B2S+ Menu (Day " + date + ")");
		System.out.println("########################################");
		System.out.println("LM)\tList item menu\tRP)\tTop ten popular");
		// System.out.println("AM)\tAdd movie");
		System.out.println("RG)\tRent game\tRB)\tRent book");
		// System.out.println("RM)\tRent movie");
		System.out.println("RTG)\tReturn game\tRTB)\tReturn book");
		// System.out.println("GM)\tReturn movie");
		System.out.println("BS)\tBuy stationary\tBG)\tBuy game");
		System.out.println("T)\tTime passing menu\tE)\tExit");
		System.out.println("----------------------------------------");
		System.out.print("Enter input command : ");

	}

	private static void printListItemMenu() {
		System.out.println("----------------------------------------");
		System.out.println("List all items in inventory");
		System.out.println("----------------------------------------");
		System.out.println("Game (Total " + inventory.getTotalGames() + "):");
		System.out.println("----------------------------------------");

		inventory.listGames();

		System.out.println("----------------------------------------");
		System.out.println("Book (Total " + inventory.getTotalBooks() + "):");
		System.out.println("----------------------------------------");

		inventory.listBooks();

		System.out.println("----------------------------------------");
		System.out.println("Stationary (Total " + inventory.getTotalStationaries() + "):");
		System.out.println("----------------------------------------");

		inventory.listStationaries();
	}

	private static void printTopTenMostExpensiveItem() {
		
		List<Item> items2 = inventory.getItems();
		int i = 0;
		for (Item t : items2) {
			
			System.out.println(t.toString());
			i++;
			if (i==10) {
				break;
			}
		}
		
		

	}

	private static void returnGame() {
		System.out.println("----------------------------------------");
		System.out.println("Return Game");
		System.out.println("----------------------------------------");

		// String gameName;
		int gameID;
		// String renterName;
		Game rentedGame;

		System.out.print("Enter game ID : ");
		gameID = KEYBOARD.nextInt();
		KEYBOARD.nextLine();
		rentedGame = inventory.searchForGameByID(gameID);

		if (rentedGame != null) {
			if (rentedGame.isRented()) {
				System.out.printf("The rental cost is $%.2f.\n", rentedGame.returnItem());
			} else {
				System.out.println("The game is not rented. Back to menu.");
			}
		} else {
			System.out.println("Invalid game ID. Back to menu.");
		}
	}

	private static void returnBook() {
		System.out.println("----------------------------------------");
		System.out.println("Return Book");
		System.out.println("----------------------------------------");

		// String bookName;
		int bookID;
		// String renterName;
		Book rentedBook;

		System.out.print("Enter book ID : ");
		bookID = KEYBOARD.nextInt();
		KEYBOARD.nextLine();
		rentedBook = inventory.searchForBookByID(bookID);

		if (rentedBook != null) {
			if (rentedBook.isRented()) {
				System.out.printf("The rental cost is $%.2f.\n", rentedBook.returnItem());
			} else {
				System.out.println("The book is not rented. Back to menu.");
			}
		} else {
			System.out.println("Invalid book ID. Back to menu.");
		}
	}

	private static void rentGame() {
		System.out.println("----------------------------------------");
		System.out.println("Rent game");
		System.out.println("----------------------------------------");

		String gameName;
		String renterName;

		System.out.print("Enter game name : ");
		gameName = KEYBOARD.nextLine();

		int index = inventory.searchForRentableGame(gameName);
		if (index < 0) {
			System.out.println("The game is not available to rent. Back to menu.");
		} else {
			Game game = (Game) inventory.getItems().get(index);

			System.out.printf(" $%.2f for " + " day\n", game.getPrice() * 0.07);

			System.out.print("Enter your name : ");
			renterName = KEYBOARD.nextLine();
			game.rent(renterName);
			System.out.println("You rented the game successfully. The game ID is " + game.getId() + ".");
			System.out.println("Please inform the game ID when you return it.");

		}

	}

	private static void rentBook() {
		System.out.println("----------------------------------------");
		System.out.println("Rent Book");
		System.out.println("----------------------------------------");

		String bookName;
		String renterName;

		System.out.print("Enter book name : ");
		bookName = KEYBOARD.nextLine();

		int index = inventory.searchForRentableBook(bookName);
		if (index < 0) {
			System.out.println("The book is not available to rent. Back to menu.");
		} else {
			Book book = (Book) inventory.getItems().get(index);

			System.out.printf(" $%.2f for " + " day\n", book.getPrice() * 0.07);

			System.out.print("Enter your name : ");
			renterName = KEYBOARD.nextLine();
			book.rent(renterName);
			System.out.println("You rented the book successfully. The book ID is " + book.getId() + ".");
			System.out.println("Please inform the book ID when you return it.");

		}

	}

	private static void buyGame() {
		System.out.println("----------------------------------------");
		System.out.println("Buy Game");
		System.out.println("----------------------------------------");

		String gameName;
		String buyerName;

		System.out.print("Enter game name : ");
		gameName = KEYBOARD.nextLine();

		int index = inventory.searchForBuyableGame(gameName);
		if (index < 0) {
			System.out.println("The game is not available to buy. Back to menu.");
		} else {
			Game game = (Game) inventory.getItems().get(index);

			System.out.print("Enter your name : ");
			buyerName = KEYBOARD.nextLine();
			System.out.println("The price is $" + game.buy(buyerName) + ".");
			System.out.println("Thank you for buying.");
		}

	}

	private static void buyStationary() {
		System.out.println("----------------------------------------");
		System.out.println("Buy Stationary");
		System.out.println("----------------------------------------");

		String stationaryName;
		String buyerName;

		System.out.print("Enter stationary name : ");
		stationaryName = KEYBOARD.nextLine();

		int index = inventory.searchForBuyableStationary(stationaryName);
		if (index < 0) {
			System.out.println("The stationary is not available to buy. Back to menu.");
		} else {
			Stationary stationary = (Stationary) inventory.getItems().get(index);

			System.out.print("Enter your name : ");
			buyerName = KEYBOARD.nextLine();
			System.out.println("The price is $" + stationary.buy(buyerName) + ".");
			System.out.println("Thank you for buying.");
		}
	}

	private static void printTimePassingMenu() {
		// Fill code
		System.out.println("----------------------------------------");
		System.out.println("Simulate Time Passing");
		System.out.println("----------------------------------------");
		String passday;
		System.out.print("Enter the number of days passing : ");
		passday = KEYBOARD.nextLine();
		date += Integer.parseInt(passday);
		System.out.print("Now is Day "+date+".");
	}

}