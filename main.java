//Scanner imported
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
		//A scanner is created named scanner.
		Scanner scanner = new Scanner(System.in);
		//Stores items and prints the receipt after checkout.
		String totalBill = "";
		//Sum of the prices, gets printed after checkout. 
		double totalPrice = 0.0;
		//A way to break out of loop and exits program when user wants to.
		boolean again = true;
		//A way to break out of loop and go to checkout when the user wants to.
		boolean checkout = false;
		//the next two booleans ans strings are used to check the user input so the program runs correctly.
		boolean validAmount = false;
		String AmountInput = "";
		boolean validPrice = false;
		String PriceInput = "";
		//welcome message, does not get printed again after the user wants to try again.
		System.out.println("Welcome to my billing system! You will be asked to enter the name, price and amount of an item and to go checkout if you are ready.");
		
		while (again) {
			while (!checkout) { 
				//asks the the name of an item and stores it in a variable.
				System.out.println("\nEnter the name of the item you want to buy");
				String name = scanner.nextLine();
				//asks for the price of an item, checks if it is valid, and stores it in another variable.
				System.out.println("\nEnter the price of the item");
				PriceInput = scanner.nextLine();
				validPrice = Verify.checkPrice(PriceInput);
				//user is asked to enter price again if input is invalid.
				while (!validPrice) {
					System.out.println("Please enter a valid price.");
					PriceInput = scanner.nextLine();
					validPrice = Verify.checkPrice(PriceInput);
				}
				//converts String to double and stores it.

				double price = Double.parseDouble(PriceInput);

				//rounds price to second decimal place in case user enters 3 or more decimal places. This would round to the first decimal place if user input is under two decimal places, which is also fine.
				price = Math.round(price * 100.0) / 100.0;

				//asks the for the quantity of the item, and checks if input is int.
				System.out.println("\nWhat is the quantity of the item(s) you want to buy");
				AmountInput = scanner.nextLine();
				validAmount = Verify.checkAmount(AmountInput);
				//user is asked to enter amount again if input is invalid.
				while(!validAmount) {
					System.out.println("Please enter a valid amount.");
					AmountInput = scanner.nextLine();
					validAmount = Verify.checkAmount(AmountInput);
				}

				//converts amount to int and stores it.
				int amount = Integer.parseInt(AmountInput);

				//takes all three variables the user inputs, and creates an object, the object changes once the user enters a second item.
				Item item = new Item(name, price, amount);

				//uses toString method to store the object into a reciept.
				totalBill += item.toString() + "\n"; 
				//gets the total of the item and stores it for the total price at checkout.
				totalPrice += item.getTotal();
				//resets these booleans to check the user input of the next item, if the user chooses to continue.
				validAmount = false;
				validPrice = false;
				
				//asks to add more items, or go to checkout.
				System.out.println("Do want to add more items or go to checkout? Type y to go to checkout or anything else to continue.");
				String goCheckout = scanner.nextLine();
				if (goCheckout.equalsIgnoreCase("y")) {
					//this will exit of the loop, moving to the next loop.
					checkout = true;
				}
				//clears console to avoid clutter.
				System.out.print("\033[H\033[2J");  
				System.out.flush(); 
					
			}
			//rounds the total price again
			totalPrice = Math.round(totalPrice * 100.0) / 100.0;
			//spits out total
			System.out.println("Here is your total: \n");
			System.out.println(totalBill);
			System.out.println("Your total amount is: " + totalPrice);

			//asks user if they want to try again. If "y" is inputted, the user gets to start over
			System.out.println("\nWould you like to start over? Enter Y to restart or anything else to exit.");
				String restart = scanner.nextLine();
				if (!restart.equalsIgnoreCase("y")) {
					//exits out of loop and program ends
					again = false;
				} else {
					//resets every variable how it was originally for the program to work correctly.
					totalPrice = 0.0;
					totalBill = "";
					checkout = false;
					validAmount = false;
					AmountInput = "";
					validPrice = false;
					PriceInput = "";
					//clears console to avoid clutter.
					System.out.print("\033[H\033[2J");  
					System.out.flush(); 
				}	
			}
		}
}
