package com.example.woman_and_man.SingletonMode;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.woman_and_man.R;

public class SingleMode extends Activity {
    private Button success_bt, failing_bt, am_bt;
    private TextView tv_states;

    public void showDialog(Context context) {
        Singleton_test.getInstance().showDialog(context);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_mode);

        success_bt = findViewById(R.id.success_bt);
        tv_states = findViewById(R.id.tv_states);
        success_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(SingleMode.this);
                /*success s = new success();
                u.Display(s);
                states = u.getStates();
                for (String stat : states) {
                    Log.w("fy", "" + stat);
                }
                tv_states.setText("" + simpleFun(states));*/
            }
        });
        failing_bt = findViewById(R.id.failing_bt);
        failing_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(SingleMode.this);
                /*Failing f = new Failing();
                u.Display(f);
                states = u.getStates();
                for (String stat : states) {
                    Log.w("fy", "" + stat);
                }
                tv_states.setText("" + simpleFun(states));*/
            }
        });
        am_bt = findViewById(R.id.am_bt);
        am_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(SingleMode.this);
                /*Amativeness a = new Amativeness();
                u.Display(a);
                states = u.getStates();
                for (String stat : states) {
                    Log.w("fy", "" + stat);
                }
                tv_states.setText("" + simpleFun(states));*/
            }
        });
    }
}

class Singleton_test {
    private void Singleton_test() {
    }

    private static Object syncRoot = new Object();
    private static Singleton_test instance;

    public static Singleton_test getInstance() {
        if (instance == null) {
            synchronized (syncRoot) {
                if (instance == null) {
                    instance = new Singleton_test();
                }
            }
        }
        return instance;
    }

    public void showDialog(Context context) {
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("haha");
            alertDialog = builder.create();
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    alertDialog = null;
                }
            });
        }
        alertDialog.show();
    }

    public void dismissDialog() {
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    }

    private AlertDialog alertDialog;
}