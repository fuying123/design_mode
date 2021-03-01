package com.example.woman_and_man.StrategyMode;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.woman_and_man.R;

public class StrategyMode extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strategy_mode);
    }
}

class ContextStrategy{
    Strategy strategy;
    public ContextStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }

}




abstract class Strategy{
    public abstract void AlgorithmInterface();
}

class ConcreteStrategyA extends Strategy{

    @Override
    public void AlgorithmInterface() {

    }
}
class ConcreteStrategyB extends Strategy{

    @Override
    public void AlgorithmInterface() {

    }
}
class ConcreteStrategyC extends Strategy{

    @Override
    public void AlgorithmInterface() {

    }
}
