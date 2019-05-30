package com.example.a6868.june_day1_work.model;

import com.example.a6868.june_day1_work.base.BaseCallBack;
import com.example.a6868.june_day1_work.base.BaseModel;
import com.example.a6868.june_day1_work.bean.ChildBean;
import com.example.a6868.june_day1_work.net.ChildService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChildModel extends BaseModel{

    public void getData(final BaseCallBack<ChildBean> baseCallBack){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ChildService.URl)
                .build();

        ChildService childService = retrofit.create(ChildService.class);

        Observable<ChildBean> data = childService.getData();

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChildBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ChildBean childBean) {
                        if (childBean != null){
                            baseCallBack.onSuccess(childBean);
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
