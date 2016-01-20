package com.example.yusuf.tddc73_project.PasswordForm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

//import com.example.yusuf.tddc73_project.PswForm;


/**
 * Created by Yusuf on 14/12/15.
 */

/**
 * Checking the strength of password returned
 * in PswStrengthAlgorithm and changes the colors of the bars
 * accordingly to the strength
 * */

public class PswStrengthCheck extends View{


    Rect redRect, yellowRect, greenRect;
    Paint redPaint, yellowPaint, greenPaint;
    private int opacityR, opacityY, opacityG;

    public PswStrengthCheck(Context context){
        super(context);

        initOpacity();

    }

    public void checkPswStrength(int strength){
        if(strength == 1){

            //redPaint.setAlpha(255);
            opacityR = 255;
            opacityY = 100;
            opacityG = 100;
        }
        else if(strength == 2 || strength == 3){
            opacityR = 255;
            opacityY = 255;
            opacityG = 100;
        }
        else if(strength == 4){
            opacityR = 255;
            opacityY = 255;
            opacityG = 255;
        }
        else{
            opacityG = 100;
            opacityY = 100;
            opacityR = 100;
        }
    }

    public void initOpacity(){
        opacityR = 100;
        opacityY = 100;
        opacityG = 100;

    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Log.d("Opacity is ", "OP" + );

        //Rectangles depends on the screensize, fills a third per rectangle.
        Display display = this.getDisplay();

        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;

        //Red Rectangle
        redRect = new Rect();
        redRect.set(0, 0, width/3, 20);

        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setAlpha(opacityR);
        redPaint.setStyle(Paint.Style.FILL);

        //Yellow Rectangle
        yellowRect = new Rect();
        yellowRect.set(width/3, 0, (2*width)/3, 20);

        yellowPaint = new Paint();
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setAlpha(opacityY);
        yellowPaint.setStyle(Paint.Style.FILL);

        //Green Rectangle
        greenRect = new Rect();
        greenRect.set((2*width)/3, 0, width, 20);

        greenPaint = new Paint();
        greenPaint.setColor(Color.GREEN);
        greenPaint.setAlpha(opacityG);
        greenPaint.setStyle(Paint.Style.FILL);

        //Draw all to canvas
        canvas.drawRect(redRect, redPaint);
        canvas.drawRect(yellowRect, yellowPaint);
        canvas.drawRect(greenRect, greenPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        setMeasuredDimension(1000, 1000);
    }

}
