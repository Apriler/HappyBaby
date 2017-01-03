package com.happybaby.happybaby.shopping_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.BaseApplication;
import com.happybaby.happybaby.adapter.ShoppingCartAdapter;
import com.happybaby.happybaby.greendao.ShoppingCartBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment implements View.OnClickListener {
    private Button mEditTv;//编辑按钮
    private TextView mShopToastTv;//购物车还是空着的呢
    private ListView shoppingcarListView;//商品列表
    private CheckBox mCheckboxAll;//全选
    private Button mDeleteBtn;//删除
    private RelativeLayout mAllLayout;//
    private CheckBox mCheckboxCommand;//全选按钮
    private TextView mTotalAmount;//总价
    private TextView mMoneyAmount;//总价
    private TextView mPrivilegeTv;//
    private Button mClearingBtn;//结算或清空
    private RelativeLayout mCommandLayout;//implements ShoppingCartAdapter.IItemCheckedboxChange{
    private CheckBox mCheckhead;//头布局
    private int totalCount;
    private double money;
    private View headView;
    private ShoppingCartAdapter shoppingCartAdapter;
    private List<ShoppingCartBean> cartBeanList = null;
    private boolean flag ;
    private LinearLayout mLlEmpty;
    private LinkedList<Boolean> tagList;
    private LinkedList<Boolean> tagList1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopping, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        initdata();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void initView(View rootView) {
        mEditTv = (Button) rootView.findViewById(R.id.edit_tv);
        mShopToastTv = (TextView) rootView.findViewById(R.id.shop_toast_tv);
        shoppingcarListView = (ListView) rootView.findViewById(R.id.treasure_rv);
        mCheckboxAll = (CheckBox) rootView.findViewById(R.id.checkbox_all);
        mDeleteBtn = (Button) rootView.findViewById(R.id.delete_btn);
        mAllLayout = (RelativeLayout) rootView.findViewById(R.id.all_layout);
        mCheckboxCommand = (CheckBox) rootView.findViewById(R.id.checkbox_command);
        mTotalAmount = (TextView) rootView.findViewById(R.id.total_amount);
        mMoneyAmount = (TextView) rootView.findViewById(R.id.money_amount);
        mPrivilegeTv = (TextView) rootView.findViewById(R.id.privilege_tv);
        mClearingBtn = (Button) rootView.findViewById(R.id.clearing_btn);
        mCommandLayout = (RelativeLayout) rootView.findViewById(R.id.command_layout);

        mEditTv.setOnClickListener(this);
        mDeleteBtn.setOnClickListener(this);
        mClearingBtn.setOnClickListener(this);

        headView = LayoutInflater.from(getContext()).inflate(R.layout.shopping_header_item, null, false); //headView
        mCheckhead = (CheckBox) headView.findViewById(R.id.checkbox_shipments);
        mCheckhead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == false) {
                    mTotalAmount.setText(" 0.00");
                    mClearingBtn.setText("去结算(0)");
                    for (int i=0;i<cartBeanList.size();i++){
                        tagList.set(i,false);
                        count(cartBeanList,tagList);
                        shoppingCartAdapter.notifyDataSetChanged();
                    }
                } else if (mEditTv.getText().equals("完成")) {
                    mTotalAmount.setText(String.format("%.2f", money));
                    mClearingBtn.setText("去结算(" + totalCount + ")");
                } else {
                    for (int i=0;i<cartBeanList.size();i++){
                        tagList.set(i,true);
                        count(cartBeanList,tagList);
                        shoppingCartAdapter.notifyDataSetChanged();
                    }
                    mTotalAmount.setText(String.format("%.2f", money));
                    mClearingBtn.setText("去结算(" + totalCount + ")");
                }


            }
        });
        mCheckboxCommand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == false) {
                    mTotalAmount.setText(" 0.00");
                    mClearingBtn.setText("去结算(0)");
                    for (int i=0;i<cartBeanList.size();i++){
                        tagList.set(i,false);
                        count(cartBeanList,tagList);
                        shoppingCartAdapter.notifyDataSetChanged();
                    }
                } else if (mEditTv.getText().equals("完成")) {
                    mTotalAmount.setText(String.format("%.2f", money));
                    mClearingBtn.setText("去结算(" + totalCount + ")");
                } else {
                    for (int i=0;i<cartBeanList.size();i++){
                        tagList.set(i,true);
                        count(cartBeanList,tagList);
                        shoppingCartAdapter.notifyDataSetChanged();
                    }
                    mTotalAmount.setText(String.format("%.2f", money));
                    mClearingBtn.setText("去结算(" + totalCount + ")");
                }


            }
        });
        shoppingcarListView.addHeaderView(headView);
        mLlEmpty = (LinearLayout) rootView.findViewById(R.id.ll_empty);
        mLlEmpty.setOnClickListener(this);
        cartBeanList = new ArrayList<>();
        tagList = new LinkedList<>();
        tagList1 = new LinkedList<>();
    }

    private void initdata() {

        //cartBeanList.removeAll(cartBeanList);
        cartBeanList = BaseApplication.app.getManager().getAll();
        if (cartBeanList == null){
            mLlEmpty.setVisibility(View.VISIBLE);
        }else {
            mLlEmpty.setVisibility(View.GONE);
            for (int i = 0; i < cartBeanList.size(); i++) {
                tagList.add(false);
            }
            shoppingCartAdapter = new ShoppingCartAdapter(getContext(), cartBeanList,tagList);
            shoppingcarListView.setAdapter(shoppingCartAdapter);
            shoppingCartAdapter.setAddDescListener(new ShoppingCartAdapter.AddDescListener() {
                @Override
                public void Add(int num) {
                    count(cartBeanList,tagList);
                }

                @Override
                public void Tag(List<Boolean> tagList) {
                    count(cartBeanList,tagList);
                }
            });

        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_tv:
                editChange();
                initdata();
                break;
            case R.id.delete_btn:

                break;
            case R.id.clearing_btn:

                //判断当前是不是删除按钮
                if ("删除".equals(mClearingBtn.getText()))
                {

                    for (int i=tagList.size()-1;i>=0;i--){
                        if (tagList.get(i)){

//                            tagList.set(i,tagList.get(++i));
//                            tagList.remove(tagList.size()-1);
                            BaseApplication.app.getManager().delete(BaseApplication.app.getManager().getShoppingCartBean(cartBeanList.get(i).getId()));
                            tagList.remove(i);
                            i=tagList.size()-1;
                        }
//                        else {
//                            tagList1.add(tagList.get(i));
//                        }

                        cartBeanList.removeAll(cartBeanList);
                        cartBeanList = BaseApplication.app.getManager().getAll();
                    }

                    shoppingCartAdapter=new ShoppingCartAdapter(getContext(), cartBeanList,tagList);
                    shoppingcarListView.setAdapter(shoppingCartAdapter);

                }else {

                }
                break;
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onReciver(int num){
//        initdata();
//    }

    private void editChange() {
        if (!flag) {
            mEditTv.setText("编辑");
            mCheckhead.setChecked(false);
            money = 0;
            totalCount = 0;
            mTotalAmount.setVisibility(View.VISIBLE);
            mTotalAmount.setText(String.format("%.2f", money));
            mClearingBtn.setText("去结算（" + totalCount + ")");

        } else {
            mEditTv.setText("完成");
            mCheckhead.setChecked(true);
            mTotalAmount.setVisibility(View.GONE);
            mClearingBtn.setText("删除");
        }
        flag = !flag;
    }

    public void count(List<ShoppingCartBean> cartBeanList, List<Boolean> tagList) {
        money=0;
        totalCount=0;
        for (int i = 0; i < tagList.size(); i++) {
            if (tagList.get(i)){
                money += cartBeanList.get(i).getNum() * cartBeanList.get(i).getPrice();
                totalCount += cartBeanList.get(i).getNum();
            }
        }
        if(mEditTv.getText().equals("完成")){
            mClearingBtn.setText("删除");
        }else {
            mTotalAmount.setText(String.format("%.2f", money));
            mClearingBtn.setText("去结算（" + totalCount + ")");
        }
    }



    //
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initView();
//        initData();
//    }
//
//    private void initData() {
//    }
//
//    private void initView() {
//        headView=LayoutInflater.from(getContext()).inflate(R.layout.shopping_header_item,null,false); //headView
//        mCheckhead= (CheckBox) headView.findViewById(R.id.checkbox_shipments);
//
//        mCheckhead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked == false) {
//                    total.setText("总计:¥ 0.00");
//                    footerButton.setText("去结算(0)");
//                } else if (shoppingCarEditor.getText().equals("完成")) {
//                    total.setText("总计:¥ "+ String.format("%.2f", money));
//                    footerButton.setText("去结算(" + totalCount + ")");
//                }else {
//                    total.setText("总计:¥ "+ String.format("%.2f", money));
//                    footerButton.setText("去结算(" + totalCount + ")");
//                }
//
//                for (int i=0;i<cartBeanList.size();i++){
//                    cartBeanList.get(i).setCheck(isChecked);
//                    shoppingCartAdapter.notifyDataSetChanged();
//                }
//            }
//        });
//        shoppingcarListView.setEmptyView(shoppingcarEmptyview); //空
//        shoppingcarListView.addHeaderView(headView);
//        shoppingCartAdapter=new ShoppingCartAdapter(getContext(),cartBeanList,this);
//        shoppingcarListView.setAdapter(shoppingCartAdapter);
//    }
//    @OnClick({R.id.edit_tv,R.id.clearing_btn})
//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.edit_tv:  //默认为"编辑"
//                editChange();
//                break;
//            case R.id.delete_btn:
//                if (footerButton.getText().equals("删除")){
//                    deleteBatch();
//                }else {//结算
//
//                }
//                break;
//
//        }
//
//
//    }
//
//    /**
//     * 右上角编辑完成切换
//     */
//    private void editChange() {
//        if (!flag) {
//            shoppingCarEditor.setText("编辑");
//            mCheckhead.setChecked(true);
//            money = 0;
//            totalCount = 0;
//            for (int i = 0; i < cartBeanList.size(); i++) {
//                CartBean productBean = cartBeanList.get(i);
//                if (productBean.isCheck() == true) {
//                    totalCount += productBean.getNum();
//                    int count = 0;
//                    count = productBean.getNum();
//                    money += productBean.getStore_price() * count;
//                }
//            }
//
//            total.setVisibility(View.VISIBLE);
//            total.setText("总计：￥ " + String.format("%.2f", money));
//            footerButton.setText("去结算（" + totalCount + ")");
//
//        } else {
//            shoppingCarEditor.setText("完成");
//            mCheckhead.setChecked(false);
//
//            total.setVisibility(View.GONE);
//            footerButton.setText("删除");
//        }
//        flag = !flag;
//    }
//
//    /**
//     * 删除选中项目
//     */
//    private void deleteBatch() {
//        List<BmobObject> newList = new ArrayList<>();
//        for (int i = 0; i < cartBeanList.size(); i++) {
//            CartBean productBean = cartBeanList.get(i);
//            if (productBean.isCheck() == true) {
//                newList.add(productBean);
//                cartBeanList.remove(productBean);
//            }
//        }
//        shoppingCartAdapter.notifyDataSetChanged();//刷新列表
//        BmobBatch batch = new BmobBatch();//删除
//        batch.deleteBatch(newList);
//        //执行批量操作
//        batch.doBatch(new QueryListListener<BatchResult>() {
//
//            @Override
//            public void done(List<BatchResult> results, BmobException ex) {
//                if (ex == null) {
//                    //返回结果的results和上面提交的顺序是一样的，请一一对应
//                    for (int i = 0; i < results.size(); i++) {
//                        ToastUtils.showToast(getContext(), "删除成功" + results.size() + "成功");
//                    }
//                } else {
//                    ToastUtils.showToast(getContext(), "没有物品可删除");
//                }
//            }
//        });
//    }
//
//
//
//
//
//    @Override
//    public void itemCheckedboxChange(int change, double price, int delete) {
//        switch (change) {
//            case 0://点击
//                break;
//            case 1://加法
//                money = money + price;
//                total.setText("总计：￥ " + String.format("%.2f", money));
//                totalCount = totalCount + delete;
//                footerButton.setText("去结算（" + totalCount + ")");
//                break;
//            case 2://减法
//                money = money - price;
//                total.setText("总计：￥ " + String.format("%.2f", money));
//                totalCount = totalCount - delete;
//                footerButton.setText("去结算（" + totalCount + ")");
//                break;
//        }
//
//    }
}

