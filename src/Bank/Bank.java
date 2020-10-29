package Bank;

import BankAccount.Account;

import java.util.HashMap;

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

  public void addAccount(Client client) {
    // TODO: get client
    // TODO: create account giving it the client
  }

  public <T extends Account> T createAccount(Object... props) {
    return new T(props);
  }
}
