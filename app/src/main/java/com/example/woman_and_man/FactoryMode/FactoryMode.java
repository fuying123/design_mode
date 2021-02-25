package com.example.woman_and_man.FactoryMode;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.woman_and_man.R;

public class FactoryMode extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factory_mode);


        init();
    }
    private Button mAddButton,mSubButton,mMulButton,mDiviButton,mEqualButton;
    private Operation opr;
    private EditText et1,et2;
    private TextView tv1_operate,tv2_result;
    private void init() {
        mAddButton=findViewById(R.id.add);
        mSubButton=findViewById(R.id.sub);
        mMulButton=findViewById(R.id.mul);
        mDiviButton=findViewById(R.id.divi);
        mEqualButton=findViewById(R.id.bt_equal);
        tv1_operate=findViewById(R.id.tv1_operate);
        tv2_result=findViewById(R.id.tv2_result);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr=OperattionFactory.createOperate("+");
                tv1_operate.setText("+");
            }
        });
        mSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr=OperattionFactory.createOperate("-");
                tv1_operate.setText("-");
            }
        });
        mMulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr=OperattionFactory.createOperate("*");
                tv1_operate.setText("*");
            }
        });
        mDiviButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr=OperattionFactory.createOperate("/");
                tv1_operate.setText("/");
            }
        });
        mEqualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.NumberA=Double.valueOf(""+et1.getText());
                opr.NumberB=Double.valueOf(""+et2.getText());
                tv2_result.setText(""+opr.getResult());
            }
        });
    }
}
