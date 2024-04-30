package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing implements Car{

    //예외 발생 정보 은닉
    private void exceptionHandling(String[] carName, int trial) {
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

    //checkCar로 예외 발생 시행
    @Override
    public void checkCar(String[] carName, int trial) {
        exceptionHandling(carName, trial);
    }

    //추상 메서드 구체화
    @Override
    public void progress(String[] carName, int trial, int[] successList) {
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

    //최댓값 조작하지 않도록 정보 은닉
    private int returnMax (int max, int[] successList){
        for (int successes : successList) {
            if (max < successes) {
                max = successes;
            }
        }
        return max;
    }

    //최댓값을 반환하여 최종 우승자 결정!
    @Override
    public void checkWinner (String[]carName, int[] successList){
        int max = returnMax(Integer.MIN_VALUE, successList);
        boolean isFirstWinner = true;
        System.out.print("최종 우승자 : ");
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



