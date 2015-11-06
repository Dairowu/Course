package com.suwan.course.TestFour;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyRemoteService extends Service {

    private static String TAG="The Process Id is:";

    private final IMyAidlInterface.Stub mBinder=new IMyAidlInterface.Stub() {
        @Override
        public int Compare(int x, int y) throws RemoteException {
            if(x>y)
                return x;
            else return y;
        }
    };
    public MyRemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
