package com.github.huangyouqiang.databindingdemo;

import android.databinding.*;
import android.databinding.BindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by huangyouqiang on 2016/9/19.
 */
public class RecyclerHandler {
    public String text;
    public int width;
    public RecyclerHandler(String str,int totalWidth) {
        this.text = str;
        if(text.equals("null")) {
            this.shouldShow = false;
        }
        this.width = totalWidth/6;
    }

    public boolean shouldShow = true;
    public void onClick(View view){
        System.out.println("click");
    }
}
