package com.auidbook.drawables;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;

import static com.auidbook.drawables.MainActivity.TAG;

/**
 * Drawable that handles multiple lines of text.
 *
 * @author Ian G. Clifton
 */
public class BetterTextDrawable extends Drawable {

    private static final int TEXT_COLOR = 0xFF311B92;

    private final TextPaint mPaint = new TextPaint(new Paint(Paint.ANTI_ALIAS_FLAG));
    private final String mText;
    private StaticLayout mStaticLayout;

    public BetterTextDrawable(String text) {

        mText = text;
        mPaint.setColor(TEXT_COLOR);
        mPaint.setTextSize(100);

        /*mStaticLayout = new StaticLayout(
                mText,
                mPaint,
                (int) mPaint.measureText(mText),
                Layout.Alignment.ALIGN_NORMAL,
                1,
                0,
                false);*/

        buildLayout((int)mPaint.measureText(mText));
    }

    // TODO: 20.02.2019 посчитать корректное количество строк текста, погуглить как
    @Override
    public int getIntrinsicHeight() {
        Log.d(TAG, "BetterTextDrawable getIntrinsicHeight(): "+mStaticLayout.getHeight());
        return mStaticLayout.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        Log.d(TAG, "BetterTextDrawable getIntrinsicWidth(): "+mStaticLayout.getWidth());
        return mStaticLayout.getWidth();
    }

    @Override
    public void draw(Canvas canvas) {
        Log.d(TAG, "BetterTextDrawable draw");
        mStaticLayout.draw(canvas);
    }

    @Override
    public void setAlpha(int alpha) {
        Log.d(TAG, "BetterTextDrawable setAlpha");
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        Log.d(TAG, "BetterTextDrawable setColorFilter");
        mPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        Log.d(TAG, "BetterTextDrawable getOpacity");
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {

        Log.d(TAG, "BetterTextDrawable onBoundsChange bounds: "+bounds.toShortString());

        /*mStaticLayout = new StaticLayout(
                mText,
                mPaint,
                bounds.width(),
                Layout.Alignment.ALIGN_NORMAL,
                1,
                0,
                false);*/

        buildLayout(bounds.width());
    }

    private void buildLayout(int width){

        mStaticLayout = StaticLayout.Builder
                .obtain(mText,0, mText.length(),mPaint,width)
                .build();
    }
}
