package edu.git.wechat.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import edu.git.wechat.R;
import edu.git.wechat.utils.HintAlertDialog;

public class OtherLoginActivity extends AppCompatActivity {

    private Button button;
    private EditText editText,editTextName,editTextPassword;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//禁止横屏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_login);
        button = findViewById(R.id.phone_login_other_next);
        editTextName = findViewById(R.id.tv_other_login_phone_number);
        editTextPassword = findViewById(R.id.tv_login_phone_password);
        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherLoginActivity.this,LoadingActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.tv_other_login_phone_number);
                String text_phone;
                text_phone = editText.getText().toString();
                if (TextUtils.isEmpty(text_phone)){
                    new HintAlertDialog(OtherLoginActivity.this).showDialog(new View(OtherLoginActivity.this));
                    return;
                }

                Intent intent = new Intent(OtherLoginActivity.this, MainActivity.class);
               /* User user = new User();
                user.setPhoneNumber(Integer.parseInt(editTextName.getText().toString()));
                user.setPassword(editTextPassword.getText().toString());
                intent.putExtra("user", (Parcelable) user);*/
                startActivity(intent);
            }
        });

    }
}