package com.auidbook.drawables;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * https://stackoverflow.com/questions/41779934/how-is-staticlayout-used-in-android
 */
public class BetterTextView extends View {

    private static final int TEXT_COLOR = 0xFF311B92;

    String mText;
    TextPaint mTextPaint;
    StaticLayout mStaticLayout;

    public BetterTextView(Context context) {
        super(context);
        initLabelView(context);
    }

    public BetterTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLabelView(context);
    }

    private void initLabelView(Context ctx) {

        mText = ctx.getString(R.string.long_string);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(38 * getResources().getDisplayMetrics().density);
        mTextPaint.setColor(TEXT_COLOR);

        // default to a single line of text
        int width = (int) mTextPaint.measureText(mText);

        mStaticLayout=getmStaticLayout(width,0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthRequirement = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthRequirement;
        } else {
            width = mStaticLayout.getWidth() + getPaddingLeft() + getPaddingRight();
            if (widthMode == MeasureSpec.AT_MOST) {

                if (width > widthRequirement) {

                    width = widthRequirement;

                    mStaticLayout=getmStaticLayout(width,1);
                }
            }
        }

        // determine the height
        int height;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightRequirement = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightRequirement;

        } else {

            height = mStaticLayout.getHeight() + getPaddingTop() + getPaddingBottom();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, heightRequirement);
            }
        }

        // Required call: set width and height
        setMeasuredDimension(width, height);
    }

    private StaticLayout getmStaticLayout(int width, int mSpacingMult){

        StaticLayout.Builder builder = StaticLayout.Builder
                .obtain(mText, 0, mText.length(), mTextPaint, width)
                .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                .setLineSpacing(1, mSpacingMult) // multiplier, add
                .setIncludePad(false);

        return builder.build();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // do as little as possible inside onDraw to improve performance

        // draw the text on the canvas after adjusting for padding
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        mStaticLayout.draw(canvas);
        canvas.restore();
    }
}
