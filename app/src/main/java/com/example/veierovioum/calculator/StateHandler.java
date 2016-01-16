package com.example.veierovioum.calculator;

import com.example.veierovioum.calculator.CalcState;

/**
 * Created by Veierovioum on 16/01/2016.
 */
public class StateHandler {

    CalcState currentState;
    CalcState prevState;

    public CalcState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CalcState currentState) {
        this.setPrevState(getCurrentState());
        this.currentState = currentState;
    }

    public CalcState getPrevState() {
        return prevState;
    }

    public void setPrevState(CalcState prevState) {
        this.prevState = prevState;
    }
}
