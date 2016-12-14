package com.happybaby.happybaby.gridfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.HotThemeBean;
import com.happybaby.happybaby.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.happybaby.happybaby.recyclerview.adapter.BaseViewHolder;

import java.util.List;

/**
 * Created by jianquan on 2016/12/14.
 */

public class HotThemeAdapter extends BaseRecyclerViewAdapter<HotThemeBean> {


    public HotThemeAdapter(Context context, List<HotThemeBean> datas) {
        super(context, datas, R.layout.place_card_view,new int[]{R.id.pic_iv,R.id.name_tv});
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //获得子View的集合
        SparseArray<View> itemViews = ((BaseViewHolder)holder).getItemViews();
        //获得子View
        ImageView itemIv = (ImageView) itemViews.get(R.id.pic_iv);
        TextView itemTv = (TextView) itemViews.get(R.id.name_tv);
        //绑定数据
        HotThemeBean data = datas.get(position);
        itemIv.setImageResource(Integer.parseInt(data.getImages()));
        itemTv.setText(data.getImageTitle());

    }
}
