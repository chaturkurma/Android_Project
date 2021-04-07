package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Survey_QuestionsActivity extends AppCompatActivity {

    private TextView ques1;
    private TextView ques2;
    private TextView ques3;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions);

        TextView ques1 = (TextView) findViewById(R.id.Q1);
        TextView ques2 = (TextView) findViewById(R.id.Q2);
        TextView ques3 = (TextView) findViewById(R.id.Q3);
        submit = (Button) findViewById(R.id.nextBTN);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(Survey_QuestionsActivity.this,SecondActivity.class);
                startActivity(ini);

            }
        });

    }
}
