import java.util.ArrayList;

import classes.Item;
import classes.Order;
public class OrderTest {
    public static void main(String[] args) {
        
        // Menu items
        Item item1 = new Item("Mocha",3.5);
        String item1Name = item1.getName();
        double item1Price = item1.getPrice();
        
        Item item2 = new Item("Drip Coffee",2.15);
        String item2Name = item2.getName();
        double item2Price = item2.getPrice();
        Item item3 = new Item("Latte",4.5);
        Item item4 = new Item("Cappuchino",3.5);

        // Order variables 
        // add member variables add()
        Order order1 = new Order();
        String order1Name = order1.getName();
        System.out.println("Customer Name: " + order1Name);

  
        Order order2 = new Order();

        Order order3 = new Order();
        order3.setName("Cindhuri");
        String order3Name = order3.getName();
        System.out.println("Customer: " + order3Name);
        order3.addItem(item1);
        System.out.println(item1Name + " - " + item1Price);
        System.out.println(item2Name + " - " + item2Price);
        order3.addItem(item2);
        
 

        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");
 
        // Application Simulations

        
        // order2.addItem(item1);
        // // Add the item1 to order2's item list and increment the order's total.
        // order2.items.add(item1);
        // order2.total += item1.price;

        // // order3 ordered a capuccino. Add the cappuccino to their order and to their tab.
        // order3.items.add(item4);
        // order3.total += item4.price;

        // // order4 added a latte. Update accordingly.
        // order4.items.add(item2);
        // order4.total += item2.price;

        // // Cindhuri’s order is now ready.  Update her status.
        // order1.ready = true;

        // // Sam ordered more drinks -- 2 lattes. Update their order as well.
        // order4.items.add(item2);
        // order4.items.add(item2);
        // order4.total += item2.price * 2;

        // // Jimmy’s order is now ready. Update his status.
        // order2.ready = true;


    }
}
