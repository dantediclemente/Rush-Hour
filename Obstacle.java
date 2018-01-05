package com.myapps.toualbiamine.rushhour;

/**
 * Created by toualbiamine on 12/17/17.
 */

public abstract class Obstacle {

    int speed;
    int lane;
    int y;

    public Obstacle(int lane){

        speed = 0;
        y = 0;
        this.lane = lane;

    }

    public abstract void move();

}
