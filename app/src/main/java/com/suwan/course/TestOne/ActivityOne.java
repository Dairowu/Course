package com.suwan.course.TestOne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.suwan.course.R;

/**
 * @版本 0.0.1
 * @创建日期 2015-10-27  15:32
 * @作者 Suwan
 * @修改日期 ：2015-10-27  15:32
 * @说明 布局文件测试，监听并相应点击按钮事件
 *
 */
public class ActivityOne extends AppCompatActivity implements View.OnClickListener {

    private Button bt1,bt2,bt3,bt4;

    private static String TAG="ActivityOne_Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        init();

        doSomething();
    }



    /**
     * 初始化相应控件
     */
    private void init() {
        bt1=(Button)findViewById(R.id.button1);
        bt2=(Button)findViewById(R.id.button2);
        bt3=(Button)findViewById(R.id.button3);
        bt4=(Button)findViewById(R.id.button4);
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
            case R.id.button1:
                Log.d(TAG, "按下的按钮为------>按钮1");
                Toast.makeText(getApplicationContext(),"按下的按钮为------>按钮1",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Log.d(TAG,"按下的按钮为------>按钮2");
                Toast.makeText(getApplicationContext(),"按下的按钮为------>按钮2",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Log.d(TAG,"按下的按钮为------>按钮3");
                Toast.makeText(getApplicationContext(),"按下的按钮为------>按钮3",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Log.d(TAG,"按下的按钮为------>按钮4");
                Toast.makeText(getApplicationContext(),"按下的按钮为------>按钮4",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
