package com.kangjj.aop.aspectJ;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kangjj.aop.R;
import com.kangjj.aop.aspectJ.annotation.ClickBehavior;
import com.kangjj.aop.aspectJ.annotation.LoginCheck;

/**
 * @Description:
 * @Author: jj.kang
 * @Email: jj.kang@zkteco.com
 * @ProjectName: 1.1.3_AOP
 * @Package: com.kangjj.aop.aspectJ
 * @CreateDate: 2019/10/29 16:58
 */
public class AOPAspectJLoginActivity extends AppCompatActivity {
    private final static String TAG = "kangjj >>> ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop_aspectj);
    }
    // 登录点击事件（用户行为统计）
    @ClickBehavior("登记")
    public void login(View view) {
        Log.e(TAG, "模拟接口请求……验证通过，登录成功！");
    }

    // 用户行为统计（友盟统计？！如果后台要求自己统计，只能用AspectJ）
    @ClickBehavior("我的专区")
    @LoginCheck //登录校验
    public void area(View view) {
        Log.e(TAG, "开始跳转到 -> 我的专区 Activity");
        startActivity(new Intent(this, OtherActivity.class));
    }

    // 用户行为统计
    @ClickBehavior("我的优惠券")
    @LoginCheck //登录校验
    public void coupon(View view) {
        Log.e(TAG, "开始跳转到 -> 我的优惠券 Activity");
        startActivity(new Intent(this, OtherActivity.class));
    }
    // 用户行为统计
    @ClickBehavior("我的积分")
    @LoginCheck //登录校验
    public void score(View view) {
        Log.e(TAG, "开始跳转到 -> 我的积分 Activity");
        startActivity(new Intent(this, OtherActivity.class));
    }
}
