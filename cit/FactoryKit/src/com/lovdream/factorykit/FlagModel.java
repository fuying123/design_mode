package com.lovdream.factorykit;

public class FlagModel {
	public String key;
	public int index;
	public int smallPcbFlag =-1;//10-19
	public int pcbaFlag =-1;//20-69
	public int testFlag =-1;//70-128
	
	public FlagModel(String key,int index, int smallPcbFlag,int pcbaFlag,int testFlag){
		this.index=index;
		this.key = key;
		this.smallPcbFlag = smallPcbFlag;
		this.pcbaFlag = pcbaFlag;
		this.testFlag = testFlag;
	}
}
