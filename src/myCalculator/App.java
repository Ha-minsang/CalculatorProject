package myCalculator;

import myCalculator.core.*;

public class App {
    public static void main(String[] args) {
        ResultManager<String> resultManager = new ResultManager<String>();
        InputManager inputManager = new InputManager();
        NumberFormat numberFormat = new NumberFormat();
        AppContext appContext = new AppContext(inputManager, resultManager);
        MenuManager menuManager = new MenuManager(appContext);

        double number1 = 0; // 첫번째 입력 숫자
        double number2 = 0; // 두번째 입력 숫자
        double result = 0; // 계산 결과
        double menu = 1; // 시작 메뉴
        boolean exit = false; // 프로그램 종료 여부
        String displayResult = ""; // 출력용 계산 결과

        System.out.println("계산기를 실행합니다.");

        while (!exit) {
            // 선택된 메뉴에 따른 실행
            menu = menuManager.mainMenu(menu);

            // 선택된 메뉴가 계산기 종료일시 즉시 종료
           if (menu == 3) continue;
           if (menu == 4) {
               exit = true;
               continue;
           }

            // 첫번째 숫자 입력
            number1 = appContext.inputFirstNumber(menu, result, displayResult);

            // 연산 기호 입력
            String symbol = appContext.inputOperation();

            // 두번째 숫자 입력
            number2 = appContext.inputSecondNumber(symbol);

            // 입력한 연산 기호에 따른 계산
            Operation op = Operation.formSymbol(symbol);
            result = op.calculate(number1, number2);

            // 정수일 경우 소수점 표시 제거, 소수일경우 소수점 아래 3자리까지만 표시
            displayResult = numberFormat.changeType(result);
            String displayNumber1 = numberFormat.changeType(number1);
            String displayNumber2 = numberFormat.changeType(number2);

            // 계산 결과 출력
            resultManager.showResult(displayResult);

            // 계산 결과 저장
            resultManager.addAnswer(displayNumber1 + symbol + displayNumber2 + " = " + displayResult);

            // 메뉴 선택
            menu = appContext.selectMenu();
        }

        //while문이 끝나면 계산기 종료
        System.out.println("계산기를 종료합니다.");
    }
}

