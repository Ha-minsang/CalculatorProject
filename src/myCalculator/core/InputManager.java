package myCalculator.core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    Scanner sc = new Scanner(System.in);

    public double inputNumber(String numberType) {
        while (true) {
            try {
                switch (numberType) {
                    case "firstNumber":
                        return sc.nextDouble();

                    case "secondNumber":
                        return sc.nextDouble();

                    case "menuNumber":
                        while (true) {
                            double choice = sc.nextDouble();
                            if (1 <= choice && choice <= 4) {
                                return choice;
                            } else {
                                System.out.print("1~4 중 다시 입력해주세요: ");
                            }
                        }
                }
            } catch (InputMismatchException e) {
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                System.out.println("\n정상적인 입력이 아닙니다.");
                System.out.print("숫자를 다시 입력해 주세요: ");
            }
        }
    }

    public String inputOperation() {
        sc.nextLine();
        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("+") || choice.equals("-")
                    || choice.equals("*") || choice.equals("/")) {
                return choice;
            } else {
                System.out.println("\n정상적인 입력이 아닙니다.");
                System.out.print("연산 기호를 다시 입력해 주세요: ");
            }
        }
    }
}
