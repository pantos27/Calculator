package com.example.veierovioum.calculator;

/**
 * Created by Veierovioum on 16/01/2016.
 */
public class DivOperator extends AbsOperator {
    public DivOperator(double x, double y) {
        super(x, y);
    }

    @Override
    public void run() {
        result=x/y;
        super.run();
    }
}
