package myCalculator;

import myCalculator.core.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ResultManager resultManager = new ResultManager();
        InputManager inputManager = new InputManager();
        NumberFormat numberFormat = new NumberFormat();

        double number1 = 0; // 첫번째 입력 숫자
        double number2 = 0; // 두번째 입력 숫자
        double result = 0; // 계산 결과
        double menu = 1; // 시작 메뉴
        int exit = 0; // 프로그램 종료 여부
        String displayResult = "";

        System.out.println("계산기를 실행합니다.");

        while (exit != 1) {
            switch ((int) menu) {
                // 1. 새로운 계산
                case 1: {
                    System.out.print("\n첫번째 숫자를 입력하세요: ");
                    number1 = inputManager.inputNumber("inputNumber");
                    break;
                }

                // 2. 이어서 계산
                case 2: {
                    number1 = result;
                    System.out.println("\n첫번째 숫자는 이전 계산 결과인 " + displayResult + "입니다.");
                    break;
                }

                // 3. 계산 기록 불러오기
                case 3: {
                        System.out.println("\n이전 계산 기록를 불러옵니다.\n");
                        for (Object answerHistory : resultManager.getAnswers()) {
                            System.out.println(answerHistory);
                        }
                    }

                    System.out.print("\n1.메뉴 선택으로 돌아가기" + "\n2.오래된 기록 삭제"
                            + "\n3.검색 필터" + "\n4.계산기 종료\n"
                            + "원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
                    double select = inputManager.inputNumber("menuNumber");

                    // 계산 기록 메뉴
                    switch ((int) select) {
                        // 1. 메뉴 선택으로 돌아가기
                        case 1: {
                            System.out.print("\n1.새로운 계산" + "\n2.이어서 계산"
                                    + "\n3.계산 기록 보기" + "\n4.계산기 종료\n"
                                    + "원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
                            menu = inputManager.inputNumber("menuNumber");
                            continue;
                        }

                        // 2. 첫번째 계산 기록 삭제
                        case 2: {
                            try {
                                resultManager.removeAnswer(0);
                                System.out.println("첫번째 계산 기록을 삭제합니다.");
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("삭제할 기록이 없습니다.");
                            }
                            continue;
                        }

                        // 3. 계산 기록 검색 필터
                        case 3: {
                            System.out.print("기준이 될 숫자를 입력해 주세요: ");
                            double inputNumber = inputManager.inputNumber("inputNumber");
                            System.out.print("over: 기준값보다 큰 기록만 검색\nunder: 기준값보다 작은 기록만 검색" +
                                    "\nequal: 기준값과 같은 기록만 검색\n검색 유형을 입력해 주세요: ");
                            String searchType = inputManager.inputString("searchType");
                            List<String> searchList = resultManager.getAnswers();
                            List<Double> serchList = searchList.stream()
                                    .map(answer -> answer.split("=")[1])
                                    .map(answer -> Double.parseDouble(answer))
                                    .filter(answer -> {
                                        if (searchType.equals("over")) return answer > inputNumber;
                                        else if (searchType.equals("under")) return answer < inputNumber;
                                        else if (searchType.equals("equal")) return answer == inputNumber;
                                        else return false;
                                    })
                                    .toList();
                            System.out.println("검색 결과 입니다.\n " + serchList);
                            menu = 1;
                            System.out.println("새로운 계산을 시작합니다.");
                            continue;
                        }

                        // 4. 계산기 종료
                        case 4: {
                            menu = 4;
                            continue;
                        }
                    }

                    // 4. 계산기 종료
                    case 4: {
                    exit = 1;
                    continue;
                }
            }

            // 연산 기호 입력
            System.out.print("연산 기호를 입력하세요: ");
            String symbol = inputManager.inputString("operation");

            // 두번째 숫자 입력
            System.out.print("두번째 숫자를 입력하세요: ");
            while (true) {
                number2 = inputManager.inputNumber("inputNumber");
                if (symbol.equals("/") && number2 == 0) {
                    System.out.print("0으로는 나눌수 없습니다. 다른 숫자를 입력해주세요: ");
                } else {
                    break;
                }
            }

            // 입력한 연산 기호에 따른 계산
            Operation op = Operation.formSymbol(symbol);
            result = op.calculate(number1, number2);

            // 정수일 경우 소수점 표시 제거, 소수일경우 소수점 아래 3자리까지만 표시
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
                    + "원하시는 메뉴를 선택해 숫자를 입력해주세요: ");
            menu = inputManager.inputNumber("menuNumber");

        }

        //while문이 끝나면 계산기 종료
        System.out.println("계산기를 종료합니다.");
    }
}

