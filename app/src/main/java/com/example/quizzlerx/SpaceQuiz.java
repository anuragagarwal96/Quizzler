package com.example.quizzlerx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SpaceQuiz extends AppCompatActivity {

    TextView mQuestionTextView;
    TextView mScoreText;
    ProgressBar mProgressBar;


    int mScore;


    final int PROGRESS_BAR_INCREMENT = 10;


    int mIndex;
    int mQuestion;

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),

    };

    public void trueButton(View v){


        checkAnswer(true);
        updateQuestion();
    }
    public void falseButton(View v){

             checkAnswer(false);
             updateQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.questionText);
        mScoreText = (TextView) findViewById(R.id.scoreText);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarActivity);

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);

    }

    public void updateQuestion(){

        mScoreText.setText("Score " + mScore + "/10");
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);

        mIndex = (mIndex + 1) % 10 ;
        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);


        if(mIndex == 0){

            AlertDialog.Builder myAlertD = new AlertDialog.Builder(this);
            myAlertD.setTitle("Game Over");
            myAlertD.setCancelable(false);
            myAlertD.setMessage("You Scored " + mScore);
            myAlertD.setPositiveButton("close Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            myAlertD.show();

        }
    }

    public void checkAnswer(boolean userSelection){


        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();

        if(userSelection == correctAnswer){
            mScore = mScore + 1;

            Toast.makeText(getApplicationContext(),"You Got it",Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
        }
    }
}