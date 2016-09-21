package com.github.huangyouqiang.aspectjlibrary;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Method;

/**
 * Created by huangyouqiang on 2016/9/21.
 */
@Aspect
public class ActivityAspect {
    @Before("execution(* android.app.Activity.onCreate(..))")
    public void onPreMethod(JoinPoint joinPoint)throws Throwable{
        Log.i("Before","aspect :: "+joinPoint);
        String name = joinPoint.getSignature().getName();
        System.out.println("getName :"+name);
        System.out.println("target :"+joinPoint.getTarget().toString());
        System.out.println("this ;"+joinPoint.getThis());
        Method l = joinPoint.getThis().getClass().getDeclaredMethod("log",String.class);
        System.out.println(l.getName());
        Method[] methods = joinPoint.getThis().getClass().getDeclaredMethods();
        for(Method m : methods){
            if(m.getName().equals("log")){
                m.setAccessible(true);
               m.invoke(joinPoint.getThis(),new String("google"));
            }
        }
    }
}
