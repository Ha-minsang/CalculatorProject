package myCalculator.core;

public class MenuManager {

    private final AppContext appContext;

    // 생성자
    public MenuManager(AppContext appContext) {
        this.appContext = appContext;
    }

    // 메인 메뉴 실행
    public double mainMenu(double input) {
        if (input == 1) { // 1. 새로운 계산
            return 1;
        } else if (input == 2) { // 2. 이어서 계산
            return 2;
        } else if (input == 3) { // 3. 계산 기록(히스토리) 보기
            appContext.showHistory();
            double select = appContext.selectHistoryMenu();
            return historyMenu(select); // 히스토리 메뉴 선택
        } else if (input == 4) { // 4. 계산기 종료
            return 4;
        } else {
            return 1; //사용하지 않지만 컴파일러 오류 방지용 코드
        }
    }

    // 히스토리 메뉴 실행
    public double historyMenu(double input) {
        if (input == 1) { // 1. 메뉴 선택으로 돌아가기
            return appContext.selectMenu();
        } else if (input == 2) { // 2. 가장 오래된 기록 삭제
            appContext.deleteHistory();
            return 3;
        } else if (input == 3) { // 3. 검색 필터
            return appContext.searchHistory();
        } else if (input == 4) { // 4. 계산기 종료
            return 4;
        } else {
            return 1; //사용하지 않지만 컴파일러 오류 방지용 코드
        }
    }
}
