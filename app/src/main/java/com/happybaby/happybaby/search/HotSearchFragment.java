package com.happybaby.happybaby.search;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.contant.IndexUrlContants;
import com.happybaby.happybaby.util.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotSearchFragment extends Fragment {

    private RecyclerView mRvData;
    private ListView mLvData;
    private HotSearchAdapter mHotAdapter;
    private Button deleteBtn;

    private List<HotSearchBean.DataBean.HotWordsBean> hotWords;
    private HotSearchService mSearchService;
    private Context mContext;
    private OnItemContentListener mOnItemContentListener;
    private ArrayAdapter<String> arrayAdapter;
    private List<MyData> all;
    private List<String> mList;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
        mOnItemContentListener= (OnItemContentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_hot_search, container, false);
        initView(view);
        initHot();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mList = new ArrayList<>();
        MyDataManager myDataManager=new MyDataManager(mContext);
        try {
            all = myDataManager.getAll();
            for (MyData data: all){
                mList.add(data.getName());
            }
            arrayAdapter=new ArrayAdapter<String>(mContext,android.R.layout.simple_list_item_1, mList);
            mLvData.setAdapter(arrayAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initHot() {
        mSearchService= OkHttpClientUtils.getRetrofit(mContext, IndexUrlContants.HOT_SEARCH_URL)
                .create(HotSearchService.class);
        mSearchService.getHotSearchEntityCall()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotSearchBean>() {



                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HotSearchBean hotSearchBean) {
                        //流布局
                        hotWords = hotSearchBean.getData().getHotWords();
                        mHotAdapter=new HotSearchAdapter(mContext,hotWords);
                        mRvData.setLayoutManager(new GridLayoutManager(getContext(),4, LinearLayoutManager.VERTICAL,false));
                        mRvData.setAdapter(mHotAdapter);
//                        initClick(hotSearchBean);
                    }
                });
    }


//    private void initClick( HotSearchBean hotSearchBean) {
//        mHotAdapter.setTouchHotSearchListner(new TouchHotSearchListner() {
//            @Override
//            public void OnTouch(String text) {
//                final Bundle bundle = new Bundle();
//                bundle.putString("SEARCH",text);
//                setArguments(bundle);
//            }
//        });
//
//    }

    private void initView(View view) {
        mRvData = (RecyclerView) view.findViewById(R.id.rv_data);
        mLvData = (ListView) view.findViewById(R.id.lv_data);
        hotWords= new ArrayList<>();
        deleteBtn= (Button) view.findViewById(R.id.delete_btns);
        deleteBtn.setOnClickListener(new View.OnClickListener() { //清空历史记录
            @Override
            public void onClick(View view) {
                MyDataManager myDataManager=new MyDataManager(mContext);
                myDataManager.deleteAll();
                mList.removeAll(mList);
                arrayAdapter=new ArrayAdapter<String>(mContext,android.R.layout.simple_list_item_1,mList);
                mLvData.setAdapter(arrayAdapter);
                mHotAdapter.notifyDataSetChanged();

            }
        });

    }


}
