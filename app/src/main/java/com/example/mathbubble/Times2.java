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

    //String mult = getIntent().getStringExtra("multiplying");
    int multiplying = 2;
    int rightAnswer;
    int min = 1;
    int max = 11;
    Random random = new Random();

    int [] answers = new int[4];
    Button [] buttons;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times2);

        int multiplier = random.nextInt(max - min) + 1;
        //textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

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
    public void setAnswers(View view){
        int multiplier = random.nextInt(max - min) + 1;
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

        assignWrongAnswers();

        printButtonValues();

        assignRightAnswer();

    } //END setAnswers

    @SuppressLint("DefaultLocale")
    public void assignWrongAnswers(){
        int multiplier = random.nextInt(max - min) + 1;
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        for (int i = 0; i < answers.length; i++){
            int wrongAnswer = (random.nextInt(max -min) + 1) * multiplying;
            if (wrongAnswer != rightAnswer){
                answers[i] = wrongAnswer;
            }
        }

        if ((answers[0] == answers[1])
                || (answers[2] == answers[1])
                || (answers[0] == answers[2])
                || (answers[3] == answers[2])
                || (answers[3] == answers[1])
                || (answers[0] == answers[3])){
            assignWrongAnswers();
        }

    } //END assignWrongAnswers()

    public void printButtonValues(){
        for (int i = 0; i < answers.length; i ++){
            buttons[i].setText(String.valueOf(answers[i]));
        }
    }

    public void assignRightAnswer(){
        int rightAnswerLocation = random.nextInt(4);
        buttons[rightAnswerLocation].setText(String.valueOf(rightAnswer));
    }
}

/* TODO FIX assignRightAnswer(); not printing values */