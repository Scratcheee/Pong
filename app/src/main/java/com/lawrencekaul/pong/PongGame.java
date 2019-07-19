package com.lawrencekaul.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class PongGame extends SurfaceView {

    // Are we debugging?
    private final boolean DEBUGGING = true;

    // These objects are needed to do the drawing
    private SurfaceHolder mOurHolder;
    private Canvas mCanvas;
    private Paint mPaint;

    // How many frames per second did we get?
    private long mFPS;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;

    // Holds the resolution of the screen
    private int mScreenX;
    private int mScreenY;
    // How big will the text be?
    private int mFontSize;
    private int mFontMargin;

    // The game objects
    private Bat mBat;
    private Ball mBall;

    // The current score and lives remaining
    private int mScore;
    private int mLives;

    // The PongGame constructor
    // Called when this line:
    // mPongGame = new PongGame (this, size.x, size.y);
    // is executed from PongActivity

    public PongGame(Context context, int x, int y) {
        // Super... calls the parent of the class
        // constructor of SurfaceView
        // provided by Android
        super(context);

        // Initialize these two members/fields
        // With the values passed in as parameters
        mScreenX = x;
        mScreenY = y;

        // Font is 5% of the screen width
        mFontSize = mScreenX / 20;
        // Margin is 1.5% of the screen width
        mFontMargin = mScreenX / 75;

        // Initialize the objects
        //ready for drawing with
        // getHolder is a method of SurfaceView
        mOurHolder = getHolder();
        mPaint = new Paint();

        // Initialize the bat and ball

        // Everything is ready so start the game
        startNewGame();

    }

    // The player has just lost
    // ir is starting their first game
    private void startNewGame(){

        // Put the ball back into the starting position

        // Reset the score and the player's chances
        mScore = 0;
        mLives = 3;

    }


        // Draw the game objects and the HUD
        void draw() {
            if (mOurHolder.getSurface().isValid()){
                // Lock the canvas (graphics memory) ready to draw
                mCanvas = mOurHolder.lockCanvas();

                // Fill the screen with a solid color
                mCanvas.drawColor(Color.argb(255, 26, 128, 182));

                // Choose a color to paint with
                mPaint.setColor(Color.argb(255, 255, 255, 255));

                // Draw the bat and ball

                //choose the font size
                mPaint.setTextSize(mFontSize);

                // Draw the HUD
                mCanvas.drawText("Score: " + mScore + " Lives: " + mLives, mFontMargin, mFontSize, mPaint);

                if (DEBUGGING){
                    printDebbugingText();
                }

                // Display the drawing on screen
                // unlockCanvasAndPost is a method of SurfaceView
                mOurHolder.unlockCanvasAndPost(mCanvas);
            }
        }

        private void printDebbugingText(){
            int debugSize = mFontSize / 2;
            int debugStart = 150;
            mPaint.setTextSize(debugSize);
            mCanvas.drawText("FPS: " + mFPS, 10, debugStart, mPaint);

    }
}
