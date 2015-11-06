package com.suwan.course.TestFour;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.os.Process;
import android.util.Log;

public class MyRemoteService extends Service {

    private static String TAG="MyRemoteService's Process Id is:";

    private final IMyAidlInterface.Stub mBinder=new IMyAidlInterface.Stub() {
        @Override
        public int Compare(int x, int y) throws RemoteException {
            if(x>y)
                return x;
            else return y;
        }
        public int getPID(){
           return Process.myPid();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public MyRemoteService() {

    }

    @Override
    public IBinder onBind(Intent intent) {

       return  mBinder;
    }
}
