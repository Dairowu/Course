package com.suwan.course.TestFour;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.suwan.course.R;
import com.suwan.course.TestTwo.LoginActivity;

public class CompareActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private Button called_service,called_remoteservice;
    private EditText first_number,second_number;
    private static String TAG="CompareActivity's PID is:";

    private ServiceConnection remoteConn=null;
    private ServiceConnection localConn=null;

    private IMyAidlInterface mRemoteAIDL=null;
    private MyService.SimpleBinder mLocalService=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        init();
        called_service.setOnClickListener(this);
        called_remoteservice.setOnClickListener(this);


    }

    private void init() {
        tv=(TextView)findViewById(R.id.textView);
        called_service=(Button)findViewById(R.id.button);
        called_remoteservice=(Button)findViewById(R.id.button1);
        first_number=(EditText)findViewById(R.id.first_input_number);
        second_number=(EditText)findViewById(R.id.second_input_number);
    }

    @Override
    public void onClick(View v) {
        boolean isNull=false;
        isNull=first_number.getText().toString().length()==0||
                second_number.getText().toString().length()==0;
        if(!isNull) {
            switch (v.getId()) {
                case R.id.button:
                    bindLocalService();
                    //doing something...
                    break;
                case R.id.button1:
                    bindRemoteService();
                    //doing something...
                    break;
            }
        }else Toast.makeText(getApplicationContext(),"输入的数字为空，请重新输入！",Toast.LENGTH_SHORT).show();
    }

    private void bindLocalService(){
        startService(new Intent(CompareActivity.this,MyService.class));
        final int first_no,second_no;
        first_no=Integer.parseInt(first_number.getText().toString());
        second_no=Integer.parseInt(second_number.getText().toString());
        localConn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("Information:","Local Service Connected!");
                mLocalService=(MyService.SimpleBinder)service;
                tv.setText(mLocalService.Compare(first_no,second_no)+"");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("Information:","Local Service Disconnected!");
            }
        };
        bindService(new Intent(CompareActivity.this,MyService.class),
                localConn, BIND_AUTO_CREATE);
    }


    private void bindRemoteService() {
        startService(new Intent(CompareActivity.this,MyRemoteService.class));
        final int first_no,second_no;
        first_no=Integer.parseInt(first_number.getText().toString());
        second_no=Integer.parseInt(second_number.getText().toString());
        remoteConn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mRemoteAIDL=IMyAidlInterface.Stub.asInterface(service);
                Log.d("Information:","Remote Service Connected!");
                Log.d(TAG, android.os.Process.myPid()+"");
                try {
                    int x=mRemoteAIDL.Compare(first_no, second_no);
                    tv.setText(x+"");
                    Log.v("远程客户端的PID",mRemoteAIDL.getPID()+"");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("Information:","Remote Service Disconnected!");
            }
        };
        bindService(new Intent(CompareActivity.this,MyRemoteService.class),
                remoteConn, Context.BIND_AUTO_CREATE);
    }
}
