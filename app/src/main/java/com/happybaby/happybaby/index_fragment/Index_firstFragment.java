package com.happybaby.happybaby.index_fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.WebviewActivity;
import com.happybaby.happybaby.adapter.ADtextAdapter;
import com.happybaby.happybaby.adapter.AdapterShouYeRecyclerview;
import com.happybaby.happybaby.contant.IndexUrlContants;
import com.happybaby.happybaby.util.OkHttpUtils;
import com.happybaby.happybaby.viewpagerwidget.FlowIndicator;
import com.jude.rollviewpager.RollPagerView;
import com.paradoxie.autoscrolltextview.VerticalTextview;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 首页 推荐页面
 */
public class Index_firstFragment extends Fragment {


    private FlowIndicator mFlowindicator;//小圆点实例
    private ViewPager mVpAds;//轮播图
    private List<View> mIvList;//轮播图的集合
    private RecyclerView mRecyclerview;
    private ImageView mIvHot;
    private VerticalTextview mTvAutoscrolltextview;
    private ImageView mIvItem1;//功能入口模块
    private ImageView mIvItem2;//功能入口模块
    private ImageView mIvItem3;//功能入口模块
    private ImageView mIvItem4;//功能入口模块
    private ImageView mIvItem5;//功能入口模块

    private RelativeLayout mRlMiaosha1;//秒杀
    private LinearLayout mLlMiaosha2;
    private View item2;
    private View item3;

    private LinearLayout mLlItemBtn;
    private RollPagerView mVpChaojidaogou;//超级导购
    private ImageView mIvGoodthings;//好物推荐图片
    private TextView mTvGoodthingsTitle;//好物推荐标题
    private TextView mTvGoodthingsText;//好物推荐文本
    private ImageView mIvGoodthingsTouxiang;//好物推荐用户头像
    private TextView mTvGoodthingsName;//好物推荐用户名
    private TextView mTvDay;//好物推荐日期
    private TextView mTvYear;//好物推荐日期



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 解析布局
        View view = inflater.inflate(R.layout.fragment_index_first, container, false);
        initView(view);

        //重写轮播图，分开解析数据
        initHttp();
//        handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//
//
//            }
//        };

        return view;
    }

    //加载数据
    private void initHttp() {
        OkHttpUtils okHttpUtils = OkHttpUtils.newInstance();//获取OkHttpUtils的单例
        okHttpUtils.doAsyncGETRequest(IndexUrlContants.INDEX_BASE_RECOMMEND, new Callback() {//开启异步GET请求
            @Override
            public void onFailure(Call call, IOException e) {       //失败
//                Looper.prepare();
//                Toast.makeText(getContext(), "下载数据失败", Toast.LENGTH_SHORT).show();
//                Looper.loop();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {//成功
                String string = response.body().string();//返回json
                if (!TextUtils.isEmpty(string)) {

//                    Message msg = handler.obtainMessage();
//                    msg.obj = string;
                    try {


                        JSONObject jsonObject = new JSONObject(string);
                        JSONArray dataArray = jsonObject.getJSONArray("data");

                        //解析data0轮播图
                        initData0(dataArray);
                        //解析hot的轮播公告
                        initData1(dataArray);
                        //解析data2功能入口模块
                        initData2(dataArray);
                        //解析data4秒杀专场
                        initData4(dataArray);
                        //解析data7超级导购
                        initData7(dataArray);
                        //解析data8超级导购
                        initData8(dataArray);
                        //解析data10专场列表
                        initData10(dataArray);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                //String result = (String) msg.obj;


            }
        });

    }

    private void initData10(JSONArray dataArray) throws Exception {
        final JSONObject data10 = dataArray.getJSONObject(10);//取到data7
        final JSONObject indata10 = data10.getJSONObject("data");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final JSONArray list10 = indata10.getJSONArray("list");
                    //创建适配器
                    AdapterShouYeRecyclerview adapter = new AdapterShouYeRecyclerview(list10, getContext());
                    //设置适配器
                    mRecyclerview.setAdapter(adapter);
                    //设置布局方向
                    mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    mRecyclerview.setNestedScrollingEnabled(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    private void initData8(JSONArray dataArray) throws Exception {
        final JSONObject data8 = dataArray.getJSONObject(8);//取到data7
        final JSONObject indata8 = data8.getJSONObject("data");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final JSONArray list8 = indata8.getJSONArray("list");
                    //取到日期
                    String day = list8.getJSONObject(0).getString("day");
                    String ym = list8.getJSONObject(0).getString("ym");
                    mTvDay.setText(day);
                    mTvYear.setText(ym);

                    //取到图片
                    Glide.with(getContext()).load(list8.getJSONObject(0).getString("phone_head_pic")).into(mIvGoodthings);
                    //取到标题 文本
                    String title = list8.getJSONObject(0).getString("title");
                    String introduction = list8.getJSONObject(0).getString("introduction");
                    mTvGoodthingsTitle.setText(title);
                    mTvGoodthingsText.setText(introduction);

                    //取到头像，名字
                    String nick_name = list8.getJSONObject(0).getString("nick_name");
                    mTvGoodthingsName.setText(nick_name);
                    Glide.with(getContext()).load(list8.getJSONObject(0).getString("avatar")).into(mIvGoodthingsTouxiang);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initData7(JSONArray dataArray) throws Exception {
        final JSONObject data7 = dataArray.getJSONObject(7);//取到data7
        final JSONObject indata7 = data7.getJSONObject("data");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final JSONArray list7 = indata7.getJSONArray("list");
                    //加载图片到每个Imageview上去
                    List<View> imgs = new ArrayList<View>();

                    for (int i = 0; i < list7.length(); i++) {
                        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_chaojidaogou, null, false);
                        String videoPic = list7.getJSONObject(i).getString("videoPic");
                        String videoTitle = list7.getJSONObject(i).getString("videoTitle");
                        ImageView iv = (ImageView) view.findViewById(R.id.iv_chaojidaogou);
                        TextView tv = (TextView) view.findViewById(R.id.tv_chaojidaogou);
                        Glide.with(getContext()).load(videoPic).into(iv);
                        tv.setText(videoTitle);
                        imgs.add(view);
                    }
                    ADtextAdapter adapter = new ADtextAdapter(imgs);
                    mVpChaojidaogou.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void initData4(JSONArray dataArray) throws Exception {
        final JSONObject data4 = dataArray.getJSONObject(4);//取到data3
        final JSONObject indata4 = data4.getJSONObject("data");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final JSONArray list4 = indata4.getJSONArray("list");
                    View item1 = LayoutInflater.from(getContext()).inflate(R.layout.item_index_black_text, null, false);

                    //图片
                    String ad_pic = list4.getJSONObject(2).getString("ad_pic");
                    ImageView iv_back1 = (ImageView) item1.findViewById(R.id.iv_back);
                    iv_back1.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(getContext()).load(ad_pic).into(iv_back1);
                    //标题
                    String ad_word = list4.getJSONObject(2).getString("ad_word");
                    TextView tv_bigtitle = (TextView) item1.findViewById(R.id.tv_bigtitle);
                    tv_bigtitle.setText(ad_word);
                    //标题
                    String ad_introduction = list4.getJSONObject(2).getString("ad_introduction");
                    TextView tv_smalltitle = (TextView) item1.findViewById(R.id.tv_smalltitle);
                    tv_smalltitle.setText(ad_introduction);
                    mRlMiaosha1.addView(item1);

//                    View item2 = LayoutInflater.from(getContext()).inflate(R.layout.item_index_black_text, mGridLayout, false);

                    //图片
                    String ad_pic2 = list4.getJSONObject(1).getString("ad_pic");
                    ImageView iv_back2 = (ImageView) item2.findViewById(R.id.iv_back);

                    Glide.with(getContext()).load(ad_pic2).into(iv_back2);
                    //标题
                    String ad_word2 = list4.getJSONObject(1).getString("ad_word");
                    TextView tv_bigtitle2 = (TextView) item2.findViewById(R.id.tv_bigtitle);
                    tv_bigtitle2.setText(ad_word2);
//                        mLlMiaosha2.addView(item2);

//                    View item3 = LayoutInflater.from(getContext()).inflate(R.layout.item_index_black_text, mGridLayout, false);
                    //图片
                    String ad_pic3 = list4.getJSONObject(3).getString("ad_pic");
                    ImageView iv_back3 = (ImageView) item3.findViewById(R.id.iv_back);

                    Glide.with(getContext()).load(ad_pic3).into(iv_back3);
                    //标题
                    String ad_word3 = list4.getJSONObject(3).getString("ad_word");
                    TextView tv_bigtitle3 = (TextView) item3.findViewById(R.id.tv_bigtitle);
                    tv_bigtitle3.setText(ad_word3);
                    //标题
                    String ad_introduction3 = list4.getJSONObject(3).getString("ad_introduction");
                    TextView tv_smalltitle3 = (TextView) item3.findViewById(R.id.tv_smalltitle);
                    tv_smalltitle3.setText(ad_introduction3);
//                        mLlMiaosha2.addView(item3);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    //解析data2功能入口模块
    private void initData2(JSONArray dataArray) throws Exception {
        final JSONObject data2 = dataArray.getJSONObject(2);//取到data2
        final JSONObject indata2 = data2.getJSONObject("data");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    final JSONArray list2 = indata2.getJSONArray("list");
                    //加载图片到每个Imageview上去
                    String pic1 = list2.getJSONObject(0).getString("pic");
                    Glide.with(getContext()).load(pic1).into(mIvItem1);
                    String pic2 = list2.getJSONObject(1).getString("pic");
                    Glide.with(getContext()).load(pic2).into(mIvItem2);
                    String pic3 = list2.getJSONObject(2).getString("pic");
                    Glide.with(getContext()).load(pic3).into(mIvItem3);
                    String pic4 = list2.getJSONObject(3).getString("pic");
                    Glide.with(getContext()).load(pic4).into(mIvItem4);
                    String pic5 = list2.getJSONObject(4).getString("pic");
                    Glide.with(getContext()).load(pic5).into(mIvItem5);
//                    for(int i= 0 ; i<list2.length(); i ++){
//                        ImageView iv=  new ImageView(getContext());
//                        String pic1 = list2.getJSONObject(i).getString("pic");
//                        Glide.with(getContext()).load(pic1).into(iv);
//                        mLlItemBtn.addView(iv);
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //解析hot的轮播公告
    private void initData1(JSONArray dataArray) throws Exception {
        final JSONObject data1 = dataArray.getJSONObject(1);
        final JSONObject indata1 = data1.getJSONObject("data");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                String module_icon = null;
                try {
                    module_icon = data1.getString("module_icon");
                    Log.e("data", "module_icon+++++++++++++" + module_icon);
                    Glide.with(getContext()).load(module_icon).into(mIvHot);//hot图标
                    final JSONArray list1 = indata1.getJSONArray("list");
                    ArrayList<String> titleList = new ArrayList<>();
                    for (int i = 0; i < list1.length(); i++) {
                        String ad_introduction = list1.getJSONObject(i).getString("ad_introduction");
                        titleList.add(ad_introduction);
                    }

                    mTvAutoscrolltextview.setTextList(titleList);//加入显示内容,集合类型
                    mTvAutoscrolltextview.setText(13, 5, Color.BLACK);//设置属性,具体跟踪源码
                    mTvAutoscrolltextview.setTextStillTime(3000);//设置停留时长间隔
                    mTvAutoscrolltextview.setAnimTime(300);//设置进入和退出的时间间隔
                    mTvAutoscrolltextview.startAutoScroll();
                    //对单条文字的点击监听
                    mTvAutoscrolltextview.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            try {
                                String h5_link_android = list1.getJSONObject(position).getString("h5_link_android");
                                Intent intent = new Intent(getContext(), WebviewActivity.class);
                                intent.putExtra("URL", h5_link_android);
                                startActivity(intent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    //解析data0轮播图
    private void initData0(JSONArray dataArray) throws Exception {
        JSONObject data0 = dataArray.getJSONObject(0);
        JSONObject indata = data0.getJSONObject("data");
        final JSONArray list = indata.getJSONArray("list");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.length(); i++) {
                    String ad_pic = null;
                    try {
                        //设置小圆点的个数和初始位置
                        mFlowindicator.setSeletion(0);
                        mFlowindicator.setCount(list.length());
                        ad_pic = list.getJSONObject(i).getString("ad_pic");

                        if (!TextUtils.isEmpty(ad_pic)) {
                            //加载轮播图
                            View textView = LayoutInflater.from(getContext()).inflate(R.layout.item_index_text, null, false);
                            ImageView iv_back = (ImageView) textView.findViewById(R.id.iv_back);//背景
                            Glide.with(getContext()).load(ad_pic).into(iv_back);

                            TextView tv_bigtitle = (TextView) textView.findViewById(R.id.tv_bigtitle);//大标题
                            TextView tv_smalltitle = (TextView) textView.findViewById(R.id.tv_smalltitle);//小标题

                            //解析轮播图内文字
                            tv_bigtitle.setText(list.getJSONObject(i).getString("ad_name"));
                            tv_smalltitle.setText(list.getJSONObject(i).getString("ad_introduction"));

                            mIvList.add(textView);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                //放入适配器
                ADtextAdapter adapter = new ADtextAdapter(mIvList);
                adapter.notifyDataSetChanged();
                mVpAds.setAdapter(adapter);
                mVpAds.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        mFlowindicator.setSeletion(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });

            }

        });

    }

    private void initView(View view) {
        mFlowindicator = (FlowIndicator) view.findViewById(R.id.flowindicator);
        mVpAds = (ViewPager) view.findViewById(R.id.vp_ads);
        mIvList = new ArrayList<>();
        mRecyclerview = (RecyclerView) view.findViewById(R.id.recyclerview_shouye);
        //设置小圆点的初始个数和初始位置
        mFlowindicator.setSeletion(0);
        mFlowindicator.setCount(3);
        mIvHot = (ImageView) view.findViewById(R.id.iv_hot);
        mTvAutoscrolltextview = (VerticalTextview) view.findViewById(R.id.tv_autoscrolltextview);
        //实例签到，热销，Apple特惠，上新，摇奖按钮
        mIvItem1 = (ImageView) view.findViewById(R.id.iv_item1);
//        mIvItem1.setOnClickListener(this);
        mIvItem2 = (ImageView) view.findViewById(R.id.iv_item2);
//        mIvItem2.setOnClickListener(this);
        mIvItem3 = (ImageView) view.findViewById(R.id.iv_item3);
//        mIvItem3.setOnClickListener(this);
        mIvItem4 = (ImageView) view.findViewById(R.id.iv_item4);
//        mIvItem4.setOnClickListener(this);
        mIvItem5 = (ImageView) view.findViewById(R.id.iv_item5);
//        mIvItem5.setOnClickListener(this);
        mLlItemBtn = (LinearLayout) view.findViewById(R.id.ll_item_btn);
        mRlMiaosha1 = (RelativeLayout) view.findViewById(R.id.rl_miaosha1);

        mLlMiaosha2 = (LinearLayout) view.findViewById(R.id.ll_miaosha2);
        item2 = view.findViewById(R.id.include1);
        item3 = view.findViewById(R.id.include2);

        //超级导购
        mVpChaojidaogou = (RollPagerView) view.findViewById(R.id.vp_chaojidaogou);

        mIvGoodthings = (ImageView) view.findViewById(R.id.iv_goodthings);

        mTvGoodthingsTitle = (TextView) view.findViewById(R.id.tv_goodthings_title);

        mTvGoodthingsText = (TextView) view.findViewById(R.id.tv_goodthings_text);

        mIvGoodthingsTouxiang = (ImageView) view.findViewById(R.id.iv_goodthings_touxiang);

        mTvGoodthingsName = (TextView) view.findViewById(R.id.tv_goodthings_name);

        mTvDay = (TextView) view.findViewById(R.id.tv_day);

        mTvYear = (TextView) view.findViewById(R.id.tv_year);

    }


}

