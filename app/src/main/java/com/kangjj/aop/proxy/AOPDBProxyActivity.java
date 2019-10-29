package com.kangjj.aop.proxy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kangjj.aop.R;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: jj.kang
 * @Email: jj.kang@zkteco.com
 * @ProjectName: 1.1.3_AOP
 * @Package: com.kangjj.aop.proxy
 * @CreateDate: 2019/10/29 16:34
 */
public class AOPDBProxyActivity extends AppCompatActivity implements DBOperation{
    private final static String TAG = AOPDBProxyActivity.class.getSimpleName();

    DBOperation db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop_db_proxy);
        db = (DBOperation) Proxy.newProxyInstance(
                DBOperation.class.getClassLoader(),new Class[]{DBOperation.class},new DBHandler(this));
    }

    public void jump(View view) {
        db.delete();
    }

    class DBHandler implements InvocationHandler{
        private DBOperation db;
        public DBHandler(DBOperation db){
            this.db = db;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] args) throws Throwable {
            if(db!=null){
                Log.e(TAG, "操作数据库之前，开始备份……");
                save(); // 查询数据库后备份，详细过程省略
                Log.e(TAG, "数据备份完成，等待操作");
                return method.invoke(db,args);
            }

            return null;
        }
    }
    @Override
    public void insert() {
        Log.e(TAG, "新增数据");
    }

    @Override
    public void delete() {
       Log.e(TAG, "删除数据");
    }

    @Override
    public void update() {
        Log.e(TAG, "修改数据");
    }

    @Override
    public void save() {
        Log.e(TAG, "保存数据");
    }

}
