package com.example.veierovioum.calculator;

/**  class for handling calculation
 * Created by Veierovioum on 16/01/2016.
 */
public class MultiOperator extends AbsOperator {
    public MultiOperator(double x, double y) {
        super(x, y);
    }

    @Override
    public void run() {
        result=x*y;
    }
}
