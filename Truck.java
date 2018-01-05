package com.myapps.toualbiamine.rushhour;

/**
 * Created by toualbiamine on 12/17/17.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Truck extends Obstacle implements Runnable {

    public static double acceleration = 0;

    public Truck(int lane) {

        super(lane);
        y = 0;
        speed = 15;
    }

    public void draw(Canvas g) {

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        //draw truck
        g.drawRect(lane * RushHourMain.LANESIZE + 85, y, lane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 65, y + 400, paint);
        g.drawRect(lane * RushHourMain.LANESIZE + 65, y, lane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 85, y + 300, paint);
        g.drawRect(lane * RushHourMain.LANESIZE + 70, y+310,
                lane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 80, y + 330, paint);
        //draw windshield
        paint.setColor(Color.LTGRAY);
        g.drawRect(lane * RushHourMain.LANESIZE + 95, y+340,
                lane * RushHourMain.LANESIZE + RushHourMain.LANESIZE / 2 + 55, y + 350, paint);

    }

    public void move() { //makes truck move

        if(CarListener.start == false) { //so truck doesn't move when game hasn't started
            y = (int) (y + speed + acceleration);
        }
        RushHourMain.road.postInvalidate();

    }


    public void run() {

        while(CarListener.over == false  && y < RushHourMain.HEIGHT){

            if(y > RushHourMain.HEIGHT - 30){
                RushHourMain.Score += 1;
            }

            move();
            acceleration += 0.05;

            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){
                System.out.println("ERROR IN TRUCK");
            }
        }
    }

    public boolean touching(Car car) {
        if (this.lane == car.myLane && (this.y + 400) > RushHourMain.HEIGHT - 290
                && this.lane == car.myLane && (this.y + 110) < RushHourMain.HEIGHT - 100) {

            return true;

        }

        return false;
    }

}


//We have 570 lines

