package com.example.a6868.june_day1_work.presenter;

import com.example.a6868.june_day1_work.base.BaseCallBack;
import com.example.a6868.june_day1_work.base.BasePresenter;
import com.example.a6868.june_day1_work.model.InfoModel;
import com.example.a6868.june_day1_work.view.InfoView;

import com.example.a6868.june_day1_work.bean.HomeBean;

public class InfoPresenter extends BasePresenter<InfoView, InfoModel> {
    public void getData(){
        if (myModel != null){
            myModel.getData(new BaseCallBack<HomeBean>() {
                @Override
                public void onSuccess(HomeBean homeBean) {
                    if (homeBean != null){
                        myView.onSuccess(homeBean);
                    }
                }

                @Override
                public void onFail(String mag) {
                    myView.onFail(mag);
                }
            });
        }
    }
}
