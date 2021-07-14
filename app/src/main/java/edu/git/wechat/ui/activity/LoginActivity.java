package edu.git.wechat.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import edu.git.wechat.R;

public class LoginActivity extends AppCompatActivity {

    TextView textView,textView1;
    Button button;
    EditText editText,editText1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView = findViewById(R.id.tv_other_login);
        button = findViewById(R.id.phone_login_other_next);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.tv_login_phone_number);
                editText1 = findViewById(R.id.editTextTextPassword2);
                String text_phone;
                String text_password;
                text_phone = editText.getText().toString();
                text_password = editText1.getText().toString();
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

                startActivity(intent);
            }
        });
    }
}