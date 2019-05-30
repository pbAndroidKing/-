package com.example.a6868.june_day1_work.base;

public abstract class BaseMvpFragment<P extends BasePresenter, V extends BaseView, M extends BaseModel> extends BaseFragment {
    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter = initMvpPresenter();
        if (myPresenter!=null){
            myPresenter.attachView(initMvpView());
            myPresenter.initModel(initMvpModel());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (myPresenter!=null){
            myPresenter.destroy();
            myPresenter = null;
        }
    }
}
