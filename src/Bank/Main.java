package Bank;

import BankAccount.CheckingAccount;
import BankAccount.SavingsAccount;

public class Main {
  public static void main(String[] args) {
    Client client = new Client("Cliff", "Choiniere", "crc268");

    client.addAccount(new CheckingAccount(1234, 10000, client));
    client.addAccount(new SavingsAccount(9876, 20000, client, 3));

    client.addDebitCard(1234);

    System.out.print(client);
  }
}
