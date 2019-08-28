package com.example.sell.presenter;

import com.example.sell.contract.MyContract;
import com.example.sell.model.MyModel;

import java.util.HashMap;
import java.util.Map;

public class MyPresenter<T> implements MyContract.MyPresenter {

    MyContract.MyModel myModel ;
    T t ;
    private final Map<String, String> map;

    public MyPresenter(T tt){
        t = tt ;
        this.map = new HashMap<>();
        myModel = new MyModel();
    }

    @Override
    public void PHomePage() {

    }
}
