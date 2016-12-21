package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.OverseasCountry;
import com.happybaby.happybaby.util.BitmapUtils;

import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */

public class HotShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(View itemView, int position);
    }

    ;
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private List<OverseasCountry.DataBeen.HotShowListBean.DataBeanXXXXX.ListBeanXXXXX> datas;

    private LayoutInflater inflater;
    private Context context;

    public HotShowAdapter(List<OverseasCountry.DataBeen.HotShowListBean.DataBeanXXXXX.ListBeanXXXXX> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_hot_show, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        OverseasCountry.DataBeen.HotShowListBean.DataBeanXXXXX.ListBeanXXXXX date = datas.get(position);

        Glide.with(context).load(date.getShow_image()).into(myHolder.mHotShowItemImg);
        Glide.with(context).load(date.getUser_info().getAvatar())
                .transform(new RoundTransformation(context))
                .into(myHolder.mHotUserIcon);
        myHolder.mHotUserName.setText(date.getUser_info().getNick_name());
        myHolder.mShowLike.setText(date.getZan_num());
        myHolder.mHotShowItemIntroduction.setText(URLDecoder.decode(date.getContent().toString()));

    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    //圆角的TransForm
    class RoundTransformation extends BitmapTransformation {

        public RoundTransformation(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform,
                                   int outWidth, int outHeight) {
            Bitmap roteBmp = BitmapUtils.getRoundCornerBitmap(toTransform, 360);
            if (roteBmp != toTransform) {
                toTransform.recycle();
            }
            return roteBmp;
        }

        @Override
        public String getId() {
            return "glide";
        }
    }



    class MyHolder extends RecyclerView.ViewHolder {

        public ImageView mHotShowItemImg;
        public TextView mHotShowItemIntroduction;
        public ImageView mHotUserIcon;
        public TextView mHotUserName;
        public TextView mShowLike;

        public MyHolder(View rootView) {
            super(rootView);
            this.mHotShowItemImg = (ImageView) rootView.findViewById(R.id.hot_show_item_img);
            this.mHotShowItemIntroduction = (TextView) rootView.findViewById(R.id.hot_show_item_introduction);
            this.mHotUserIcon = (ImageView) rootView.findViewById(R.id.hot_user_icon);
            this.mHotUserName = (TextView) rootView.findViewById(R.id.hot_user_name);
            this.mShowLike = (TextView) rootView.findViewById(R.id.show_like);
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
