package com.example.veierovioum.calculator;

public class PlusOperator extends AbsOperator {

    public PlusOperator(double x, double y) {
        super(x, y);
    }

    @Override
    public void run() {
        result=x+y;
        super.run();
    }
}
