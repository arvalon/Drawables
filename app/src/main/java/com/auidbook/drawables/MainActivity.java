package com.auidbook.drawables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.auidbook.drawables.editor.EditorActivity;
import com.auidbook.drawables.examples.ExamplesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.examples_button).setOnClickListener(v ->
                startActivity(new Intent(this, ExamplesActivity.class))
        );

        findViewById(R.id.try_button).setOnClickListener(v ->
            startActivity(new Intent(this, EditorActivity.class))
        );
    }
}