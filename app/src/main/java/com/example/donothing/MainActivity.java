package com.example.donothing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
        setContentView(R.layout.activity_main);
        ImageView iconView = findViewById(R.id.icon);
        try (InputStream in = getAssets().open("icon.png")) {
            Bitmap icon = BitmapFactory.decodeStream(in);
            iconView.setImageBitmap(icon);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load icon.png from assets", e);
        }
    }
}