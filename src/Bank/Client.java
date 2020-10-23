package Bank;

import BankAccount.Account;
import BankAccount.CDInvestment;
import BankAccount.CheckingAccount;
import BankAccount.SavingsAccount;
import BankTools.DebitCard;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Client {
  private String name;
  private String firstName;
  private String lastName;
  private String middleName;
  private String clientId;
  //    private String Address
  private HashMap<Integer, Account> accounts;
  private List<DebitCard> debitCards;
//    private List<CheckingAccount> checkingAccounts;
//    private List<SavingsAccount> savingsAccounts;
//    private List<CDInvestment> cdInvestments;

  public Client(String firstName, String lastName, String clientId) {
    this.name = firstName + " " + lastName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.clientId = clientId;
    this.accounts = new HashMap<>();
    this.debitCards = new ArrayList<>();
//        this.checkingAccounts = new ArrayList<CheckingAccount>();
//        this.savingsAccounts = new ArrayList<SavingsAccount>();
//        this.cdInvestments = new ArrayList<CDInvestment>();
  }


  public void addAccount(Account account) {
    accounts.put(account.getAccountNum(), account);
  }

  public void addDebitCard(int accountNum) {
    Account account = accounts.get(accountNum);
    if (account != null) {

      if (account instanceof CheckingAccount) {
        DebitCard card = new DebitCard("Unnamed Card " + debitCards.size(), "1234", "987", this.name, (CheckingAccount)account);
        debitCards.add(card);
      } else {
        System.out.println("Account is not a Checking account!");
      }

    } else {
      System.out.println("No account exists for " + accountNum + "!");
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("| Client '")
      .append(name)
      .append("' |\nBank Accounts:\n");
    for (int accountNum : accounts.keySet()) {
      Account account = accounts.get(accountNum);
      sb.append("- ")
        .append(accountNum)
        .append(": ")
        .append(account.getDetails())
        .append('\n');
    }
    sb.append("Debit Cards:\n");
    for (var debitCard : debitCards) {
      sb.append("- ")
        .append(debitCard)
        .append('\n');
    }
    return sb.toString();
  }

  //    public void addAccount(CheckingAccount account) {
//        checkingAccounts.add(account);
//    }
//
//    public void addAccount(SavingsAccount account) {
//        savingsAccounts.add(account);
//    }

}
