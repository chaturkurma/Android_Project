
package com.example.projectproposal;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button By;
    private Button By1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );
        
        By = (Button) findViewById(R.id.Adminlogin);
        By1 = (Button) findViewById(R.id.Studentlogin);

        By.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(MainActivity.this, adminlogin.class);
                startActivity(ini);


            }
        });

        By1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(MainActivity.this,WelcomePage.class);
                startActivity(ini);


            }
        });
    }
}










