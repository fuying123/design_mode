
package com.example.woman_and_man;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.woman_and_man.AgentMode.AgentMode;
import com.example.woman_and_man.DecoMode.DecoMode;
import com.example.woman_and_man.FactoryMode.FactoryMode;
import com.example.woman_and_man.SingletonMode.SingleMode;
import com.example.woman_and_man.StrategyMode.StrategyMode;
import com.example.woman_and_man.VisitorMode.VisitorMode;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    Button success_bt, failing_bt, am_bt,factory_mode,strategy_mode,mDeco_Mode,visitor_mode,single_mode,agent_mode;
    TextView tv_states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



    }


    private void init() {
        agent_mode=findViewById(R.id.agent_mode_id);
        agent_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AgentMode.class));
            }
        });
        factory_mode=findViewById(R.id.factory_mode_id);
        factory_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FactoryMode.class));
            }
        });
        visitor_mode=findViewById(R.id.visitor_id);
        visitor_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VisitorMode.class));
            }
        });
        single_mode=findViewById(R.id.single_id);
        single_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleMode.class));
            }
        });
        strategy_mode=findViewById(R.id.strategy_mode_id);
        strategy_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StrategyMode.class));
            }
        });
        mDeco_Mode=findViewById(R.id.deco_id);
        mDeco_Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DecoMode.class));
            }
        });


    }

}
