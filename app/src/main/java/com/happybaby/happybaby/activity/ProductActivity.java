package com.happybaby.happybaby.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.ProductADAdapter;
import com.happybaby.happybaby.adapter.ProductChattingAdapter;
import com.happybaby.happybaby.bean.Product1Bean;
import com.happybaby.happybaby.bean.Product2Bean;
import com.happybaby.happybaby.constant.ProductConstant;
import com.happybaby.happybaby.greendao.ShoppingCartBean;
import com.happybaby.happybaby.util.OkHttpUtils;
import com.jude.rollviewpager.RollPagerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
//商品详情页面

public class ProductActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbarProduct;
    private RollPagerView mVpProduct;//轮播图
    private TextView mTvProductBrandName;//Apple/苹果
    private TextView mTvProductName;//Apple iPhone 7 128GB黑色  （国行）
    private TextView mTvProductMinPrice;//6078
    private TextView mTvProductMarketPrice;//897.81
    private TextView mTvProductHomeMarketPrice;//6900.00
    private TextView mTvProductSaveMoney;//822.00
    private ImageView mIvCountryFlag;//美国图标
    private TextView mTvCountryName;//美国
    private ImageView mIvBack5;//
    private TextView mTvReferDataText;//此商品价格参考美国apple.com网站
    private TextView mTvBondedTaxInfo;//关税：个人邮寄进境物品海关依法征收进口税
    private TextView mTvTitleDesc;//商品满意度4.5分
    private TextView mTvTotal;//2
    private RecyclerView mRecyclerviewProduct;//评论
    private ImageView mCartShoppingcar;//购物车图标
    private TextView mProductAddShoppingcar;//加入购物车
    private TextView mProductImmediatelyParchase;//立即购买
    private PopupWindow popupWindow;
    private String url1 = ProductConstant.PRODUCT_BASE;
    private String url2 = ProductConstant.PRODUCT_BASE_CHATTING;
    private ImageView mIconPop;//商品图
    private TextView mPricePop;//价格
    private TextView mSubstactPop;//-
    private TextView mNumberPop;//数量
    private TextView mAddPop;//+
    private Button mConfirmPop;//提交到数据库里
    private String id;
    private ShoppingCartBean shopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView();
        initURL();
        initToolBar();
        initHttp();


    }

    private void initPopupwindowdata(View popView) {
        //实例化popupwindow控件
        mIconPop = (ImageView) popView.findViewById(R.id.icon_pop);
        mIconPop.setOnClickListener(this);
        mPricePop = (TextView)  popView.findViewById(R.id.price_pop);
        mPricePop.setOnClickListener(this);
        mSubstactPop = (TextView) popView. findViewById(R.id.substact_pop);
        mSubstactPop.setOnClickListener(this);
        mNumberPop = (TextView)  popView.findViewById(R.id.number_pop);
        mNumberPop.setOnClickListener(this);
        mAddPop = (TextView)  popView.findViewById(R.id.add_pop);
        mAddPop.setOnClickListener(this);
        mConfirmPop = (Button)  popView.findViewById(R.id.confirm_pop);
        mConfirmPop.setOnClickListener(this);

    }

    private void initPopupwindow() {
        View popView =  LayoutInflater.from(ProductActivity.this).inflate(R.layout.popupwindow_bottom, null, false);
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        initPopupwindowdata(popView);
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {//关闭popup时其他地方变亮
            @Override
            public void onDismiss() {

                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1f;
                getWindow().setAttributes(params);

            }
        });

    }


    private void initHttp() {
        OkHttpUtils okHttpUtils = OkHttpUtils.newInstance();//获取OkHttpUtils的单例
        okHttpUtils.doAsyncGETRequest(url1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String product1Str = response.body().string();
                Gson gsonproduct1 = new Gson();
                Product1Bean product1 = gsonproduct1.fromJson(product1Str, Product1Bean.class);
                final Product1Bean.DataBean data = product1.getData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<ImageView> imageViewList = new ArrayList<ImageView>();
                        for (int i = 0; i < data.getProductImage().size() / 2; i++) {
                            ImageView imageView = new ImageView(ProductActivity.this);
                            Glide.with(ProductActivity.this).load(data.getProductImage().get(i).getImageUrl())
                                    .into(imageView);
                            imageViewList.add(imageView);
                        }
                        ProductADAdapter adapter = new ProductADAdapter(imageViewList);
                        mVpProduct.setAdapter(adapter);
                        mTvProductBrandName.setText(data.getBrandName());
                        mTvProductName.setText(data.getName());
                        mTvProductMinPrice.setText(data.getSkuPrice().getMin_price());
                        mTvProductMarketPrice.setText(data.getSkuPrice().getMarket_price());
                        mTvProductHomeMarketPrice.setText(data.getSkuPrice().getHome_market_price());
                        mTvProductSaveMoney.setText(data.getSkuPrice().getSaveMoney());
                        Glide.with(ProductActivity.this).load(data.getCountry_flag()).into(mIvCountryFlag);
                        mTvCountryName.setText(data.getCountryName());
                        mTvReferDataText.setText(data.getReferData().getText());
                        mTvBondedTaxInfo.setText(data.getBonded_tax_info().getText());
                        shopping.setImageUrl(data.getProductImage().get(0).getImageUrl());//图片地址
                        //数据加载到popupwindow里
                        Glide.with(ProductActivity.this).load(shopping.getImageUrl())
                                .into(mIconPop) ;//商品图
                        mPricePop.setText(mTvProductMinPrice.getText());//价格
                        mNumberPop.setText("1");


                    }
                });
            }
        });
        okHttpUtils.doAsyncGETRequest(url2, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String product2Str = response.body().string();
                Gson gsonproduct2 = new Gson();
                Product2Bean product2 = gsonproduct2.fromJson(product2Str, Product2Bean.class);
                final Product2Bean.DataBean data = product2.getData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mTvTitleDesc.setText(data.getCommentInfo().getTitleDesc());
                        mTvTotal.setText(data.getCommentInfo().getTotal());
                        List<Product2Bean.DataBean.CommentInfoBean.CommentListBean> commentList = data.getCommentInfo().getCommentList();
                        ProductChattingAdapter adapter = new ProductChattingAdapter(commentList, ProductActivity.this);
                        mRecyclerviewProduct.setAdapter(adapter);
                        mRecyclerviewProduct.setLayoutManager(new LinearLayoutManager(ProductActivity.this, LinearLayoutManager.VERTICAL, false));
                    }
                });
            }
        });
    }

    //初始化后退按钮
    private void initToolBar() {
        setSupportActionBar(mToolbarProduct);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    private void initURL() {
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        url1 += id;
        url2 += id;
    }


    private void initView() {
        mToolbarProduct = (Toolbar) findViewById(R.id.toolbar_product);
        mVpProduct = (RollPagerView) findViewById(R.id.vp_product);
        mTvProductBrandName = (TextView) findViewById(R.id.tv_product_brandName);
        mTvProductName = (TextView) findViewById(R.id.tv_product_name);
        mTvProductMinPrice = (TextView) findViewById(R.id.tv_product_min_price);
        mTvProductMarketPrice = (TextView) findViewById(R.id.tv_product_market_price);
        mTvProductHomeMarketPrice = (TextView) findViewById(R.id.tv_product_home_market_price);
        mTvProductSaveMoney = (TextView) findViewById(R.id.tv_product_saveMoney);
        mIvCountryFlag = (ImageView) findViewById(R.id.iv_country_flag);
        mTvCountryName = (TextView) findViewById(R.id.tv_countryName);
        mIvBack5 = (ImageView) findViewById(R.id.iv_back5);
        mTvReferDataText = (TextView) findViewById(R.id.tv_referData_text);
        mTvBondedTaxInfo = (TextView) findViewById(R.id.tv_bonded_tax_info);
        mTvTitleDesc = (TextView) findViewById(R.id.tv_titleDesc);
        mTvTotal = (TextView) findViewById(R.id.tv_total);
        mRecyclerviewProduct = (RecyclerView) findViewById(R.id.recyclerview_product);
        mCartShoppingcar = (ImageView) findViewById(R.id.cart_shoppingcar);
        mProductAddShoppingcar = (TextView) findViewById(R.id.product_add_shoppingcar);
        mProductAddShoppingcar.setOnClickListener(this);
        mProductImmediatelyParchase = (TextView) findViewById(R.id.product_immediately_parchase);
        shopping = new ShoppingCartBean();//实例数据的对象
        initPopupwindow();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.product_add_shoppingcar://弹出popupwindow按钮
                //背景变灰
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 0.3f;
                getWindow().setAttributes(params);
                View rootview = getLayoutInflater().inflate(R.layout.activity_change_user_name, null);
                popupWindow.showAtLocation(rootview, Gravity.BOTTOM,0,0);

                break;

            case R.id.substact_pop://-
                if("1".equals(mNumberPop.getText())){
                    showToast("最小购买数为1 ");
                }else {
                    int i = Integer.parseInt(mNumberPop.getText().toString());
                    mNumberPop.setText(String.valueOf(--i));
                }
                break;
            case R.id.add_pop://+
                if("6".equals(mNumberPop.getText())){
                    showToast("最大购买数为6 ");
                }else {
                    int i = Integer.parseInt(mNumberPop.getText().toString());
                    mNumberPop.setText(String.valueOf(++i));
                }
                break;

            case R.id.confirm_pop://提交按钮
                shopping.setName(mTvProductName.getText().toString());//产品名
                shopping.setNum(Integer.valueOf(mNumberPop.getText().toString()));//数量
                shopping.setId(Integer.valueOf(id));//id
                shopping.setPrice(Double.parseDouble(mTvProductMinPrice.getText().toString()));//价格
                ShoppingCartBean shoppingCartBean = BaseApplication.app.getManager().getShoppingCartBean(shopping.getId());
                if (shoppingCartBean == null){
                    BaseApplication.app.getManager().insert(shopping);
                }else {
                    BaseApplication.app.getManager().update(shopping);

                }
                showToast("添加成功");
                popupWindow.dismiss();

                break;


        }
    }
}
