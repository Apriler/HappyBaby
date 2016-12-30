package com.happybaby.happybaby.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.User;
import com.happybaby.happybaby.util.BitmapUtils;


import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;


//改变用户信息
public class ChangeUserNameActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbarChange;
    private ImageView mIvChangeTouxiang;
    private TextView mTvChangeName;
    private TextView mIvChangeDiqu;
    private TextView mIvChangeQianming;
    private RelativeLayout mActivityChangeUserName;
    private RelativeLayout mRlChange1;// 切换头像
    private RelativeLayout mRlChange2;// 切换名字
    private RelativeLayout mRlChange3;// 切换地区
    private RelativeLayout mRlChange4;// 切换签名
    private PopupWindow pp;
    private TextView tv_fromgallery;//从相册取
    private TextView tv_fromnew;//拍新照片
    private TextView tv_cancel_back;//取消
    //系统拍照图片地址
    public static String file_path;
    public static final int REQUEST_CODE = 100;
    public static final int REQUEST_GALLERY_CODE = 101;
    public static final int REQUEST_CROP_CODE = 102;
    public static final int REQUEST_NAME_CODE = 103;
    public static final int REQUEST_QIANMING_CODE = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_name);
        initView();
        initData();
        inittoolbar();
        initpopupwindow();//弹出框初始化
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file_path = Environment.getExternalStorageDirectory() + File.separator + "head.jpg";
        }
    }

    private void initData() {
        User  user = User.getCurrentUser(User.class);
        if(user.getName() == null){
            mTvChangeName.setText(user.getUsername());//取到用户名
        }else {
            mTvChangeName.setText(user.getName());//取到用户名
        }
        Glide.with(ChangeUserNameActivity.this).load(user.getTouxiang()).override(50,50).into(mIvChangeTouxiang);//加载头像
        if(TextUtils.isEmpty(user.getQianming())){
            mIvChangeQianming.setText("还没有写签名噢~~");
        }else {
            mIvChangeQianming.setText(user.getQianming());
        }

    }

    private void initpopupwindow() {
        View view1 = getLayoutInflater().inflate(R.layout.popupwindow_change, null, false);

        pp = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pp.setAnimationStyle(R.style.mypopwindow_anim_style);
        pp.setBackgroundDrawable(new ColorDrawable());
        pp.setOutsideTouchable(true);
        tv_fromgallery = (TextView) view1.findViewById(R.id.tv_fromgallery);
        tv_fromgallery.setOnClickListener(this);
        tv_fromnew = (TextView) view1.findViewById(R.id.tv_fromnew);
        tv_fromnew.setOnClickListener(this);
        tv_cancel_back = (TextView) view1.findViewById(R.id.tv_cancel_back);
        tv_cancel_back.setOnClickListener(this);
        pp.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1f;
                getWindow().setAttributes(params);

            }
        });


        pp.setFocusable(true);

    }

    private void inittoolbar() {
        setSupportActionBar(mToolbarChange);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void initView() {
        mToolbarChange = (Toolbar) findViewById(R.id.toolbar_change);
        mIvChangeTouxiang = (ImageView) findViewById(R.id.iv_change_touxiang);
        mTvChangeName = (TextView) findViewById(R.id.tv_change_name);
        mIvChangeDiqu = (TextView) findViewById(R.id.iv_change_diqu);
        mIvChangeQianming = (TextView) findViewById(R.id.iv_change_qianming);
        mActivityChangeUserName = (RelativeLayout) findViewById(R.id.activity_change_user_name);
        mRlChange1 = (RelativeLayout) findViewById(R.id.rl_change1);
        mRlChange1.setOnClickListener(this);
        mRlChange2 = (RelativeLayout) findViewById(R.id.rl_change2);
        mRlChange2.setOnClickListener(this);
        mRlChange3 = (RelativeLayout) findViewById(R.id.rl_change3);
        mRlChange3.setOnClickListener(this);
        mRlChange4 = (RelativeLayout) findViewById(R.id.rl_change4);
        mRlChange4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_change1://头像
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 0.3f;
                getWindow().setAttributes(params);
                pp.showAtLocation(ChangeUserNameActivity.this.findViewById(R.id.activity_change_user_name), Gravity.BOTTOM, 0, 0);
                break;

            case R.id.rl_change2://昵称
                intent=new Intent();
                intent.setClass(ChangeUserNameActivity.this,ChangeMsgActivity.class);
                intent.putExtra("NAME",mTvChangeName.getText());
                startActivityForResult(intent,REQUEST_NAME_CODE);
                break;
//            case R.id.rl_change3://地区
//
//                break;
            case R.id.rl_change4://签名
                intent=new Intent();
                intent.setClass(ChangeUserNameActivity.this,ChangeQianmingActivity.class);
                intent.putExtra("QIANMING",mIvChangeQianming.getText());
                startActivityForResult(intent,REQUEST_QIANMING_CODE);
                break;

            case R.id.tv_fromgallery://来自图库
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_GALLERY_CODE);
                pp.dismiss();

                break;

            case R.id.tv_fromnew://来自照相机
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri uri = Uri.fromFile(new File(file_path));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, REQUEST_CODE);
                pp.dismiss();

                break;

            case R.id.tv_cancel_back://返回
                pp.dismiss();

                break;

        }
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {

            File file = new File(file_path);
            if (file.exists()) {
                Uri uri = Uri.fromFile(new File(file_path));
                gotoCrop(uri);

            }
        } else if (requestCode == REQUEST_GALLERY_CODE) {
            if (data != null) {
                Uri uri = data.getData();
                gotoCrop(uri);
            }
        } else if (requestCode == REQUEST_CROP_CODE) {
            if (data != null) {
                Bitmap bmp = data.getParcelableExtra("data");
                Bitmap bitmap = BitmapUtils.getRoundCornerBitmap(bmp, 360);//调用工具类方法设置圆角
                if (bitmap != bmp) {
                    bmp.recycle();
                }

                mIvChangeTouxiang.setImageBitmap(BitmapUtils.scaleBitmap(bitmap, 50, 50));
                BitmapUtils.saveBitmap(bitmap, file_path);
                updatatoBmob();

            }
        } else if (requestCode == REQUEST_NAME_CODE) {
            if (data != null) {
                //获取返回的用户名，设置上
                String newname = data.getStringExtra("NEWNAME");
                mTvChangeName.setText(newname);
            }
        }else if (requestCode == REQUEST_QIANMING_CODE) {
                if (data != null) {
                    //获取返回的签名，设置上
                    String newqianming = data.getStringExtra("NEWQIANMING");
                    mIvChangeQianming.setText(newqianming);
                }else {
                    mIvChangeQianming.setText("还没有写签名噢~~");
                }

            }

    }

    private void updatatoBmob() {

        final BmobFile bmobFile = new BmobFile(new File(file_path));

        bmobFile.uploadblock(new UploadFileListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    //bmobFile.getFileUrl()--返回的上传文件的完整地址
                    showToast("上传文件成功:" + bmobFile.getFileUrl());
                    User newUser = new User();
                    newUser.setTouxiang(bmobFile.getFileUrl());
                    User bmobUser = User.getCurrentUser(User.class);
                    newUser.update(bmobUser.getObjectId(), new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                showToast("更新用户信息成功");
                            } else {
                                showToast("更新用户信息失败:" + e.getMessage());
                            }
                        }
                    });
                } else {
                    showToast("上传文件失败：" + e.getMessage());
                }

            }
            @Override
            public void onProgress(Integer value) {
                // 返回的上传进度（百分比）
            }
        });
    }

    //打开图片剪切
    private void gotoCrop(Uri inputRri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(inputRri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);  //设置剪切框的比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 70);  //图片输出大小
        intent.putExtra("outputY", 70);  //图片输出大小
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, REQUEST_CROP_CODE);
    }


}
