package com.swfp.utils;

import java.util.List;
import android.os.SystemProperties;

public class ProjectControlUtil {
	
	
	
	public static final boolean isC802 = "msm8953_64_c802".equals(SystemProperties.get("ro.build.product"));
	
	public static final boolean isC600h= "msm8953_64_c600h".equals(SystemProperties.get("ro.build.product"));
	
	public static final boolean isC600u = "msm8953_64_c600u".equals(SystemProperties.get("ro.build.product"));
	
	public static final boolean isC600e = "msm8953_64_c600e".equals(SystemProperties.get("ro.build.product"));
	
	public static final boolean isC600x= "msm8953_64_c600x".equals(SystemProperties.get("ro.build.product"));
	
	public static final boolean isC600 = "msm8953_64_c600".equals(SystemProperties.get("ro.build.product"));
	
	public static final boolean isC601 = "msm8953_64_c601".equals(SystemProperties.get("ro.build.product"));

	public static final boolean isC601e = "msm8953_64_c601e".equals(SystemProperties.get("ro.build.product"));

	public static final boolean isC601r = "msm8953_64_c601r".equals(SystemProperties.get("ro.build.product"));

	public static final boolean isC551 = "msm8953_64_c551".equals(SystemProperties.get("ro.build.product"));

	
	
	
	
	public static final boolean IS_TYPE_C = isC551 || isC600 ||isC802|| isC600x ;

	
	

	// 该返回值控制,进入pcba测试之后,wifi,蓝牙等,是否自己进行测试;
	public static boolean isPcbaHasAutoTest() {
		boolean isTest =isC802 || isC600h || isC600u ||isC600 ||isC601 || isC601r || isC601e;
		return isTest;
	}
	
	//重力是否两个方向;
	public static boolean isGravitySenorHasTwoDirection () {
		boolean isHasTwo= !(isC802 ||  isC600 || isC601 || isC601r || isC601e);
		return isHasTwo;
	}

}
