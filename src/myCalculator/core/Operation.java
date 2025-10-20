package myCalculator.core;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    // 덧셈 기능
    ADD("+", (a, b) -> a + b),

    // 뺄셈 기능
    SUB("-", (a, b) -> a - b),

    // 곱셈 기능
    MUL("*",  (a, b) -> a * b) ,

    // 나눗셈 기능
    DIV("/" , (a, b) -> a / b);

    String symbol;
    DoubleBinaryOperator operator;

    // 생성자
    Operation(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    // 게터로 Enum 상수의 심볼 가져오기
    public String getSymbol() {
        return symbol;
    }

    // 계산 메서드
    public double calculate(double a, double b) {
        return operator.applyAsDouble(a, b);
    }

    // 심볼과 일치하는 심볼을 가진 Enum 상수의 람다식 가져오기
    public static Operation formSymbol(String symbol) {
        for(Operation operation : Operation.values()) {
            if(operation.getSymbol().equals(symbol)) {
                return operation;
            }
        }
        return null; // 실행되지 않지만 오류 방지를 위해 추가
    }
}
