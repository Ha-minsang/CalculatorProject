package myCalculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        while (true) {
            System.out.print("첫번째 숫자를 입력하세요: ");
            try {
                int number1 = sc.nextInt();
                if (number1 < 0) {
                    System.out.println("양의 정수를 입력하세요.");
                }

                System.out.print("두번째 숫자를 입력하세요: ");
                int number2 = sc.nextInt();
                if (number2 < 0) {
                    System.out.println("양의 정수를 입력하세요.");
                }

                System.out.print("연산 기호를 입력하세요: ");
                sc.nextLine();
                String operation = sc.nextLine();
                switch (operation) {
                    case "+":
                        cal.add(number1, number2);
                        break;
                    case "-":
                        cal.sub(number1, number2);
                        break;
                    case "*":
                        cal.mul(number1, number2);
                        break;
                    case "/":
                        if (number2 == 0) {
                            System.out.println("0으로는 나눌수 없습니다.");
                        } else {
                            cal.div(number1, number2);
                        }
                        break;
                    default:
                        System.out.println("잘못된 연산 기호입니다.");
                }
                System.out.print("더 계산하시겠습니까?(exit를 입력하면 종료됩니다)");
                String input = sc.nextLine();

                if (input.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("정상적인 입력이 아닙니다.");
            }

        }
    }
}
