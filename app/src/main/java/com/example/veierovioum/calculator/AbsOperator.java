package com.example.veierovioum.calculator;

/**
 * abstract class for handling calculations
 *
 */
public abstract class AbsOperator extends Thread {

    double x;
    double y;
    double result;
    iReturnResult iResult;

    public AbsOperator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setResultListener(iReturnResult r){
        this.iResult=r;
    }

    @Override
    public  void run() {
        if (iResult!=null) iResult.operationFinished();
    }

    public double getResult() {


        return result;
    }
}

