package com.example.sell.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sell.R;
import com.example.sell.view.CommodClassActivity;
import com.example.sell.view.CommodCommodActivity;
import com.example.sell.view.CommodCustomerActivity;
import com.example.sell.view.CommodReleaseActivity;
import com.example.sell.view.CommodShopActivity;


public class CommodityFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_commodity,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //店铺设置
        shop();
        //商品管理
        commod();
        //商品分类
        commodClass();
        //发布商品
        release();
        //顾客管理
        customer();

    }

    private void customer() {
        LinearLayout linearLayout = view.findViewById(R.id.commod_customer);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommodCustomerActivity.class);
                startActivity(intent);
            }
        });
    }


    private void release() {
        LinearLayout linearLayout = view.findViewById(R.id.commod_Release);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommodReleaseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void commodClass() {
        LinearLayout linearLayout = view.findViewById(R.id.commod_class);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommodClassActivity.class);
                startActivity(intent);
            }
        });
    }

    private void commod() {
        LinearLayout linearLayout = view.findViewById(R.id.commod_commod);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommodCommodActivity.class);
                startActivity(intent);
            }
        });
    }

    private void shop() {
        LinearLayout linearLayout = view.findViewById(R.id.commod_shop);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CommodShopActivity.class);
                startActivity(intent);
            }
        });
    }


}
