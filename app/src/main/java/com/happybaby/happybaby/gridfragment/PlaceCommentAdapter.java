package com.happybaby.happybaby.gridfragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.GridAdapter;
import com.happybaby.happybaby.bean.GridBean;
import com.happybaby.happybaby.bean.PlaceBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PlaceCommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

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

    private Context context; //上下文
    private List<PlaceBean.DataBean.ListBean> datas; // 数据源
    private LayoutInflater inflater; // 布局加载器

    public PlaceCommentAdapter(Context context, List<PlaceBean.DataBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //由布局生成生成View
        View converView = inflater.inflate(R.layout.place_topic_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(converView);
        return viewHolder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        List<ImageView> imageViews = new ArrayList<>();
        //获得指定位置数据
        PlaceBean.DataBean.ListBean data = datas.get(position);
        //绑定数据

        viewHolder.userNameClick.setText(data.getUser_info().getNick_name());  //用户名
        viewHolder.attentionClick.setText(data.getId()); //关注按钮
        viewHolder.likenessTv.setText(data.getProduct_count()); //相似产品
        viewHolder.likeNumber.setText(data.getZan_num()); //点赞数量，没有赞时，显示为“赞”
        viewHolder.commentTv.setText(data.getComment_num());  //评论数量
        viewHolder.shareTv.setText(data.getShare_info().getShare_text_other_qq());  //分享  **
        Picasso.with(context).load(data.getUser_info().getAvatar()).into(viewHolder.ivHead);//用户头像
        viewHolder.likeClick.setImageResource(data.getIs_zan());  //赞的动画效果

//
//        ivHead = (ImageView) convertView.findViewById(R.id.iv_head);  //用户头像

//        likeClick = (ImageView) convertView.findViewById(R.id.like_click);  //点赞





        for (int i = 0 ; i <data.getImage_info().size();i++){
            String image_url = data.getImage_info().get(i).getImage_url();
            ImageView iv = new ImageView(context);
            Picasso.with(context).load(image_url).into(iv);
            imageViews.add(iv);
        }
        viewHolder.viewPager.setAdapter(new GridAdapter(imageViews));
//        //holder.itemView ViewHolder所对应的子View
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itemClickListener.itemClick(holder.itemView, holder.getLayoutPosition());
//            }
//        });
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                itemLongClickListener.itemLongCilck(holder.itemView, holder.getLayoutPosition());
//                return true;
//            }
//        });
    }

    //返回数据源长度
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义ViewHolder
    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivHead, likeClick;
        TextView userNameClick,attentionClick,likenessTv,likeNumber,commentTv,shareTv;
        ViewPager viewPager;


        public MyViewHolder(View convertView) {
            super(convertView);
            ivHead = (ImageView) convertView.findViewById(R.id.iv_head);  //用户头像
            userNameClick = (TextView) convertView.findViewById(R.id.user_name_click); //用户名
            attentionClick = (TextView) convertView.findViewById(R.id.attention_click); //关注按钮
            likenessTv = (TextView) convertView.findViewById(R.id.likeness_tv);     //相似产品
            likeClick = (ImageView) convertView.findViewById(R.id.like_click);  //点赞
            likeNumber = (TextView) convertView.findViewById(R.id.like_number);     //点赞数量，没有赞时，显示为“赞”
            commentTv = (TextView) convertView.findViewById(R.id.comment_tv);     //评论
            shareTv = (TextView) convertView.findViewById(R.id.share_tv);     //分享

            viewPager = (ViewPager) convertView.findViewById(R.id.pull_down_vp);  //viewPager中心图片
            //itemView ViewHolder所对应的子View
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    itemClickListener.itemClick(itemView, getLayoutPosition());
//                }
//            });
//
//                    itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    itemLongClickListener.itemLongCilck(itemView, getLayoutPosition());
//                    return true;
//                }
//            });

        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 以下方法为UI界面刷新方法
    ///////////////////////////////////////////////////////////////////////////
    //重新加载资源
    public void reloadRecyclerView(List<PlaceBean.DataBean.ListBean> _datas) {
        datas.addAll(_datas);
        notifyDataSetChanged();
    }

    //适配器中添加单条数据，刷新UI
    public void addItem(PlaceBean.DataBean.ListBean data, int position) {
        datas.add(position, data);
        notifyItemInserted(position);
    }


}
