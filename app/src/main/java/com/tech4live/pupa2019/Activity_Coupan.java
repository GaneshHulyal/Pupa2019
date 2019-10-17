package com.tech4live.pupa2019;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Coupan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__coupan);
        Bundle extras=getIntent().getExtras();
        String name=extras.getString("name");
        String pos=extras.getString("position");
        String num=extras.getString("number");
        TextView t1=(TextView)findViewById(R.id.text1);
        TextView t2=(TextView)findViewById(R.id.text2);
        t1.setText("MIB_PUPA_2019_"+name+"_"+"OFF-0"+pos+"_"+num);
        t2.setText(name);
    }
}
