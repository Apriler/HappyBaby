package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.ProductActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/20.
 */

public class AdapterShouYeRecyclerview extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private JSONArray list;
    private Context context;


    public AdapterShouYeRecyclerview(JSONArray list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_index, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        MyViewHolder holder = (MyViewHolder) holder1;
        try {

            //加载大图片
            String event_img = list.getJSONObject(position).getString("event_img");
            Glide.with(context).load(event_img).into(holder.mIvBigads);
            //加载大图片文字
            String title_fir = list.getJSONObject(position).getString("title_fir");
            String title_sec = list.getJSONObject(position).getString("title_sec");
            holder.mTvBigtitle.setText(title_fir);
            holder.mTvSmalltitle.setText(title_sec);

            JSONArray event_productlist = list.getJSONObject(position).getJSONArray("event_product");
            for (int i = 0; i < event_productlist.length(); i++) {
                //加载小图片们
                View little_ads = LayoutInflater.from(context).inflate(R.layout.items_small_ads, holder.mLlGallery, false);
                ImageView mIvSmalladsHot = (ImageView) little_ads.findViewById(R.id.iv_smallads_hot);
                ImageView mIvSmallads = (ImageView) little_ads.findViewById(R.id.iv_smallads);
                TextView mTvTitle = (TextView) little_ads.findViewById(R.id.tv_title);
                TextView mTvScripe = (TextView) little_ads.findViewById(R.id.tv_scripe);
                TextView mTvMoney = (TextView) little_ads.findViewById(R.id.tv_money);
                final JSONObject event_product = event_productlist.getJSONObject(i);
                //包邮标志
                String url = event_product.getJSONArray("activity_icon").getJSONObject(0).getString("url");
                Glide.with(context).load(url).into(mIvSmalladsHot);
                //小图
                String product_image = event_product.getString("product_image");
                Glide.with(context).load(product_image).into(mIvSmallads);
                //名
                String brand_name = event_product.getString("brand_name");
                mTvTitle.setText(brand_name);
                //详情
                String name = event_product.getString("name");
                mTvScripe.setText(name);
                //价格
                String store_price = event_product.getString("store_price");
                mTvMoney.setText(store_price);
                holder.mLlGallery.addView(little_ads);
                little_ads.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, ProductActivity.class);
                        try {
                            intent.putExtra("ID",event_product.getString("product_id"));
                            context.startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "onBindViewHolder: "
                    + e.getMessage());

        }


    }

    private static final String TAG = "data";

    @Override
    public int getItemCount() {
        return list.length();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView mIvBigads;
        public TextView mTvBigtitle;
        public TextView mTvSmalltitle;
        public LinearLayout mLlGallery;

        public MyViewHolder(View rootView) {
            super(rootView);
            this.mIvBigads = (ImageView) rootView.findViewById(R.id.iv_bigads);
            this.mTvBigtitle = (TextView) rootView.findViewById(R.id.tv_bigtitle);
            this.mTvSmalltitle = (TextView) rootView.findViewById(R.id.tv_smalltitle);
            this.mLlGallery = (LinearLayout) rootView.findViewById(R.id.ll_gallery);
        }
    }

}
