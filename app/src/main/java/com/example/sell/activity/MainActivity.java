package com.example.sell.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.sell.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private int viewLanguage;
    private CheckBox language_zg;
    private CheckBox language_jpz;
    private RadioGroup loging_radioGroup;
    private SharedPreferences sp;
    private EditText main_phone;
    private EditText main_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XNAJ();
        setContentView(R.layout.activity_main);
        //输入框失去焦点
        main_phone = findViewById(R.id.main_phone);
        main_pwd = findViewById(R.id.main_pwd);
        edittext();
        //点击注册页面
        Register();
        //忘记密码
        Forget();
        //点击登录
        Loging();
        //切换语言
        language();
    }

    private void edittext() {
        main_phone.setFocusable(false);
        main_pwd.setFocusable(false);
        main_phone.clearFocus();
        //输入框获取焦点
        main_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_phone.setFocusable(true);
                main_phone.setFocusableInTouchMode(true);
                main_phone.requestFocus();
            }
        });
        main_pwd.clearFocus();
        //输入框获取焦点
        main_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_pwd.setFocusable(true);
                main_pwd.setFocusableInTouchMode(true);
                main_pwd.requestFocus();
            }
        });
    }

    private void language() {
        language_zg = findViewById(R.id.language_zg);
        language_jpz = findViewById(R.id.language_jpz);
        loging_radioGroup = findViewById(R.id.loging_RadioGroup);

        sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        boolean China = sp.getBoolean("China", true);
        String e = sp.getString("e", "1");
        if (China==true){
            language_zg.setChecked(true);
            language_jpz.setChecked(false);
        }else {
            language_zg.setChecked(false);
            language_jpz.setChecked(true);
        }

        /*if (e.equals("1")){
            language_zg.setChecked(true);
            language_jpz.setChecked(false);
            changeAppLanguage(Locale.SIMPLIFIED_CHINESE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("e","3");
            edit.commit();
            edit.apply();

        }else if (e.equals("2")){
            language_zg.setChecked(false);
            language_jpz.setChecked(true);
            changeAppLanguage(Locale.UK);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("e","3");
            edit.commit();
            edit.apply();
        }*/


        language_zg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAppLanguage(Locale.SIMPLIFIED_CHINESE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("China",true);
                edit.putString("e","1");
                edit.commit();
                edit.apply();
            }
        });
        language_jpz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAppLanguage(Locale.UK);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("China",false);
                edit.putString("e","2");
                edit.commit();
                edit.apply();
            }
        });
    }
    /**
     * 更改应用语言
     *
     * @param locale
     */
    public void changeAppLanguage(Locale locale) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, metrics);
        //重新启动Activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    private void Loging() {
        Button button = findViewById(R.id.loging_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        });
        /*Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        startActivity(intent);
        finish();*/
    }

    private void Forget() {
        TextView textView = findViewById(R.id.main_forget);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Register() {
        TextView textView = findViewById(R.id.main_register);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void XNAJ() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    //为避免底部导航栏覆盖注释掉这一行
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }


}
