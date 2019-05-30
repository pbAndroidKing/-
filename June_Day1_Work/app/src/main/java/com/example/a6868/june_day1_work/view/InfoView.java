package com.example.a6868.june_day1_work.view;

import com.example.a6868.june_day1_work.base.BaseView;

import com.example.a6868.june_day1_work.bean.HomeBean;

public interface InfoView extends BaseView{
    void onSuccess(HomeBean homeBean);

    void onFail(String mag);
}
