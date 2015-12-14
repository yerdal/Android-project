package com.example.yusuf.tddc73_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;


/**
 * Created by Yusuf on 14/12/15.
 */
public class pswStrengthCheck extends View{

    Rect redRect, yellowRect, greenRect;
    Paint redPaint, yellowPaint, greenPaint;
    private int opacityR, opacityY, opacityG;

    public pswStrengthCheck(Context context){
        super(context);

        init();


    }

    public void checkPswStrength(int strength){
        if(strength == 1){
            //Log.d("PASSWORD RED CHECK", "EINARS BALLE");
            //redPaint.setAlpha(255);
            opacityR = 255;
        }
        else if(strength == 2){
            opacityY = 255;
        }
        else{
            opacityG = 100;
            opacityY = 100;
            opacityR = 100;
        }
    }

    public void init(){

        opacityR = 100;
        opacityY = 100;
        opacityG = 100;

    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Log.d("Opacity is ", "OP" + );
        redRect = new Rect();
        redRect.set(0, 0, 300, 20);

        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setAlpha(opacityR);
        redPaint.setStyle(Paint.Style.FILL);

        yellowRect = new Rect();
        yellowRect.set(300, 0, 600, 20);

        yellowPaint = new Paint();
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setAlpha(opacityY);
        yellowPaint.setStyle(Paint.Style.FILL);

        greenRect = new Rect();
        greenRect.set(600, 0, 900, 20);

        greenPaint = new Paint();
        greenPaint.setColor(Color.GREEN);
        greenPaint.setAlpha(opacityG);
        greenPaint.setStyle(Paint.Style.FILL);


        canvas.drawRect(redRect, redPaint);
        canvas.drawRect(yellowRect, yellowPaint);
        canvas.drawRect(greenRect, greenPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        //Sets the dimensions for the item.
        setMeasuredDimension(1000, 1000);
    }

}
