package com.happybaby.happybaby.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by bodhixu on 2016/11/21.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{

    //SparseArray封装后的hashmap，比传递的hashmap优点就是速度快
    //要求是key必须要是int型数据
    private SparseArray<View> itemViews;

    public BaseViewHolder(View convertView, int[] itemViewIds,
                          final BaseRecyclerViewAdapter.OnItemClickListener itemClickListener,
                          final BaseRecyclerViewAdapter.OnItemLongClickListener itemLongClickListener) {
        super(convertView);

        itemViews = new SparseArray<>();
        for (int i=0; i<itemViewIds.length; i++) {
            View itemView = convertView.findViewById(itemViewIds[i]);
            itemViews.put(itemViewIds[i], itemView);
        }

        //itemView ViewHolder所对应的子View
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.itemClick(itemView, getLayoutPosition());
                }
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (itemLongClickListener != null) {
                    itemLongClickListener.itemLongCilck(itemView, getLayoutPosition());
                }
                return true;
            }
        });
    }

    public SparseArray<View> getItemViews() {
        return itemViews;
    }
}
