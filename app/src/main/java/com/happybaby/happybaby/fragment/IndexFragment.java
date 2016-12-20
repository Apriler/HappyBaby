package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.ContentAdapter;
import com.happybaby.happybaby.bean.TablayoutTitle;
import com.happybaby.happybaby.contant.IndexUrlContants;
import com.happybaby.happybaby.index_fragment.Index_firstFragment;
import com.happybaby.happybaby.util.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * 首页
 */
public class IndexFragment extends Fragment {

    private ImageView mImgTitleHomepage;
    private View mViewHomepage;
    private TabLayout mTablayout;
    private ViewPager mVpFrag;
    private List<String> Strlist;//标题的集合
    List<Fragment> fraglist;//fragment的集合
    private ContentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //解析布局
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        initView(view);
        initHttp();

        Log.e("Tag", "-------------------------->");

        return view;
    }


    //加载数据
    private void initHttp() {
        OkHttpUtils okHttpUtils = OkHttpUtils.newInstance();//获取OkHttpUtils的单例
        okHttpUtils.doAsyncGETRequest(IndexUrlContants.INDEX_BASE_TITLE, new Callback() {//开启异步GET请求
            @Override
            public void onFailure(Call call, IOException e) {       //失败
//                Looper.prepare();
//                Toast.makeText(getContext(), "下载数据失败", Toast.LENGTH_SHORT).show();
//                Looper.loop();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {//成功

                Log.e("Tag", "!!!!!!!!!!!!!!!!!!!!!!!!!!");

                String string = response.body().string();//返回json
                if (!TextUtils.isEmpty(string)) {
                    Gson gson = new Gson();
                    final TablayoutTitle title = gson.fromJson(string, TablayoutTitle.class);//获取到title的实例
                    //添加标题数据放入集合
                    for (int i = 0; i < title.getData().size(); i++) {
                        String tab_name = title.getData().get(i).getTab_name();
                        Strlist.add(tab_name);
                        Index_firstFragment first = new Index_firstFragment();
                        //放入fragment的集合中
                        fraglist.add(first);
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter = new ContentAdapter(getChildFragmentManager(), fraglist, Strlist);
                            Log.e("Tag", "2222222222222222222222222");
                            //创建适配器实例
                            mVpFrag.setAdapter(adapter);
                            mVpFrag.setOffscreenPageLimit(title.getData().size());
                        }
                    });
                }
            }
        });
    }

    private void initView(View view) {
        mImgTitleHomepage = (ImageView) view.findViewById(R.id.img_title_homepage);
        mViewHomepage = (View) view.findViewById(R.id.view_homepage);
        mTablayout = (TabLayout) view.findViewById(R.id.tablayout);
        mVpFrag = (ViewPager) view.findViewById(R.id.vp_frag);
        Strlist = new ArrayList<>();
        fraglist = new ArrayList<>();
        mTablayout.setupWithViewPager(mVpFrag);
    }

}
