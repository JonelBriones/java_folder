

public class Gorilla extends Mammal {
    //constructor
    public Gorilla(int energy) {
        super(energy); //super needed if we want specifically for Gorilla energy 
    }
    public void throwSomething() {
        System.out.println("Gorilla threw a rock!");
        this.energy -=5;
    }

    public void eatBannana() { 
        System.out.println("Gorilla eating a Bannana!");
        this.energy += 10;
    }
    public void climb() {
        System.out.println("Gorilla is climbing!");
        this.energy -= 10;
    }
}

