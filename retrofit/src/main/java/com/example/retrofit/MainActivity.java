package com.example.retrofit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private int type = 1;
    private String urlpic = "http://misc.dyhoa.com/exam/video/1/course2/15.MP4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    public void click(View view) {
        OkHttpClient builder = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.dyhoa.com/")
                .client(builder)
                .build();

        final HttpPostService fileDownloadApi = retrofit.create(HttpPostService.class);
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                try {
                    Response<ResponseBody> response = fileDownloadApi.downloadPicWithUrl(urlpic).execute();
                    if (response != null && response.isSuccessful()) {
                        //文件总长度
                        long fileSize = response.body().contentLength();
                        long fileSizeDownloaded = 0;
                        InputStream is = response.body().byteStream();
                            // 首先保存图片
                            File file = Environment.getExternalStorageDirectory().getAbsoluteFile();//注意小米手机必须这样获得public绝对路径
                            String fileName = "picture";
                            File appDir = new File(file, fileName);
                            if (!appDir.exists()) {
                                appDir.mkdirs();
                            }
                            String filePicName = null;
                            int indexOf = urlpic.lastIndexOf(".");
                            String picName = urlpic.substring(0, indexOf);
                            // LogUtil.e("picname"+picName);
                            if (type == 1) {
                                filePicName = picName + ".MP4";
                            } else {
                                filePicName = picName + ".gif";
                            }

                            File filePic = new File(appDir, filePicName);

                            FileOutputStream fos = null;
                            try {
                                fos = new FileOutputStream(filePic);
                                int count = 0;
                                byte[] buffer = new byte[1024];
                                while ((count = is.read(buffer)) != -1) {
                                    fos.write(buffer, 0, count);
                                    fileSizeDownloaded += count;
                                    text.setText(Size2.getPrintSize(fileSizeDownloaded)+"");
                                    // subscriber.onNext("file download: " + fileSizeDownloaded + " of " + fileSize);
                                }

                                fos.flush();
                                fos.close();
                                subscriber.onCompleted();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            // 最后通知图库更新
//                            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(filePic.getAbsolutePath()))));
//                            ToastUtil.showSafeToast("保存成功");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://misc.dyhoa.com/")
//                .addConverterFactory(GsonConverterFactory.create(new Gson()))
//                .build();
//        HttpPostService fileDownloadApi = retrofit.create(HttpPostService.class);
//        Observable<ResponseBody> responseBodyCall = fileDownloadApi.downloadPicWithUrl("");
//        responseBodyCall.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ResponseBody>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        InputStream is = responseBody.byteStream();
//                        File file = Environment.getExternalStorageDirectory().getAbsoluteFile();//注意小米手机必须这样获得public绝对路径
//                        String fileName = "picture";
//                        File appDir = new File(file, fileName);
//                        if (!appDir.exists()) {
//                            appDir.mkdirs();
//                        }
//                        try {
//                            OutputStream fos = new FileOutputStream(appDir);
//                            byte[] bys = new byte[1024];
//                            int len = 0;
//                            while ((len = is.read(bys))!=-1){
//                                fos.write(bys,0,len);
//                                filecount += len;
//                                text.setText(Size2.getPrintSize(len)+"");
//                            }
//                            fos.flush();
//                            fos.close();
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                });
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
    }
}
