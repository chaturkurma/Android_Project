package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class WelcomePage extends AppCompatActivity {
    private EditText id;
    private EditText password;
    private TextView info;
    private Button but;
    private TextView title;
    private Button but1;
    private Button but2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        id =findViewById(R.id.name);
        password = findViewById((R.id.Password));
        //TextView info = (TextView) findViewById(R.id.textView);
        but =findViewById(R.id.button);
        title =findViewById(R.id.Title);
        but1 = findViewById(R.id.New);
        but2 = findViewById(R.id.Fpassword);

        but2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(WelcomePage.this, ForgotPassword.class);
                startActivity(ini);

            }
        });
    }

    public void gotoSignInAction(View v) {
         String user = id.getText().toString();
         String p = password.getText().toString();
        if (user.length() == 0) {
            id.requestFocus();
            id.setError("Id cannot be empty!!");
        } else   if (p.length() == 0) {
            password.requestFocus();
            password.setError("Password cannot be empty!!");
        } else {

            ParseUser.logInInBackground(user, p, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {

                    if (parseUser != null) {

                        Toast.makeText(WelcomePage.this, "Welcome back!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(WelcomePage.this, Survey_Page.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(WelcomePage.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }


        

        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

              Intent ini = new Intent(WelcomePage.this,Signup.class);
            startActivity(ini);

            }
            });


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


        //[but.setOnClickListener(new View.OnClickListener() {

           // @Override
            //public void onClick(View view) {

                //Intent ini = new Intent(WelcomePage.this,Survey_Page.class);
               // startActivity(ini);

           // }
       // });
       // but1.setOnClickListener(new View.OnClickListener() {

            //@Override
            //public void onClick(View view) {

              //  Intent ini = new Intent(WelcomePage.this,Signup.class);
                //startActivity(ini);

            //}
        //});]
        //but2.setOnClickListener(new View.OnClickListener() {

            //@Override
          //  public void onClick(View view) {

        //        Intent ini = new Intent(WelcomePage.this,ForgotPassword.class);
      //          startActivity(ini);

    //        }
       // });


  //  }


//}
