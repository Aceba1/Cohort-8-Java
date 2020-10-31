package BankTools;

import java.util.Random;

public class ChaosInterface implements UI {
  Random rand = new Random();

  String[] randStr = {"D", "M", "W", "Q", "Y"};

  @Override
  public int requestInt(String id) {
    return rand.nextInt(10) + 1;
  }

  @Override
  public String requestString(String id) {
    return randStr[rand.nextInt(randStr.length)];
  }
}
