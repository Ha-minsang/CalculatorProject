package myCalculator.core;

import java.util.List;

public class AppContext {
    private final InputManager inputManager;
    private final ResultManager<String> resultManager;

    // 생성자
    public AppContext(InputManager inputManager, ResultManager<String> resultManager) {
        this.inputManager = inputManager;
        this.resultManager = resultManager;
    }


    // 첫번째 숫자 입력
    public double inputFirstNumber(double input, double result, String displayResult) {
        if (input == 1) {
            System.out.print("\n첫번째 숫자를 입력하세요: ");
            return inputManager.inputNumber("number");
        } else if (input == 2) {
            System.out.println("\n첫번째 숫자는 이전 계산 결과인 " + displayResult + "입니다.");
            return result;
        } else {
            return 0; //사용하지 않는 컴파일러 오류 방지용 코드
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
            double number2 = inputManager.inputNumber("number");
            if (symbol.equals("/") && number2 == 0) {
                System.out.print("0으로는 나눌수 없습니다. 다른 숫자를 입력해주세요: ");
            } else {
                return number2;
            }
        }
    }

    // 계산 결과 출력
    public void showResult(String displayResult) {
        System.out.println("계산 결과는 " + displayResult + "입니다.\n" +
                "(소수점 아래 세자리까지만 표시됩니다)\n");
    }

    // 메인 메뉴 숫자 입력
    public double selectMenu() {
        System.out.print("""
                1.새로운 계산
                2.이어서 계산\
                
                3.계산 기록 보기  \s
                4.계산기 종료\
                
                원하시는 메뉴를 선택해 숫자를 입력해주세요:\s""");
        return inputManager.inputNumber("menu");
    }

    // 히스토리 메뉴 숫자 입력
    public double selectHistoryMenu() {
        System.out.print("""
                
                1.메뉴 선택으로 돌아가기
                2.오래된 기록 삭제\
                
                3.검색 필터
                4.계산기 종료
                원하시는 메뉴를 선택해 숫자를 입력해주세요:\s""");
        return inputManager.inputNumber("menu");
    }

    // 히스토리 출력
    public void showHistory() {
        if (resultManager.getAnswers().isEmpty()) {
            System.out.println("저장된 기록이 없습니다.");
        } else {
            System.out.println("\n이전 계산 기록를 불러옵니다.\n");
            for (Object answerHistory : resultManager.getAnswers()) {
                System.out.println(answerHistory);
            }
        }
    }

    // 조건에 맞는 결과 검색
    public double searchHistory() {
        System.out.print("기준이 될 숫자를 입력해 주세요: ");
        double inputNumber = inputManager.inputNumber("number");
        System.out.print("""
                over: 기준값보다 큰 기록만 검색
                under: 기준값보다 작은 기록만 검색\
                
                equal: 기준값과 같은 기록만 검색
                검색 유형을 입력해 주세요:\s""");
        String searchType = inputManager.inputSearchType();
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
        if (serchList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("검색 결과 입니다.\n " + serchList);
        }
        System.out.println("새로운 계산을 시작합니다.");
        return 1;
    }

    // 가장 오래된 기록 삭제
    public void deleteHistory() {
        try {
            resultManager.removeAnswer(0);
            System.out.println("첫번째 계산 기록을 삭제합니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 기록이 없습니다.");
        }
    }


}
