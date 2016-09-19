package com.github.huangyouqiang.databindingdemo;

import android.databinding.*;
import android.databinding.adapters.TextViewBindingAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.github.huangyouqiang.databindingdemo.BR;
/**
 * Created by huangyouqiang on 2016/9/18.
 */
public class Presenter extends BaseObservable {
    public ObservableArrayMap<String,Object> map = new ObservableArrayMap<>();
    public ObservableField<String> ObservableStr = new ObservableField<>();
    DateFormat format;
    public String name;
    private String oriStr;

    public Presenter(String str){
        this.name = str;
        oriStr = str;
        this.ObservableStr.set("you are you");
        format = new SimpleDateFormat("hh:mm:ss");
        this.map.put("time", format.format(new Date()));

    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void one(View view){
        Button b = (Button) view;
        String s = b.getText().toString();
        this.name = name.equals(s)?oriStr:s;
        this.ObservableStr.set(s);
        this.map.put("time",format.format(new Date()));
        notifyPropertyChanged(BR.name);
    }
    @android.databinding.BindingAdapter("android:text")
    public static void setText(TextView text,String value){
        TextViewBindingAdapter.setText(text,value);
      //  System.out.println(text.getId()+" set text :"+value);
    }
}
