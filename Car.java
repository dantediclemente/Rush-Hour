package com.myapps.toualbiamine.rushhour;

/**
 * Created by toualbiamine on 12/17/17.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Car implements Runnable {


    public static int myLane = 0;
    public static int carY = RushHourMain.HEIGHT - 400;
    int speed = 40;
//    int test = 75;

    public Car(){

        int lane = 0;

    }

    public void draw(Canvas g){

        //draws car
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        g.drawRect(myLane * RushHourMain.LANESIZE + 85, (RushHourMain.HEIGHT - 350) + 100, myLane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 65, (RushHourMain.HEIGHT - 230) + 100, paint);
        g.drawRect(myLane * RushHourMain.LANESIZE + 90, (RushHourMain.HEIGHT - 350) + 100, myLane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 60, (RushHourMain.HEIGHT - 200) + 100, paint);
        g.drawRect(myLane * RushHourMain.LANESIZE + 95, (RushHourMain.HEIGHT - 390) + 100, myLane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 55, (RushHourMain.HEIGHT - 230) + 100, paint);
        g.drawRect(myLane * RushHourMain.LANESIZE + 70, (RushHourMain.HEIGHT - 320) + 100, myLane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 80, (RushHourMain.HEIGHT - 310) + 100, paint);

        //draws windshield
        paint.setColor(Color.LTGRAY);
        g.drawRect(myLane * RushHourMain.LANESIZE + 95, (RushHourMain.HEIGHT - 330) + 100, myLane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 55, (RushHourMain.HEIGHT - 320) + 100, paint);
        g.drawRect(myLane * RushHourMain.LANESIZE + 95, (RushHourMain.HEIGHT - 250) + 100, myLane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 55, (RushHourMain.HEIGHT - 240) + 100, paint);


    }

    public void run(){

        while(CarListener.over == false){ //while game is not over

            CarListener.update(); //checks if car is touching obstacle

        }

        try{
            Thread.sleep(10);
        }
        catch (InterruptedException e) {

        }

    }

}
