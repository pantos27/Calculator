package com.example.veierovioum.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AbsOperator pendingOperation;

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

        //get operator sign
        String operator=btn.getText().toString();
        //store it in text view
        TextView txtOperator=(TextView) findViewById(R.id.txtOperator);
        txtOperator.setText(operator);

        //store previous number
        TextView txtPrevNum=(TextView) findViewById(R.id.txtPrevNum);
        txtPrevNum.setText(getNumberAsString());
        //reset to zero
        resetMainNumber();
        //eneble = button
        enableEqual(true);



    }

    private void enableEqual(boolean b) {
        Button btn=(Button)findViewById(R.id.buttonEquals);
        btn.setEnabled(true);
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

        //check to see if new number
        if (getNumberAsString().equalsIgnoreCase("0") && !number.equals(".")
                ){
            txtView.setText("");
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

    public void equalsClick(View v){
        //get the two numbers for operation
        TextView txtPrev= (TextView) findViewById(R.id.txtPrevNum);
        double x=Double.parseDouble(txtPrev.getText().toString());
        double y=getDispNumber();

        final TextView txtResult=(TextView) findViewById(R.id.txtView);

        TextView txtOperator=(TextView)findViewById(R.id.txtOperator);
        String operator=txtOperator.getText().toString();

        switch (operator) {
            case "/": {
                pendingOperation =new DivOperator(x,y);
                break;
            }
            case "*":{
                pendingOperation=new MultiOperator(x,y);
                break;
            }
            case "+":{
                pendingOperation=new PlusOperator(x,y);
                break;
            }
            case "-":{
                pendingOperation=new MinusOperator(x,y);
                break;
            }
            default:{
                pendingOperation=null;
                break;
            }
        }

        if (pendingOperation==null)return;

        pendingOperation.setResultListener(new iReturnResult() {
            @Override
            public void operationFinished() {
                String result= String.valueOf(pendingOperation.getResult());
                //trim decimal point if it's a round number
                if(result.endsWith(".0")) {
                    result = result.replace(".0","");
                }
                //show result
                txtResult.setText(result);
            }
        });
        pendingOperation.run();

        enableEqual(false);
        txtOperator.setText("");
        txtPrev.setText("");


    }
}
