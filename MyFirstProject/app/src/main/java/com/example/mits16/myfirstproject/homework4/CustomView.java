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


        painText = new Paint();
        painText.setColor(Color.BLACK);
        painText.setTextSize(80);
        painText.setStrokeWidth(40.0f);


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


        startXText = w/2.3f;
        startYText = h/4.1f;

        startXText2 = w/2f;
        startYText2 = h/3.6f;

        startXText3 = w/2.2f;
        startYText3 = h/3.5f;

        startXText4 = w/2.3f;
        startYText4 = h/3.6f;



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx,cy,radius,pain);
        canvas.drawLine(startXHour,startYHour,stopXHour,stopYHour,painLineHour);
        canvas.drawLine(startXMinutes,startYMinutes,stopXMinutes,stopYMinutes,painLine);

        canvas.drawText(text,startXText,startYText,painText);

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
}
