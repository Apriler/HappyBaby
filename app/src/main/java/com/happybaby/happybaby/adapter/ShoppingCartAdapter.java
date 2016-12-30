package com.happybaby.happybaby.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.BaseApplication;
import com.happybaby.happybaby.greendao.ShoppingCartBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public class ShoppingCartAdapter extends BaseAdapter{
    private Context context;
    private List<ShoppingCartBean> list;
    private LayoutInflater inflater;
    private AddDescListener addDescListener;
    private List<Boolean> tagList;
    public void setAddDescListener(AddDescListener addDescListener) {
        this.addDescListener = addDescListener;
    }

    public ShoppingCartAdapter(Context context, List<ShoppingCartBean> list,List<Boolean> tagList) {
        this.tagList = tagList;
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyShopHolder myShopHolder =null;
        if(view == null){
            view = inflater.inflate(R.layout.item_shopping, viewGroup, false);
            myShopHolder=new MyShopHolder(view);
            view.setTag(myShopHolder);
        }
        else {
            myShopHolder= (MyShopHolder) view.getTag();
        }
        ShoppingCartBean s = list.get(i);
        myShopHolder.mCheckboxItem .setChecked(tagList.get(i));
        myShopHolder.mCheckboxItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = !tagList.get(i);
                tagList.set(i,b);
                addDescListener.Tag(tagList);
                ShoppingCartAdapter.this.notifyDataSetChanged();
            }
        });
        Glide.with(context).load(s.getImageUrl()).into(myShopHolder.mTreasureIv);
        myShopHolder.mDetailsTv.setText(s.getName());
        myShopHolder.mPriceTv .setText(String.valueOf(s.getPrice()));
        myShopHolder.mNumberMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCartBean shoppingCartBean = list.get(i);
                int num = shoppingCartBean.getNum();
                if (num != 1){
                    shoppingCartBean.setNum(--num);
                    BaseApplication.app.getManager().update(shoppingCartBean);
                }else {
                    Toast.makeText(context,"最小购买量为 1",Toast.LENGTH_SHORT).show();
                }
                addDescListener.Add(num);
                ShoppingCartAdapter.this.notifyDataSetChanged();
            }
        });
        myShopHolder.mNumberTv.setText(String.valueOf(s.getNum()));
        myShopHolder.mNumberPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCartBean shoppingCartBean1 = list.get(i);
                int num1 = shoppingCartBean1.getNum();
                if (num1 != 6){
                    shoppingCartBean1.setNum(++num1);
                    BaseApplication.app.getManager().update(shoppingCartBean1);
                }else {
                    Toast.makeText(context,"最大购买量为 6",Toast.LENGTH_SHORT).show();
                }
                addDescListener.Add(num1);
            ShoppingCartAdapter.this.notifyDataSetChanged();
            }
        });

        return view;
    }



    public static class MyShopHolder {
        public View rootView;
        public CheckBox mCheckboxItem;
        public ImageView mTreasureIv;
        public TextView mDetailsTv;
        public TextView mPriceTv;
        public TextView mNumberMinus;
        public TextView mNumberTv;
        public TextView mNumberPlus;
        public RelativeLayout mTreasureLayout;

        public MyShopHolder(View rootView) {
            this.rootView = rootView;
            this.mCheckboxItem = (CheckBox) rootView.findViewById(R.id.checkbox_item);
            this.mTreasureIv = (ImageView) rootView.findViewById(R.id.treasure_iv);
            this.mDetailsTv = (TextView) rootView.findViewById(R.id.details_tv);
            this.mPriceTv = (TextView) rootView.findViewById(R.id.price_tv);
            this.mNumberMinus = (TextView) rootView.findViewById(R.id.number_minus);
            this.mNumberTv = (TextView) rootView.findViewById(R.id.number_tv);
            this.mNumberPlus = (TextView) rootView.findViewById(R.id.number_plus);
            this.mTreasureLayout = (RelativeLayout) rootView.findViewById(R.id.treasure_layout);
        }

    }

    public interface AddDescListener {
        void Add(int num);
        void Tag(List<Boolean> tagList);
    }
}
