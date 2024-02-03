

public class Verify {

	//two constants are initialized to be used to check if the user input is a number or double.
  //this could have been in the methods:
	public static final String VALID_CHARS_AMOUNT = "0123456789";
	public static final String VALID_CHARS_PRICE = "0123456789.";

	//a method thats checks if user input is a number, when the user is asked to input the quantity of the item they want to buy.
	public static boolean checkAmount(String input) {
		//loops through each character, and returns false if the char is not in the VALID_CHARS_AMOUNT String.
		for (int i = 0; i < input.length(); i++) {
			String Char = input.substring(i, i+1);
			if (VALID_CHARS_AMOUNT.indexOf(Char) == -1) {
				return false;
			}
		}
		//returns true if conditions are met.
		return true;
	}//end of checkAmount

	//A method that checks if the user input is a double, when the user is asked to input the price of the item they want to buy.
	public static boolean checkPrice(String input) {
		//if input is just a period, return false.
		if (input.equals(".")) {
			return false;
		}
		//keeps track of how many dots are in the user input
		int dotCount = 0;
		//loops through each character, increments the dotCount variable if user input is a dot, returns false if there are more than two dots in the input, and returns false if there are characters in the input that do not represent a double, such as letters or symbols.
		for (int i = 0; i < input.length(); i++) {
			String Char = input.substring(i, i+1);
			if (Char.equals(".")) {
				dotCount++;
			}
			if (dotCount > 1) {
				return false;
			}
			if (VALID_CHARS_PRICE.indexOf(Char) == -1) {
				return false;
			}
		}
		//returns true if conditions are met.
		return true;
	}//end of checkPrice
}
