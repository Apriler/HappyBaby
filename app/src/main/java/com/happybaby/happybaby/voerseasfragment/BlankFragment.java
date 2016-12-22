package com.happybaby.happybaby.voerseasfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.CategoryAdapter;
import com.happybaby.happybaby.adapter.GoodsAdapter;
import com.happybaby.happybaby.adapter.HotEventAdapter;
import com.happybaby.happybaby.adapter.HotShowAdapter;
import com.happybaby.happybaby.adapter.MayLikeAdapter;
import com.happybaby.happybaby.adapter.ViewAdapter;
import com.happybaby.happybaby.base.BaseFragment;
import com.happybaby.happybaby.bean.MyLike;
import com.happybaby.happybaby.bean.OverseasCountry;
import com.happybaby.happybaby.constant.MyConstant;
import com.happybaby.happybaby.constant.OverseasConstant;
import com.happybaby.happybaby.util.OkHttpUtils;
import com.happybaby.happybaby.viewpagerwidget.CustomScrollView;
import com.happybaby.happybaby.viewpagerwidget.MyItemDecoration;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {


    private RollPagerView mLunboVp;
    private LinearLayout mGoodsMore, mCategoryMoreLl, mHotEventMore, mHotShowMore, mMayLikeMore, mHotRecommendedMore;
    private ImageView mGoodsImg, mCategoryImg, mHotEventImg, mHotShowImg, mMayLikeImg, mHotRecommendedImg;
    //     测试
    // private ListView mGoodslv;//好物推荐列表
    //  好物适配器
    // private AdListView goodAdapter;
    private CustomScrollView mCustomScrollView;

    private List<String> dates;
    //    布局集合
    private List<View> views;
    //轮播适配器
    private ViewAdapter Lunadapter;

    private RecyclerView mCategoryRecycler, mHotEventRv, mHotShowRv, mMayLikeRv, mGoodsRv;


    //图片数据源
    private List<OverseasCountry.DataBeen.AdListBean.DataBean.ListBean> adListDates;

    //好物数据源
    private List<OverseasCountry.DataBeen.GoodsThingsBean.DataBeanX.ListBeanX> dataBeanXList;

    private GoodsAdapter goodsAdapter;

    //分类精选数据源
    private List<OverseasCountry.DataBeen.CategoryListBean.DataBeanXX.ListBeanXX> dateCategoryList;

    private CategoryAdapter categoryAdapter;

    //热门推荐数据源
    private List<OverseasCountry.DataBeen.HotEventListBean.DataBeanXXXX.ListBeanXXXX> dateHotEventList;

    private HotEventAdapter hotEventAdapter;
    //最热晒图数据源
    private List<OverseasCountry.DataBeen.HotShowListBean.DataBeanXXXXX.ListBeanXXXXX> dateHotShowList;

    private HotShowAdapter hotShowAdapter;

    //    猜你喜欢数据源
    private List<MyLike.DataBean.ListBean> dateMayLikeList, newList;
    private MayLikeAdapter mayLikeAdapter;
    private MyLike myLike;


    private OverseasCountry country;

    private LinearLayout loadMoreLayout;
    private int likePage = 1;
    private int count;
    private String countryUrl;
    private String mayLikeUrl;


//----------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        initView(view);
        initDate();
        mayLikeShow();

        return view;
    }

    private void mayLikeShow() {


        mayLikeUrl = String.format(OverseasConstant.MAYLIKE_URL, count, likePage);

        //        第二段Url

        OkHttpUtils.doAsyncGETRequest(mayLikeUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null) {
                    final String result2 = response.body().string();

                    Gson gson = new Gson();
                    myLike = gson.fromJson(result2, MyLike.class);
                    dateMayLikeList = myLike.getData().getList();
                    Log.e("Tag", "size ====================================== " + dateMayLikeList.size());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initMyLikeData();
                        }
                    });
                }
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void initDate() {
        adListDates = new ArrayList<>();
        dataBeanXList = new ArrayList<>();
        dateCategoryList = new ArrayList<>();
        dateHotEventList = new ArrayList<>();
        dateHotShowList = new ArrayList<>();
        dateMayLikeList = new ArrayList<>();
        Bundle bundle = getArguments();
        count = bundle.getInt(MyConstant.COUNTRY_KEY);
        countryUrl = String.format(OverseasConstant.COUNTRY_URL, count);


        // Log.e("NEWURL", "countryUrl====---------========-----========" + countryUrl);

//        第一段Url
        OkHttpUtils.doAsyncGETRequest(countryUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//成功
                if (response != null) {
                    Log.e("Tag", "Thread = " + Thread.currentThread().getName());

                    final String result = response.body().string();
                    Gson gson = new Gson();
                    country = gson.fromJson(result, OverseasCountry.class);
                    //轮播图集合
                    adListDates = country.getData().getAd_list().getData().getList();
                    Log.e("wuwuwu", "adListDatesSize" + adListDates.size());
//                    好物推荐集合
                    dataBeanXList = country.getData().getGoods_things().getData().getList();
//                    分类精选
                    dateCategoryList = country.getData().getCategory_list().getData().getList();
//                    热门活动
                    dateHotEventList = country.getData().getHot_event_list().getData().getList();

//                    最热晒图
                    dateHotShowList = country.getData().getHot_show_list().getData().getList();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initLunbo();
                            initGoods();
                            initCategory();
                            initHotRecommended();
                            initHotEvent();
                            initHotShow();
                            initMayLike();
                        }
                    });
                }

            }
        });


    }

    //==================================================
    private void initView(View view) {

        mCustomScrollView = (CustomScrollView) view.findViewById(R.id.refresh_sv);
        mLunboVp = (RollPagerView) view.findViewById(R.id.lunbo_vp);

        mGoodsRv = (RecyclerView) view.findViewById(R.id.goods_rv);
        // mTJlv.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dates));
        mGoodsMore = (LinearLayout) view.findViewById(R.id.goods_more_ll);
        mGoodsImg = (ImageView) view.findViewById(R.id.goods_img);

//----------------------------实例化推荐控件------
        mCategoryImg = (ImageView) view.findViewById(R.id.category_img);


        mCategoryMoreLl = (LinearLayout) view.findViewById(R.id.category_more_ll);

        mCategoryRecycler = (RecyclerView) view.findViewById(R.id.category_recycler);

//        -----------------------实例化热门推荐------------------------------------
        mHotRecommendedImg = (ImageView) view.findViewById(R.id.hot_recommended_img);
        mHotRecommendedMore = (LinearLayout) view.findViewById(R.id.hot_recommended_more_ll);

        //--------------------------------实例化热门活动控件-------
        mHotEventRv = (RecyclerView) view.findViewById(R.id.hot_event_rv);
        mHotEventMore = (LinearLayout) view.findViewById(R.id.hot_event_more_ll);
        mHotEventImg = (ImageView) view.findViewById(R.id.hot_event_img);
//       --------------- 最热晒图控件实例化---------------------
        mHotShowMore = (LinearLayout) view.findViewById(R.id.hot_show_more_ll);
        mHotShowImg = (ImageView) view.findViewById(R.id.hot_show_img);
        mHotShowRv = (RecyclerView) view.findViewById(R.id.hot_show_rv);

//        ---------------猜你喜欢控件实例化-------------------
        mMayLikeMore = (LinearLayout) view.findViewById(R.id.may_like_more_ll);
        mMayLikeImg = (ImageView) view.findViewById(R.id.may_like_img);
        mMayLikeRv = (RecyclerView) view.findViewById(R.id.may_like_rv);
//底部加载更多
        loadMoreLayout = (LinearLayout) view.findViewById(R.id.loadMore_layout);
        mCustomScrollView.setScanScrollChangedListener(new CustomScrollView.ISmartScrollChangedListener() {
            @Override
            public void onScrolledToBottom() {
//如果加载更多不可见，设置成可见
                if (loadMoreLayout.getVisibility() == View.GONE) {
                    loadMoreLayout.setVisibility(View.VISIBLE);
                    //开启异步加载数据
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            newLikeData();

                        }
                    }).start();
                }

            }

            @Override
            public void onScrolledToTop() {


            }

            @Override
            public void onScrolled() {

            }
        });
    }

    //    ====================猜你喜欢========================
    private void initMayLike() {
        Glide.with(getContext()).load(country.getData().getGuess_like().getModule_icon()).into(mMayLikeImg);
        if (country.getData().getGuess_like().getMore().isIs_show()) {
            mMayLikeMore.setVisibility(View.VISIBLE);

        } else {
            mMayLikeMore.setVisibility(View.GONE);
        }
    }

    private void initMyLikeData() {


        mayLikeAdapter = new MayLikeAdapter(dateMayLikeList, getContext());
        mMayLikeRv.setAdapter(mayLikeAdapter);
        mMayLikeRv.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));

        mayLikeAdapter.setOnItemClickListener(new MayLikeAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View itemView, int position) {

                showToast("猜你喜欢" + position);

            }
        });

    }

    private void newLikeData() {
        likePage++;
        mayLikeUrl = String.format(OverseasConstant.MAYLIKE_URL, count, likePage);

        OkHttpUtils.doAsyncGETRequest(mayLikeUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null) {
                    final String result2 = response.body().string();

                    Gson gson = new Gson();
                    myLike = gson.fromJson(result2, MyLike.class);
                    newList = myLike.getData().getList();
                    dateMayLikeList.addAll(newList);

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //取消加载更多布局
                            loadMoreLayout.setVisibility(View.GONE);
                            //加载更多数据

                            mayLikeAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });


    }

    //==================最热晒图===============
    private void initHotShow() {
        Glide.with(getContext()).load(country.getData().getHot_show_list().getModule_icon()).into(mHotShowImg);
        if (country.getData().getHot_show_list().getMore().isIs_show()) {
            mHotShowMore.setVisibility(View.VISIBLE);
            mHotShowMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    showToast("最热晒图");

                }
            });
        } else {
            mHotShowMore.setVisibility(View.GONE);
        }

        hotShowAdapter = new HotShowAdapter(dateHotShowList, getContext());

        mHotShowRv.setAdapter(hotShowAdapter);
        hotShowAdapter.setOnItemClickListener(new HotShowAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View itemView, int position) {

                showToast("最热晒图" + position);

            }
        });
        mHotShowRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false));

    }
//==============================热门活动=======================

    private void initHotEvent() {
        Glide.with(getContext()).load(country.getData().getHot_event_list().getModule_icon()).into(mHotEventImg);
        if (country.getData().getHot_event_list().getMore().isIs_show()) {
            mHotEventMore.setVisibility(View.VISIBLE);

        } else {
            mHotEventMore.setVisibility(View.GONE);
        }
        hotEventAdapter = new HotEventAdapter(dateHotEventList, getContext());
        mHotEventRv.setAdapter(hotEventAdapter);
        hotEventAdapter.setOnItemClickListener(new HotEventAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View itemView, int position) {
                showToast("活动" + position);
            }
        });
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        mHotEventRv.setLayoutManager(layoutManager);


    }
//===============================热门推荐======================

    private void initHotRecommended() {

        Glide.with(getContext()).load(country.getData().getHot_recommend().getModule_icon()).into(mHotRecommendedImg);
        if (country.getData().getHot_recommend().getMore().isIs_show()) {
            mHotRecommendedMore.setVisibility(View.VISIBLE);

        } else {
            mHotRecommendedMore.setVisibility(View.GONE);
        }

    }


    //-----------------------------------------------------------------
    private void initLunbo() {
        views = new ArrayList<>();
        for (int i = 0; i < adListDates.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.lunbo_layout, null);
            ImageView img = (ImageView) view.findViewById(R.id.lunbo_img);
            TextView tile = (TextView) view.findViewById(R.id.ad_word);
            TextView introduction = (TextView) view.findViewById(R.id.ad_ad_introduction);
            Glide.with(getContext()).load(adListDates.get(i).getAd_pic()).into(img);
            tile.setText(adListDates.get(i).getAd_name());
            introduction.setText(adListDates.get(i).getAd_introduction());
            views.add(view);
        }
        Lunadapter = new ViewAdapter(views);
        Log.e("sasa", "asa:" + views.size());
        mLunboVp.setAdapter(Lunadapter);
        mLunboVp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                showToast("轮播");

            }
        });

    }


    //加载好物数据
    private void initGoods() {
        Glide.with(getContext()).load(country.getData().getGoods_things().getModule_icon()).into(mGoodsImg);
        if (country.getData().getGoods_things().getMore().isIs_show()) {
            mGoodsMore.setVisibility(View.VISIBLE);
            mGoodsMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    showToast("好物更多");

                }
            });
        } else {
            mGoodsMore.setVisibility(View.GONE);
        }
        goodsAdapter = new GoodsAdapter(dataBeanXList, getContext());
        mGoodsRv.setAdapter(goodsAdapter);
        goodsAdapter.setOnItemClickListener(new GoodsAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View itemView, int position) {
                showToast("好物" + position);

            }
        });
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        mGoodsRv.setLayoutManager(layoutManager);
//        -----------------------ListView实现----------------------------
//        goodAdapter = new AdListView(dataBeanXList, getContext());
//        mGoodslv.setAdapter(goodAdapter);
////        动态设置高度
//        setListViewHeightBasedOnChildren(mGoodslv);
//        mGoodslv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                showToast("" + i);
//
//            }
//        });


    }

    //==================加载分类精选==================
    private void initCategory() {
        Glide.with(getContext()).load(country.getData().getCategory_list().getModule_icon()).into(mCategoryImg);
        if (country.getData().getCategory_list().getMore().isIs_show()) {
            mCategoryMoreLl.setVisibility(View.VISIBLE);

        } else {
            mCategoryMoreLl.setVisibility(View.GONE);
        }

        categoryAdapter = new CategoryAdapter(dateCategoryList, getContext());

        mCategoryRecycler.setAdapter(categoryAdapter);

        categoryAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View itemView, int position) {

                showToast("精选" + position);

            }
        });
        mCategoryRecycler.addItemDecoration(new MyItemDecoration());
        mCategoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        //mCategoryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//    动态生成 子布局 图片
//        for (int i = 0; i < dateCategoryList.size(); i++) {
//
//            ImageView imageView = new ImageView(getContext());
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mCategoryRecycler.getWidth() / 3, 150);
//            //params.setMargins(5,5,5,5);
//
//            imageView.setLayoutParams(params);
//
//            Picasso.with(getContext()).load(country.getData().getCategory_list().getData().getList().get(i).getCategory_pic_link()).into(imageView);
//
//           // mCategoryRecycler.addView(imageView);
//        }

    }

    /**
     * ================= 动态设置ListView的高度 ========================
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null) return;

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1) + 40);
        listView.setLayoutParams(params);
    }
}
