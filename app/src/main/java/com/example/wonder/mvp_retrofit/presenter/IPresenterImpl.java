package com.example.wonder.mvp_retrofit.presenter;

import com.example.wonder.mvp_retrofit.http.GoodsListBean;
import com.example.wonder.mvp_retrofit.http.HttpConfig;
import com.example.wonder.mvp_retrofit.model.IModel;
import com.example.wonder.mvp_retrofit.view.IView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPresenterImpl implements IPresenter {
    private IView iView;
    @Override
    public void showBookToView(IModel iModel, IView iView) {
            this.iView=iView;
        iModel.getList();
    }

    @Override
    public void getData(List<GoodsListBean.DataBean> list) {
       iView.showGoodsList(list);
    }
}
