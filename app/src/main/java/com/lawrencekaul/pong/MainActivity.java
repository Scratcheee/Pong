package com.lawrencekaul.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.PointerIcon;

public class MainActivity extends AppCompatActivity {

    private PongGame mPongGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        mPongGame = new PongGame(this, size.x, size.y);
        setContentView(mPongGame);
    }

    @Override
    protected void onResume(){
        super.onResume();

        //More code here later in the chapter
    }

    @Override
    protected void onPause(){
        super.onPause();

        //More code here later in the chapter
    }
}