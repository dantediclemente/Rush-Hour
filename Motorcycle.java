package com.myapps.toualbiamine.rushhour;

/**
 * Created by toualbiamine on 12/17/17.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Motorcycle extends Obstacle implements Runnable {

    public static double acceleration = 0;

    public Motorcycle(int lane){

        super(lane);
        y = 10;
        speed = 20;

    }

    public void draw(Canvas g){

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        //draws motorcyle
        g.drawRect(lane*RushHourMain.LANESIZE + 60, y, lane*RushHourMain.LANESIZE + 100, y+115, paint);
        g.drawRect(lane*RushHourMain.LANESIZE + 40, y+80, lane*RushHourMain.LANESIZE + 120,
                y+90, paint);
        //draws windshield
        paint.setColor(Color.LTGRAY);
        g.drawRect(lane*RushHourMain.LANESIZE + 65, y+85, lane*RushHourMain.LANESIZE + 95,
                y+100, paint);

    }

    public void move(){
        //Moves obstacle down
        if(CarListener.start == false) {

            y = (int) (y + speed + acceleration);
        }

        RushHourMain.road.postInvalidate();

    }


    public void run(){

        //while game not over and object not at the end of the road
        while(CarListener.over != true && y < RushHourMain.HEIGHT){

            if(this.y > RushHourMain.HEIGHT - 30){ //checks if car has dodged obstacle + add score
                RushHourMain.Score++;
            }

            move();
            acceleration += 0.05;

            try{

                Thread.sleep(50);
            }
            catch(InterruptedException e){
                System.out.println("ERROR IN MOTORCYCLE");
            }


        }

    }

    public boolean touching(Car car) { //checks if motorcycle touches car

        if (this.lane == car.myLane && (this.y + 115) > RushHourMain.HEIGHT - 290
                && this.lane == car.myLane && (this.y + 115) < RushHourMain.HEIGHT - 100) {

            return true;

        }
        return false;
    }
    


}
