package myCalculator;

import java.util.ArrayList;

public class Calculator {
   static ArrayList<Integer> answers = new ArrayList<Integer>();

    static void add(int a, int b) {
        int result = a + b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    static void sub(int a, int b) {
        int result = a - b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    static void mul(int a, int b) {
        int result = a * b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

    static void div(int a, int b) {
        int result = a / b;
        answers.add(result);
        System.out.println("계산 결과는 " + result + "입니다.");
    }

}
