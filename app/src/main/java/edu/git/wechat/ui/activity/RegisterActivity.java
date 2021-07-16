package edu.git.wechat.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.git.wechat.R;
import edu.git.wechat.model.database.DBOpenHelper;
import edu.git.wechat.utils.UtilsPhone;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_rgsName, et_rgsAcc, et_rgsPsw;
    private DBOpenHelper dbOpenHelper;
    private Button button,button_phone_register;
    private EditText editText,editTextTextPersonName,ed_register_phone_number,editTextTextPassword;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//禁止横屏
        setContentView(R.layout.activity_register);
        initView();//初始化界面
        dbOpenHelper = new DBOpenHelper(this);
        /*button = findViewById(R.id.button_phone_register);
        imageView = findViewById(R.id.imageView2);*/
        /*imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoadingActivity.class));
            }
        });*/
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.tv_register_phone_number);
                String text_phone;
                text_phone = editText.getText().toString();
                if (TextUtils.isEmpty(text_phone)){
                    new HintAlertDialog(RegisterActivity.this).showDialog(new View(RegisterActivity.this));
                    return;
                }
                startActivity(new Intent(RegisterActivity.this, OtherLoginActivity.class));
            }
        });*/
    }

        private void initView() {
            editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
            ed_register_phone_number = findViewById(R.id.ed_register_phone_number);
            editTextTextPassword = findViewById(R.id.editTextTextPassword);
            button_phone_register = findViewById(R.id.button_phone_register);
            imageView = findViewById(R.id.imageView2);

            imageView.setOnClickListener(this);
            button_phone_register.setOnClickListener(this);
        }
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView2://返回登录界面
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.button_phone_register://注册按钮
                    //获取用户输入的用户名、密码、验证码
                    String username = editTextTextPersonName.getText().toString().trim();
                    String account = ed_register_phone_number.getText().toString().trim();
                    String password = editTextTextPassword.getText().toString().trim();
                    //注册验证
                    if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)) {
                        if ((UtilsPhone.checkTel(account))) {
                            dbOpenHelper.insert(username,account,password);
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                            Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "不电话号码的格式", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "注册失败，请重新注册！！！", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
}