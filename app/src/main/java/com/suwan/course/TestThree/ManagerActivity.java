package com.suwan.course.TestThree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.suwan.course.R;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        findViewById(R.id.sp).setOnClickListener(this);
        findViewById(R.id.ini).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sp:
                startActivity(new Intent(ManagerActivity.this,SPActivity.class));
                break;
            case R.id.ini:
                startActivity(new Intent(ManagerActivity.this,MainActivity.class));
                break;
        }
    }
}
