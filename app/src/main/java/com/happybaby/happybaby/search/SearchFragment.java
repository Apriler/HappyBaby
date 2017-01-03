package com.happybaby.happybaby.search;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.contant.IndexUrlContants;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private ListView mLvData2;
    private HotSearchService mHotService;
    private Context mContext;
    private List<String> mList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_seatch, container, false);
        initView(view);
        Bundle bundle=getArguments();
        if (bundle!=null){
            initData(bundle.getString(SearchActivity.KEY_SEARCH));
        }
        return view;
    }

    private void initData(String string) {
        mHotService=OkHttpClientUtils.getRetrofit(mContext, IndexUrlContants.SEARCH_URL)
                .create(HotSearchService.class);
        mHotService.getSearchEntityCall(string)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        initArray(searchBean);
                    }


                });

    }

    private void initArray(SearchBean searchBean) {
        List<SearchBean.DataBean.ListBean> prodlist=searchBean.getData().getList();
//        mList=new ArrayList<>();
//        for (SearchBean.DataBean.ListBean bean : prodlist) {
//            mList.add(bean.getName());
//
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, mList);


        SearchAdapter adapter= new SearchAdapter(prodlist,mContext);

        mLvData2.setAdapter(adapter);

    }

    private void initView(View view) {
        mLvData2= (ListView) view.findViewById(R.id.lv_data2);
    }

}
