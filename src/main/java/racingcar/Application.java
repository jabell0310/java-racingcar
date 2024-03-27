package racingcar;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);

        String carNameList = in.next();
        int trial = in.nextInt();
        String[] carName = carNameList.split(",");


        try {
            // 예외 처리: 입력값이 0 이하인 경우
            if (trial <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }

            // 예외 처리: 차 이름이 6글자 이상인 경우
            for (String name : carName) {
                if (name.length() >= 6) {
                    throw new IllegalArgumentException("차 이름은 5글자 이하여야 합니다.");
                }
            }
        }

        catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
            return;
        }


        Random random = new Random();
        int[] successList = new int[carName.length];



        for (int i = 0; i < trial; i++) {
            for (int j = 0; j < carName.length; j++) {
                int isSuccess = random.nextInt(10);
                if (isSuccess >= 4)
                    successList[j]++;
                //System.out.print(i + "회: " + successList[j] + " ");
                //System.out.println();
                System.out.println(carName[j] + " : " + "-".repeat(successList[j]));
            }

            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        for (int successes : successList)
            if (max < successes) max = successes;

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
