
package com.example.texttospeet;

import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.time.Instant;
import java.util.List;


import java.util.Locale;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    //定义控件
    private Button speechButton;
    private TextView speechText;
    private TextToSpeech tts;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化TTS
        tts = new TextToSpeech(this, this);
        //获取控件
        speechText = (TextView)findViewById(R.id.speechTextView);
        speechButton = (Button)findViewById(R.id.speechButton);
        s = speechText.getText().toString();
        Log.e("TAG", s+"+++++++++");
        //为button添加监听
        speechButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub
                    // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    tts.setPitch(1.0f);
                    // 设置语速
                    tts.setSpeechRate(1.0f);
                    //播放语音
                    tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }
    @Override
    public void onInit(int status){
        // 判断是否转化成功
        if (status == TextToSpeech.SUCCESS){
            //默认设定语言为中文，原生的android貌似不支持中文。
            int result = tts.setLanguage(Locale.CHINESE);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(MainActivity.this, R.string.notAvailable, Toast.LENGTH_SHORT).show();
            }else{
                //不支持中文就将语言设置为英文
                tts.setLanguage(Locale.US);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
