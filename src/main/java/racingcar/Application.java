package racingcar;



import camp.nextstep.edu.missionutils.Console;



public class Application {



    public static void main(String[] args) {
        String carNameList = Console.readLine();
        int trial = Integer.parseInt(Console.readLine());


        String[] carName = carNameList.split(",");
        int[] successList = new int[carName.length];

        CarRacing carRacing = new CarRacing();
        carRacing.checkCar(carName, trial);
        carRacing.progress(carName, trial, successList);
        carRacing.checkWinner(carName, successList);
    }


}




