package myCalculator;

import myCalculator.core.CalculatorManager;
import myCalculator.core.Operation;
import myCalculator.core.ResultManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResultManager resultManager = new ResultManager();
        CalculatorManager calculatorManager = new CalculatorManager();

        double number1 = 0;
        double number2 = 0;
        double result = 0;
        double resultNumber;
        double menu = 1;


        while (true) {
            switch ((int) menu) {
                case 1: {
                    System.out.print("첫번째 숫자를 입력하세요: ");
                    number1 = calculatorManager.enterNumber("firstNumber");
                    System.out.println("number1 = " + number1);
                    break;
                }
                case 2: {
                    try {
                        resultNumber = (double) resultManager.getAnswers().get(resultManager.getAnswers().size() - 1);
                        number1 = resultNumber;
                        System.out.println("첫번째 숫자는 이전 계산 결과인 " + number1 + "입니다.");
                    }

                    // 이전 계산 결과 값이 없을 때 첫번째 숫자 입력
                    catch (IndexOutOfBoundsException e) {
                        System.out.print("이어서 할 계산 기록이 없습니다.");
                        System.out.print("첫번째 숫자를 입력하세요: ");
                        number1 = calculatorManager.enterNumber("firstNumber");
                    }
                    break;
                }
                case 3: {
                    ArrayList<Double> answerHistory = resultManager.getAnswers();
                    System.out.println("이전 계산 결과를 불러옵니다.\n" + answerHistory);
                }
            }

            // 두번째 숫자 입력
            System.out.print("두번째 숫자를 입력하세요: ");
            number2 = calculatorManager.enterNumber("secondNumber");
            System.out.println("number2 = " + number2);


            // 연산 기호 입력
            System.out.print("연산 기호를 입력하세요: ");
            String operation = calculatorManager.enterOperation();
            switch (operation) {
                case "+": {
                    result = Operation.ADD.apply(number1, number2);
                    break;
                }
                case "-": {
                    result = Operation.SUB.apply(number1, number2);
                    break;
                }
                case "*": {
                    result = Operation.MUL.apply(number1, number2);
                    break;
                }
                case "/": {
                    while (true) {
                        if (number2 == 0) {
                            System.out.println("0으로는 나눌수 없습니다.");
                            System.out.print("두번째 숫자를 다시 입력하세요: ");
                            number2 = calculatorManager.enterNumber("secondNumber");
                        } else {
                            result = Operation.DIV.apply(number1, number2);
                            break;
                        }
                    }
                }
                default:
                    System.out.println("잘못된 연산 기호입니다.\n 사칙 연산 기호중 다시 입력해주세요: ");

            }
            System.out.println("\n계산 결과는 " + result + "입니다.\n");
            resultManager.addAnswer(result);


            System.out.print("1.새로운 계산       " + "2.이어서 계산\n"
                    + "3.계산 기록 보기   " + "4.계산기 종료\n"
                    + "원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
            menu = calculatorManager.enterNumber("menuNumber");


            if (menu == 4) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}

