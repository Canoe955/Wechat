
package edu.git.wechat.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.git.wechat.R;
import edu.git.wechat.model.entity.User;
import edu.git.wechat.viewmodel.UserViewModel;

public class TestLogingActivity extends AppCompatActivity {
    Button buttonInsert,buttonRegister;
    EditText editTextAccount,editTextPassword;
    UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_loging);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonRegister = findViewById(R.id.buttonRegister);
        editTextAccount = findViewById(R.id.editTextAccount);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strAccount = editTextAccount.getText().toString().trim();
                String strPassword  = editTextPassword.getText().toString().trim();
                User user = new User(null,strAccount,strPassword,null);
                userViewModel.insertUser(user);
                if (user != null){
                    Toast.makeText(getApplication(),"注册成功",Toast.LENGTH_LONG);
                    startActivity(new Intent(TestLogingActivity.this,TestActivity.class));
                }
            }
        });
    }
}