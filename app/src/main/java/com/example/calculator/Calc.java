package com.example.calculator;

public class Calc {

    private double value1;
    private double value2;

    public Calc(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public double add() {
        return value1 + value2;
    }

    public double deduct() {
        return value1 - value2;
    }

    public double multiply() {
        return value1 * value2;
    }

    public double div() {
        if (value2 == 0) {
            return 0;
        } else {
            return value1 / value2;
        }
    }
}
