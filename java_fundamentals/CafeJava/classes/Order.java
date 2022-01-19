package classes;
import java.util.ArrayList;
public class Order {

    //MEMBER VARIABLES
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    //Constructor Method (name is same of class)
    public Order() {
        this.name = "Guest";
    }
    //Overloaded Constructor
    public Order(String name) {
        this.name = name;
    }
    public void customer(String customerName) {
        System.out.printf("Customer: %s\n", customerName);
    }

    //Getter
    public String getName() {
        return this.name;
    }   
    //Setter
    public void setName (String name) {
        this.name = name;
    }
    //Getter
    public boolean getReady() {
        return this.ready;
    }   
    //Setter
    public void setReady (boolean ready) {
        this.ready = ready;
    }
    //Getter
    public ArrayList<Item> getItems() {
        return this.items;
    }   
    //Setter
    public void setItem (ArrayList<Item> items) {
        this.items = items;
    }
    
}
