package racingcar;


import java.util.Random;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static int max = Integer.MIN_VALUE;
    static String carNameList = Console.readLine();
    static int trial = Integer.parseInt(Console.readLine());



    public static void main(String[] args) {

        String[] carName = carNameList.split(",");

        if (exceptionHandling(carName)) return;

        int[] successList = new int[carName.length];

        progress(carName, successList);

        returnMax(successList);

        checkWinner(carName, successList);
    }

    private static boolean exceptionHandling(String[] carName) {
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
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
            return true;
        }
        return false;
    }

    public static void progress(String[] carName, int[] successList) {
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




