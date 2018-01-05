
package com.myapps.toualbiamine.rushhour;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

public class RushHourMain extends Activity {

    //get height and width of window
    static int width= Resources.getSystem().getDisplayMetrics().widthPixels;
    static int height=Resources.getSystem().getDisplayMetrics().heightPixels;

    public static final int WIDTH = width;
    public static final int HEIGHT = height;
    public static int Score = 0;
    public static final int LANESIZE = WIDTH / 4;

    public static Road road;
    public static Car car[];
    public static ObstacleOrganizer obs;
    public static CarListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        car = new Car[1];
        car[0] = new Car();

        road = new Road(this);

        obs = new ObstacleOrganizer();
        Thread o = new Thread(obs);
        o.start();

        Thread c = new Thread(car[0]);
        c.start();

        listener = new CarListener();
        road.setOnTouchListener(listener);



        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE); //deletes top bar

        setContentView(road);

    }

    public static void reset(){ //reset game

        Score = 0;

        CarListener.over = false;

        car = new Car[1];
        car[0] = new Car();

        obs = new ObstacleOrganizer();

        Thread o = new Thread(obs);
        o.start();

        Thread c = new Thread(car[0]);
        c.start();



        Motorcycle.acceleration = 0;
        Truck.acceleration = 0;


    }


}
