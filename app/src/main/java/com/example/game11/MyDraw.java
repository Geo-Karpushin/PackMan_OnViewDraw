package com.example.game11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyDraw extends View{
    float x = -100f;
    float y = 1000f;
    float r = 100f;
    float center_x = x-r,
    center_y = y-r;
    boolean open = true;
    int col = 5;

    Paint p = new Paint();
    Path path = new Path();
    final RectF oval = new RectF();

    public MyDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(open){
        path.addCircle(y, x, r, Path.Direction.CCW);
        p.setColor(Color.YELLOW);
        canvas.drawColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(5);
        p.setAntiAlias(true);
        oval.set(center_x - r, center_y - r, center_x + r,
                center_y + r);
            x+=5;
            center_x = x-r;
            canvas.drawArc(oval, 45, 270, true, p);
            col--;
            if(col==0) {
                open = !open;
                col = 5;
            }
        }
        else{
            p.setColor(Color.YELLOW);
            canvas.drawColor(Color.BLACK);
            p.setStyle(Paint.Style.FILL);
            p.setStrokeWidth(5);
            p.setAntiAlias(true);
            x+=5;
            center_x = x-r;
            canvas.drawCircle(center_x, center_y, r, p);
            col--;
            if(col==0) {
                open = !open;
                col = 5;
            }
        }
        this.invalidate();
    }
}
