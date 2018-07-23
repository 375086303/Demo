package com.example.texttospeet;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class MyApplition extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpeechUtility.createUtility(MyApplition.this, SpeechConstant.APPID +"=5b506fb0");
    }
}
