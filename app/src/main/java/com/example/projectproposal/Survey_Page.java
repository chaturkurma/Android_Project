package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Survey_Page extends AppCompatActivity {
private TextView title1;
private Button btn2;
private Button btn3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey__page);

        TextView title1 = (TextView) findViewById(R.id.surveypage);
        btn2 = (Button) findViewById(R.id.ContinueBTN);
        btn3 = (Button) findViewById(R.id.CancelBTN);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(Survey_Page.this,Survey_questions.class);
                startActivity(ini);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


               Intent ini = new Intent(Survey_Page.this,WelcomePage.class);
               startActivity(ini);

            }
        });


    }
}
