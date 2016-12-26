package com.happybaby.happybaby.viewpagerwidget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 自定义ScrollView，解决嵌套ListView不能置顶
 * @author bodhixu
 *
 */
public class CustomScrollView extends ScrollView{
	
	public CustomScrollView(Context context) {
		super(context);
	}

	public CustomScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

	private ISmartScrollChangedListener mSmartScrollChangedListener;
	private boolean isScrolledToTop = true; // 初始化的时候设置一下值
	private boolean isScrolledToBottom = false;

	/** 定义监听接口 */
	public interface ISmartScrollChangedListener {
		void onScrolledToBottom();
		void onScrolledToTop();
		void onScrolled();
	}

	public void setScanScrollChangedListener(ISmartScrollChangedListener smartScrollChangedListener) {
		mSmartScrollChangedListener = smartScrollChangedListener;
	}

	@Override
	protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
		super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
		if (scrollY == 0) {
			isScrolledToTop = clampedY;
			isScrolledToBottom = false;
		} else {
			isScrolledToTop = false;
			isScrolledToBottom = clampedY;
		}
		notifyScrollChangedListeners();
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
	}

	private void notifyScrollChangedListeners() {
		if (isScrolledToTop) {
			if (mSmartScrollChangedListener != null) {
				mSmartScrollChangedListener.onScrolledToTop();
			}
		} else if (isScrolledToBottom) {
			if (mSmartScrollChangedListener != null) {
				mSmartScrollChangedListener.onScrolledToBottom();
			}
		} else {
			if (mSmartScrollChangedListener != null) {
				mSmartScrollChangedListener.onScrolled();
			}
		}
	}

	public boolean isScrolledToTop() {
		return isScrolledToTop;
	}

	public boolean isScrolledToBottom() {
		return isScrolledToBottom;
	}
}
