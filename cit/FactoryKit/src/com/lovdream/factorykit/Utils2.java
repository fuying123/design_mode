package com.lovdream.factorykit;

import java.util.ArrayList;

import android.app.Activity;

import com.lovdream.factorykit.Config.TestItem;

public class Utils2 {
	
	private static Utils2 instance;
	private Utils2(){}
	public static Utils2 getInstance(){
		if(instance==null){
			instance = new Utils2();
		}
		return instance;
	}
	
	public int findIndex(String key,boolean isInPcba,Activity activity) {
		   FactoryKitApplication app = (FactoryKitApplication)activity
	                .getApplication();
	        Config config = app.getTestConfig();
		   ArrayList<TestItem> pcbaItems = config.getTestItems();
	        for (TestItem item : pcbaItems) {
	            if (item.key.equals(key)) {
	                if(isInPcba) return item.fm.pcbaFlag;
	                else return item.fm.testFlag;
	            }
	        }
	        return -1;
	    }

}
