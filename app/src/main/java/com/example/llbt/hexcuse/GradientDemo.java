package com.example.llbt.hexcuse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by llbt on 2016/4/19.
 */
public class GradientDemo extends View {

	private Paint mPaint;
	private int mWidth;
	private int mHeight;
	private int raduis;

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
		mPaint.setColor(Color.BLUE);
		mPaint.setStrokeMiter(5);
		raduis = mWidth/3;
		canvas.drawCircle(mWidth/2, mHeight/2, raduis, mPaint);
	}


}
