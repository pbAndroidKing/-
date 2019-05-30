package com.example.a6868.june_day1_work.net;

import com.example.a6868.june_day1_work.bean.ChildBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ChildService {
    //http://news-at.zhihu.com/api/4/news/latest
    String URl = "http://news-at.zhihu.com/api/4/news/";

    @GET("latest")
    Observable<ChildBean> getData();
}
