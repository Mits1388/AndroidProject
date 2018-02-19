package com.example.mits16.myfirstproject.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mizz8 on 18.02.2018.
 */

public class CustomView  extends View{

    private float cx;
    private float cy;
    private float radius;
    private Paint pain;
    private float startX;
    private float startY;
    private float stopX;
    private float stopY;
    private float startXHour;
    private float startYHour;
    private float stopXHour;
    private float stopYHour;
    private float startXMinutes;
    private float startYMinutes;
    private float stopXMinutes;
    private float stopYMinutes;
    private Paint painLine;
    private Paint painLineHour;



    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        pain = new Paint();
        pain.setColor(Color.argb(200,255,140,0));
        pain.setAntiAlias(true);

        painLine = new Paint();
        painLine.setColor(Color.BLACK);
        painLine.setAntiAlias(true);
        painLine.setStrokeWidth(15.0f);

        painLineHour = new Paint();
        painLineHour.setColor(Color.BLACK);
        painLineHour.setStrokeWidth(40.0f);
        Calendar calendar = new C

    }







    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w/2;
        cy = h/2;
        radius = w > h ? cy : cx;

        startX = w/2;
        startY = h/5;
        stopX = w/2;
        stopY = h/4;

        startXHour = w/2;
        startYHour = h/2;
        stopXHour = w/3.7f;
        stopYHour = h/2;

        startXMinutes = w/2;
        startYMinutes = h/2;
        stopXMinutes = w/2;
        stopYMinutes = h/3.8f;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx,cy,radius,pain);
        canvas.drawLine(startXHour,startYHour,stopXHour,stopYHour,painLineHour);
        canvas.drawLine(startXMinutes,startYMinutes,stopXMinutes,stopYMinutes,painLine);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);

    }
}
