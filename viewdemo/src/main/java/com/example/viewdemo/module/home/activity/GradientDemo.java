package com.example.viewdemo.module.home.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;

/**
 * Created by llbt on 2016/4/19.
 */
public class GradientDemo extends View implements View.OnClickListener{

	private Paint mPaint;
	private int mWidth;
	private int mHeight;
	private int raduis;
	private int mColor;

	public GradientDemo(Context context) {
		this(context, null);
	}

	public GradientDemo(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GradientDemo(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		setOnClickListener(this);
		mColor = Color.BLUE;
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		if(widthMode == MeasureSpec.EXACTLY){
			mWidth = width;
		}else{

		}
		if(heightMode == MeasureSpec.EXACTLY){
			mHeight = height;
		}else{

		}
		raduis = mWidth/4;
		setMeasuredDimension(mWidth, mHeight);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(mColor);
		mPaint.setStrokeMiter(5);

		canvas.drawCircle(mWidth/2, mHeight/2, raduis, mPaint);
		invalidate();

	}

	@Override
	public void onClick(View view) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for(raduis = mWidth/4; raduis < mWidth/3; raduis++){
//					mColor += 100;
//					mPaint.setColor(mColor);
//					postInvalidate();
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//			}
//		}).start();
	}
}
