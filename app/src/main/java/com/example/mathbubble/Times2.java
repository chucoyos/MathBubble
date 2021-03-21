package com.example.mathbubble;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Times2 extends AppCompatActivity {

    Button topLeftButton, topRightButton, midLeftButton, midRightButton, bottomLeftButton, bottomRightButton;
    TextView textView;
    int multiplying = 2;
    int rightAnswer;

    int [] answers = {1,2,3,4};
    Button [] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times2);

        buttons = new Button[]{topLeftButton, topRightButton,
                midLeftButton, midRightButton,
                bottomLeftButton, bottomRightButton};

        topLeftButton = findViewById(R.id.topLeftButton);
        topRightButton = findViewById(R.id.topRightButton);
        bottomLeftButton = findViewById(R.id.bottomLeftButton);
        bottomRightButton = findViewById(R.id.bottomRightButton);
        textView = findViewById(R.id.textView);
        setAnswers();
    }

    @SuppressLint("DefaultLocale")
    public void setAnswers(){
        Random random = new Random();
        int multiplier = random.nextInt(10) + 1;
        textView.setText(String.format( "%d X %d", multiplying, multiplier));
        rightAnswer = multiplying * multiplier;

        for (int i = 0; i < answers.length; i++){
                answers[i] = (random.nextInt(10) + 1) * multiplying;

        }
         topLeftButton.setText(String.valueOf(rightAnswer));
         topRightButton.setText(String.valueOf(answers[1]));
         bottomLeftButton.setText(String.valueOf(answers[2]));
         bottomRightButton.setText(String.valueOf(answers[3]));
        }
    }