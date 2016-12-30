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
import com.happybaby.happybaby.bean.Product2Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */

public class ProductChattingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Product2Bean.DataBean.CommentInfoBean.CommentListBean> commentList;
    private Context context;

    public ProductChattingAdapter(List<Product2Bean.DataBean.CommentInfoBean.CommentListBean> commentList, Context context) {
        this.commentList = commentList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_chatting, parent, false);
        ProductViewHolder holder = new ProductViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        Product2Bean.DataBean.CommentInfoBean.CommentListBean listBean = commentList.get(position);
        ProductViewHolder holder= (ProductViewHolder) holder1;
        holder.tv_nickName.setText(listBean.getNickName());
        holder.tv_addTimeStr.setText(listBean.getAddTimeStr());
        holder.tv_commentList_content.setText(listBean.getContent());
        Glide.with(context).load(listBean.getUserHead()).into(holder.iv_userHead);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_userHead;
        public TextView tv_nickName;
        public TextView tv_addTimeStr;
        public TextView tv_commentList_content;

        public ProductViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_userHead = (ImageView) rootView.findViewById(R.id.iv_userHead);
            this.tv_nickName = (TextView) rootView.findViewById(R.id.tv_nickName);
            this.tv_addTimeStr = (TextView) rootView.findViewById(R.id.tv_addTimeStr);
            this.tv_commentList_content = (TextView) rootView.findViewById(R.id.tv_commentList_content);
        }

    }
}
