package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var07Service extends Service {
    private ProcessingThread processingThread = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        int top_left = intent.getIntExtra("top_left", -1);
//        int top_right = intent.getIntExtra("top_right", -1);
//        int bottom_left = intent.getIntExtra("bottom_left", -1);
//        int bottom_right = intent.getIntExtra("bottom_right", -1);
        processingThread = new ProcessingThread(this);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}