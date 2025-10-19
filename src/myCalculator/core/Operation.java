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

    Operation(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public String getSymbol() {
        return symbol;
    }

    public double calculate(double a, double b) {
        return operator.applyAsDouble(a, b);
    }

    public static Operation formSymbol(String symbol) {
        for(Operation operation : Operation.values()) {
            if(operation.getSymbol().equals(symbol)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산 기호입니다.");
    }
}
