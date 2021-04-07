package com.example.projectproposal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Survey_questions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String climate;
    private TextView ques1;
    private TextView ques2;
    private TextView ques3;
    private Button submit;
    private EditText ans1;
    private EditText ans2;
    private EditText ans3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions);


        final EditText ans1 = findViewById(R.id.Ans1);
        final EditText ans2 = findViewById(R.id.Ans2);
        submit = findViewById(R.id.nextBTN);

        Spinner spinner = findViewById(R.id.climateDropdown);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.climatedropdown, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String a1 = ans1.getText().toString();
                String a2 = ans2.getText().toString();
                Intent ini = new Intent(Survey_questions.this, SecondActivity.class);
                ini.putExtra("a1", a1);
                ini.putExtra("a2", a2);
                ini.putExtra("a3", climate);
                startActivity(ini);

            }
        });

        Button skip=findViewById(R.id.skipBTN);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Survey_questions.this, SecondActivity.class));
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                climate = "Normal";
                break;
            case 1:
                climate = "Hot";
                break;
            case 2:
                climate = "Cold";
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
