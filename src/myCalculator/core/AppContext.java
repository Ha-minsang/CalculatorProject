package myCalculator.core;

import java.util.InputMismatchException;
import java.util.List;

public class AppContext {
    private final InputManager inputManager;

    // 생성자
    public AppContext(InputManager inputManager) {
        this.inputManager = inputManager;
    }


    // 첫번째 숫자 입력
    public double inputFirstNumber(double input, double result, String displayResult) {
        if (input == 1) {
            System.out.print("\n첫번째 숫자를 입력하세요: ");
            return inputManager.inputNumber();
        } else if (input == 2) {
            System.out.println("\n첫번째 숫자는 이전 계산 결과인 " + displayResult + "입니다.");
            return result;
        } else {
            throw new InputMismatchException("오류: 잘못된 입력입니다.");
        }
    }

    // 연산 기호 입력
    public String inputOperation() {
        System.out.print("연산 기호를 입력하세요: ");
        return inputManager.inputOperation();
    }


    // 두번째 숫자 입력
    public double inputSecondNumber(String symbol) {
        System.out.print("두번째 숫자를 입력하세요: ");
        while (true) {
            double number2 = inputManager.inputNumber();
            if (symbol.equals("/") && number2 == 0) {
                System.out.print("0으로는 나눌수 없습니다. 다른 숫자를 입력해주세요: ");
            } else {
                return number2;
            }
        }
    }
}
