package com.example.projectproposal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class SendRequestActivity extends AppCompatActivity {

    Button sendRequest;
    EditText gre;
    EditText gpa;
    EditText toefl;
    EditText ielts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

         gre = findViewById(R.id.greApply);
         gpa = findViewById(R.id.gpaApply);
        toefl = findViewById(R.id.toeflApply);
         ielts = findViewById(R.id.ieltsApply);
        sendRequest = findViewById(R.id.sendRequest);
        final ParseUser currentUser = ParseUser.getCurrentUser();
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseObject adminRequest = new ParseObject("adminRequest");
                adminRequest.put("clientId", currentUser.getUsername());
                adminRequest.put("gre", gre.getText().toString().toLowerCase());
                adminRequest.put("gpa", gpa.getText().toString().toLowerCase());
                adminRequest.put("toefl", toefl.getText().toString().toLowerCase());
                adminRequest.put("ielts", ielts.getText().toString().toLowerCase());

                adminRequest.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            Toast.makeText(SendRequestActivity.this, "Request sent!", Toast.LENGTH_LONG).show();
                        } else {

                            Toast.makeText(SendRequestActivity.this, e.getMessage()+" Error in sending request", Toast.LENGTH_LONG).show();
                        }
                        // Here you can handle errors, if thrown. Otherwise, "e" should be null
                    }
                });
            }
        });


    }
}
