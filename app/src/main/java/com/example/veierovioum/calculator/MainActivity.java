package com.example.veierovioum.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AbsOperator pendingOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View v){

        if (v.getTag().toString().equalsIgnoreCase(getString(R.string.number)))
        {
            numberClick((Button)v);

        }else if (v.getTag().toString().equalsIgnoreCase(getString(R.string.operator))){

            operatorClick((Button)v);

        }

    }

    /**
     * resolve an operator press
     * @param btn clicked button
     */
    private void operatorClick(Button btn) {

        String operator=btn.getText().toString();
        TextView txtOperator=(TextView) findViewById(R.id.txtOperator);
        txtOperator.setText(operator);

        TextView txtPrevNum=(TextView) findViewById(R.id.txtPrevNum);
        txtPrevNum.setText(getNumberAsString());

        resetMainNumber();

        // TODO: 16/01/2016 enelbe equals button


        switch (operator){
            case "/":
            {

            }
        }

    }

    private void resetMainNumber() {
        TextView v= (TextView) findViewById(R.id.txtView);

        v.setText("0");
    }

    /**
     * resolves a number press
     * @param btn clicked button
     */
    private void numberClick(Button btn) {
        //get data from UI
        String number=btn.getText().toString();
        TextView txtView=(TextView) findViewById(R.id.txtView);
        //check if there's already a decimal point
        if (getNumberAsString().contains(".") && number.equals("."))
            return;

        // TODO: 16/01/2016 clear zero
        //check to see if new number
        if (getNumberAsString().equalsIgnoreCase("0") && !number.equals(".")
                ){
            txtView.clearComposingText();
        }


        txtView.append(number);
    }

    @NonNull
    private String getNumberAsString() {
        TextView txtView =(TextView)findViewById(R.id.txtView);
        return txtView.getText().toString();
    }

    /**
     * gets the number entered on the main display
     * @return value of number
     */
    private double getDispNumber(){
        TextView txtViw= (TextView) findViewById(R.id.txtView);

        return Double.parseDouble(txtViw.getText().toString());

    }
}
