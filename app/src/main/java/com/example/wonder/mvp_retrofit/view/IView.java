package com.example.wonder.mvp_retrofit.view;

import com.example.wonder.mvp_retrofit.http.GoodsListBean;

import java.util.List;

public interface IView {
    void showGoodsList(List<GoodsListBean.DataBean> data);
}
