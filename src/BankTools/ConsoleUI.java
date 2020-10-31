package BankTools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements UI {

  Scanner scanner = new Scanner(System.in);

  @Override
  public int requestInt(String id) { //, String desc) {
    while (true) {
      try { // desc + "\n" +
        System.out.println(id + ": ");
        int read = scanner.nextInt();
        scanner.nextLine();
        return read;
      } catch (InputMismatchException e) {
        scanner.nextLine();
      }
    }
  }

  @Override
  public String requestString(String id) { //, String desc) {
    System.out.println(id + ": ");
    return scanner.nextLine();
  }
}
