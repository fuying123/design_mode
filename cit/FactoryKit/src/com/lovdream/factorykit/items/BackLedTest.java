package com.lovdream.factorykit.items;

import android.os.Handler;
import android.view.View;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.os.SystemProperties;
import android.util.Log;
import android.telephony.TelephonyManager;

import java.io.FileOutputStream;

import com.lovdream.factorykit.R;
import com.lovdream.factorykit.TestItemBase;
import com.lovdream.LovdreamDeviceManager;
import com.swfp.utils.ProjectControlUtil;

public class BackLedTest extends TestItemBase{

	private static final String[] BACK_CTRL_NODES = {
		"sys/class/ext_dev/function/power_en",
		"sys/class/ext_dev/function/pin10_en",
		"sys/class/ext_dev/function/pin11_en",
		"sys/class/ext_dev/function/pogo_irq",
		"sys/class/ext_dev/function/uart_rx",
		"sys/class/ext_dev/function/uart_tx"
	};
	private static final String[] BACK_CTRL_NODES_FOR_C802 = {
		"sys/class/ext_dev/function/ext_dev_3v3_enable",
		"sys/class/ext_dev/function/pin10_en",
		"sys/class/ext_dev/function/pin11_en",
		"sys/class/ext_dev/function/pogo_irq",
		"sys/class/ext_dev/function/uart_rx",
		"sys/class/ext_dev/function/uart_tx"
	};

    private LovdreamDeviceManager ldm;
    private Context mContext;

	@Override
	public String getKey(){
		return "back_led";
	}

	@Override
	public String getTestMessage(){
		return getActivity().getString(R.string.back_led_mesg);
	}

	@Override
	public void onStartTest(){
	                mContext = getActivity();
                ldm = (LovdreamDeviceManager)mContext.getSystemService(Context.LOVDREAMDEVICES_SERVICE);
		if(!ProjectControlUtil.isC802){
			for(String s : BACK_CTRL_NODES){
				ldm.writeToFile(s, 1+"");
			//writeValue(s,1);
			}
		}else{
			for(String s : BACK_CTRL_NODES_FOR_C802){
				ldm.writeToFile(s, 1+"");
			}
		}

	}

	@Override
	public void onStopTest(){
		if(!ProjectControlUtil.isC802){
			for(String s : BACK_CTRL_NODES){
				//writeValue(s,0);
				ldm.writeToFile(s, 0+"");
			}
		}else{
			for(String s : BACK_CTRL_NODES_FOR_C802){
				ldm.writeToFile(s, 0+"");
			}
		}
	}

	private void writeValue(String path,int value){
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(String.valueOf(value).getBytes());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
