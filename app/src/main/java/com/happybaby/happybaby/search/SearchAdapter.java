package com.happybaby.happybaby.search;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.ProductActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */

public class SearchAdapter extends BaseAdapter {

    private List<SearchBean.DataBean.ListBean> prodlist;
    private Context context;
    private LayoutInflater inflater;

    public SearchAdapter(List<SearchBean.DataBean.ListBean> prodlist, Context context) {
        this.prodlist = prodlist;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return prodlist.size();
    }

    @Override
    public Object getItem(int i) {
        return prodlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MySearchHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_search, viewGroup, false);
            holder = new MySearchHolder(view);
            view.setTag(holder);
        } else {
            holder = (MySearchHolder) view.getTag();
        }
        Glide.with(context).load(prodlist.get(i).getImage_url()).into(holder.mIvSearchTreasure);
        holder.mTvSearchPrice.setText(prodlist.get(i).getStore_price());
        holder.mTvSerachDetails.setText(prodlist.get(i).getBrand_name());
        holder.mTvSerachJieshao.setText(prodlist.get(i).getName());
        holder.mTreasureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("ID",prodlist.get(i).getProduct_id());
                context.startActivity(intent);
            }
        });
        return view;
    }


    public static class MySearchHolder {
        public View rootView;
        public ImageView mIvSearchTreasure;
        public TextView mTvSerachDetails;
        public TextView mTvSerachJieshao;
        public TextView mTvSearchPrice;
        public RelativeLayout mTreasureLayout;

        public MySearchHolder(View rootView) {
            this.rootView = rootView;
            this.mIvSearchTreasure = (ImageView) rootView.findViewById(R.id.iv_search_treasure);
            this.mTvSerachDetails = (TextView) rootView.findViewById(R.id.tv_serach_details);
            this.mTvSerachJieshao = (TextView) rootView.findViewById(R.id.tv_serach_jieshao);
            this.mTvSearchPrice = (TextView) rootView.findViewById(R.id.tv_search_price);
            this.mTreasureLayout = (RelativeLayout) rootView.findViewById(R.id.treasure_layout);
        }

    }


}
