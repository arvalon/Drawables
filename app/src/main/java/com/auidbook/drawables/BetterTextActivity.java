package com.auidbook.drawables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class BetterTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_better_text);

        View view = findViewById(R.id.view);
        view.setBackground(new BetterTextDrawable(getString(R.string.long_string)));
    }
}
