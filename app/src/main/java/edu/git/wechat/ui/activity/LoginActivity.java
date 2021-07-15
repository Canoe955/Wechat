package edu.git.wechat.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import edu.git.wechat.R;
import edu.git.wechat.model.entity.User;
import edu.git.wechat.viewmodel.UserViewModel;

public class LoginActivity extends AppCompatActivity {

    TextView textView,textView1;
    Button buttonLogin;
    EditText editTextAccount, editTextPassword;
    ImageView imageView;
    UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        textView = findViewById(R.id.tv_other_login);
        buttonLogin = findViewById(R.id.phone_login_other_next);
        imageView = findViewById(R.id.image_exit);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,OtherLoginActivity.class));
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,LoadingActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAccount = findViewById(R.id.tv_login_phone_number);
                editTextPassword = findViewById(R.id.editTextTextPassword2);
                String text_phone = editTextAccount.getText().toString().trim();
                String text_password = editTextPassword.getText().toString().trim();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                // 使用正则判断输入是否合法
              /*  intent.putExtra("phone",text_phone);
                //电话是否为空
                if(!(TextUtils.isEmpty(text_phone)||TextUtils.isEmpty(text_password))){
                    //使用正则表达式检查输入是否符合
                    if(UtilsPhone.checkTel(text_phone)){
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"请输入有效的手机号",Toast.LENGTH_LONG).show();
                    }
                }else {
                     new HintAlertDialog(LoginActivity.this).showDialog(new View(LoginActivity.this));
//                   Toast.makeText(this, "请输入手机号！！！", Toast.LENGTH_SHORT).show();
                }*/

               /* AsyncTask<String, Void, User> stringVoidVoidAsyncTask = userViewModel.queryUserUser(text_phone);
                try {
                    User usr = stringVoidVoidAsyncTask.execute("").get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String account = usr.getAccount();
                            if (account.equals(text_phone)){
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplication(), "账号错误！！！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }*/
                startActivity(intent);
            }
        });

        /*new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();;*/
    }
}