package com.example.shraboni.algorithmdesignforads.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shraboni.algorithmdesignforads.R;
import com.example.shraboni.algorithmdesignforads.ui.addAdvertise.AddAdvertiseActivity;
import com.example.shraboni.algorithmdesignforads.ui.createUser.CreateUserActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView{

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnRegister;
    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        presenter =  new LoginPresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callOnLogin();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateUserActivity.class));
            }
        });
    }

    @Override
    public void onSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, AddAdvertiseActivity.class));
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    private void callOnLogin() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if(email != null && !email.isEmpty() && password != null && !password.isEmpty()){
            presenter.doLogin(email,password);
        }else{
            Toast.makeText(this, "please enter the fields !", Toast.LENGTH_SHORT).show();
        }

    }
}
