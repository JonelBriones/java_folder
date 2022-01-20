import classes.BankAccount;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(900.50,3031.50);
        account1.totalBalance();
        BankAccount account2 = new BankAccount(1700.00,300.00);
        System.out.println(BankAccount.accountCount());
        account2.totalBalance(); //2000
        account2.deposit(100,"Saving"); //Checking 1800 Saving 400
        account2.withdraw(1700,"Saving"); //Checking 100 Saving IF
        account2.getBalance("Saving"); //Checking 100 Saving 400
    }
    
}
