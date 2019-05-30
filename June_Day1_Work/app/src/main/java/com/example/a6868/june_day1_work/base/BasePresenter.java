package com.example.a6868.june_day1_work.base;

import java.util.ArrayList;

public class BasePresenter<V extends BaseView , M extends BaseModel> {
    private ArrayList<BaseModel> list = new ArrayList<>();

    protected V myView;
    protected M myModel;

    public void attachView(V myView){
        this.myView = myView;
    }

    public void initModel(M myModel){
        this.myModel = myModel;
        list.add(myModel);
    }

    public void destroy(){
        if (list.size()>0){
            for (BaseModel baseModel: list) {
                baseModel.destroy();
            }
        }
        if (myModel != null){
            myModel = null;
        }
        if (myView !=null){
            myView = null;
        }
    }
}
