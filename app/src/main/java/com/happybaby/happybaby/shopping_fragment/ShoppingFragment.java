package com.happybaby.happybaby.shopping_fragment;


import android.content.Context;
import android.os.Bundle;
import android.renderscript.Int4;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.greendao.CartBean;
import com.happybaby.happybaby.greendao.DaoSession;
import com.happybaby.happybaby.greendao.ShoppingCartAdapter;
import com.happybaby.happybaby.greendao.ShoppingCartBeanDao;
import com.happybaby.happybaby.util.ToastUtils;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment implements ShoppingCartAdapter.IItemCheckedboxChange{

    @BindView(R.id.edit_tv)  //购物车编辑按钮
    Button shoppingCarEditor;
    @BindView(R.id.treasure_rv)
    ListView shoppingcarListView;  //RecyclerView列表
    @BindView(R.id.shop_toast_tv)
    TextView shoppingcarEmptyview;//空view
//    @BindView(R.id.progressBar)
//    ProgressBar progressBar;
    @BindView(R.id.total_amount)
    TextView total;
    @BindView(R.id.clearing_btn)
    Button footerButton;
    @BindView(R.id.command_layout)
    RelativeLayout footer;

    //private Context mContext= App.app;
    //private DaoSession daoSession=App.newInstance().getDaoSession();
    private ShoppingCartBeanDao cartBeanDao;
    private List<CartBean> cartBeanList=new ArrayList<>();
    private ShoppingCartAdapter shoppingCartAdapter;
    private CheckBox mCheckhead;
    private boolean flag=true;
    private View headView;
    private double money;
    private int totalCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_shopping, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
        headView=LayoutInflater.from(getContext()).inflate(R.layout.shopping_header_item,null,false); //headView
        mCheckhead= (CheckBox) headView.findViewById(R.id.checkbox_shipments);

        mCheckhead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == false) {
                    total.setText("总计:¥ 0.00");
                    footerButton.setText("去结算(0)");
                } else if (shoppingCarEditor.getText().equals("完成")) {
                    total.setText("总计:¥ "+ String.format("%.2f", money));
                    footerButton.setText("去结算(" + totalCount + ")");
                }else {
                    total.setText("总计:¥ "+ String.format("%.2f", money));
                    footerButton.setText("去结算(" + totalCount + ")");
                }

                for (int i=0;i<cartBeanList.size();i++){
                    cartBeanList.get(i).setCheck(isChecked);
                    shoppingCartAdapter.notifyDataSetChanged();
                }
            }
        });
        shoppingcarListView.setEmptyView(shoppingcarEmptyview); //空
        shoppingcarListView.addHeaderView(headView);
        shoppingCartAdapter=new ShoppingCartAdapter(getContext(),cartBeanList,this);
        shoppingcarListView.setAdapter(shoppingCartAdapter);
    }
    @OnClick({R.id.edit_tv,R.id.clearing_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.edit_tv:  //默认为"编辑"
                editChange();
                break;
            case R.id.delete_btn:
                if (footerButton.getText().equals("删除")){
                    deleteBatch();
                }else {//结算

                }
                break;

        }


    }

    /**
     * 右上角编辑完成切换
     */
    private void editChange() {
        if (!flag) {
            shoppingCarEditor.setText("编辑");
            mCheckhead.setChecked(true);
            money = 0;
            totalCount = 0;
            for (int i = 0; i < cartBeanList.size(); i++) {
                CartBean productBean = cartBeanList.get(i);
                if (productBean.isCheck() == true) {
                    totalCount += productBean.getNum();
                    int count = 0;
                    count = productBean.getNum();
                    money += productBean.getStore_price() * count;
                }
            }

            total.setVisibility(View.VISIBLE);
            total.setText("总计：￥ " + String.format("%.2f", money));
            footerButton.setText("去结算（" + totalCount + ")");

        } else {
            shoppingCarEditor.setText("完成");
            mCheckhead.setChecked(false);

            total.setVisibility(View.GONE);
            footerButton.setText("删除");
        }
        flag = !flag;
    }

    /**
     * 删除选中项目
     */
    private void deleteBatch() {
        List<BmobObject> newList = new ArrayList<>();
        for (int i = 0; i < cartBeanList.size(); i++) {
            CartBean productBean = cartBeanList.get(i);
            if (productBean.isCheck() == true) {
                newList.add(productBean);
                cartBeanList.remove(productBean);
            }
        }
        shoppingCartAdapter.notifyDataSetChanged();//刷新列表
        BmobBatch batch = new BmobBatch();//删除
        batch.deleteBatch(newList);
        //执行批量操作
        batch.doBatch(new QueryListListener<BatchResult>() {

            @Override
            public void done(List<BatchResult> results, BmobException ex) {
                if (ex == null) {
                    //返回结果的results和上面提交的顺序是一样的，请一一对应
                    for (int i = 0; i < results.size(); i++) {
                        ToastUtils.showToast(getContext(), "删除成功" + results.size() + "成功");
                    }
                } else {
                    ToastUtils.showToast(getContext(), "没有物品可删除");
                }
            }
        });
    }





    @Override
    public void itemCheckedboxChange(int change, double price, int delete) {
        switch (change) {
            case 0://点击
                break;
            case 1://加法
                money = money + price;
                total.setText("总计：￥ " + String.format("%.2f", money));
                totalCount = totalCount + delete;
                footerButton.setText("去结算（" + totalCount + ")");
                break;
            case 2://减法
                money = money - price;
                total.setText("总计：￥ " + String.format("%.2f", money));
                totalCount = totalCount - delete;
                footerButton.setText("去结算（" + totalCount + ")");
                break;
        }

    }
}

