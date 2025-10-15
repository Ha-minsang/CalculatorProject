package myCalculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.print("첫번째 숫자를 입력하세요: ");
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
            char operation = sc.next().charAt(0);
            switch (operation) {
                case '+':
                    Calculator.add(number1, number2);
                    break;
                case '-':
                    Calculator.sub(number1, number2);
                    break;
                case '*':
                    Calculator.mul(number1, number2);
                    break;
                case '/':
                    if (number2 == 0) {
                        System.out.println("0으로는 나눌수 없습니다.");
                    } else {
                        Calculator.div(number1, number2);
                    }
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다.");
            }
            sc.nextLine();
            System.out.print("더 계산하시겠습니까?(exit를 입력하면 종료됩니다)");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }


        }
    }
}
