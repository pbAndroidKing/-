package com.example.a6868.june_day1_work.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void destroy() {
        compositeDisposable.clear();
    }
}
