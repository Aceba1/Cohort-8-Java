package Bank;

import BankAccount.BankTypes;
//import BankAccount.CheckingAccount;
//import BankAccount.SavingsAccount;
import BankAccount.SavingsAccount;
import BankTools.ChaosInterface;
import BankTools.ConsoleUI;
import BankTools.UI;

public class Main {
  public static void main(String[] args) {
    Bank bank = new Bank("Cliff Trust");
    UI ui = new ChaosInterface();

    bank.addClient("Titus", "Buchanan");
    bank.addAccount("0", BankTypes.CHECKING_ACCOUNT, 1000_00, ui);
    bank.addAccount("0", BankTypes.SAVINGS_ACCOUNT, 5000_00, ui);

    SavingsAccount savingsAccount = (SavingsAccount) bank.getAccount(1);
    savingsAccount.applyInterest();

    bank.displayClients();
//    Client client = new Client("Cliff", "Choiniere", "crc268");
//
//    client.addAccount(new CheckingAccount(1234, 10000, client));
//    client.addAccount(new SavingsAccount(9876, 20000, client, 3));
//
//    client.addDebitCard(1234);
//
//    System.out.print(client);
  }
}
