package com.example.a6868.june_day1_work.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a6868.june_day1_work.R;
import com.example.a6868.june_day1_work.adapter.RlvChildAdapter;
import com.example.a6868.june_day1_work.base.BaseMvpFragment;
import com.example.a6868.june_day1_work.bean.ChildBean;
import com.example.a6868.june_day1_work.model.ChildModel;
import com.example.a6868.june_day1_work.presenter.ChildPresenter;
import com.example.a6868.june_day1_work.view.ChildIView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends BaseMvpFragment<ChildPresenter, ChildIView, ChildModel> implements ChildIView {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.mSmart)
    SmartRefreshLayout mSmart;


    private ArrayList<ChildBean.StoriesBean> list_item;
    private ArrayList<ChildBean.TopStoriesBean> list_banner;
    private RlvChildAdapter rlvChildAdapter;

    public ChildFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_child;
    }

    @Override
    protected ChildIView initMvpView() {
        return this;
    }

    @Override
    protected ChildModel initMvpModel() {
        return new ChildModel();
    }

    @Override
    protected ChildPresenter initMvpPresenter() {
        return new ChildPresenter();
    }

    @Override
    public void onSuccess(ChildBean childBean) {
        list_item = new ArrayList<ChildBean.StoriesBean>();
        List<ChildBean.StoriesBean> stories = childBean.getStories();
        list_item.addAll(stories);
        rlvChildAdapter.setList_item(list_item);

        list_banner = new ArrayList<ChildBean.TopStoriesBean>();
        List<ChildBean.TopStoriesBean> topStories = childBean.getTop_stories();
        list_banner.addAll(topStories);
        rlvChildAdapter.setList_banner(list_banner);

    }

    @Override
    public void onFail(String mag) {
        Toast.makeText(getContext(), mag, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rlv.setLayoutManager(linearLayoutManager);

        rlvChildAdapter = new RlvChildAdapter(list_item, list_banner, getContext());
        rlv.setAdapter(rlvChildAdapter);


    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }
}
