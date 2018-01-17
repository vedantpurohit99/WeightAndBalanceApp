package com.example.vedantpurohit.weightandbalancecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    Data [] data =  new Data [] {new Data("Basic Empty Weight",0, 0, 0),
                                 new Data("Pilot and Passenger", 0, 0, 0),
                                 new Data("Rear Passenger",0, 0, 0),
                                 new Data("Baggage",0, 0, 0),
                                 new Data("Fuel",0, 0, 0),
                                 new Data("Start/Taxi/Run-Up", 0, 0, 0),
                                 new Data("Fuel Burn", 0, 0, 0),
                                 new Data("ZERO FUEL WEIGHT", 0, 0, 0),
                                 new Data("TAKEOFF WEIGHT", 0, 0, 0),
                                 new Data("LANDING WEIGHT", 0, 0, 0)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public EditText [] calculate (EditText weight, EditText arm, EditText moment){
        if(!weight.getText().toString().equals("") && !arm.getText().toString().equals("")){
            moment.setText(String.valueOf(Integer.parseInt(weight.getText().toString()) * Integer.parseInt(arm.getText().toString())));

        }
        else if (!weight.getText().toString().equals("") && !moment.getText().toString().equals("")){
            arm.setText(String.valueOf(Integer.parseInt(moment.getText().toString()) / Integer.parseInt(weight.getText().toString())));
        }
        else if (!arm.getText().toString().equals("") && !moment.getText().toString().equals("")){
            weight.setText(String.valueOf(Integer.parseInt(moment.getText().toString()) / Integer.parseInt(arm.getText().toString())));
        }
        return new EditText[] {weight, arm, moment};
    }

    public void calcButton (View view){
        EditText [] [] texts = {{(EditText) findViewById(R.id.c1), (EditText) findViewById(R.id.c2), (EditText) findViewById(R.id.c3)},
                                {(EditText) findViewById(R.id.c4), (EditText) findViewById(R.id.c5), (EditText) findViewById(R.id.c6)},
                                {(EditText) findViewById(R.id.c7), (EditText) findViewById(R.id.c8), (EditText) findViewById(R.id.c9)},
                                {(EditText) findViewById(R.id.c10), (EditText) findViewById(R.id.c11), (EditText) findViewById(R.id.c12)},
                                {(EditText) findViewById(R.id.c13), (EditText) findViewById(R.id.c14), (EditText) findViewById(R.id.c15)},
                                {(EditText) findViewById(R.id.c16), (EditText) findViewById(R.id.c17), (EditText) findViewById(R.id.c18)},
                                {(EditText) findViewById(R.id.c19), (EditText) findViewById(R.id.c20), (EditText) findViewById(R.id.c21)}};

        int tweight = 0, tmoment = 0;
        TextView [] [] sums = {{(TextView) findViewById(R.id.t1), (TextView) findViewById(R.id.t2), (TextView) findViewById(R.id.t3)},
                               {(TextView) findViewById(R.id.t4), (TextView) findViewById(R.id.t5), (TextView) findViewById(R.id.t6)},
                               {(TextView) findViewById(R.id.t7), (TextView) findViewById(R.id.t8), (TextView) findViewById(R.id.t9)}};

        for (int i = 0; i < 7; i++){
            texts[i] = calculate (texts[i][0], texts[i][1], texts[i][2]);

            data[i].setWeight(Integer.parseInt(texts[i][0].getText().toString()));
            data[i].setArm(Integer.parseInt(texts[i][1].getText().toString()));
            data[i].setMoment(Integer.parseInt(texts[i][2].getText().toString()));
        }

        for (int x = 0; x < 4; x++){
            tweight = tweight + data [x].getWeight();
            tmoment = tmoment + data [x].getMoment();
        }

        data [7].setWeight(tweight);
        data [7].setArm(tmoment/tweight);
        data [7].setMoment(tmoment);

        sums[0][0].setText(String.valueOf(tweight));
        sums[0][1].setText(String.valueOf(tmoment/tweight));
        sums[0][2].setText(String.valueOf(tmoment));

        // Fuel
        tweight = tweight + data [4].getWeight();
        tmoment = tmoment + data [4].getMoment();
        // RunUp
        tweight = tweight - data [5].getWeight();
        tmoment = tmoment - data [5].getMoment();

        data [8].setWeight(tweight);
        data [8].setArm(tmoment/tweight);
        data [8].setMoment(tmoment);

        sums[1][0].setText(String.valueOf(tweight));
        sums[1][1].setText(String.valueOf(tmoment/tweight));
        sums[1][2].setText(String.valueOf(tmoment));

        // Fuel Burn
        tweight = tweight - data [6].getWeight();
        tmoment = tmoment - data [6].getMoment();

        data [9].setWeight(tweight);
        data [9].setArm(tmoment/tweight);
        data [9].setMoment(tmoment);

        sums[2][0].setText(String.valueOf(tweight));
        sums[2][1].setText(String.valueOf(tmoment/tweight));
        sums[2][2].setText(String.valueOf(tmoment));

    }
}
