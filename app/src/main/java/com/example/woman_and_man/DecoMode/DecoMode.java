package com.example.woman_and_man.DecoMode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.woman_and_man.R;

public class DecoMode extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deco_mode);
        ConcreteComponent c=new ConcreteComponent();
        ConcreteDecoratorA a=new ConcreteDecoratorA();
        ConcreteDecoratorB aa=new ConcreteDecoratorB();
        a.SetComponent(c);
        aa.SetComponent(a);
        aa.Operation();
    }
}

abstract class Componment {
    public abstract void Operation();
}

class ConcreteComponent extends Componment {

    @Override
    public void Operation() {
        Log.w("fy","ConcreteComponent:Operation");
    }
}

abstract class Decorator extends Componment {
    protected Componment componment;

    public void SetComponent(Componment componment) {
        this.componment = componment;
    }

    @Override
    public void Operation() {
        componment.Operation();
    }
}

class ConcreteDecoratorA extends Decorator{
    private String addedState;

    @Override
    public void Operation() {
        super.Operation();
        addedState="";
        Log.w("fy","ConcreteDecoratorA:Operation");
    }
}
class ConcreteDecoratorB extends Decorator{

    private void AddedBehavior(){
        Log.w("fy","ConcreteDecoratorB:AddedBehavior");
    }
    @Override
    public void Operation() {
        super.Operation();
        AddedBehavior();
        Log.w("fy","ConcreteDecoratorB:Operation");
    }
}




