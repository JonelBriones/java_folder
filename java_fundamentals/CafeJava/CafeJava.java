public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.5;
        double lattePrice = 4.2;
        double cappucinoPrice = mochaPrice;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;

        
        
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println("I would like to order a coffee");
        System.out.println(displayTotalMessage + dripCoffeePrice);
        if(isReadyOrder1) {
            System.out.println(pendingMessage);
        }
        isReadyOrder1 = true;
        if(isReadyOrder1) {
            System.out.println(readyMessage);
        }

        // Noah //
        boolean isReadyOrder2 = true;
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println("I would like to order a cappucino");
        System.out.println(displayTotalMessage + cappucinoPrice);
        if(isReadyOrder2) {
            System.out.println(readyMessage);
        }
        else {
            System.out.println(pendingMessage);

        }

        // Sam //

        boolean isReadyOrder3 = false;
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println("I would like to order two lattes");
        System.out.println(displayTotalMessage + (cappucinoPrice * 2));
        if(isReadyOrder3) {
            System.out.println(readyMessage);
        }
        else {
            System.out.println(pendingMessage);

        }
        
            // Jimmy //

        boolean isReadyOrder4 = false;
        System.out.println(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println("I would like to order a latte");
        System.out.println(displayTotalMessage + dripCoffeePrice);
        System.out.println("Oh, you were charged for a coffee!");
        System.out.println("You have to pay, $" + (lattePrice - dripCoffeePrice) );
        if(isReadyOrder4) {
            System.out.println(readyMessage);
        }
        else {
            System.out.println(pendingMessage);

        }
    }
}
