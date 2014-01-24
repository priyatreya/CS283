package com.example.hello;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.i("MainActivity", "I'm in onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
    	Log.i("MainActivity", "I'm in onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.i("MainActivity", "I'm in onStart");
		super.onStop();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.i("MainActivity", "I'm in onResume");
		super.onResume();
	}
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("MainActivity", "I'm in onDestroy");
		super.onDestroy();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.i("MainActivity", "I'm in onPause");
		super.onPause();
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
