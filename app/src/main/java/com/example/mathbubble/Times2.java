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
    int rightAnswer;

    int [] answers = {1,2,3,4};
    Button [] buttons;

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
    }

    @SuppressLint("DefaultLocale")
    public void setAnswers(View view){
        Random random = new Random();
        int multiplier = random.nextInt(10) + 1;
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

        for (int i = 0; i < answers.length; i++){
            int wrongAnswer = (random.nextInt(10) + 1) * multiplying;
            if (rightAnswer != wrongAnswer){
                answers[i] = wrongAnswer;
            }

        }

        for (int i = 0; i < buttons.length; i ++){
            buttons[i].setText(String.valueOf(answers[i]));
        }

         int rightAnswerLocation = random.nextInt(4);

        buttons[rightAnswerLocation].setText(String.valueOf(rightAnswer));

        /* TODO
         ELIMINATE DUPLICATED ANSWERS
         */

    }
}