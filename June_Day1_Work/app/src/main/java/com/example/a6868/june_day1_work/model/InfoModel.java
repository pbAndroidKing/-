package com.example.a6868.june_day1_work.model;

import com.example.a6868.june_day1_work.base.BaseCallBack;
import com.example.a6868.june_day1_work.base.BaseModel;
import com.example.a6868.june_day1_work.net.MyService;

import com.example.a6868.june_day1_work.bean.HomeBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoModel extends BaseModel {
    public void getData(final BaseCallBack<HomeBean> baseCallBack){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyService.URL)
                .build();

        MyService myService = retrofit.create(MyService.class);

        Observable<HomeBean> data = myService.getData();

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        if (homeBean != null){
                            baseCallBack.onSuccess(homeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
