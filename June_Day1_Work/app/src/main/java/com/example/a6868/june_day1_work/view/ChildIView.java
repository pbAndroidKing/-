package com.example.a6868.june_day1_work.view;

import com.example.a6868.june_day1_work.base.BaseView;
import com.example.a6868.june_day1_work.bean.ChildBean;

public interface ChildIView extends BaseView{
    void onSuccess(ChildBean childBean);

    void onFail(String mag);
}
