package myCalculator.core;

public class NumberFormat {
    public String changeType(double numberDouble) {
        if (numberDouble % 1 == 0) {
            return String.valueOf((int) numberDouble);
        }
        return String.valueOf(Math.ceil(numberDouble * 1000) / 1000);
    }
}




