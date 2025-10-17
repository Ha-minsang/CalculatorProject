package myCalculator.core;

public enum Operation {
    // 덧셈 기능
    ADD("+") {
        public double apply(double a, double b) {
            return a + b;
        }
    },

    // 뺄셈 기능
    SUB("-") {
        public double apply(double a, double b) {
            return a - b;
        }
    },

    // 곱셈 기능
    MUL("*") {
        public double apply(double a, double b) {
            return a * b;
        }
    },

    // 나눗셈 기능
    DIV("/") {
        public double apply(double a, double b) {
            return a / b;
        }
    };

String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }

public abstract double apply(double a, double b);
}
