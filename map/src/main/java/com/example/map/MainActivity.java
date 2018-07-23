package com.example.map;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent();

        i.setAction("android.intent.action.VIEW");

        i.addCategory("android.intent.category.DEFAULT");

        i.setPackage("com.autonavi.minimap");

        i.setData(Uri.parse("androidamap://viewMap?sourceApplication=appname&poiname=abc&lat=31.023183&lon=121.268299&dev=0")); // softname，开发程序的名称

        startActivity(i);
    }
}
