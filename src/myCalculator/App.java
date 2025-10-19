package myCalculator;

import myCalculator.core.InputManager;
import myCalculator.core.Operation;
import myCalculator.core.ResultManager;

public class App {
    public static void main(String[] args) {
        ResultManager resultManager = new ResultManager();
        InputManager inputManager = new InputManager();

        double number1 = 0;
        double number2 = 0;
        double result = 0;
//        double resultNumber =result; // 마지막으로 저장된 계산 결과
        double menu = 1;

        System.out.println("계산기를 실행합니다.");

        while (true) {
            switch ((int) menu) {
                // 새로운 계산
                case 1: {
                    System.out.print("\n첫번째 숫자를 입력하세요: ");
                    number1 = inputManager.inputNumber("firstNumber");
                    break;
                }

                // 이어서 계산
                case 2: {
                    try {
//                        resultNumber = (double) resultManager.getAnswers().get(resultManager.getAnswers().size() - 1);
                        number1 = result;
                        System.out.println("\n첫번째 숫자는 이전 계산 결과인 " + number1 + "입니다.");
                    }

                    // 이전 계산 결과 값이 없을 때 첫번째 숫자 입력
                    catch (IndexOutOfBoundsException e) {
                        System.out.print("이어서 할 계산 기록이 없습니다.");
                        System.out.print("첫번째 숫자를 입력하세요: ");
                        number1 = inputManager.inputNumber("firstNumber");
                    }
                    break;
                }

                // 계산 기록 불러오기
                case 3: {
                    System.out.println("이전 계산 결과를 불러옵니다.\n");
                    for(Object answerHistory : resultManager.getAnswers() ) {
                        System.out.println(answerHistory);
                    }


                }
            }

            // 연산 기호 입력
            System.out.print("연산 기호를 입력하세요: ");
            String symbol = inputManager.inputOperation();

            // 두번째 숫자 입력
            System.out.print("두번째 숫자를 입력하세요: ");
            while(true) {
                number2 = inputManager.inputNumber("secondNumber");
                if (symbol.equals("/") && number2 == 0) {
                    System.out.print("0으로는 나눌수 없습니다. 다른 숫자를 입력해주세요: ");
                } else {
                    break;
                }
            }



            // 입력한 연산 기호에 따른 계산
            Operation op = Operation.formSymbol(symbol);
            result = op.calculate(number1, number2);

            // 계산 결과 송출 및 저장
            System.out.println("\n계산 결과는 " + result + "입니다.\n");
            resultManager.addAnswer(number1 + symbol + number2 + " = " + result);


            // 메뉴 선택
            System.out.print("1.새로운 계산       " + "2.이어서 계산\n"
                    + "3.계산 기록 보기   " + "4.계산기 종료\n"
                    + "원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
            menu = inputManager.inputNumber("menuNumber");

            // 계산기 종료
            if (menu == 4) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}

