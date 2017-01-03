package com.happybaby.happybaby.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happybaby.happybaby.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;



public class HotSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private List<HotSearchBean.DataBean.HotWordsBean> mList;
	private LayoutInflater mInflater;
	private TouchHotSearchListner touchHotSearchListner;

	public void setTouchHotSearchListner(TouchHotSearchListner touchHotSearchListner) {
		this.touchHotSearchListner = touchHotSearchListner;
	}

	public HotSearchAdapter(Context mContext, List<HotSearchBean.DataBean.HotWordsBean> mList) {
		this.mList = mList;
		mInflater = LayoutInflater.from(mContext);
	}




	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mInflater.inflate(R.layout.item_hots, parent, false);
		HotViewHolder holder = new HotViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder1, int i) {
		final HotViewHolder holder = (HotViewHolder) holder1;
		holder.mTvData.setText(mList.get(i).getKey_word());
		holder.mTvData.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final String text = holder.mTvData.getText().toString();
				EventBus.getDefault().post(text);
			}
		});
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public int getItemCount() {
		return mList.size();
	}



	private  class HotViewHolder extends RecyclerView.ViewHolder{
		private View rootView;
		private TextView mTvData;

		private HotViewHolder(View rootView) {
			super(rootView);
			this.rootView = rootView;
			this.mTvData = (TextView) rootView.findViewById(R.id.tv_data);
		}

	}
}
