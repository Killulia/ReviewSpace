package com.kingwag.day19review;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by kingwag on 2016/12/20.
 */

public class MyTextView extends TextView {


    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GRAY);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.RED);

        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,paint1);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }
}
