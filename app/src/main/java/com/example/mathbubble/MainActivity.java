package com.example.mathbubble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void times2(View view){
        Intent intent = new Intent(this, Times2.class);
        intent.putExtra("multiplying", "2");
        startActivity(intent);
    }
}