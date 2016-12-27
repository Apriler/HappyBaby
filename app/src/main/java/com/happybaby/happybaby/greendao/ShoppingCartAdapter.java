package com.happybaby.happybaby.greendao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.util.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;


/**
 * Created by jianquan on 2016/12/27.
 */

public class ShoppingCartAdapter extends CartDBHelperAdapter<CartBean> {
    private IItemCheckedboxChange iItemCheckedboxChange;

    public interface IItemCheckedboxChange{
        void itemCheckedboxChange(int state, double v, int item);
    }

    public ShoppingCartAdapter(Context context, List<CartBean> list,
                               IItemCheckedboxChange iItemCheckedboxChange) {
        super(context, list);
        this.iItemCheckedboxChange=iItemCheckedboxChange;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.item_shopping,parent,false);
            vh= new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }

        final CartBean cartBean=mList.get(position);
        vh.storePrice.setText(cartBean.getStore_price()+""); //价格
        vh.name.setText(cartBean.getName()); //描述
        vh.num.setText(cartBean.getName()+"");//数量
        vh.checkboxItem.setChecked(cartBean.isCheck());

        vh.checkboxItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartBean.setCheck(!cartBean.isCheck());
                notifyDataSetChanged();
                iItemCheckedboxChange.itemCheckedboxChange(0,cartBean.getStore_price()*cartBean.getNum(),0);//传递给调用者
            }
        });

        Glide.with(mContext).load(cartBean.getProduct_image()).into(vh.productImage); //图片
        final ViewHolder finalVh=vh;
        vh.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newNum=cartBean.getNum()+1;
                cartBean.setNum(newNum);  //加1
                iItemCheckedboxChange.itemCheckedboxChange(1,cartBean.getStore_price(),1);//传递给调用者
                cartBean.update(cartBean.getObjectId(), new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            Log.i("Tag","更新成功");
                        }else {
                            Log.i("Tag","更新失败:"+e.getMessage()+","+e.getErrorCode());
                        }
                    }
                });
            }
        });

        vh.substact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cartBean.getNum()==1){
                    ToastUtils.showToast(mContext,"最小数量为1");
                }else {
                    int newNum = cartBean.getNum()-1;
                    finalVh.num.setText(newNum+"");  //加1
                    cartBean.setNum(newNum);
                    iItemCheckedboxChange.itemCheckedboxChange(2,cartBean.getStore_price(),1); //传递给调用者
                    cartBean.update(cartBean.getObjectId(), new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e==null){
                                Log.i("Tag","更新成功");
                            }else {
                                Log.i("Tag","更新失败："+e.getMessage()+","+e.getErrorCode());
                            }

                        }
                    });
                }
            }
        });




        return null;
    }


    static class ViewHolder {
        @BindView(R.id.checkbox_item)
        CheckBox checkboxItem;
        @BindView(R.id.treasure_iv)
        ImageView productImage;
        @BindView(R.id.details_tv)
        TextView name;
        @BindView(R.id.price_tv)
        TextView storePrice;
        @BindView(R.id.number_minus)
        TextView substact;
        @BindView(R.id.number_tv)
        TextView num;
        @BindView(R.id.number_plus)
        TextView add;

        ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
