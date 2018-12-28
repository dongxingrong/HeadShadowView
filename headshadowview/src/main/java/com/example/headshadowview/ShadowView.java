package com.example.headshadowview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ShadowView extends View {

    private Paint mPaint = new Paint();
    private Paint mPaintOne = new Paint();
    private float mShadowSize = 0F;

    private int mShadowColor = 0;
    private int mBgColor = 0;

    private static final int DEFAULT_COLOR = Color.WHITE;
    private static final float DEFAULT_SHADOW_SIZE = 50;

    private int mRadius = 50;

    public ShadowView(Context context) {
        super(context);
        init(context, null);
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ShadowView);

        try {
            mShadowSize = array.getDimension(R.styleable.ShadowView_shadow_size, DEFAULT_SHADOW_SIZE);
            mShadowColor = array.getColor(R.styleable.ShadowView_shadow_color, DEFAULT_COLOR);
            mBgColor = array.getColor(R.styleable.ShadowView_shadow_bg_color, DEFAULT_COLOR);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            array.recycle();
        }

        mPaintOne.setColor(mBgColor);
        mPaintOne.setAntiAlias(true);

        mPaint.setColor(mShadowColor);
        mPaint.setAntiAlias(true);

        setLayerType(LAYER_TYPE_SOFTWARE, null);

    }

    private int mWidth = 0;
    private int mHeight = 0;
    private BlurMaskFilter mBlurMaskFilter;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        if (mWidth > 0 && mHeight > 0 && mBlurMaskFilter == null) {
            int minRadius = getMinRadius();
            mRadius = getRadius();
            mBlurMaskFilter = new BlurMaskFilter(minRadius, BlurMaskFilter.Blur.SOLID);
            mPaint.setMaskFilter(mBlurMaskFilter);
        }
    }

    private int getMinRadius() {
        return (int) ((mHeight - mShadowSize) / 2);
    }

    private int getRadius() {
        return (int) (mShadowSize / 2 - getMinRadius());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mWidth == 0 || mHeight == 0)
            return;

        int min = mWidth > mHeight ? mHeight : mWidth;
        if (min < mShadowSize)
            return;

        int widthHalf = mWidth / 2;
        int heightHalf = mHeight / 2;
        canvas.drawCircle(widthHalf, heightHalf + (mHeight - mShadowSize) / 2, mRadius, mPaint);
        canvas.drawCircle(widthHalf, heightHalf, mShadowSize / 2, mPaintOne);
    }
}
