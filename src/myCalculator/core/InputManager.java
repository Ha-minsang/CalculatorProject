package myCalculator.core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    Scanner sc = new Scanner(System.in);

    // 숫자 입력 메서드
    public double inputNumber(String numberType) {
        while (true) {
            try {
                switch (numberType) {
                    // 단순 숫자 입력
                    case "number":
                        return sc.nextDouble();

                    // 메뉴 선택
                    case "menu":
                        while (true) {
                            double choice = sc.nextDouble();
                            if (1 <= choice && choice <= 4) {
                                return choice;
                            } else {
                                System.out.print("1~4 중 다시 입력해주세요: ");
                            }
                            break;
                        }
                }
                // 숫자가 아닌 값을 입력했을때
            } catch (InputMismatchException e) {
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                System.out.println("\n정상적인 입력이 아닙니다.");
                System.out.print("숫자를 다시 입력해 주세요: ");
            }
        }
    }

    // 문자 입력 메서드
    public String inputString(String input) {
        sc.nextLine();
        while (true) {
            switch (input) {
                // 기호 입력
                case "operation": {
                    String choice = sc.nextLine();
                    if (choice.equals("+") || choice.equals("-")
                            || choice.equals("*") || choice.equals("/")) {
                        return choice;
                    } else {
                        System.out.println("\n정상적인 입력이 아닙니다.");
                        System.out.print("연산 기호를 다시 입력해 주세요: ");
                    }
                    break;
                }

                // 검색 필터 입력
                case "searchType": {
                    String search = sc.nextLine();
                    if (search.equals("over") || search.equals("under") || search.equals("equal")) {
                        return search;
                    } else {
                        System.out.println("\n정상적인 입력이 아닙니다.");
                        System.out.print("over / under / equal 중 다시 입력해주세요: ");
                    }
                    break;
                }
            }
        }
    }
}
