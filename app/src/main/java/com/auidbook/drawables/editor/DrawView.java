package com.auidbook.drawables.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Admin on 07.06.2016.
 */
public class DrawView extends View {

    private Bitmap paperBitmap;
    private Canvas paperCanvas;
    private Paint paint;

    private int w;
    private int h;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint  = new Paint();
        paint.setColor(0xffff0000);
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
        newCanvas();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(paperBitmap, 0, 0, null);
    }

    private void newCanvas() {
        paperBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        paperCanvas = new Canvas(paperBitmap);
    }

    public void drawPoint(float x, float y) {
        paperCanvas.drawPoint(x, y, paint);
        invalidate();
    }

    public void clear() {
        newCanvas();
        invalidate();
    }

    public void changeColor(int color) {
        paint.setColor(color);
    }
}
