package com.kangjj.aop.aspectJ.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.kangjj.aop.aspectJ.LoginActivity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoginCheckAspect {
    private final static String TAG = "kangjj >>> ";
    //注意不能写错，写错所有的Aspect都无效
    @Pointcut("execution(@com.kangjj.aop.aspectJ.annotation.LoginCheck * *(..))")
    public void methodPointCut(){}

    @Around("methodPointCut()")
    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable{
        Context context = (Context) joinPoint.getThis();
        if(false) {//从SharedPreferences中读取登录状态
            Log.e(TAG, "检测到已登录！");
            return joinPoint.proceed();
        }else{
            Log.e(TAG, "检测到未登录！");
            Toast.makeText(context, "请先登录！", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActivity.class));
            return null;
        }
    }
}
