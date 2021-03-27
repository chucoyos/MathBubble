package com.example.mathbubble;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Times2 extends AppCompatActivity {

    Button button0, button1, button2, button3;
    TextView textView;

    //String mult = getIntent().getStringExtra("multiplying");
    int multiplying = 2;
    int multiplier;
    int rightAnswer;
    int min = 1;
    int max = 11;
    Random random = new Random();

    int [] multipliers = new int[4];
    Button [] buttons;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times2);

        //multiplier = random.nextInt(max - min) + 1;
        //textView.setText(String.format( "%d X %d", multiplying, multiplier));
        //rightAnswer = multiplying * multiplier;

        button0 = findViewById(R.id.topLeftButton);
        button1 = findViewById(R.id.topRightButton);
        button2 = findViewById(R.id.bottomLeftButton);
        button3 = findViewById(R.id.bottomRightButton);
        textView = findViewById(R.id.textView);

        buttons = new Button[]{button0, button1,
                button2, button3};

        assignWrongAnswers();
        printButtonValues();
        assignRightAnswer();
    } //END onCreate


    @SuppressLint("DefaultLocale")
    public void setMultipliers(View view){
        multiplier = random.nextInt(max - min) + 1;
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

        //assignWrongAnswers();

        generateMultipliers();

        printButtonValues();

        //assignRightAnswer();
        Log.i("multiplier", String.valueOf(multiplier));
        Log.i("rightAnswer", String.valueOf(rightAnswer));

    } //END setAnswers

    @SuppressLint("DefaultLocale")
    public void assignWrongAnswers(){
        int multiplier = random.nextInt(max - min) + 1;
        for (int i = 0; i < multipliers.length; i++){
            int wrongAnswer = (random.nextInt(max - min) + 1) * multiplying;
            if (wrongAnswer != rightAnswer){
                multipliers[i] = wrongAnswer;
            }
        }

        if ((multipliers[0] == multipliers[1])
                || (multipliers[2] == multipliers[1])
                || (multipliers[0] == multipliers[2])
                || (multipliers[3] == multipliers[2])
                || (multipliers[3] == multipliers[1])
                || (multipliers[0] == multipliers[3])){
            assignWrongAnswers();
        }

    } //END assignWrongAnswers()

    public void generateMultipliers(){
        for (int i = 0; i < multipliers.length; i ++){
            int multiplier = random.nextInt((max - min) +1) * multiplying;;
            while (multiplier == rightAnswer ){
                multiplier = random.nextInt((max - min) +1) * multiplying;
            }
            multipliers[i] = multiplier;
        }
    }

    public void printButtonValues(){
        for (int i = 0; i < multipliers.length; i ++){
            buttons[i].setText(String.valueOf(multipliers[i]));
            Log.i("Answers", String.valueOf(multipliers[i]));
        }
    }

    public void assignRightAnswer(){
        int rightAnswerLocation = random.nextInt(4);
        //buttons[0].setText(String.valueOf(rightAnswer));
    }
}

/* TODO FIX assignWrongAmswers() is printing duplicated values, assignRightAnswer(); printing some duplicated buttons(sometimes) and extraString null reference */