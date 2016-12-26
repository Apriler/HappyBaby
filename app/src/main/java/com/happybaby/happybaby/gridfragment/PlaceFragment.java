package com.happybaby.happybaby.gridfragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceScreen;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.GridAdapter;
import com.happybaby.happybaby.bean.GridBean;
import com.happybaby.happybaby.bean.PlaceBean;
import com.happybaby.happybaby.contant.GridUrlContants;
import com.happybaby.happybaby.task.GridDownLoadTask;
import com.happybaby.happybaby.util.OkHttpUtils;
import com.happybaby.happybaby.viewpagerwidget.CustomScrollView;
import com.happybaby.happybaby.viewpagerwidget.MyScrollview;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PlaceFragment extends Fragment  {
    private List<ImageView> views; //轮播图集合
    private ViewPager gridVp;   //格子圈轮播图
    private LinearLayout addotLayout;  //轮播图圆点
    private List<GridBean.DataBeanX.DataBean.ListBean> list;  //轮播图网址
    private RecyclerView pullDownRv;
    private List<GridBean.DataBeanX.DataBean.ListBean> themeList;  //热门图片网址
    private LayoutInflater mInflater;  //布局解析
    private LinearLayout mIdGallery;  //热门的图片和文言布局
    private List<GridBean.DataBeanX.DataBean.ListBean> totalList;//全球达人模块
    private LinearLayout mNickGallery;  //全球达人的图片和文言布局

    private List<GridBean.DataBeanX.DataBean.ListBean> topicList;//热门话题模块
    private RecyclerView topicRv;  //热门话题RecyclerView
    private DataAdapter dataAdapter;//热门话题适配器
    private List<PlaceBean.DataBean.ListBean> placeList; //下拉列表模块
    private PlaceCommentAdapter placeCommentAdapter;  //下拉列表模块适配器
    private RecyclerView downRv;  //下拉模块RecyclerView
    private int page=1;      //设定加载第几页
    private Retrofit retrofit;  //Retrofit请求
    private PlaceService placeService;  //服务
    private List<PlaceBean.DataBean.ListBean> lists;  //数据源集合

    //底部加载更多视图
    private LinearLayout loadMoreLayout;
    //外层自定义ScrollView
    private MyScrollview mainScrollView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        mInflater=LayoutInflater.from(getContext());
        initView(rootView);
        initData();
        initRetrofit();
        initPlaceBean();
        mainScrollView.setOnScrollToBottomLintener(new MyScrollview.OnScrollToBottomListener() {
            @Override
            public void onScrollBottomListener(boolean isBottom) {
                // TODO Auto-generated method stub
                Log.e("Tag", isBottom + "--------------isBottom");
                if(isBottom){
                    initmore();
                }
            }
        });
        return rootView;
    }

    private void initmore() {

//        mainScrollView.setScanScrollChangedListener(new CustomScrollView.ISmartScrollChangedListener() {
//            @Override
//            public void onScrolledToBottom() {
//        if (loadMoreLayout.getVisibility() == View.GONE) {
//            loadMoreLayout.setVisibility(View.VISIBLE);
            placeService.getPlaceString(page)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<PlaceBean>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onNext(final PlaceBean placeBean) {
                                Log.e("Tag","current:"+Thread.currentThread());
                                loadMoreLayout.setVisibility(View.GONE);
                                //获取集合
                                Log.e("Tag", "++++++++++++++"+page);
                                List<PlaceBean.DataBean.ListBean> list = placeBean.getData().getList();
                                page++;
                                lists.addAll(list);
                                lists.notify();
                                //String s = String.format(GridUrlContants.GRID_CHAT_BASE,page);
                                placeCommentAdapter.notifyDataSetChanged();


                        }
                    });
//                    Log.e("Tag", "--------------->  onScrolledToBottom");
//                }
//            }
//
//            @Override
//            public void onScrolledToTop() {
//                Log.e("Tag", "--------------->  onScrolledToTop");
//            }
//
//            @Override
//            public void onScrolled() {
//                Log.e("Tag", "--------------->  onScrolled");
//
//            }
//        });
        }




    private void initPlaceBean() {
        placeService.getPlaceString(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PlaceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final PlaceBean placeBean) {
                        //获取集合

                        lists = placeBean.getData().getList();
                        placeCommentAdapter= new PlaceCommentAdapter(getContext(), lists);  //实例化适配器
                        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        downRv.setLayoutManager(mLinearLayoutManager);
                        downRv.setAdapter(placeCommentAdapter);
                        page++;
                    }
                });

    }

    private void initRetrofit() {
        retrofit=new Retrofit.Builder()
                .baseUrl(GridUrlContants.GRID_CHAT_BASE)  //绑定路径
                .client(OkHttpUtils.newOkHttpClient())  //OkHttpClient单例模式
                .addConverterFactory(GsonConverterFactory.create()) //Gson解析
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RXJava回调
                .build();  //创建Retrofit

        placeService = retrofit.create(PlaceService.class);
    }




    private void initData() {
        themeList = new ArrayList<>();

    }
    //创建一个线程池
    private Executor downloadExecutor;

    //初始化视图
    private void initView(View rootView) {
        mIdGallery = (LinearLayout) rootView.findViewById(R.id.id_gallery);
        mNickGallery= (LinearLayout) rootView.findViewById(R.id.nick_gallery);
        topicRv= (RecyclerView) rootView.findViewById(R.id.topic_recycler);
        gridVp = (ViewPager) rootView.findViewById(R.id.grid_vp);
        views = new ArrayList<>();  //实例化轮播图集合
        pullDownRv= (RecyclerView) rootView.findViewById(R.id.pull_down_rv); //下拉列表模块recyclerView
        downRv= (RecyclerView) rootView.findViewById(R.id.down_rv);
        //打开异步下载
        //downRv.setPullRefreshEnabled(false);
        downloadExecutor = Executors.newFixedThreadPool(10);
        GridDownLoadTask task = new GridDownLoadTask(GridUrlContants.GRID_BASE);
        task.setOnGridLoadListener(new GridDownLoadTask.OnGridLoadListener() {
            @Override
            public void downSuccess(String result) {
                //数据解析
                Gson gson = new Gson();
                GridBean gridBean = gson.fromJson(result, GridBean.class);

                //轮播图加载
                list = gridBean.getData().get(0).getData().getList();
                for (int i = 0; i < list.size(); i++) {
                    String ad_pic = list.get(i).getAd_pic();
                    ImageView view = new ImageView(getContext());
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(getContext()).load(ad_pic).into(view);
                    views.add(view);
                }
                GridAdapter gridAdapter = new GridAdapter(views);
                gridVp.setAdapter(gridAdapter);

                //热门图片模块加载
                themeList = gridBean.getData().get(1).getData().getList();
                    for (int i = 0; i < themeList.size(); i++) {
                    //获取滑动布局的viewgroup
                    View itemForScrollView = mInflater.inflate(R.layout.place_hot_view, mIdGallery, false);
                    //滑动布局的两个组件
                    ImageView mIvItem = (ImageView) itemForScrollView.findViewById(R.id.pic_iv);
                    TextView mTvItem = (TextView) itemForScrollView.findViewById(R.id.name_tv);
                    //循环添加数据
                    Picasso.with(getContext()).load(themeList.get(i).getTag_image()).into(mIvItem);
                    mTvItem.setText(themeList.get(i).getTag_name());
                    mIdGallery.addView(itemForScrollView);
                }
                //全球达人模块
                totalList = gridBean.getData().get(2).getData().getList();
                for (int i = 0; i < themeList.size(); i++) {
                    //获取滑动布局的viewgroup
                    View itemForScrollView = mInflater.inflate(R.layout.place_total_view, mNickGallery, false);
                    //滑动布局的两个组件
                    ImageView mIvItem = (ImageView) itemForScrollView.findViewById(R.id.big_avatar_iv);

                    TextView mTvItem = (TextView) itemForScrollView.findViewById(R.id.nick_name_tv);
                    //循环添加数据
                    Picasso.with(getContext()).load(totalList.get(i).getBig_avatar()).into(mIvItem);
                    mTvItem.setText(totalList.get(i).getNick_name());
                    mNickGallery.addView(itemForScrollView);

                }
                WindowManager wm1 = getActivity().getWindowManager();

                //热门话题模块
                topicList= gridBean.getData().get(3).getData().getList();
                dataAdapter=new DataAdapter(getContext(),topicList);

                topicRv.setAdapter(dataAdapter);
                topicRv.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));

            }
        });
        task.execute();
        //实例化圆点，并与轮播图片绑定
        addotLayout = (LinearLayout) rootView.findViewById(R.id.addot_layout);
        gridVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //改变圆点状态
                for (int i = 0; i < addotLayout.getChildCount(); i++) {
                    ImageView iv = (ImageView) addotLayout.getChildAt(i); //获得圆点的view
                    if (i == position) { //当前圆点被选中
                        iv.setImageResource(R.mipmap.icon_single_event_indicator_check);
                    } else {
                        iv.setImageResource(R.mipmap.icon_single_event_indicator_normal);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //底部加载更多
        loadMoreLayout = (LinearLayout) rootView.findViewById(R.id.loadMore_layout);

        //外层ScrollView
        mainScrollView = (MyScrollview)rootView.findViewById(R.id.fragment_place);


    }

    /**
     * 画圆角图片
     * @param bitmap
     * @param pixels
     * @return
     */
    private Bitmap getRoundCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

}
