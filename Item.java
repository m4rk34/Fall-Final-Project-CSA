
//this class is used to create a item the user wants to buy, with its name, the price of the item, and the quantity of the item.
public class Item {

	private double price;
	private String name;
	private int amount;

	//constructor for the item.
	public Item(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	//3 accessor methods, mainly used for the toString method for the reciept.
	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public int getAmount() {
		return this.amount;
	}

	//this is used for the reciept to print it after checkout.
	//spaces are used in between to read reciept easier
	public String toString() {
		return " Name: " + this.getName() + "   Price:  " + this.getPrice() + "   Amount:  " + this.getAmount();
	}

	//returns the total cost of the item by multiplying the price by the amount, rounds to the second decimal place.
	public double getTotal() {
		return Math.round(this.getPrice() * this.getAmount() * 100.0) / 100.0;
	}


}
