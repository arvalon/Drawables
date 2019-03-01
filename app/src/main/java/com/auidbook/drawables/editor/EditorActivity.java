package com.auidbook.drawables.editor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.auidbook.drawables.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

// TODO: 01.03.2019 ClickableViewAccessibility warning
/**
 * Simple paint editor example
 * @author arvalon
 */
public class EditorActivity extends AppCompatActivity {

    public static final String BLUE_COLOR = "#ff0000ff";
    public static final String RED_COLOR = "#ff0000";
    public static final String GREEN_COLOR = "#00ff00";

    private DrawView drawView;

    //@SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawView = findViewById(R.id.my_view);

        drawView.setOnTouchListener((v, event) -> {


            int action = event.getAction();
            if(action == MotionEvent.ACTION_DOWN ||
                    action == MotionEvent.ACTION_UP ||
                    action == MotionEvent.ACTION_MOVE)
            {
                drawView.drawPoint(
                        event.getX(),
                        event.getY()
                );
            }

            return true;
        });
    }

    public void clear(View view) {
        drawView.clear();
    }

    public void colorChange(View view) {
        switch (view.getId())
        {
            case R.id.color_blue:

                drawView.changeColor(Color.parseColor(BLUE_COLOR));
                break;

            case R.id.color_red:

                drawView.changeColor(Color.parseColor(RED_COLOR));
                break;

            case R.id.color_green:

                drawView.changeColor(Color.parseColor(GREEN_COLOR));
                break;
        }
    }
}
