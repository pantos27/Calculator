package com.example.veierovioum.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View v){

        String number=getString(R.string.number);
        String operator=getString(R.string.operator);
        if (v.getTag().toString().equalsIgnoreCase(number))
        {
            numberClick((Button)v);

        }

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
        if (txtView.getText().toString().contains(".") && number.equals("."))
            return;
        //check to see if new number
        if (txtView.getText().toString().equalsIgnoreCase("0") && !number.equals(".")
                ){
            txtView.clearComposingText();
        }


        txtView.append(number);
    }
}
