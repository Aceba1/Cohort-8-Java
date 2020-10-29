package BankAccount;

import Bank.Client;

public class SavingsAccount extends BankAccount {
    private int interest;

    public SavingsAccount (int accountNum, int balance, Client owner, int interest) {
        super(accountNum, balance, owner, "Savings");
        this.interest = interest;
    }

    public void applyInterest() {
        deposit((balance * interest) / 100);
    }
}
