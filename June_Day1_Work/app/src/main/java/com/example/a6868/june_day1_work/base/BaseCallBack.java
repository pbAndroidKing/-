package com.example.a6868.june_day1_work.base;

public interface BaseCallBack<T> {
    void onSuccess(T t);

    void onFail(String mag);
}
