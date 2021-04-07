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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class adminlogin extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView info;
    private Button B1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        name =  findViewById(R.id.name);
        password =  findViewById((R.id.Password));
        B1 = findViewById(R.id.BTN6);

    }

    public void gotoSignInAction(View v) {
        String user = name.getText().toString();
        String p = password.getText().toString();
        if (user.length() == 0) {
            name.requestFocus();
            name.setError("Id cannot be empty!!");
        } else   if (p.length() == 0) {
            password.requestFocus();
            password.setError("Password cannot be empty!!");
        } else {

            ParseUser.logInInBackground(user, p, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {

                    if (parseUser != null) {

                        String role = parseUser.getString("role");
                        System.out.println(role);
                        if (role.equalsIgnoreCase("admin") ){
                            Toast.makeText(adminlogin.this, "Welcome back!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(adminlogin.this, AdminUniversityList.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(adminlogin.this, "Invalid login or password", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(adminlogin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }






}

