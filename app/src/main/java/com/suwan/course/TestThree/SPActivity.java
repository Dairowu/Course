package com.suwan.course.TestThree;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.suwan.course.R;

public class SPActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private EditText editText;
    private TextView info_detail;
    private Button submit, getInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        init();
        sp=getSharedPreferences("default",MODE_PRIVATE);
        editor=sp.edit();
        submit.setOnClickListener(this);
        getInfo.setOnClickListener(this);
    }

    private void init(){
        editText = (EditText) findViewById(R.id.edittext1);
        info_detail = (TextView) findViewById(R.id.info_detail);
        submit = (Button) findViewById(R.id.submit);
        getInfo = (Button) findViewById(R.id.get_info);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                doSubmit();
                break;
            case R.id.get_info:
                doGetInfo();
                break;
        }
    }

    private void doGetInfo() {
        String s=sp.getString("default","No Content");
        info_detail.setText(s);
    }

    private void doSubmit() {
        if(!TextUtils.isEmpty(editText.getText())){
            String s=editText.getText().toString();
            editor.putString("default",s).commit();

        }else Toast.makeText(getApplicationContext(), "请输入要储存的信息",Toast.LENGTH_SHORT);
    }
}
