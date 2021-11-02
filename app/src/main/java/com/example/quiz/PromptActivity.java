package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PromptActivity extends AppCompatActivity {
    public static final String KEY_EXTRA_ANSWER_SHOWN="answerShown";
    private Button showCorrectAnswerButton;
    private TextView answerTextView;
    private boolean correctAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
        correctAnswer=getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER,true);
        showCorrectAnswerButton = findViewById(R.id.button);
        answerTextView = findViewById(R.id.answer_text_view);

        showCorrectAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int answer=correctAnswer ? R.string.button_true : R.string.button_false;
                answerTextView.setText(answer);
                setAnswerShowResult(true);
            }
        });
    }

    private void setAnswerShowResult(boolean answerWasShown){
        Intent resultIntent=new Intent();
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN,answerWasShown);
        setResult(RESULT_OK,resultIntent);
    }
}