package com.suwan.course;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.suwan.course.TestFour.CompareActivity;
import com.suwan.course.TestOne.ActivityOne;
import com.suwan.course.TestThree.MainActivity;
import com.suwan.course.TestThree.ManagerActivity;
import com.suwan.course.TestTwo.Main2Activity;

public class NavActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        init();
        doSomething();
    }


    /**
     * 初始化相应控件
     */
    private void init() {
        bt1=(Button)findViewById(R.id.test4);
        bt2=(Button)findViewById(R.id.test5);
        bt3=(Button)findViewById(R.id.test6);
        bt4=(Button)findViewById(R.id.test7);
    }

    /**
     * 对按钮做相应的响应
     */
    private void doSomething() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test4:
                startActivity(new Intent(NavActivity.this, ActivityOne.class));
                break;
            case R.id.test5:
                startActivity(new Intent(NavActivity.this, Main2Activity.class));
                break;
            case R.id.test6:
                startActivity(new Intent(NavActivity.this, CompareActivity.class));
                break;
            case R.id.test7:
                startActivity(new Intent(NavActivity.this, ManagerActivity.class));
                break;
        }

    }
}
