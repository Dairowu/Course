package com.suwan.course.TestTwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.suwan.course.R;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText user_name,user_pwd;
    private String user_name_string,user_pwd_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(!TextUtils.isEmpty(user_name.getText())){
                  if(!TextUtils.isEmpty(user_pwd.getText())){
                      user_name_string=user_name.getText().toString();
                      user_pwd_string=user_pwd.getText().toString();
                      Intent intent=new Intent();
                      intent.putExtra("user_name",user_name_string);
                      intent.putExtra("user_pwd",user_pwd_string);
                      setResult(RESULT_OK, intent);
                      LoginActivity.this.finish();

                  }else  Toast.makeText(getApplicationContext(),"用户密码不能为空！！"
                          ,Toast.LENGTH_SHORT).show();
              }
                else Toast.makeText(getApplicationContext(),"请输入用户帐号！！"
                      ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        login=(Button)findViewById(R.id.login);
        user_name=(EditText)findViewById(R.id.user_name);
        user_pwd=(EditText)findViewById(R.id.user_pwd);
    }

}
