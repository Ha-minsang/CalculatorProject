package myCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResultManager resultManager = new ResultManager();
        double number1;
        double number2;
        double result = 0;
        double resultNumber;

        while (true) {
            try {
                // 이전 계산 결과 값이 있을 때 첫번째 숫자 대체
                try {
                    resultNumber = (double) resultManager.getAnswers().get(resultManager.getAnswers().size() - 1);
                    number1 = resultNumber;
                    System.out.println("첫번째 숫자는 이전 계산 결과인 " + number1 + "입니다.");
                }

                // 이전 계산 결과 값이 없을 때 첫번째 숫자 입력
                catch (IndexOutOfBoundsException e) {
                    System.out.print("첫번째 숫자를 입력하세요: ");
                    number1 = sc.nextDouble();
                }

                // 두번째 숫자 입력
                System.out.print("두번째 숫자를 입력하세요: ");
                number2 = sc.nextDouble();

                // 연산 기호 입력
                System.out.print("연산 기호를 입력하세요: ");
                sc.nextLine();
                String operation = sc.nextLine();
                switch (operation) {
                    case "+": {
                        result = Arithmetic.ADD.apply(number1, number2);
                        break;
                    }
                    case "-": {
                        result = Arithmetic.SUB.apply(number1, number2);
                        break;
                    }
                    case "*": {
                        result = Arithmetic.MUL.apply(number1, number2);
                        break;
                    }
                    case "/": {
                        if (number2 == 0) {
                            System.out.println("0으로는 나눌수 없습니다.");
                        } else {
                            result = Arithmetic.DIV.apply(number1, number2);
                        }
                        break;
                    }
                    default:
                        System.out.println("잘못된 연산 기호입니다.");
                }
                System.out.println("계산 결과는 " + result + "입니다.");
                resultManager.addAnswer(result);

                // 프로그램 종료 여부 확인
                System.out.print("더 계산하시겠습니까?(exit를 입력하면 종료됩니다)");
                String input = sc.nextLine();

                if (input.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }

            // 계산기 실행 도중 잘못된 값을 입력하였을 때 메세지 송출
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("정상적인 입력이 아닙니다.");
            }

        }
    }
}

