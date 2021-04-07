package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class AddUniversity extends AppCompatActivity {

    Button addUni;
    EditText name;
    EditText type;
    EditText rate;
    EditText gre;
    EditText tofle;
    EditText location;
    EditText url;
    EditText climate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_university);

         addUni = findViewById(R.id.addUnivBtn);
         name = findViewById(R.id.addName);
        location = findViewById(R.id.addLocation);
         type = findViewById(R.id.addType);
         rate = findViewById(R.id.addRate);
         gre = findViewById(R.id.addGre);
         tofle = findViewById(R.id.addTofle);
         url = findViewById(R.id.addUrl);
         climate = findViewById(R.id.addClimate);
        addUni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseObject university = new ParseObject("university");
                university.put("name", name.getText().toString().toLowerCase());
                university.put("type", type.getText().toString().toLowerCase());
                university.put("rate", rate.getText().toString().toLowerCase());
                university.put("gre", gre.getText().toString().toLowerCase());
                university.put("tofle", tofle.getText().toString().toLowerCase());
                university.put("location", location.getText().toString().toLowerCase());
                university.put("url", url.getText().toString().toLowerCase());
                university.put("climate", climate.getText().toString().toLowerCase());
                university.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            Toast.makeText(AddUniversity.this, "University added!", Toast.LENGTH_LONG).show();
                        } else {

                            Toast.makeText(AddUniversity.this, e.getMessage()+" Error in adding university", Toast.LENGTH_LONG).show();
                        }
                        // Here you can handle errors, if thrown. Otherwise, "e" should be null
                    }
                });
            }
        });


    }
}
