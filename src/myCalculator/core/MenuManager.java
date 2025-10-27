package myCalculator.core;

import java.util.InputMismatchException;

public class MenuManager {
    InputManager inputManager = new InputManager();
    private final ResultManager<String> resultManager;

    // 생성자
    public MenuManager( ResultManager<String> resultManager) {
        this.resultManager = resultManager;
    }



    // 메인 메뉴 숫자 입력
    public double selectMenu() {
        System.out.print("""
                1.새로운 계산
                2.이어서 계산\
                
                3.계산 기록 보기  \s
                4.계산기 종료\
                
                원하시는 메뉴를 선택해 숫자를 입력해주세요:\s""");
        return inputManager.inputMenu();
    }

    // 히스토리 메뉴 숫자 입력
    public double selectHistoryMenu() {
        System.out.print("""
                
                1.메뉴 선택으로 돌아가기
                2.오래된 기록 삭제\
                
                3.검색 필터
                4.계산기 종료
                원하시는 메뉴를 선택해 숫자를 입력해주세요:\s""");
        return inputManager.inputMenu();
    }

    // 메인 메뉴 실행
    public double mainMenu(double input) {
        if (input == Menu.NEW.menuNumber || input == Menu.CONTINUE.menuNumber
                || input == Menu.EXIT.menuNumber) {
            // 1. 새로운 계산, 2. 이어서 계산, 4. 계산기 종료
            return input;
        } else if (input == Menu.HISTORY.menuNumber) { // 3. 계산 기록(히스토리) 보기
            resultManager.showHistory();
            double select = selectHistoryMenu();
            return historyMenu(select); // 히스토리 메뉴 선택
        } else {
            throw new InputMismatchException("오류: 잘못된 입력입니다.");
        }
    }

    // 히스토리 메뉴 실행
    public double historyMenu(double input) {
        if (input == 1) { // 1. 메뉴 선택으로 돌아가기
            return selectMenu();
        } else if (input == 2) { // 2. 가장 오래된 기록 삭제
            resultManager.deleteHistory();
            return 3;
        } else if (input == 3) { // 3. 검색 필터
            return resultManager.searchHistory();
        } else if (input == 4) { // 4. 계산기 종료
            return 4;
        } else {
            throw new InputMismatchException("오류: 잘못된 입력입니다.");
        }
    }
}
