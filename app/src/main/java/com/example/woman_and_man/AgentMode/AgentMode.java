package com.example.woman_and_man.AgentMode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.example.woman_and_man.R;

public class AgentMode extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agent_mode);
        Proxy_Subject p=new Proxy_Subject();
        p.Request();
    }
}

abstract class Subject{
    public abstract void Request();
}
class RealSubject extends Subject{

    @Override
    public void Request() {
        Log.w("fy","真是的请求");
    }
}
class Proxy_Subject extends Subject{
    RealSubject realSubject;
    @Override
    public void Request() {
        if(realSubject==null){
            realSubject=new RealSubject();
        }
        realSubject.Request();
    }
}