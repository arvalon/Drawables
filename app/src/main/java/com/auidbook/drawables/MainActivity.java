package com.auidbook.drawables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;

// TODO: 19.02.2019 перетащить остальные view, причесать id и др.

/**
 * Drawables example
 * @author Ian G. Clifton
 */
public class MainActivity extends AppCompatActivity {

    static final String TAG = "drawables.logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // SimpleTextDrawable
        View view = findViewById(R.id.view);
        view.setBackground(new SimpleTextDrawable(getString(R.string.hello_world)));

        // BetterTextDrawable -> BetterTextView

        // SimpleImageDrawable
        View view3 = findViewById(R.id.view2);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        final SimpleImageDrawable simpleImageDrawable = new SimpleImageDrawable(bitmap);
        view3.setBackground(simpleImageDrawable);

        // LightingColorFilter example
        //                AARRGGBB
        final int mul = 0xFF00FF00;
        final int add = 0x000000BB;

        final ColorFilter lightingColorFilter = new LightingColorFilter(mul, add);

        View view4 = findViewById(R.id.view3);

        SimpleImageDrawable simpleImageDrawable2 = new SimpleImageDrawable(bitmap);

        view4.setBackground(simpleImageDrawable2);

        simpleImageDrawable2.setColorFilter(lightingColorFilter);
    }
}
