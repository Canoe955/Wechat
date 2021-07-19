package edu.git.wechat.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.git.wechat.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //绑定NavController
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        //工具条的配置  navController.getGraph()-获取导航图表传递过去 或者传递fragment的id
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();
        //进行装配//activity的引用
//        NavigationUI.setupActionBarWithNavController(this,navController,configuration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        /*View view = bottomNavigationView.getChildAt(3);
        BottomNavigationView itemView = (BottomNavigationView) view;
        View badge = LayoutInflater.from(this).inflate(R.layout.fragment_tab_con_and_bottom, bottomNavigationView, false);
        itemView.addView(badge);*/

    }

}