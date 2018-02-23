package com.example.mits16.myfirstproject.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import java.util.Calendar;


/**
 * Created by mizz8 on 18.02.2018.
 */

public class CustomView  extends View{

    private float cx;
    private float cy;
    private float startX;
    private float startY;
    private float stopX;
    private float stopY;
    private Paint painLine;
    private String text = "12";
    private String text2 = "3";
    private String text3 = "6";
    private String text4 = "9";
    private Paint painText;
    private float startXText;
    private float startYText;
    private float startXText2;
    private float startYText2;
    private float startXText3;
    private float startYText3;
    private float startXText4;
    private float startYText4;
    private int height,width = 0;
    private int padding = 0;
    private int fontsize = 0;
    private int numeralSpacing = 0;
    private int handTruncation, hourhandTruncation = 0;
    private int radius;
    private Paint paint;
    private Paint paintClock;
    private boolean isInit;




    public CustomView(Context context) {
        super(context);

    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    private void init(){
        paintClock = new Paint();
        paintClock.setColor(Color.argb(200,255,140,0));
        paintClock.setAntiAlias(true);

        painLine = new Paint();
        painLine.setColor(Color.BLACK);
        painLine.setAntiAlias(true);
        painLine.setStrokeWidth(15.0f);

        painText = new Paint();
        painText.setColor(Color.BLACK);
        painText.setTextSize(80);
        painText.setStrokeWidth(40.0f);
        painText.setAntiAlias(true);

        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);


        height = getHeight();
        width = getWidth();
        padding = numeralSpacing+50;
        fontsize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,13,getResources().getDisplayMetrics());
        int min = Math.min(height,width);
        radius = min/2 - padding;
        handTruncation = min/20;
        hourhandTruncation = min/7;
        isInit = true;

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w/2;
        cy = h/2;
        radius = (int) (w > h ? cy : cx);

        startX = w/2;
        startY = h/4;
        stopX = w/2;
        stopY = h/3.5f;

        startXText = w/2.3f;
        startYText = h/3.4f;

        startXText2 = w/2f;
        startYText2 = h/3.2f;

        startXText3 = w/2.15f;
        startYText3 = h/3f;

        startXText4 = w/2.3f;
        startYText4 = h/3.2f;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(!isInit){
            init();
        }
        drawCircle(canvas);
        //drawCenter(canvas);
        drawDial(canvas);
        drawHands(canvas);
        postInvalidateDelayed(500);
        invalidate();
    }


    private void drawCircle(Canvas canvas){
        canvas.drawCircle(cx,cy,radius,paintClock);
    }

    private void drawDial(Canvas canvas){
        canvas.drawText(text, startXText,startYText, painText);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.save();
        canvas.rotate(-90, startX, stopY);
        canvas.drawText(text2, startXText2,startYText2, painText);
        canvas.restore();
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.save();
        canvas.rotate(-180, startX, stopY);
        canvas.drawText(text3, startXText3,startYText3, painText);
        canvas.restore();
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.save();
        canvas.rotate(90, startX, stopY);
        canvas.drawText(text4, startXText4,startYText4, painText);
        canvas.restore();
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
        canvas.drawLine(startX,startY,stopX,stopY,painLine);
        canvas.rotate(30,cx,cy);
    }



    private void drawHands(Canvas canvas, double loc, boolean isHour) {
        double angle = Math.PI*loc/30 - Math.PI/2;
        int handRadius = isHour ? radius -handTruncation -hourhandTruncation : radius - handTruncation;
        canvas.drawLine(width/2, height/2,(float)(width/2+Math.cos(angle)*handRadius),(float)(height/2+Math.sin(angle)*handRadius),paint);

    }


    private void drawHands(Canvas canvas) {

        Calendar c = Calendar.getInstance();
        float hour = c.get(Calendar.HOUR_OF_DAY);
        hour = hour > 12? hour - 12: hour;
        drawHands(canvas,(hour+ c.get(Calendar.MINUTE)/60)*5f,true);
        drawHands(canvas, c.get(Calendar.MINUTE),false);
        drawHands(canvas, c.get(Calendar.SECOND),false);
    }


   /* private void drawCenter(Canvas canvas) {
        canvas.drawCircle(width/2,height/2, 15, paint);
    }*/
}
