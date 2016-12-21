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
import com.happybaby.happybaby.bean.OverseasCountry;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */

public class HotEventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(View itemView, int position);
    }

    ;
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private List<OverseasCountry.DataBeen.HotEventListBean.DataBeanXXXX.ListBeanXXXX> datas;

    private LayoutInflater inflater;
    private Context context;

    public HotEventAdapter(List<OverseasCountry.DataBeen.HotEventListBean.DataBeanXXXX.ListBeanXXXX> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.hotevent_layout, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        OverseasCountry.DataBeen.HotEventListBean.DataBeanXXXX.ListBeanXXXX date = datas.get(position);

        Glide.with(context).load(date.getAd_pic_400()).into(myHolder.mLunboImg);
        myHolder.mAdWord.setText(date.getAd_word());
        myHolder.mAdAdIntroduction.setText(date.getAd_introduction());

    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }


    class MyHolder extends RecyclerView.ViewHolder {

        public ImageView mLunboImg;
        public TextView mAdWord;
        public TextView mAdAdIntroduction;

        public MyHolder(View rootView) {
            super(rootView);

            this.mLunboImg = (ImageView) rootView.findViewById(R.id.event_img);
            this.mAdWord = (TextView) rootView.findViewById(R.id.event_word);
            this.mAdAdIntroduction = (TextView) rootView.findViewById(R.id.event_introduction);


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
