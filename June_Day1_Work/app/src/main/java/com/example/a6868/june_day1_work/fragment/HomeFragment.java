package com.example.a6868.june_day1_work.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a6868.june_day1_work.R;
import com.example.a6868.june_day1_work.adapter.RlvAdapter;
import com.example.a6868.june_day1_work.base.BaseMvpFragment;
import com.example.a6868.june_day1_work.model.InfoModel;
import com.example.a6868.june_day1_work.presenter.InfoPresenter;
import com.example.a6868.june_day1_work.view.InfoView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import com.example.a6868.june_day1_work.bean.HomeBean;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<InfoPresenter, InfoView, InfoModel> implements InfoView {


    @BindView(R.id.mBanner)
    Banner mBanner;
    @BindView(R.id.home_Tab)
    TabLayout homeTab;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.mRlv)
    RecyclerView mRlv;
    Unbinder unbinder;

    private ArrayList<HomeBean.DataBean> list_item = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected InfoView initMvpView() {
        return this;
    }

    @Override
    protected InfoModel initMvpModel() {
        return new InfoModel();
    }

    @Override
    protected InfoPresenter initMvpPresenter() {
        return new InfoPresenter();
    }

    @Override
    public void onSuccess(HomeBean homeBean) {
        List<HomeBean.DataBean> data = homeBean.getData();
        list_item.addAll(data);

    }

    @Override
    public void onFail(String mag) {
        Toast.makeText(getContext(), mag, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView(View inflate) {

        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.story_icon_new));
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.story_icon_morning));
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.story_icon_sleep));
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.story_icon_classify));

        tvTitle.setText("今日推荐");

        tvName.setText("今天听什么，村长告诉你");

        //创建布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRlv.setLayoutManager(gridLayoutManager);
        //创建适配器
        RlvAdapter adapter = new RlvAdapter(list_item, getContext());
        mRlv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
