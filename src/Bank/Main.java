package Bank;

import BankAccount.Account;
import BankAccount.CheckingAccount;
import BankAccount.SavingsAccount;

public class Main {
  public static void main(String[] args) {
    Client client = new Client("Cliff", "Choiniere", "crc268");

    client.addAccount(new CheckingAccount(1234, 10000, "cliff"));
    client.addAccount(new SavingsAccount(9876, 20000, "cliff", 3));

    client.addDebitCard(1234);

    System.out.print(client);
  }
}
