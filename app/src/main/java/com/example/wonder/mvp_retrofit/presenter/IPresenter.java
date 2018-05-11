package com.example.wonder.mvp_retrofit.presenter;

import com.example.wonder.mvp_retrofit.http.GoodsListBean;
import com.example.wonder.mvp_retrofit.model.IModel;
import com.example.wonder.mvp_retrofit.view.IView;

import java.util.List;

public interface IPresenter {
    void showBookToView(IModel iModel, IView iView);
    //接受从m传上来的数据
    void getData(List<GoodsListBean.DataBean> list);
}
