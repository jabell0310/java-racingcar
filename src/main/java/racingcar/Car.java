package racingcar;

//사용자가 사용할 수 있는 추상 메서드 작성
public interface Car {

    void checkCar(String[] carName, int trial);


    void progress(String[] carName, int trial, int[] successList);


    void checkWinner(String[] carName, int[] successList);
}
