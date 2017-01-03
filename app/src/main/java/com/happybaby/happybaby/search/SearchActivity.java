package com.happybaby.happybaby.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.happybaby.happybaby.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,OnItemContentListener{


    Button btnJumpPage;
    ImageView btnTitleSearchpage;
    private EditText edtMessage;
    private HotSearchAdapter hotSearchAdapter;
    public static final String KEY_SEARCH = "KEY_SEARCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        EventBus.getDefault().register(this);
        initView();
        initFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReciver(String s){
        edtMessage.setText(s);
        if (!TextUtils.isEmpty(s)){
            MyDataManager myDataManager = new MyDataManager(this);
            MyData data = new MyData();
            data.setName(s);
            try {
                myDataManager.insert(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
            initReplace(s);
        }

    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_search,new HotSearchFragment(),"HotSearchFragment")
                .commit();
    }

    //实例化控件
    private void initView() {
        btnTitleSearchpage= (ImageView) findViewById(R.id.btn_title_searchpage);
        btnJumpPage= (Button) findViewById(R.id.btn_jump_page);
        edtMessage= (EditText) findViewById(R.id.edt_message);
        btnJumpPage.setOnClickListener(this);
        btnTitleSearchpage.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_jump_page:
                String content=edtMessage.getEditableText().toString();
                if (!TextUtils.isEmpty(content)){
                    MyDataManager myDataManager = new MyDataManager(this);
                    MyData data = new MyData();
                    data.setName(content);
                    try {
                        myDataManager.insert(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    initReplace(content);
                }
                break;
            case R.id.btn_title_searchpage:
                finish();
                break;
        }

    }

    @Override
    public void getItemContent(String data) {
        if (data!=null) {
           initReplace(data);
        }
    }

    private void initReplace(String content) {

        edtMessage.setText(content);
        SearchFragment searchFragment=new SearchFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_search,searchFragment)
                .addToBackStack(null)
                .commit();
        Bundle bundle=new Bundle();
        bundle.putString(KEY_SEARCH,content);
        searchFragment.setArguments(bundle);


    }
}
