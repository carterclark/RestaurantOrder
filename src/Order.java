
/**
 * Class holds multiple MenuItems
 * 
 * @author Carter Clark
 */

import java.text.DecimalFormat;

public class Order {
	
	//instance variables
	private String restaurant;
	private MenuItem[] items;
	private int numItems;
	
	//static constant variables
	private static final double taxRate = 0.08;
	private static final double tipPercent = 0.20;
	
	//static object for formatting output
	private static DecimalFormat df2 = new DecimalFormat("$###,###.##");
	
	//constructors
	Order(){
		this.items = new MenuItem[10];
		this.numItems = 0;
	}
	
	/**
	 * Constructor
	 * @param restaurant name of restaurant
	 */
	Order(String restaurant){
		this.restaurant = restaurant;
		this.items = new MenuItem[10];
		this.numItems = 0;
	}
	
	/**
	 * Constructor
	 * @param restaurant name of restaurant
	 * @param capacity number of items in order
	 */
	Order(String restaurant, int capacity){
		this.restaurant = restaurant;
		this.items = new MenuItem[capacity];
		this.numItems = 0;
	}
	
	/**
	 * Adds a MenuItem object to this Order based on parameters
	 * 
	 * @param name, name of MenuItem
	 * @param price, price of item
	 * @param quantity, number of this MenuItem being ordered
	 * 
	 * @return 	TRUE if the MenuItem was added
	 * 			FALSE if the MenuItem could not be added
	 */
	public boolean add(String name, double price, int quantity) {
		
		MenuItem newItem = new MenuItem(name, price, quantity);
		int index = find(name);
		
		//if item is already in array
		if(index != -1) {
			items[index].setQuantity(items[index].getQuantity() + quantity);
		}
		
		//if item is not in array
		else {
			
			//if the array is full
			if(numItems == items.length) {
				System.out.println("Error! The array is full");
				return false;
			}
			
			//if the array is not full
			else {
				items[numItems] = newItem;
				numItems++;
			}
		}
		return true;
	}
	
	/**
	 * Adds a MenuItem that is already instantiated
	 * 
	 * @param item, MenuItem already declared and instantiated
	 * 
	 * @return 	TRUE if the MenuItem was added
	 * 			FALSE if the MenuItem could not be added
	 */
	public boolean add(MenuItem item) {
		return add(item.getName(), item.getPrice(), item.getQuantity());
	}
	
	/**
	 * Method looks for a name in the order
	 * 
	 * @param name, name of MenuItem
	 * @return	the index of the MenuItem if it is in the order
	 * 			-1 if the MenuItem is not in the order
	 */
	public int find(String name) {
		for(int i=0; i<numItems; i++) {
			if(items[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
		
	}

	/**
	 * adds the total cost of all orders before taxes and tips
	 * @return	the total cost
	 */
	public double getTotalBeforeTax() { 
		
		double count = 0;
		
		for(int i=0; i<numItems; i++) {
			count += items[i].getPrice() * items[i].getQuantity();
		}
		return count;
	}
	
	/**
	 * Calculates tax from total cost
	 * @param taxRate, a percent tax rate
	 * @return the amount tax to pay
	 */
	public double getTax(double taxRate) {
		
		return getTotalBeforeTax() * taxRate;
	}
	
	/**
	 * Calculates how much to tip from the total
	 * @param percentage, percent of tip to give
	 * @return	the amount to tip
	 */
	public double getTip(double percentage) {
		return getTotalBeforeTax() * percentage;
	}
	
	/**
	 * gets the number of items in the order
	 * 
	 * @return the number of MenuItems
	 */
	public int getNumMenuItems() {
		return numItems;
	}
	
	/**
	 * method counts quantity of each item and adds them
	 * @return	number of items
	 */
	public int getTotalQuantity() {
		
		int count = 0;
		
		for(int i=0; i<numItems; i++) {
			count += items[i].getQuantity();
		}
		return count;
	}
	
	/** 
	 * @return	Returns formatted string containing the contents of the order
	 */
	@Override
	public String toString(){
		
		String str = "\n" + restaurant + "\n"
				+ "--------------------------------------------\n"
				+ "Item\t\t" + "Price\t  " + "Qty\t" + "Total\n"
				+ "------------------------------------\n";
		
		for(int i=0; i<numItems; i++) {
			str += items[i].toString() + "\n";
		}
		
		str += "------------------------------------\n"
			+ "Total:\t\t" + df2.format(getTotalBeforeTax()) + "\n"
			+ "Tax:\t\t" + df2.format(getTax(taxRate)) + "\n"
			+ "Tip:\t\t" + df2.format(getTip(tipPercent)) + "\n"
			+ "------------------------------------\n"
			+ "Grand Total:\t" 
			+ df2.format(getTotalBeforeTax() + getTax(taxRate) + getTip(tipPercent));
		
		return str;
	}
}
