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

public class GoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(View itemView, int position);
    }

    ;
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private List<OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX> datas;

    private LayoutInflater inflater;
    private Context context;
    //不同布局标识
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;

    public GoodsAdapter(List<OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view1 = inflater.inflate(R.layout.goods_item1, parent, false);
        View view2 = inflater.inflate(R.layout.goods_item2, parent, false);

        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE1) {
            holder = new MyHolder1(view1);

        } else {
            holder = new MyHolder2(view2);

        }

        return holder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX date=datas.get(position);
        if (position==0){
            MyHolder1 myHolder1= (MyHolder1) holder;
            myHolder1.mGood1Introduction.setText(date.getIntroduction());
            myHolder1.mGood1Tile.setText(date.getTitle());
            myHolder1.mGoods1Comment.setText(date.getComment_num());
            myHolder1.mGoods1Like.setText(date.getLike_num());
            Glide.with(context).load(date.getPhone_head_pic()).into(myHolder1.mGoods1Img);

        }else {
            MyHolder2 myHolder2= (MyHolder2) holder;
            myHolder2.mGood2Introduction.setText(date.getIntroduction());
            myHolder2.mGood2Tile.setText(date.getTitle());
            myHolder2.mGoods2Comment.setText(date.getComment_num());
            myHolder2.mGoods2Like.setText(date.getLike_num());
            Glide.with(context).load(date.getPhone_small_pic()).into(myHolder2.mGoods2Img);


        }


    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE1;
        } else {
            return TYPE2;
        }


    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }


    class MyHolder1 extends RecyclerView.ViewHolder {
        public TextView mGood1Tile;
        public TextView mGood1Introduction;
        public TextView mGoods1Like;
        public TextView mGoods1Comment;
        public ImageView mGoods1Img;

        public MyHolder1(View rootView) {
            super(rootView);

            this.mGood1Tile = (TextView) rootView.findViewById(R.id.good1_tile);
            this.mGood1Introduction = (TextView) rootView.findViewById(R.id.good1_introduction);
            this.mGoods1Like = (TextView) rootView.findViewById(R.id.goods1_like);
            this.mGoods1Comment = (TextView) rootView.findViewById(R.id.goods1_comment);
            this.mGoods1Img = (ImageView) rootView.findViewById(R.id.goods1_img);
            //itemView ViewHolder所对应的子View
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.itemClick(itemView, getLayoutPosition());
                }
            });

        }

    }

    class MyHolder2 extends RecyclerView.ViewHolder {

        public TextView mGood2Tile;
        public TextView mGood2Introduction;
        public TextView mGoods2Like;
        public TextView mGoods2Comment;
        public ImageView mGoods2Img;

        public MyHolder2(View rootView) {
            super(rootView);

            this.mGood2Tile = (TextView) rootView.findViewById(R.id.good2_tile);
            this.mGood2Introduction = (TextView) rootView.findViewById(R.id.good2_introduction);
            this.mGoods2Like = (TextView) rootView.findViewById(R.id.goods2_like);
            this.mGoods2Comment = (TextView) rootView.findViewById(R.id.goods2_comment);
            this.mGoods2Img = (ImageView) rootView.findViewById(R.id.goods2_img);
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
