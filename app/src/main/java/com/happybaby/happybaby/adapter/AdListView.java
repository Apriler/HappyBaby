package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.OverseasCountry;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class AdListView extends BaseAdapter {
    private List<OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX> dates;
    private Context context;
    private LayoutInflater inflater;


    //不同布局标识
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;


    public AdListView(List<OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX> dates, Context context) {
        this.dates = dates;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //返回几种 不同布局
    @Override
    public int getViewTypeCount() {
        return 2;
    }
//获得当前应加载的布局


    @Override
    public int getItemViewType(int position) {

        if (position == 0) {

            return TYPE1;
        } else {
            return TYPE2;
        }


    }

    @Override
    public int getCount() {
        return dates != null ? dates.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return dates.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        int type = getItemViewType(position);
        ViewHolder1 holer1 = null;
        ViewHolder2 holer2 = null;


        if (view == null) {


            switch (type) {

                case TYPE1:
                    view = inflater.inflate(R.layout.goods_item1, null, false);
                    holer1 = new ViewHolder1(view);
                    view.setTag(holer1);
                    break;
                case TYPE2:
                    view = inflater.inflate(R.layout.goods_item2, null, false);
                    holer2 = new ViewHolder2(view);
                    view.setTag(holer2);

                    break;
            }

        } else {

            switch (type) {
                case TYPE1:
                    holer1 = (ViewHolder1) view.getTag();

                    break;
                case TYPE2:
                    holer2 = (ViewHolder2) view.getTag();


                    break;
            }
        }
//获取当前数据源
        OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX date=dates.get(position);

    switch (type){
        case TYPE1:
            holer1.mGood1Introduction.setText(date.getIntroduction());
            holer1.mGood1Tile.setText(date.getTitle());
            holer1.mGoods1Comment.setText(date.getComment_num());
            holer1.mGoods1Like.setText(date.getLike_num());
            Picasso.with(context).load(date.getPhone_head_pic()).into(holer1.mGoods1Img);
            break;
        case TYPE2:
            holer2.mGood2Introduction.setText(date.getIntroduction());
            holer2.mGood2Tile.setText(date.getTitle());
            holer2.mGoods2Comment.setText(date.getComment_num());
            holer2.mGoods2Like.setText(date.getLike_num());
            Picasso.with(context).load(date.getPhone_small_pic()).into(holer2.mGoods2Img);
            break;

    }

        return view;
    }


     class ViewHolder1 {

        public TextView mGood1Tile;
        public TextView mGood1Introduction;
        public TextView mGoods1Like;
        public TextView mGoods1Comment;
        public ImageView mGoods1Img;

        public ViewHolder1(View rootView) {

            this.mGood1Tile = (TextView) rootView.findViewById(R.id.good1_tile);
            this.mGood1Introduction = (TextView) rootView.findViewById(R.id.good1_introduction);
            this.mGoods1Like = (TextView) rootView.findViewById(R.id.goods1_like);
            this.mGoods1Comment = (TextView) rootView.findViewById(R.id.goods1_comment);
            this.mGoods1Img = (ImageView) rootView.findViewById(R.id.goods1_img);
        }

    }

    class ViewHolder2 {

        public TextView mGood2Tile;
        public TextView mGood2Introduction;
        public TextView mGoods2Like;
        public TextView mGoods2Comment;
        public ImageView mGoods2Img;

        public ViewHolder2(View rootView) {

            this.mGood2Tile = (TextView) rootView.findViewById(R.id.good2_tile);
            this.mGood2Introduction = (TextView) rootView.findViewById(R.id.good2_introduction);
            this.mGoods2Like = (TextView) rootView.findViewById(R.id.goods2_like);
            this.mGoods2Comment = (TextView) rootView.findViewById(R.id.goods2_comment);
            this.mGoods2Img = (ImageView) rootView.findViewById(R.id.goods2_img);
        }

    }
}
