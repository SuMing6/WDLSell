package com.example.sell.view;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.sell.R;
import com.example.sell.adapter.CommodCommodAdapter;
import com.example.sell.fragment.CommodAllFragment;
import com.example.sell.fragment.CommodLowerFragment;
import com.example.sell.fragment.CommodSellFragment;

import java.util.ArrayList;

public class CommodCommodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XNAJ();
        setContentView(R.layout.activity_commod_commod);
        //头部导航栏
        head();
        //退出页面
        back();
    }

    private void back() {
        TextView textView = findViewById(R.id.commod_commod_back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void head() {
        TabLayout tabLayout = findViewById(R.id.commod_commod_TabLayout);
        ViewPager viewPager = findViewById(R.id.commod_commod_ViewPage);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> list_Title = new ArrayList<>();

        fragmentList.add(new CommodAllFragment());
        fragmentList.add(new CommodSellFragment());
        fragmentList.add(new CommodLowerFragment());

        list_Title.add("全部");
        list_Title.add("出售中");
        list_Title.add("已下架");

        viewPager.setAdapter(new CommodCommodAdapter(getSupportFragmentManager(),CommodCommodActivity.this,fragmentList,list_Title));
        tabLayout.setupWithViewPager(viewPager);//此方法就是让tablayout和ViewPager联动

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
