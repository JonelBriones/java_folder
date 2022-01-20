package classes;
import java.util.ArrayList;


// attributes
public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;
//class member    
    
    public BankAccount(double checkingBalanceParam, double savingBalanceParam) {
        checkingBalance = checkingBalanceParam;
        savingBalance = savingBalanceParam;
        // this.checkingBalance = checkingBalanceParam;
        // this.savingBalance = savingBalanceParam;

        // totalAmount = checkingBalanceParam + savingBalanceParam;
        numberOfAccounts ++;
    }
    public static int accountCount() {
        return numberOfAccounts;
    }
    public void totalBalance() {
        System.out.println("Total Balance: $" + (checkingBalance + savingBalance));
    }

    // get methods
    public double getCheckingBalance() {
        System.out.println(checkingBalance);
        return checkingBalance;
    }
    public double getSavingBalance() {
        System.out.println(savingBalance);
        return savingBalance;
    }

    public double depositChecking(double amount) {
        System.out.printf("Adding $%s,\nChecking Balance: $%s \n",amount,(checkingBalance + amount));
        checkingBalance =  checkingBalance + amount;
        return checkingBalance;
        
    }
    public double depositSaving(double amount) {
        System.out.printf("Adding $%s,\nSaving Balance: $%s \n",amount,(savingBalance + amount));
        savingBalance =  savingBalance + amount;
        return savingBalance;
        
    }
    public void withdrawChecking(double amount) {
        if (amount > checkingBalance) {
            System.out.println("Insufficient Funds");
        }
        else {
            checkingBalance = checkingBalance - amount;
            System.out.printf("Withdraw Amount: $%s\nNew Checking Balance: $%s\n", amount,checkingBalance);
        }
    }
    public void withdrawSaving(double amount) {
        if (amount > savingBalance) {
            System.out.println("Insufficient Funds");
        }
        else {
            savingBalance = savingBalance - amount;
            System.out.printf("Withdraw Amount: $%s\nNew Saving Balance: $%s\n", amount,savingBalance);
        }
    }

}



