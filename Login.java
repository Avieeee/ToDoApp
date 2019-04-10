package com.mobile.taskmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class Login extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Button login;
    private TextView forgotpass;
    private Button createAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (TextView) findViewById(R.id.et_username);
        password = (TextView) findViewById(R.id.et_password);
        login = (Button) findViewById(R.id.btn_login);
        forgotpass = (TextView) findViewById(R.id.forgot_password);
        createAccount = (Button) findViewById(R.id.txt_create_an_account);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent search = new Intent(Login.this, lists_todo.class);
                startActivity(search);

            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }


        });

    }
}
