package com.chipsee.touchtester;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.chipsee.view.PointerLocationView;

public class MainActivity extends AppCompatActivity {

    PointerLocationView mPointerView;
    private Button passButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideSystemUI();

        mPointerView = (PointerLocationView) findViewById(R.id.pointerview);
        mPointerView.setBackgroundColor(Color.TRANSPARENT);

        mPointerView
                .setOnPointCountChangeListener(new PointerLocationView.OnPointCountChangeListener() {
                    public void onPointCountChange(int newPointCount) {
                        Log.i("Jeffy", "Count:" + newPointCount);
                        if (newPointCount >= 20) {
                            passButton.performClick();
                        }
                    }
                });
    }

    private void hideSystemUI() {
        View mDecorView = getWindow().getDecorView();
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION 	// hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN  		// hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE );		// IMMERSIVE Android4.4 (API 19)
        //| SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void showSystemUI() {
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
