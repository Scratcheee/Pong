package com.lawrencekaul.pong;

import android.graphics.RectF;

import java.util.Random;

class Ball {


    //Todo: Randomize dividing factor of mXVelocity = -(y / 10);

    /*
    These are the member variables (fields) they all
    have the m prefix, they are all private because
    direct access is not required
     */
    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;


    /*
    This is the constructor method. It is
    called by the code: mBall = new Ball (mScreenX);
    in the PongGame class
     */
    Ball(int screenX) {
        // Make the ball square and 1% of the screen width
        mBallWidth = screenX / 100;
        mBallHeight = screenX / 100;

        /*
        Initialize the RectF with 0, 0, 0, 0 We do it here
        because we only want to do it once
        we will initialize the detail at the start of each game
         */
        mRect = new RectF();
    }

    // Return a reference to mRect to PongGame
    RectF getRect() {
        return mRect;
    }

    // Update the ball position
    // Called each frame/loop
    void update(long fps) {
        /*
        Move the ball based upon the horizontal (mXVelocity) and
        vertical (mYVelocity) speed and the current frame rate (fps)
         */

        // Move the top left corner
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);

        // Match up the bottom right corner based on the size of the ball
        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;
    }

    private Boolean randomizePositivity(){

        Random rand = new Random();

        int randInt = rand.nextInt(10);

        if (randInt <=5){
            return true;
        } else {
            return false;
        }

    }

    // Reverse the vertical direction of travel
    void reverseYVelocity() {
        mYVelocity = -mYVelocity;
    }

    // Reverse the horizontal direction of travel
    void reverseXVelocity() {
        mXVelocity = -mXVelocity;
    }

    void reset(int x, int y) {


        // Initialize the four points of the rectangle which defines the ball
        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        /*
        How fast will the ball travel
        You could vary this to suit
        You could even increase it as the game progresses
        to make it harder
         */
        mYVelocity = (y / 3);

        if (randomizePositivity()) {
            mXVelocity = -(y / 10);
        } else {
            mXVelocity = (y / 10);
        }
    }

    void increaseVelocity() {
        // Increase the speed by 10%
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;
    }

    // Bounce the ball back based on whether
    // it hits the left or right-hand side
    void batBounce(RectF batPosition) {
        // Detect center of the bat
        float batCenter = batPosition.left + (batPosition.width() / 2);

        // Detect the center of the ball
        float ballCenter = mRect.left + (mBallWidth / 2);

        // Where on the bat did the ball hit?
        float relativeIntersect = (batCenter - ballCenter);

        // Pick a bounce direction
        if (relativeIntersect < 0) {
            // Go right
            mXVelocity = Math.abs(mXVelocity);
            // Math.abs is a static method that strips any negative
            // values from a value. so -1 becomes 1 and 1 stays as 1
        } else {
            // Go left
            mXVelocity = -Math.abs(mXVelocity);
        }

        /*
        Having calculated left or right for horizontal direction simply
        reverse the vertical direction to go back up the screen
         */
        reverseYVelocity();
    }
}
