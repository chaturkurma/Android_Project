package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeventhActivity extends AppCompatActivity {
    private TextView txt;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private TextView w1;
    private TextView w2;
    private TextView w3;
    private TextView w4;
    private TextView w5;
    private Button BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        TextView t1=(TextView) findViewById(R.id.univName);
        TextView t2=(TextView) findViewById(R.id.univLoc);
        TextView t3=(TextView) findViewById(R.id.gradRate);
        TextView t4=(TextView) findViewById(R.id.ReqScore);
        TextView t5=(TextView) findViewById(R.id.score2);
        TextView txt=(TextView) findViewById(R.id.textView5);
        TextView w1=(TextView) findViewById(R.id.type);
        TextView w2=(TextView) findViewById(R.id.location);
        TextView w3=(TextView) findViewById(R.id.rate);
        TextView w4=(TextView) findViewById(R.id.gre);
        TextView w5=(TextView) findViewById(R.id.tofle);
        BTN = (Button)findViewById(R.id.button2);

        BTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(Intent.ACTION_VIEW, Uri.parse("https://undergrad.admissions.columbia.edu/apply"));
                startActivity(ini);

            }
        });


    }
}

