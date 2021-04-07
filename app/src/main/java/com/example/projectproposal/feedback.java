package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class feedback extends AppCompatActivity {
    private Button BTN6;
    private TextView feedback;
    private TextView Rating;
    private EditText E1;
    private EditText E2;
    private TextView Title;
    private Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        TextView feedback  = (TextView) findViewById(R.id.feedback);
        TextView Rating = (TextView) findViewById(R.id.textView9);
        TextView Title = (TextView) findViewById(R.id.bt);
        BTN6 = (Button) findViewById(R.id.FinishBTN);
        EditText E1 = (EditText)findViewById(R.id.editText4);
        EditText E2 = (EditText)findViewById(R.id.editText5);
        B1 = (Button) findViewById(R.id.Back);



        BTN6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(feedback.this,MainActivity.class);
                startActivity(ini);

            }

        });

        B1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(feedback.this,SecondActivity.class);
                startActivity(ini);

            }

        });
    }
}
