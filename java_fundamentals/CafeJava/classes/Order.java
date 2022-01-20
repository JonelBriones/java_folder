package classes;
import java.util.ArrayList;
public class Order {

    //MEMBER VARIABLES
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    //Constructor Method (name is same of class)
    public Order() {
        this("Guest");
    }
    //Overloaded Constructor
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }
    public void addItem(Item additem) {
        items.add(additem);
    }

    //Getter
    public String getName() {
        return name;
    }   
    //Setter
    public void setName (String name) {
        this.name = name;
    }
    //Getter
    public boolean getReady() {
        return ready;
    }   
    //Setter
    public void setReady (boolean ready) {
        this.ready = ready;
    }
    //Getter
    public ArrayList<Item> getItems() {
        return items;
    }   
    //Setter
    public void setItem (ArrayList<Item> items) {
        this.items = items;
    }
    
    public void getOrderTotal (double total) {
        
    }
}
