package com.example.a6868.june_day1_work.presenter;

import com.example.a6868.june_day1_work.base.BaseCallBack;
import com.example.a6868.june_day1_work.base.BasePresenter;
import com.example.a6868.june_day1_work.bean.ChildBean;
import com.example.a6868.june_day1_work.model.ChildModel;
import com.example.a6868.june_day1_work.view.ChildIView;

public class ChildPresenter extends BasePresenter<ChildIView, ChildModel>{

    public void getData(){
        if (myModel != null){
            myModel.getData(new BaseCallBack<ChildBean>() {
                @Override
                public void onSuccess(ChildBean childBean) {
                    if (childBean != null){
                        myView.onSuccess(childBean);
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
