package com.myapps.toualbiamine.rushhour;

import android.view.MotionEvent;
import android.view.View;

public class CarListener implements View.OnTouchListener {

    int x;
    public static boolean over = false;
    public static boolean start = true;


    public boolean onTouch(View view, MotionEvent motionEvent) {

        x = (int) motionEvent.getX();
        int lane_index = x / 270; //lane clicked on
        int action = motionEvent.getActionMasked();

        switch(action) {
            case MotionEvent.ACTION_BUTTON_PRESS:
                if(over == true){ //if end of the game
                    RushHourMain.reset();
                }
            case MotionEvent.ACTION_DOWN:
                if (start == true){ //if beginning of the game
                    start = false;
                    RushHourMain.road.postInvalidate();
                }

                if (over == false) { //if game's playing
//                    if(lane_index == RushHourMain.car[0].myLane - 1 ||
//                            lane_index == RushHourMain.car[0].myLane + 1){ //possible movement
//                        RushHourMain.car[0].myLane = lane_index;
//                        RushHourMain.road.postInvalidate();
//                    }
                    if (lane_index < RushHourMain.car[0].myLane) {
                        RushHourMain.car[0].myLane = RushHourMain.car[0].myLane -1;
                        RushHourMain.road.postInvalidate();
                    }
                    if(lane_index > RushHourMain.car[0].myLane){
                        RushHourMain.car[0].myLane = RushHourMain.car[0].myLane +1;
                        RushHourMain.road.postInvalidate();
                    }
                }

                if(over == true){
                    RushHourMain.reset();
                }

        }

        return true;

    }


    public static void update() { //Updates the status of the game
        //Checks if obstacle touches car

        if (ObstacleOrganizer.touching(RushHourMain.car[0]) == true) {

            over = true; //updates status of game to OVER
            System.out.println("Game over");

            if(RushHourMain.Score> ObstacleOrganizer.topScore){

                ObstacleOrganizer.topScore = RushHourMain.Score;
            }
        }

    }

}
