package edu.git.wechat.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class HintAlertDialog {
    private Context context ;

    public HintAlertDialog(Context context) {
        this.context = context;
    }
    public void showDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("没有用户名");
        builder.setTitle("用户名或密码错误！！！");
        builder.setMessage("请重新正确输出");
        builder.setPositiveButton("我知道了",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
