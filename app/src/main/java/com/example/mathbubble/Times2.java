package com.example.mathbubble;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Times2 extends AppCompatActivity {

    Button button0, button1, button2, button3;
    TextView textView;

    int multiplying = 2;
    int multiplier;
    int rightAnswer;

    Random random = new Random();

    int [] multipliers = new int[4];
    Button [] buttons;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times2);


        button0 = findViewById(R.id.topLeftButton);
        button1 = findViewById(R.id.topRightButton);
        button2 = findViewById(R.id.bottomLeftButton);
        button3 = findViewById(R.id.bottomRightButton);
        textView = findViewById(R.id.textView);

        buttons = new Button[]{button0, button1,
                button2, button3};
        multiplier = (random.nextInt(10) + 1);
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

        generateMultipliers();
        printButtonValues();
        assignRightAnswer();
    } //END onCreate


    @SuppressLint("DefaultLocale")
    public void setMultipliers(View view){
        multiplier = (random.nextInt(10) + 1);
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

        generateMultipliers();

        printButtonValues();

        assignRightAnswer();

    } //END setAnswers


    public void generateMultipliers(){
        for (int i = 0; i < multipliers.length; i ++){
            int multiplier = (random.nextInt(10) + 1) * multiplying;
            while (multiplier == rightAnswer ){
                multiplier = (random.nextInt(10) + 1) * multiplying;
            }
            multipliers[i] = multiplier;
        }

        if ((multipliers[0] == multipliers[1])
                || (multipliers[2] == multipliers[1])
                || (multipliers[0] == multipliers[2])
                || (multipliers[3] == multipliers[2])
                || (multipliers[3] == multipliers[1])
                || (multipliers[0] == multipliers[3])){
            generateMultipliers();
        }
    }

    public void printButtonValues(){
        for (int i = 0; i < multipliers.length; i ++){
            buttons[i].setText(String.valueOf(multipliers[i]));
        }
    }

    public void assignRightAnswer(){
        int rightAnswerLocation = random.nextInt(4);
        buttons[rightAnswerLocation].setText(String.valueOf(rightAnswer));
    }
}

/* TODO  */