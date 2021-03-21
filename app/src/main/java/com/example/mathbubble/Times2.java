package com.example.mathbubble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Times2 extends AppCompatActivity {

    Button topLeftButton, topRightButton, midLeftButton, midRightButton, bottomLeftButton, bottomRightButton;
    int wrongAnswer;

    int [] answers = {1,2,3,4,5,6};
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
        midLeftButton = findViewById(R.id.midLeftButton);
        midRightButton = findViewById(R.id.midRightButton);
        bottomLeftButton = findViewById(R.id.bottomLeftButton);
        bottomRightButton = findViewById(R.id.bottomRightButton);
        setAnswers();
    }

    public void setAnswers(){

        for (int i = 0; i < answers.length; i++){
            Random random = new Random();
            wrongAnswer = random.nextInt(10) + 1;
                answers[i] = wrongAnswer * 2;

        }
         topLeftButton.setText(String.valueOf(answers[0]));
         topRightButton.setText(String.valueOf(answers[1]));
         midLeftButton.setText(String.valueOf(answers[2]));
         midRightButton.setText(String.valueOf(answers[3]));
         bottomLeftButton.setText(String.valueOf(answers[4]));
         bottomRightButton.setText(String.valueOf(answers[5]));
        }
    }