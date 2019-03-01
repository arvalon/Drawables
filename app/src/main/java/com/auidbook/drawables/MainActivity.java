package com.auidbook.drawables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Drawables example
 *
 * SimpleTextDrawable and BetterTextDrawable replaced by BetterTextView
 *
 * @author Ian G. Clifton
 * @author arvalon
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // SimpleImageDrawable

        View view = findViewById(R.id.view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.giwajip);
        SimpleImageDrawable simpleImageDrawable = new SimpleImageDrawable(bitmap);
        view.setBackground(simpleImageDrawable);

        // LightingColorFilter
        int mul = 0xFF00FF00;
        int add = 0x000000BB;

        ColorFilter lightingColorFilter = new LightingColorFilter(mul, add);
        View view2 = findViewById(R.id.view2);
        SimpleImageDrawable simpleImageDrawable2 = new SimpleImageDrawable(bitmap);
        view2.setBackground(simpleImageDrawable2);
        simpleImageDrawable2.setColorFilter(lightingColorFilter);

        // RoundedImageDrawable

        Bitmap largeBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.giwajip);

        ImageView imageView = findViewById(R.id.image);
        RoundedImageDrawable roundedImageDrawable = new RoundedImageDrawable(largeBitmap, 200);
        imageView.setImageDrawable(roundedImageDrawable);

        // FadedImageDrawable

        ImageView imageView2 = findViewById(R.id.image2);
        FadedImageDrawable fadedImageDrawable = new FadedImageDrawable(largeBitmap);
        imageView2.setImageDrawable(fadedImageDrawable);

    }
}
