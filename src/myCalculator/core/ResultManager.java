package myCalculator.core;

import java.util.ArrayList;
import java.util.List;

public class ResultManager<T> {
    private final List<T> answersList = new ArrayList<T>();
    InputManager inputManager = new InputManager();

    // 게터 기능
    public ArrayList<T> getAnswers() {
        return (ArrayList<T>) answersList;
    }

    // 저장 기능
    public void addAnswer(String num1, String symbol, String num2, String result) {
        answersList.add((T) (num1 + symbol + num2 + "=" + result));
    }

    // 삭제 기능
    public void removeAnswer(int index) {
        answersList.remove(index);
    }

    // 계산 결과 출력 기능
    public void showResult(String displayResult) {
        System.out.println("계산 결과는 " + displayResult + "입니다.\n" +
                "(소수점 아래 세자리까지만 표시됩니다)\n");
    }

    // 히스토리 출력
    public void showHistory() {
        if (getAnswers().isEmpty()) {
            System.out.println("저장된 기록이 없습니다.");
        } else {
            System.out.println("\n이전 계산 기록를 불러옵니다.\n");
            for (Object answerHistory : getAnswers()) {
                System.out.println(answerHistory);
            }
        }
    }

    // 조건에 맞는 결과 검색
    public double searchHistory() {
        System.out.print("기준이 될 숫자를 입력해 주세요: ");
        double inputNumber = inputManager.inputNumber();
        System.out.print("""
                over: 기준값보다 큰 기록만 검색
                under: 기준값보다 작은 기록만 검색\
                
                equal: 기준값과 같은 기록만 검색
                검색 유형을 입력해 주세요:\s""");
        String searchType = inputManager.inputSearchType();
        List<String> searchList = (List<String>) getAnswers();
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
            removeAnswer(0);
            System.out.println("첫번째 계산 기록을 삭제합니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 기록이 없습니다.");
        }
    }
}
