package classes;
public class Item {
    private String name;
    private double price; 
    
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
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
     public double getPrice() {
        return this.price;
    }   
    //Setter
    public void setPrice (double price) {
        this.price = price;
    }
    public void addItem(String name, double price) {
        System.out.print(name + " -  $" + price);
    }
}
