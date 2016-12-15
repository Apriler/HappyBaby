package com.happybaby.happybaby.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bodhixu on 2016/11/21.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{



    //===========================================
    //====================点击监听接口========================
    //==========================================
    public interface OnItemClickListener{
        void itemClick(View itemView, int position);
    };

    public interface OnItemLongClickListener{
        void itemLongCilck(View itemView, int position);
    }

    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener  itemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }
    //===========================================
    //====================点击监听接口========================
    //==========================================

    protected Context context; //上下文
    protected List<T> datas; // 数据源
    protected LayoutInflater inflater; // 布局加载器
    protected int itemLayoutId; //item子项布局id
    protected int[] itemViewIds; //item布局中子View的id集合

    public BaseRecyclerViewAdapter(Context context, List<T> datas, int place_card_view, int itemLayoutId) {
        this.context = context;
        this.datas = datas;
        this.itemLayoutId = itemLayoutId;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //由布局生成生成View
        View converView = inflater.inflate(itemLayoutId, parent, false);
        return new BaseViewHolder(converView, itemViewIds, itemClickListener, itemLongClickListener);
    }


    //返回数据源长度
    @Override
    public int getItemCount() {
        return datas.size();
    }


    ///////////////////////////////////////////////////////////////////////////
    // 以下方法为UI界面刷新方法
    ///////////////////////////////////////////////////////////////////////////
    //重新加载资源
    public void reloadRecyclerView(List<T> _datas) {
        datas.addAll(_datas);
        notifyDataSetChanged();
    }

    //适配器中添加单条数据，刷新UI
    public void addItem(T data, int position) {
        datas.add(position, data);
        notifyItemInserted(position);
    }

    //添加多条数据
    public void addItems(List<T> _datas, int positionStart) {
        datas.addAll(_datas);
        notifyItemRangeInserted(positionStart,_datas.size());
    }

    //移除指定位置数据
    public void removeItem(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    //移除多条数据
    public void removeItems(List<T> _datas, int positionStart) {
        datas.removeAll(_datas);
        notifyItemRangeRemoved(positionStart , _datas.size());
    }

    //更新一条数据
    public void changeItem(T data, int position) {
        datas.remove(position);
        datas.add(position,data);
        notifyItemChanged(position);
    }

}
