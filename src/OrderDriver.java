/**
 * Driver to test Order and MenuItem classes
 * 
 * @author Carter Clark
 *
 */

public class OrderDriver {

	public static void main(String[] args) {
		
		//first order
		MenuItem fries = new MenuItem("Fries", 2.05, 30);
		MenuItem burger = new MenuItem("Burger", 10.99, 3);
		MenuItem shake = new MenuItem("Shake", 25.67, 4);
		
		Order jen = new Order("Jennies", 10);
		
		//second order
		MenuItem waffles = new MenuItem("Waffles", 15.49, 4);
		MenuItem waffleFries = new MenuItem("Waffle Fries", 3.50, 20);
		MenuItem baconBurger = new MenuItem("Bacon Burger", 13.99, 2);
		MenuItem milk = new MenuItem("Milk", 5.00, 1);
		MenuItem pepsi = new MenuItem("Pepsi", 1.25, 3);
		
		//MenuItem pepsi2 = new MenuItem("Pepsi", 1.25, 3);
		
		Order alf = new Order("Alfs", 10);
		
		jen.add(fries);
		jen.add(burger);
		jen.add(shake);
		jen.add(burger);
		
		alf.add(waffles);
		alf.add(waffleFries);
		alf.add(baconBurger);
		alf.add(milk);
		alf.add(pepsi);
		//alf.add(pepsi2);
		alf.add(milk);
		
		
//		System.out.println(pepsi.equals(milk));
		
		System.out.println(jen.toString());
		System.out.println(alf.toString());

	}

}
