package classes;
import java.util.ArrayList;


// attributes
public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    public static int numberOfAccounts = 0;
    public static double totalAmount = 0;
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
    public double getBalance(String account) {
        if (account == "Checking") {
            System.out.println(checkingBalance);
        return checkingBalance;
        }
        else {
            System.out.println(savingBalance);
        return savingBalance;
        }
        
    }
    public void deposit(double amount, String account) {
        if (account == "Checking") {
            System.out.printf("Adding $%s,\nNew Checking Balance: $%s \n",amount,(checkingBalance + amount));
        checkingBalance += amount; 
        }
        else {
            System.out.printf("Adding $%s,\nNew Saving Balance: $%s \n",amount,(savingBalance + amount));
        savingBalance += amount; 
        }
    }

    public void withdraw(double amount, String account) {
        if (account == "Checking") {
            if (amount > checkingBalance) {
                System.out.println("Insufficient Funds");
            }
            else {
                checkingBalance -= amount;
                System.out.printf("Withdraw Amount: $%s\nNew Checking Balance: $%s\n", amount,checkingBalance);
            }
        }
        else {
            if (amount > savingBalance) {
                System.out.println("Insufficient Funds");
            }
            else {
                savingBalance -= amount;
                System.out.printf("Withdraw Amount: $%s\nNew Saving Balance: $%s\n", amount,savingBalance);
            }
        }
        
    }


}



