package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPassword extends AppCompatActivity {
    private EditText emailEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        emailEt = findViewById(R.id.emailET);

    }

    public void resetPassword(View v) {
        final String email = emailEt.getText().toString();
        /*added validation to check if email is blank*/
        if( TextUtils.isEmpty(emailEt.getText())){
            emailEt.setError( "Email is required!" );
        }else {
            ParseUser.requestPasswordResetInBackground(emailEt.getText().toString(), new RequestPasswordResetCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // An email was successfully sent with reset instructions.
                        Toast.makeText(ForgotPassword.this, "An email was successfully sent with reset instructions.", Toast.LENGTH_LONG).show();
                    } else {
                        // Something went wrong. Look at the ParseException to see what's up.
                        Toast.makeText(ForgotPassword.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

}

       // BT6.setOnClickListener(new View.OnClickListener() {

         //   @Override
           // public void onClick(View view) {

             //   Intent ini = new Intent(ForgotPassword.this,MainActivity.class);
               // startActivity(ini);

            //}
        //});




    //}
//}
