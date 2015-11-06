package com.suwan.course.TestTwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.suwan.course.R;

/**
 * @版本 0.0.1
 * @创建日期 2015-10-27  19:00
 * @作者 Suwan
 * @修改日期 ：2015-10-27  19:00
 * @说明   登录测试，获取登录界面的数据
 */
public class Main2Activity extends AppCompatActivity {

    private Button login;
    private TextView login_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Main2Activity.this,LoginActivity.class),2);
            }
        });
    }

    private void init() {
        login=(Button)findViewById(R.id.login);
        login_detail=(TextView)findViewById(R.id.login_detail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2&&resultCode==RESULT_OK&&data!=null){
            String user_name=data.getExtras().getString("user_name","没有获取到数据");
            String user_pwd=data.getExtras().getString("user_pwd","没有获取到数据");
            login_detail.setText("恭喜你，登陆成功！\n你的账号是：\t"+user_name+"\n密码是:\t"+user_pwd);
        }

    }
}
