package com.example.veierovioum.calculator;

public class MinusOperator extends AbsOperator {

    public MinusOperator(double x, double y) {
        super(x, y);
    }

    @Override
    public void run() {
        result=x-y;
    }
}

