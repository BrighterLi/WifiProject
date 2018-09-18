package com.example.wifiworld;

import java.util.List;

import android.R.layout;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class WifiAdapter extends BaseAdapter {
    List<ScanResult> list;
    List<ScanResult> datas;
    LayoutInflater inflater;
    Context context;
    
    public WifiAdapter(Context context,List<ScanResult> list){
    	this.inflater = LayoutInflater.from(context);
    	this.list = list;
    	this.context = context;
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	public void setDatas(List<ScanResult> datas){
		this.datas = datas;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View view = null;
		view = inflater.inflate(R.layout.item_wifi_list, null);
		ScanResult scanResult = list.get(arg0);
		//int imgId = R.id.imageView;
		
		TextView textView = (TextView)view.findViewById(R.id.textView);
		textView.setText(scanResult.SSID);
		
		TextView signal_strenth =(TextView)view.findViewById(R.id.signal_strenth);
		signal_strenth.setText(String.valueOf(Math.abs(scanResult.level)));
		
		ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
		if(Math.abs(scanResult.level)> 80){
			imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.stat_sys_wifi_signal2));
			//imgId = R.drawable.stat_sys_wifi_signal2;
		} else {
			//imgId = R.drawable.stat_sys_wifi_signal1;
			imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.stat_sys_wifi_signal1));
		}
		
		return view;
	}

}
