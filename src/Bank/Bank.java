package Bank;

import BankAccount.*;
import BankTools.UI;

import java.util.HashMap;
import java.util.Map;

public class Bank {
  private String name;

  private int safeAmt = 0;
  private HashMap<String, Client> clients = new HashMap<>();
  private HashMap<Integer, Account> accounts = new HashMap<>();
  private int clientCount = 0;
  private int accountCount = 0;

  public Bank(String name) {
    this.name = name;
  }

  public void addClient(String firstName, String lastName) {
    String id = Integer.toString(clientCount++);
    clients.put(id, new Client(firstName, lastName, id));

  }

  public Account getAccount(int accountId) {
    return accounts.get(accountId);
  }

//  public void addClient(Client client) {
//    clients.put(client.getClientId(), client);
//  }

  public void addAccount(String clientID, BankTypes type, int startingBal, UI ui) {
    // TODO: get client
    // TODO: create account giving it the client

    Client client = clients.get(clientID);
    if (client == null) throw new NullPointerException("Client " + clientID + " does not exist!");

    Account account = createAccount(client, type, startingBal, ui);

    client.addAccount(account);
    accounts.put(account.getAccountNum(), account);
    accountCount++;
  }

  private Account createAccount(Client client, BankTypes type, int startingBal, UI ui) {
    return switch (type) {
      case SAVINGS_ACCOUNT -> new SavingsAccount(
        accountCount,
        startingBal,
        client,
        ui.requestInt("interest"));

      case CHECKING_ACCOUNT -> new CheckingAccount(
        accountCount,
        startingBal,
        client);

      case INVESTMENT_ACCOUNT -> new InvestmentAccount(
        accountCount,
        startingBal,
        client,
        ui.requestInt("interest"),
        ui.requestInt("period"),
        ui.requestString("periodType").charAt(0));

      case CD_INVESTMENT_ACCOUNT -> new CDInvestment(
        accountCount,
        startingBal,
        client,
        ui.requestInt("interest"),
        ui.requestInt("period"),
        ui.requestString("timeFrame").charAt(0));
    };
  }

  public void displayClients() {
    for (Client client : clients.values()) {
      System.out.println(client.toString());
    }
  }

//  private Account createAccount(Client client, BankTypes type, int startingBal, Map<String, Object> params) {
//    return switch (type) {
//      case SAVINGS_ACCOUNT -> new SavingsAccount(
//        accountCount,
//        startingBal,
//        client,
//        (int) params.get("interest"));
//
//      case CHECKING_ACCOUNT -> new CheckingAccount(
//        accountCount,
//        startingBal,
//        client);
//
//      case INVESTMENT_ACCOUNT -> new InvestmentAccount(
//        accountCount,
//        startingBal,
//        client,
//        (int) params.get("interest"),
//        (int) params.get("period"),
//        (char) params.get("periodType"));
//
//      case CD_INVESTMENT_ACCOUNT -> new CDInvestment(
//        accountCount,
//        startingBal,
//        client,
//        (int) params.get("interest"),
//        (int) params.get("period"),
//        (int) params.get("timeFrame"));
//    };
//  }

}
