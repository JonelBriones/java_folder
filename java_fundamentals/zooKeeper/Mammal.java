

public class Mammal {
    protected int energy = 100;

    //constructor, pass in a parameter to use as an object, can be used for any mammal.
    public Mammal(int energy) {
        this.energy = energy;
    }
    // Display energy level for mammals.
    public int displayEnergy() {
        System.out.println("This Mammal's Energy Level is " + this.energy);
        return this.energy;
    }



}