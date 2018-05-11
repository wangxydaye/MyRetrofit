package com.example.wonder.mvp_retrofit.view;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wonder.mvp_retrofit.R;
import com.example.wonder.mvp_retrofit.http.GoodsListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wonder on 2018/4/23.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    private Context context;
    private List<GoodsListBean.DataBean> list;
    private final int NEWS1 = 1;
    private final int NEWS2 = 2;

    public Myadapter(Context context, List<GoodsListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        int type = getItemViewType(position);
        switch (type){
            case NEWS1:
                //隐藏下面，显示上面
                LinearLayout shang = holder.getShang();
                LinearLayout xia = holder.getXia();
                shang.setVisibility(View.VISIBLE);
                xia.setVisibility(View.GONE);
                holder.getTitle().setText(list.get(position).getTitle());
                String images = list.get(position).getImages();
                String s = images.split("\\|")[0];
                holder.getPic().setImageURI(s);
                break;
            case NEWS2:
                //隐藏上面，显示下面
                LinearLayout shang1 = holder.getShang();
                LinearLayout xia1 = holder.getXia();
                shang1.setVisibility(View.GONE);
                xia1.setVisibility(View.VISIBLE);
                holder.getTitle2().setText(list.get(position).getTitle());
                String image = list.get(position).getImages();
                String sc = image.split("\\|")[0];
                holder.getPic2().setImageURI(sc);
                break;
        }
    }
    @Override
    public int getItemViewType(int position) {
        GoodsListBean.DataBean dataBean = list.get(position);
        int itemtype = dataBean.getItemtype();
        if(itemtype%2==0){
            return NEWS1;
        }else {
            return NEWS2;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView pic, pic2;
        private TextView title, title2;
        private LinearLayout shang,xia;

        public MyViewHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.drawer);
            pic2 = itemView.findViewById(R.id.drawer2);
            title = itemView.findViewById(R.id.tv);
            title2 = itemView.findViewById(R.id.tv2);
            shang=itemView.findViewById(R.id.shang);
            xia=itemView.findViewById(R.id.xia);
        }

        public MyViewHolder(View itemView, SimpleDraweeView pic, SimpleDraweeView pic2, TextView title, TextView title2,LinearLayout shang,LinearLayout xia) {
            super(itemView);
            this.pic = pic;
            this.pic2 = pic2;
            this.title = title;
            this.title2 = title2;
            this.shang = shang;
            this.xia = xia;
        }

        public SimpleDraweeView getPic() {
            return pic;
        }

        public void setPic(SimpleDraweeView pic) {
            this.pic = pic;
        }

        public SimpleDraweeView getPic2() {
            return pic2;
        }

        public void setPic2(SimpleDraweeView pic2) {
            this.pic2 = pic2;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getTitle2() {
            return title2;
        }

        public void setTitle2(TextView title2) {
            this.title2 = title2;
        }

        public LinearLayout getShang() {
            return shang;
        }

        public void setShang(LinearLayout shang) {
            this.shang = shang;
        }

        public LinearLayout getXia() {
            return xia;
        }

        public void setXia(LinearLayout xia) {
            this.xia = xia;
        }
    }

}
