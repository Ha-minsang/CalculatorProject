package myCalculator.core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorManager {
    Scanner sc = new Scanner(System.in);

    public double enterNumber(String numberType) {
        while (true) {
            try {
                if (numberType.equals("firstNumber")) {
                    return sc.nextDouble();
                } else if (numberType.equals("secondNumber")) {
                    return sc.nextDouble();
                }else if (numberType.equals("menuNumber")) {
                    double choice =  sc.nextDouble();
                    if (1 <= choice && choice <= 4) {
                        return sc.nextDouble();
                    } else {
                        System.out.print("1 2 3 4 중에 선택해 다시 입력해 주세요. ");
                        sc.next();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("정상적인 입력이 아닙니다.");
                sc.next();
                System.out.print("숫자를 다시 입력해 주세요: ");
            }
        }
    }

    public String enterOperation() {
        while (true) {
            try {
                sc.nextLine();
                return sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("정상적인 입력이 아닙니다.");
                sc.next();
                System.out.print("연산 기호를 다시 입력해 주세요: ");
            }
        }
    }
}
