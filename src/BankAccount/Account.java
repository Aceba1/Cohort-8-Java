package BankAccount;

public interface Account {
  void withdraw(int amt);
  void deposit(int amt);
  String getDetails();

  int getBalance();
  int getAccountNum();
  String getOwner();
  String getType();
}
