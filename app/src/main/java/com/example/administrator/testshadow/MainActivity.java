package com.example.administrator.testshadow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        int width = dp2px(this, 67);
//
//        Paint mPaint = new Paint();
//        mPaint.setColor(ContextCompat.getColor(this, R.color.color_6C62F5));
//        mPaint.setShadowLayer(20, 0F, 1F, ContextCompat.getColor(this, R.color.color_6C62F5));
//        Bitmap target = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(target);
//        canvas.drawCircle(width / 2, width / 2, width / 2 - 20, mPaint);
//
//        ImageView imageView = findViewById(R.id.iv_shadow);
    }

    public static int dp2px(Context context, final float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
