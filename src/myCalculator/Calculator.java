package myCalculator;

import java.util.ArrayList;

public class Calculator {
    private static final ArrayList<Integer> answers = new ArrayList<>();

    // 덧셈 기능
    static void add(int a, int b) {
        int result = a + b;
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    // 뺄셈 기능
    static void sub(int a, int b) {
        int result = a - b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    // 곱셈 기능
    static void mul(int a, int b) {
        int result = a * b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    // 나눗셈 기능
    static void div(int a, int b) {
        int result = a / b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    public static ArrayList<Integer> getAnswers() {
        return answers;
    }

}
