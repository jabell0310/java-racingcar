package racingcar;



import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import static racingcar.CheckResult.checkWinner;
import static racingcar.CheckResult.returnMax;
import static racingcar.ExceptionHandler.exceptionHandling;
import static racingcar.Running.progress;

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








}




