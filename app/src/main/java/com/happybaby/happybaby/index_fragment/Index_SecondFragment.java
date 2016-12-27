package com.happybaby.happybaby.index_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.ADtextAdapter;
import com.happybaby.happybaby.adapter.ZhiDeMaiAdapter;
import com.happybaby.happybaby.bean.ZhiDeMai1;
import com.happybaby.happybaby.bean.ZhiDeMai2;
import com.happybaby.happybaby.constant.ZhideMaiContants;
import com.happybaby.happybaby.inter.ZhiDeMaiapi;
import com.happybaby.happybaby.inter.ZhiDeMaiapi1;
import com.happybaby.happybaby.inter.ZhiDeMaiapi2;
import com.happybaby.happybaby.util.HttpUtils;
import com.happybaby.happybaby.util.OkHttpUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jude.rollviewpager.RollPagerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 首页——值得买
 */
public class Index_SecondFragment extends Fragment implements View.OnClickListener {


    private ImageView mIvNew;
    private TextView mTvNew;
    private ImageView mIvHot;
    private TextView mTvHot;
    private XRecyclerView mRecycler;
    private boolean flag = true;
    private RelativeLayout mLlNew;
    private RelativeLayout mLlHot;
    private RollPagerView mVpZhidemai;
    private Retrofit retrofit;
    private List<View> viewlist;//轮播图

    private View mLine1;
    private View mLine2;
    private int page1 = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index__second, container, false);
        initView(view);
        retrofit = new Retrofit.Builder()
                .baseUrl(ZhideMaiContants.ZHIDEMAI_LUNBO_BASE)
                .client(OkHttpUtils.newOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofit.create(ZhiDeMaiapi.class)
                .getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZhiDeMai1>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZhiDeMai1 zhiDeMai1) {
                        //轮播图
                        List<ZhiDeMai1.DataBean.AdListBean> ad_list = zhiDeMai1.getData().getAd_list();
                        for (int i = 0; i < ad_list.size(); i++) {
                            View view1 = LayoutInflater.from(getContext()).inflate(R.layout.item_chaojidaogou, null, false);
                            ImageView iv = (ImageView) view1.findViewById(R.id.iv_chaojidaogou);
                            TextView tv = (TextView) view1.findViewById(R.id.tv_chaojidaogou);
                            Picasso.with(getContext()).load(ad_list.get(i).getAd_pic()).into(iv);
                            tv.setText(ad_list.get(i).getAd_name());
                            viewlist.add(view1);
                        }
                        ADtextAdapter adapter = new ADtextAdapter(viewlist);
                        mVpZhidemai.setAdapter(adapter);

                    }
                });

        retrofit = new Retrofit.Builder()
                .baseUrl(ZhideMaiContants.ZHIDEMAI_ITEM_NEW_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpUtils.newOkHttpClient())
                .build();
        retrofit.create(ZhiDeMaiapi1.class)
                .getData(page1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiDeMai2>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZhiDeMai2 zhiDeMai2) {
                        List<ZhiDeMai2.DataBean.ListBean> list = zhiDeMai2.getData().getList();
                        ZhiDeMaiAdapter adapter = new ZhiDeMaiAdapter(list, getContext());
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        mRecycler.setLayoutManager(layoutManager);
                        mRecycler.setAdapter(adapter);
                    }
                });


        return view;
    }

    private void initView(View view) {
        mIvNew = (ImageView) view.findViewById(R.id.iv_new1);
        mTvNew = (TextView) view.findViewById(R.id.tv_new1);
        mIvHot = (ImageView) view.findViewById(R.id.iv_hot1);
        mTvHot = (TextView) view.findViewById(R.id.tv_hot1);
        mRecycler = (XRecyclerView) view.findViewById(R.id.recycler);
        mLlNew = (RelativeLayout) view.findViewById(R.id.ll_new1);
        mLlNew.setOnClickListener(this);
        mLlHot = (RelativeLayout) view.findViewById(R.id.ll_hot1);
        mLlHot.setOnClickListener(this);
        mVpZhidemai = (RollPagerView) view.findViewById(R.id.vp_zhidemai);
        mVpZhidemai.setOnClickListener(this);
        mLine1 = (View) view.findViewById(R.id.line1);
        mLine1.setOnClickListener(this);
        mLine2 = (View) view.findViewById(R.id.line2);
        mLine2.setOnClickListener(this);
        viewlist = new ArrayList<>();
        mRecycler.setPullRefreshEnabled(false);
        mRecycler.setNestedScrollingEnabled(false);//滑动
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ll_new1:
                mIvNew.setImageResource(R.drawable.raider_new_on);
                mTvNew.setTextColor(getResources().getColor(R.color.colorAccent));
                mIvHot.setImageResource(R.drawable.raider_hot_off);
                mTvHot.setTextColor(getResources().getColor(R.color.colorBlack));
                mLine1.setBackgroundResource(R.color.colorAccent);
                mLine2.setBackgroundResource(Color.alpha(255));

                retrofit = new Retrofit.Builder()
                        .baseUrl(ZhideMaiContants.ZHIDEMAI_ITEM_NEW_BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(OkHttpUtils.newOkHttpClient())
                        .build();
                retrofit.create(ZhiDeMaiapi1.class)
                        .getData(page1)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ZhiDeMai2>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ZhiDeMai2 zhiDeMai2) {
                                List<ZhiDeMai2.DataBean.ListBean> list = zhiDeMai2.getData().getList();
                                ZhiDeMaiAdapter adapter = new ZhiDeMaiAdapter(list, getContext());
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                mRecycler.setLayoutManager(layoutManager);
                                mRecycler.setAdapter(adapter);
                            }
                        });
                break;
            case R.id.ll_hot1:
                mIvNew.setImageResource(R.drawable.raider_new_off);
                mTvNew.setTextColor(getResources().getColor(R.color.colorBlack));
                mIvHot.setImageResource(R.drawable.raider_hot_on);
                mTvHot.setTextColor(getResources().getColor(R.color.colorAccent));
                mLine2.setBackgroundResource(R.color.colorAccent);
                mLine1.setBackgroundResource(Color.alpha(255));

                retrofit = new Retrofit.Builder()
                        .baseUrl(ZhideMaiContants.ZHIDEMAI_ITEM_HOT_BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(OkHttpUtils.newOkHttpClient())
                        .build();
                retrofit.create(ZhiDeMaiapi2.class)
                        .getData(page1)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ZhiDeMai2>() {


                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ZhiDeMai2 zhiDeMai2) {
                                List<ZhiDeMai2.DataBean.ListBean> list = zhiDeMai2.getData().getList();
                                ZhiDeMaiAdapter adapter = new ZhiDeMaiAdapter(list, getContext());
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                mRecycler.setLayoutManager(layoutManager);
                                mRecycler.setAdapter(adapter);
                            }
                        });
                break;
        }
    }
}
