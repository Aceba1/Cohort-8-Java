package BankAccount;

import Bank.Client;

public interface Account {
  void withdraw(int amt);
  void deposit(int amt);
  String getDetails();

  int getBalance();
  int getAccountNum();
  Client getOwner();
  String getType();
}
