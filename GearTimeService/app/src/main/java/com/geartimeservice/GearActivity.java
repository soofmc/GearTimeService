package com.geartimeservice;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

public class GearActivity extends Activity {

	static GearActivity instance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
        Intent intent = new Intent(this, GearTimeService.class);
		startService(intent);
	}
}
