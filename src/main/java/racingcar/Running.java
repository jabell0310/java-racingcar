package racingcar;

import camp.nextstep.edu.missionutils.Randoms;



public class Running {
  public static void progress(String[] carName,int trial, int[] successList) {
    for (int i = 0; i < trial; i++) {
      for (int j = 0; j < carName.length; j++) {
        int isSuccess = Randoms.pickNumberInRange(0, 9);
        if (isSuccess >= 4)
          successList[j]++;
        System.out.println(carName[j] + " : " + "-".repeat(successList[j]));
      }
      System.out.println();
    }
  }
}
