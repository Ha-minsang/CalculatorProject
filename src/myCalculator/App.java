package myCalculator;

import myCalculator.core.InputManager;
import myCalculator.core.NumberFormat;
import myCalculator.core.Operation;
import myCalculator.core.ResultManager;

public class App {
    public static void main(String[] args) {
        ResultManager resultManager = new ResultManager();
        InputManager inputManager = new InputManager();
        NumberFormat numberFormat = new NumberFormat();

        double number1 = 0;
        double number2 = 0;
        double result = 0;
//        double resultNumber =result; // 마지막으로 저장된 계산 결과
        double menu = 1;
        int exit = 0;
        String displayResult = "";

        System.out.println("계산기를 실행합니다.");

        while (exit != 1) {
            switch ((int) menu) {
                // 새로운 계산
                case 1: {
                    System.out.print("\n첫번째 숫자를 입력하세요: ");
                    number1 = inputManager.inputNumber("firstNumber");
                    break;
                }

                // 이어서 계산
                case 2: {
                    number1 = result;
                    System.out.println("\n첫번째 숫자는 이전 계산 결과인 " + displayResult + "입니다.");
                    break;
                }

                // 계산 기록 불러오기
                case 3: {
                        System.out.println("\n이전 계산 기록를 불러옵니다.\n");
                        for (Object answerHistory : resultManager.getAnswers()) {
                            System.out.println(answerHistory);
                        }
                    }

                    System.out.print("\n1.메뉴 선택으로 돌아가기" + "\n2.오래된 기록 삭제"
                            + "\n3.검색 필터" + "\n4.계산기 종료\n"
                            + "\n원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
                    double select = inputManager.inputNumber("menuNumber");

                    switch ((int) select) {
                        case 1: {
                            System.out.print("\n1.새로운 계산" + "\n2.이어서 계산"
                                    + "\n3.계산 기록 보기" + "\n4.계산기 종료\n"
                                    + "\n원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
                            menu = inputManager.inputNumber("menuNumber");
                            continue;
                        }
                        case 2: {
                            try {
                                resultManager.removeAnswer(0);
                                System.out.println("첫번째 계산 기록을 삭제합니다.");
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("삭제할 기록이 없습니다.");
                            }
                            continue;
                        }
                        case 3: {
                            // 입력 값보다 큰 결과만 보이게 구현 예정
                        }
                        case 4: {
                            menu = 4;
                            continue;
                        }
                    }

                case 4: {
                    exit = 1;
                    continue;
                }
            }

            // 연산 기호 입력
            System.out.print("연산 기호를 입력하세요: ");
            String symbol = inputManager.inputOperation();

            // 두번째 숫자 입력
            System.out.print("두번째 숫자를 입력하세요: ");
            while (true) {
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

            // 정수일 경우 소수점 표시 제거
            displayResult = numberFormat.changeType(result);
            String displayNumber1 = numberFormat.changeType(number1);
            String displayNumber2 = numberFormat.changeType(number2);

            // 계산 결과 송출 및 저장
            System.out.println("\n계산 결과는 " + displayResult + "입니다.\n" +
                    "(소수점 아래 세자리까지만 표시됩니다)\n");
            resultManager.addAnswer(displayNumber1 + symbol + displayNumber2 + " = " + displayResult);


            // 메뉴 선택
            System.out.print("1.새로운 계산" + "\n2.이어서 계산"
                    + "\n3.계산 기록 보기   " + "\n4.계산기 종료\n"
                    + "\n원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
            menu = inputManager.inputNumber("menuNumber");

        }

        //while문이 끝나면 계산기 종료
        System.out.println("계산기를 종료합니다.");
    }
}

