public class Bat extends Mammal {
    public Bat(int energy) {
        super(energy);
    }
    public void fly() {
        System.out.println("Bat flew!");
        this.energy -=50;
    }
    public void eatHumans() {
        System.out.println("Bat is eating a Human!");
        this.energy +=25;
    }
    public void attackTown() {
        System.out.println("Bat is attacking a Town!");
        this.energy -=100;
    }
}
