package myCalculator;

public enum Arithmetic {
    // 덧셈 기능
    ADD("+") {
        public int apply(int a, int b) {
            return a + b;
        }
    },

    // 뺄셈 기능
    SUB("-") {
        public int apply(int a, int b) {
            return a - b;
        }
    },

    // 곱셈 기능
    MUL("*") {
        public int apply(int a, int b) {
            return a * b;
        }
    },

    // 나눗셈 기능
    DIV("/") {
        public int apply(int a, int b) {
            return a / b;
        }
    };

String symbol;
    Arithmetic(String symbol) {
        this.symbol = symbol;
    }

public abstract int apply(int a, int b);
}
