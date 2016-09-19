package com.github.huangyouqiang.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.huangyouqiang.databindingdemo.databinding.RecyclerItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangyouqiang on 2016/9/18.
 */
public class BindingAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private List<String> list;
    private LayoutInflater inflater;
    private Context mContext;
    private int width;

    public BindingAdapter(Context context,int mWidth) {
        this.mContext = context;
        list = new ArrayList<>();
        for(int i =1;i<10;i++){
            list.add(i+"");
        }
        list.add("null");
        list.add("0");
        inflater = LayoutInflater.from(context);
        this.width = mWidth;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,R.layout.recycler_item,parent,false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

        final RecyclerHandler handler = new RecyclerHandler(list.get(position),this.width);
        holder.getBinding().setVariable(com.github.huangyouqiang.databindingdemo.BR.item,handler);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).equals("null")){
            return 1;
        }else{
            return 0;
        }
    }
}
