import classes.BankAccount;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(900.50,3031.50);
        account1.totalBalance();
        BankAccount account2 = new BankAccount(1700.00,300.00);
        System.out.println(BankAccount.accountCount());
        account2.totalBalance(); //2000
        account2.depositChecking(100); //1800
        account2.depositSaving(100); //400
        account2.totalBalance(); //2200
        account2.withdrawChecking(1700); //100
        account2.withdrawSaving(200); // 200
        account2.getSavingBalance();
        account2.getCheckingBalance();
    }
    
}
