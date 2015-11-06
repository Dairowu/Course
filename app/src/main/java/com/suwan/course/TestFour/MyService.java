package com.suwan.course.TestFour;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.util.Log;

public class MyService extends Service {
    private final static String TAG="MyService's PID is:" ;
    public SimpleBinder simpleBinder =new SimpleBinder();
    public MyService() {
        Log.d(TAG,""+ android.os.Process.myPid());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return simpleBinder;
    }



    public class SimpleBinder extends Binder{


    public int Compare(int x,int y){
        if(x>y)
        return x;
        else return y;
    }
    }
}
