package edu.git.wechat.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import edu.git.wechat.R;
import edu.git.wechat.model.database.DBOpenHelper;
import edu.git.wechat.model.entity.Accounts;
import edu.git.wechat.model.entity.User;
import edu.git.wechat.utils.HintAlertDialog;
import edu.git.wechat.utils.UtilsPhone;
import edu.git.wechat.viewmodel.UserViewModel;

/**
 * 实现 implements View.OnClickListener之后
 * 就可以将onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private DBOpenHelper dbOpenHelper;
    TextView textView, textView1;
    Button buttonLogin;
    EditText editTextAccount, editTextPassword;
    ImageView imageView;
    private String userName;
    UserViewModel userViewModel;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
//        Objects.requireNonNull(getSupportActionBar()).hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//禁止横屏

        setContentView(R.layout.activity_login);
        initView();
        dbOpenHelper = new DBOpenHelper(this);

    }

    public void initView() {
        textView = findViewById(R.id.tv_other_login);
        buttonLogin = findViewById(R.id.phone_login_other_next);
        imageView = findViewById(R.id.image_exit);
        editTextAccount = findViewById(R.id.tv_login_phone_number);
        editTextPassword = findViewById(R.id.editTextTextPassword2);

        buttonLogin.setOnClickListener(this);
        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_other_login:
                startActivity(new Intent(this,OtherLoginActivity.class));
            case R.id.image_exit:
                startActivity(new Intent(this,LoadingActivity.class));
            case R.id.phone_login_other_next:
                    String name = editTextAccount.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();
                    //判断是否为空
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                        ArrayList<Accounts> data = dbOpenHelper.getAccount();
                        //先用一个线程去取数据 在放到ui线程上面去执行
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ArrayList<Accounts> data = dbOpenHelper.getAccount();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (data.size() == 0){
                                            @SuppressLint("ShowToast") Toast toast =
                                                    Toast.makeText(getApplication(), "请您先去注册!!!", Toast.LENGTH_SHORT);
                                            toast.show();
                                        }else {
                                            for (int i = 0; i < data.size(); i++) {
                                                Accounts accounts = data.get(i);
                                                String str_account = accounts.getAccount();
                                                String str_password = accounts.getPassword();
                                                if ((name.equals(str_account) && password.equals(str_password))) {
                                                    userName = accounts.getName();
                                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                                }else {
                                                    Toast.makeText(getApplication(), "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        }).start();
                    } else {
                        Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                    }
        }
        }


             /*  if (data.size()==0){
                            Toast.makeText(this, "请您先去注册！！！", Toast.LENGTH_SHORT).show();
                        }else{
                            for (int i = 0; i < data.size(); i++) {
                                Accounts accounts = data.get(i);
                                String str_account = accounts.getAccount();
                                String str_password = accounts.getPassword();
                                if ((name.equals(str_account) && password.equals(str_password))) {
                                    userName = accounts.getName();
                                    Thread thread = new Thread() {
                                        @Override
                                        public void run() {
                                            try {
                                                sleep(2000);
                                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                                finish();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    };
                                    thread.start();
                                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }*/

         /*SharedPreferences sp = getSharedPreferences("accounts_account", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (sp.getBoolean("flag", false)) {
            String acc_read = sp.getString("acc", "");
            String psw_read = sp.getString("psw", "");
            editTextAccount.setText(acc_read);
            editTextPassword.setText(psw_read);
        }*/




//        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        /*textView = findViewById(R.id.tv_other_login);
        buttonLogin = findViewById(R.id.phone_login_other_next);
        imageView = findViewById(R.id.image_exit);*/

        /*textView.setOnClickListener(new View.OnClickListener() {
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
        });*/






       /* buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAccount = findViewById(R.id.tv_login_phone_number);
                editTextPassword = findViewById(R.id.editTextTextPassword2);
                String text_phone = editTextAccount.getText().toString().trim();
                String text_password = editTextPassword.getText().toString().trim();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                // 使用正则判断输入是否合法
              *//*  intent.putExtra("phone",text_phone);
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
                }*//*

     *//* AsyncTask<String, Void, User> stringVoidVoidAsyncTask = userViewModel.queryUserUser(text_phone);
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
                }*//*
                startActivity(intent);
            }
        });*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();;*/

}