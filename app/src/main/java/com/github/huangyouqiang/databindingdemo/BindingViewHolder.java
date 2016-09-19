package com.github.huangyouqiang.databindingdemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by huangyouqiang on 2016/9/18.
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
    protected final T mBinding;
    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }
    public T getBinding(){
        return this.mBinding;
    }
}
