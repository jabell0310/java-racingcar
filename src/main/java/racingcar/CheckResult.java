package racingcar;

import static racingcar.Application.max;

public class CheckResult {
  public static void returnMax(int[] successList) {
    for (int successes : successList)
      if (max < successes) max = successes;
  }


  public static void checkWinner(String[] carName, int[] successList) {
    boolean isFirstWinner = true;
    for (int i = 0; i < carName.length; i++) {
      if (successList[i] == max) {
        if (!isFirstWinner) {
          System.out.print(", ");
        }
        isFirstWinner = false;
        System.out.print(carName[i]);
      }
    }
  }
}
