class TestBat {
    public static void main(String[] args) {
        //object instantiation, passing in a parameter,
        Bat energy = new Bat(300); // 300 will be the default energy lv for gorilla
        energy.displayEnergy(); //300
        energy.fly(); 
        energy.displayEnergy(); // 250
        energy.eatHumans();
        energy.displayEnergy(); // 275
        energy.attackTown();
        energy.displayEnergy(); // 175
    }

}