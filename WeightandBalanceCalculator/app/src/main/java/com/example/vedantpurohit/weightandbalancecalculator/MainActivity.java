package com.example.vedantpurohit.weightandbalancecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendCalculate (View view){
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

    public void sendInstruct (View view){
        Intent intent = new Intent (this, Instructions.class);
        startActivity(intent);
    }
}
