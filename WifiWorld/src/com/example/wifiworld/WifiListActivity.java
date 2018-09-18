package com.example.wifiworld;

import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class WifiListActivity extends Activity {
    private Button btn_open;
    private WifiManager mWifiManager;
    ListView wifi_lv;
    List<ScanResult> list;
    WifiAdapter mWifiAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
		//mWifiManager.setWifiEnabled(false);
		btn_open = (Button)findViewById(R.id.wifi_open);
		
		//open or close wifi 
		btn_open.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mWifiManager.isWifiEnabled()==false){
				    mWifiManager.setWifiEnabled(true);
				    //setContentView(R.layout.activity_main);
				    //list = mWifiManager.getScanResults();
					//wifi_lv = (ListView)findViewById(R.id.wifi_lv);
					//if(list == null){
					//	Toast.makeText(WifiListActivity.this, "list is null", Toast.LENGTH_LONG).show();
					//} else {
					//wifi_lv.setAdapter(new WifiAdapter(WifiListActivity.this,list));
					//}
				    Toast.makeText(WifiListActivity.this, "wifi is openning", Toast.LENGTH_SHORT).show();
				} else {
					mWifiManager.setWifiEnabled(false);
					//setContentView(R.layout.activity_main_empty);
					Toast.makeText(WifiListActivity.this, "wifi is closing", Toast.LENGTH_SHORT).show();
				}
			}
		});
		list = mWifiManager.getScanResults();
		wifi_lv = (ListView)findViewById(R.id.wifi_lv);
		if(list == null){
			Toast.makeText(this, "list is null", Toast.LENGTH_LONG).show();
		} else {
	    wifi_lv.setAdapter(new WifiAdapter(this,list));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
