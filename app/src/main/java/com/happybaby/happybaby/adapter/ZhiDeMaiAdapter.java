package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.ZhiDeMai2;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */

public class ZhiDeMaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ZhiDeMai2.DataBean.ListBean> list;
    private Context context;

    public ZhiDeMaiAdapter(List<ZhiDeMai2.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zhidemai, null, false);
        MyHolderZhiDe holderZhiDe= new MyHolderZhiDe(view);
        return holderZhiDe;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        MyHolderZhiDe holder= (MyHolderZhiDe) holder1;
        holder.mTvGoodthingsName.setText(list.get(position).getNick_name());
        holder.mTvGoodthingsText.setText( list.get(position).getIntroduction());
        holder.mTvGoodthingsTitle.setText(list.get(position).getTitle());
        Picasso.with(context).load(list.get(position).getAvatar()).into(holder.mIvGoodthingsTouxiang);
        Picasso.with(context).load(list.get(position).getPhone_head_pic()).into(holder.mIvGoodthings);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolderZhiDe extends RecyclerView.ViewHolder {


        private  TextView mTvGoodthingsName;
        private  ImageView mIvGoodthingsTouxiang;
        private  TextView mTvGoodthingsText;
        private  TextView mTvGoodthingsTitle;
        private  ImageView mIvGoodthings;

        public MyHolderZhiDe(View view1) {
            super(view1);
            mTvGoodthingsName = (TextView) view1.findViewById(R.id.tv_goodthings_name);
            mIvGoodthingsTouxiang = (ImageView) view1.findViewById(R.id.iv_goodthings_touxiang);
            mTvGoodthingsText = (TextView) view1.findViewById(R.id.tv_goodthings_text);
            mTvGoodthingsTitle = (TextView) view1.findViewById(R.id.tv_goodthings_title);
            mIvGoodthings = (ImageView) view1.findViewById(R.id.iv_goodthings);
        }
    }
}
