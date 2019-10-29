package com.kangjj.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kangjj.aop.proxy.AOPDBProxyActivity;
import com.kangjj.aop.proxy.DBOperation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void goAOPProxy(View view) {
        startActivity(new Intent(this, AOPDBProxyActivity.class));
    }

    public void goAOPAspectJ(View view) {
        startActivity(new Intent(this, AOPDBProxyActivity.class));
    }

}
