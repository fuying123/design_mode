package com.example.woman_and_man.FactoryMode;


import android.text.Editable;
import android.util.Log;

public class OperattionFactory {
    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}

abstract class Operation {
    public Double NumberA;
    public Double NumberB;

    public abstract double getResult();
}

class OperationSub extends Operation {

    @Override
    public double getResult() {
        Log.w("fy", "OperationSub");
        return NumberA - NumberB;
    }
}

class OperationAdd extends Operation {

    @Override
    public double getResult() {
        Log.w("fy", "OperationAdd");
        return NumberA + NumberB;
    }
}

class OperationMul extends Operation {

    @Override
    public double getResult() {
        Log.w("fy", "OperationMul");
        return NumberA * NumberB;
    }
}

class OperationDiv extends Operation {

    @Override
    public double getResult() {
        Log.w("fy", "OperationDiv");
        return NumberA / NumberB;
    }
}
