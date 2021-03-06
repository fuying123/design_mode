package com.example.woman_and_man.VisitorMode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.woman_and_man.R;

import java.util.ArrayList;
import java.util.Iterator;

public class VisitorMode extends Activity {
    private Button success_bt, failing_bt, am_bt;
    private TextView tv_states;
    ArrayList<String> states = new ArrayList<>();
    ObjectStructure u = new ObjectStructure();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor_mode);
        u.Add(new Woman());
        u.Add(new Man());
        init();
    }

    public String simpleFun(ArrayList<String> l) {
        StringBuffer sb = new StringBuffer();

        sb.append("[");

        Iterator<String> i = l.iterator();
        boolean isNull = i.hasNext();
        while (isNull) {
            String o = i.next();
            sb.append(String.valueOf(o));
            isNull = i.hasNext();
            if (isNull) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }
    private void init() {
        success_bt = findViewById(R.id.success_bt);
        tv_states = findViewById(R.id.tv_states);
        success_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                success s = new success();
                u.Display(s);
                states = u.getStates();
                for (String stat : states) {
                    Log.w("fy", "" + stat);
                }
                tv_states.setText("" + simpleFun(states));
            }
        });
        failing_bt = findViewById(R.id.failing_bt);
        failing_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Failing f = new Failing();
                u.Display(f);
                states = u.getStates();
                for (String stat : states) {
                    Log.w("fy", "" + stat);
                }
                tv_states.setText("" + simpleFun(states));
            }
        });
        am_bt = findViewById(R.id.am_bt);
        am_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Amativeness a = new Amativeness();
                u.Display(a);
                states = u.getStates();
                for (String stat : states) {
                    Log.w("fy", "" + stat);
                }
                tv_states.setText("" + simpleFun(states));
            }
        });
    }
}

abstract class Action {
    public abstract String GetManConclusion(Man concreteElementA);

    public abstract String GetWomanConclusion(Woman concreteElementB);
}

abstract class Person {
    public abstract String Accept(Action visitor);
}

class Man extends Person {

    @Override
    public String Accept(Action visitor) {
        return visitor.GetManConclusion(this);
    }
}

class Woman extends Person {

    @Override
    public String Accept(Action visitor) {
        return visitor.GetWomanConclusion(this);
    }
}

//state
class success extends Action {

    @Override
    public String GetManConclusion(Man concreteElementA) {
        return "背后多半有个伟大的女人";
        //Log.w("fy","GetManConclusion success");
    }

    @Override
    public String GetWomanConclusion(Woman concreteElementB) {
        //Log.w("fy", "GetWomanConclusion success");
        return "背后大多有个不成功的男人";
    }
}

class Failing extends Action {

    @Override
    public String GetManConclusion(Man concreteElementA) {
        //Log.w("fy", "GetManConclusion fail");
        return "闷头喝酒谁也不用劝";
    }

    @Override
    public String GetWomanConclusion(Woman concreteElementB) {
        //Log.w("fy", "GetWomanConclusion fail");
        return "眼泪汪汪，谁也劝不了";
    }
}

class Amativeness extends Action {

    @Override
    public String GetManConclusion(Man concreteElementA) {
        //Log.w("fy", "GetManConclusion Amativeness");
        return "凡是不懂也要装懂";
    }

    @Override
    public String GetWomanConclusion(Woman concreteElementB) {
        //Log.w("fy", "GetWomanConclusion Amativeness");
        return "遇事懂也装不懂";
    }
}

class ObjectStructure {
    private ArrayList<Person> elements = new ArrayList<>();
    private ArrayList<String> states = new ArrayList<>();

    public void Add(Person element) {
        elements.add(element);
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public void Detach(Person element) {
        elements.remove(element);
    }

    public void Display(Action visitor) {
        states.clear();
        for (Person p : elements) {
            //Log.w("fy","p.Accept(visitor)------"+p.Accept(visitor));
            states.add(p.Accept(visitor));
        }
    }
}