class TestZooKeeper {
    public static void main(String[] args) {
        //object instantiation, passing in a parameter,
        Gorilla energy = new Gorilla(100); // 100 will be the default energy lv for gorilla
        energy.displayEnergy(); //100
        energy.throwSomething(); 
        energy.displayEnergy(); //95
        energy.eatBannana();
        energy.displayEnergy(); //100 or 105
        energy.climb();
        energy.displayEnergy(); // 90 or 95
    }

}