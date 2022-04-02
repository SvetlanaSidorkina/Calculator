package com.example.calculator;

public class Calc extends Object {

    public float result;
    public float value1, value2;

    public float getValue1() {
        return value1;
    }

    public float getValue2() {
        return value2;
    }

    public float getResult() {
        return result;
    }

    public static float add(float value1, float value2) {
        return value1 + value2;
    }

    public static float deduct(float value1, float value2) {
        return value1 - value2;
    }

    public static float multiply(float value1, float value2) {
        return value1 * value2;
    }

    public static float div(float value1, float value2) {
        if (value2 == 0) {
            return 0;
        } else {
            return value1 / value2;
        }
    }
}
