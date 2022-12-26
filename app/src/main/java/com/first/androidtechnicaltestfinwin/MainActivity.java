package com.first.androidtechnicaltestfinwin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
Button butsignin;
TextInputEditText emaill,passwordd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butsignin = (Button) findViewById(R.id.btsignin);
        emaill = (TextInputEditText) findViewById(R.id.edemeil);
        passwordd = (TextInputEditText)findViewById(R.id.edpassword);
        butsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (emaill.getText().toString().equals("")||passwordd.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter correct email and password",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                }

            }
        });
    }
}