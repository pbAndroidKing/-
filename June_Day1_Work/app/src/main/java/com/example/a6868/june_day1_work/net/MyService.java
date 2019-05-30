package com.example.a6868.june_day1_work.net;

import com.example.a6868.june_day1_work.bean.HomeBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {
    //http://news-at.zhihu.com/api/4/sections

    String URL = "http://news-at.zhihu.com/api/4/";

    @GET("sections")
    Observable<HomeBean> getData();
}
