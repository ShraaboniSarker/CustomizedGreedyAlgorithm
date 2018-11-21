package com.example.shraboni.algorithmdesignforads.ui.createUser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shraboni.algorithmdesignforads.R;
import com.example.shraboni.algorithmdesignforads.ui.login.LoginActivity;

public class CreateUserActivity extends AppCompatActivity implements ICreateUserView{

    EditText etName;
    EditText etEmail;
    EditText etPassword;
    EditText etDob;
    Button btnRegister;
    private ICreateUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etDob = findViewById(R.id.etDob);
        btnRegister = findViewById(R.id.btnRegister);
        presenter = new CreateUserPresenter(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regiterUser();
            }
        });
    }

    private void regiterUser() {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String dob = etDob.getText().toString();

        if (name != null && !name.isEmpty() && password != null && !password.isEmpty()
                &&email != null && !email.isEmpty() && dob != null && !dob.isEmpty()){
            presenter.registerUser(name,email,password,dob);
        }
    }

    @Override
    public void onSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CreateUserActivity.this, LoginActivity.class));
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
