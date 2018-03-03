package com.clockytheandroidclock.morningwood;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int correctButtonId = -1;

    private static final int[] buttonIds = new int[] {
            R.id.btn_A,
            R.id.btn_B,
            R.id.btn_C,
            R.id.btn_D
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        setQuestion();
    }

    public void setQuestion() {
        Random rnd = new Random();
        int a = rnd.nextInt(100);
        int b = rnd.nextInt(100);

        String question = "What is " + a + " + " + b + "?";

        int[] answers = new int[] {-1, -1, -1, -1};

        int correctAns = rnd.nextInt(4);
        correctButtonId = buttonIds[correctAns];

        answers[correctAns] = a + b;
        for (int i = 0; i < 4; i++) {
            if (i == correctAns) continue;
            do {
                answers[i] = rnd.nextInt(200);
            } while (answers[i] == a + b);
        }

        TextView questionText = findViewById(R.id.question_text);
        questionText.setText(question);

        Button[] ansBtns = new Button[] {
                findViewById(R.id.btn_A),
                findViewById(R.id.btn_B),
                findViewById(R.id.btn_C),
                findViewById(R.id.btn_D),
        };
        for (int i = 0; i < ansBtns.length; i++) {
            ansBtns[i].setText(String.valueOf(answers[i]));
        }
    }

    /**
     * Change color of the correct answer button, then choose new question
     * @param view clicked view
     */
    public void onClick(final View view) {

        final Drawable saveBackground = findViewById(correctButtonId).getBackground();
        int color = (view.getId() == correctButtonId)? Color.GREEN : Color.RED;

        view.setBackgroundColor(color);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setBackgroundDrawable(saveBackground);
                setQuestion();
            }
        }, 400);
    }
}