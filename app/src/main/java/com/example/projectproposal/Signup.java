package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    private TextView Title;
    private TextView f1;
    private TextView lname;
    private TextView email;
    private TextView contact;
    private TextView password;
    private TextView confPassword;
    EditText emailET, passwordET, contactET, confirmPasswordET, fnameET, lnameET;
    private EditText a;
    private EditText b;
    private EditText c;
    private EditText d;
    private EditText e;
    private EditText f;
    private Button signupBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Title = (TextView) findViewById(R.id.title);
        f1 = (TextView) findViewById(R.id.Fname);
        lname = (TextView) findViewById(R.id.Lname);
        email = (TextView) findViewById(R.id.Email);
        contact = (TextView) findViewById(R.id.Contact);
        password = (TextView) findViewById(R.id.Password);
        confPassword = (TextView) findViewById(R.id.ConfirmPassword);

        fnameET = (EditText) findViewById((R.id.fnameET));
        lnameET = (EditText) findViewById((R.id.lnameET));
        emailET = (EditText) findViewById((R.id.emailET));
        passwordET = (EditText) findViewById((R.id.passwordET));
        contactET = (EditText) findViewById((R.id.contactET));
        confirmPasswordET = (EditText) findViewById((R.id.confirmPasswordET));
        signupBTN = (Button)findViewById(R.id.signupBTN);

    }

    public void gotoSuccessfulSignUpActivityAction(View v) {
        //Fullname Field validation
         String fName=fnameET.getText().toString();
         String mobNum=contactET.getText().toString();
         String user=lnameET.getText().toString();
         String p=passwordET.getText().toString();
         String Cpass=confirmPasswordET.getText().toString();
        if(fName.length()==0){
            fnameET.requestFocus();
            fnameET.setError("Name field cannot be empty!!");
        }
        else if(!fName.matches("[a-zA-Z ]+"))
        {
            fnameET.requestFocus();
            fnameET.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        //Mobile Number validation

        else if(mobNum.length()==0|| mobNum.length()>11){
            contactET.requestFocus();
            contactET.setError("Mobile Field is Empty/ too Long");
        }
//        else if (!Pattern.matches("[0-9]+",mobNum)){
//            contact.setError("Mobile Field should contain only numerical values");
//        }



        //Password validation
        else if(p.length()<8&&!isValidPassword(p)){
            passwordET.requestFocus();
            passwordET.setError("Enter Valid Password with atleast 1 capital letter, 1 small letter, 1 number and a symbol");
        }

        //Confirm Password Validation
        else if(!(Cpass.equals(p))){
            confirmPasswordET.requestFocus();
            confirmPasswordET.setError("Password and Confirm Password does not match");
        }

        else {
            System.out.println(emailET.getText().toString().trim());
            ParseUser userSignup = new ParseUser();

            userSignup.setUsername(emailET.getText().toString().trim());
            userSignup.setEmail(emailET.getText().toString().trim());
            userSignup.setPassword(passwordET.getText().toString());
            userSignup.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null) {
                        ParseUser currentUser = ParseUser.getCurrentUser();


                        currentUser.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {

                                    try {
                                        Intent toOtherIntent = new Intent(Signup.this, WelcomePage.class);
                                        startActivity(toOtherIntent);

                                    } catch (Exception ex) {
                                        System.out.println(ex);
                                    }

                                } else {

                                    // Toast.makeText(getActivity(), e.getMessage()+" Error in posting item", Toast.LENGTH_LONG).show();
                                }
                                // Here you can handle errors, if thrown. Otherwise, "e" should be null
                            }
                        });

                    } else {
                        System.out.println(e);
                        ParseUser.logOut();

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
