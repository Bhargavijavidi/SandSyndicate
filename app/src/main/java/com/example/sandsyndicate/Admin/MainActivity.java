package com.example.sandsyndicate.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sandsyndicate.R;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button) findViewById((R.id.Login));
        ed1=(EditText) findViewById(R.id.USER);
        ed2=(EditText) findViewById(R.id.PASSWORD);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().isEmpty())

                {

                }
            }
        }
    }
}