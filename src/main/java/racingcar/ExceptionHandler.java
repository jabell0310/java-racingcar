package racingcar;



public class ExceptionHandler {
  static boolean exceptionHandling(String[] carName, int trial) {
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

    return false;
  }

}
