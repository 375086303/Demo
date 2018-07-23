package com.example.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

public interface HttpPostService {
    //下载图片
    @Streaming
    @GET
    Call<ResponseBody> downloadPicWithUrl(@Url String url);
}
