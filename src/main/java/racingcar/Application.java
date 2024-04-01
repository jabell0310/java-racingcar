package racingcar;



import camp.nextstep.edu.missionutils.Console;

import static racingcar.CheckResult.checkWinner;
import static racingcar.CheckResult.returnMax;
import static racingcar.ExceptionHandler.exceptionHandling;
import static racingcar.Running.progress;

public class Application {

    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        String carNameList = Console.readLine();

        int trial = Integer.parseInt(Console.readLine());


        String[] carName = carNameList.split(",");


        System.out.println(carName.length);

        if (exceptionHandling(carName ,trial)) return;

        int[] successList = new int[carName.length];

        progress(carName, trial, successList);

        returnMax(successList);

        checkWinner(carName, successList);
    }








}




