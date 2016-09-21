package com.github.huangyouqiang.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.github.huangyouqiang.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Presenter mPresenter;
    private BindingAdapter bindingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mPresenter = new Presenter("Data Binding !");
        binding.setPresenter(mPresenter);
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public void onBound(ViewDataBinding binding) {
                super.onBound(binding);
            }

            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                Transition transition = new AutoTransition();
                transition.setDuration(1000);
                transition.setInterpolator(new AccelerateDecelerateInterpolator());
                ViewGroup rootView = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(rootView,transition);
                return true;
            }

            @Override
            public void onCanceled(ViewDataBinding binding) {
                super.onCanceled(binding);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        binding.recycler.setLayoutManager(new GridLayoutManager(this,3));
        bindingAdapter = new BindingAdapter(this,binding.recycler.getWidth());
        binding.recycler.setAdapter(bindingAdapter);
    }

    @Override
    protected void onDestroy() {
        if(mPresenter != null){
            mPresenter.quit();
        }
        super.onDestroy();
    }
    private void log(String s){
        System.out.println("haha "+s);
    }
}
