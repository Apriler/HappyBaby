package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.OverseasCountry;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener{
        void itemClick(View itemView, int position);
    };
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private List<OverseasCountry.DataBeen.CategoryListBean.DataBeanXX.ListBeanXX> datas;

    private LayoutInflater inflater;
    private Context context;

    public CategoryAdapter(List<OverseasCountry.DataBeen.CategoryListBean.DataBeanXX.ListBeanXX> datas, Context context) {
        this.datas = datas;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.hot_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        OverseasCountry.DataBeen.CategoryListBean.DataBeanXX.ListBeanXX date = datas.get(position);

        Picasso.with(context).load(date.getCategory_pic_link()).into(myHolder.mHotImg);


    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }


    class MyHolder extends RecyclerView.ViewHolder {

        public ImageView mHotImg;

        public MyHolder(View rootView) {
            super(rootView);

            mHotImg = (ImageView) rootView.findViewById(R.id.hot_img);
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
