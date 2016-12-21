package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.MyLike;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MayLikeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(View itemView, int position);
    }

    ;
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private List<MyLike.DataBean.ListBean> datas;

    private LayoutInflater inflater;
    private Context context;

    public MayLikeAdapter(List<MyLike.DataBean.ListBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.may_like_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        MyLike.DataBean.ListBean date = datas.get(position);
        if(date.getProduct_icon_new() !=null) {
            if (date.getProduct_icon_new().size() == 1) {
                Glide.with(context).load(date.getProduct_icon_new().get(0).getUrl())
                        .into(myHolder.mMaylikeTog1);


            } else {
                Glide.with(context).load(date.getProduct_icon_new().get(0).getUrl())
                        .into(myHolder.mMaylikeTog1);
                Glide.with(context).load(date.getProduct_icon_new().get(1).getUrl())
                        .into(myHolder.mMaylikeTog2);

            }
        }
        Glide.with(context).load(date.getImage_url()).into((myHolder).mMaylikeImg);

        myHolder.mMaylikeName.setText(date.getBrand_name());
        myHolder.mMaylikeTitle.setText(date.getShort_title());
        myHolder.mMaylikePrice.setText("￥"+date.getActivity_price());

//        //宽度固定，高度等比
//        Picasso.with(this).load(UrlConstants.NET_URL)
//                .resize(160, 0)
//                .into(dengbiIv);


    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }


    class MyHolder extends RecyclerView.ViewHolder {

        public ImageView mMaylikeImg;
        public ImageView mMaylikeTog1;
        public ImageView mMaylikeTog2;
        public TextView mMaylikeName;
        public TextView mMaylikeTitle;
        public TextView mMaylikePrice;

        public MyHolder(View rootView) {
            super(rootView);
            this.mMaylikeImg = (ImageView) rootView.findViewById(R.id.maylike_img);
            this.mMaylikeTog1 = (ImageView) rootView.findViewById(R.id.maylike_tog1);
            this.mMaylikeTog2 = (ImageView) rootView.findViewById(R.id.maylike_tog2);
            this.mMaylikeName = (TextView) rootView.findViewById(R.id.maylike_name);
            this.mMaylikeTitle = (TextView) rootView.findViewById(R.id.maylike_title);
            this.mMaylikePrice = (TextView) rootView.findViewById(R.id.maylike_price);
            //itemView ViewHolder所对应的子View
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.itemClick(itemView, getLayoutPosition());
                }
            });
        }
    }


}
