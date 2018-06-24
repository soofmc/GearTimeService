package com.geartimeservice;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class GearTimeService extends Service {

	private AlarmManager GearAlarmManager;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mTimer = new Timer();
		mTimer.schedule(timerTask, 500, 60 * 1000);

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	private Timer mTimer;

	TimerTask timerTask = new TimerTask() {

	@Override
	public void run() {
	    Log.e("Log", "Running");
	    GearActivity gearActivity = GearActivity.instance;
	    GearAlarmManager = (AlarmManager) gearActivity.getSystemService(Context.ALARM_SERVICE);
		GearAlarmManager.setTimeZone("America/New_York");
        GearAlarmManager.setTimeZone("Europe/Paris");
		}
	};

	public void onDestroy() {
		try {
			mTimer.cancel();
			timerTask.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Intent intent = new Intent("com.android.techtrainner");
		sendBroadcast(intent);
	}
}
