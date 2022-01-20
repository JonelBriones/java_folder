package classes;
public class Item {
    
    private String name;
    private double price; 
    
    public Item() {
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item addItem( Item item) {
        this.name = item.name;
        this.price = item.price;
        return item;
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
     public double getPrice() {
        return price;
    }   
    //Setter
    public void setPrice (double price) {
        this.price = price;
    }
    
    public void addItem(Item name, Item price) {
        System.out.println(name + " - " + price);
    }
    
}
