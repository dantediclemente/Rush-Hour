package com.myapps.toualbiamine.rushhour;

import android.graphics.Canvas;


public class ObstacleOrganizer implements Runnable {

    public static Truck[] truck;
    public static Motorcycle[] motorcycle;
    public static int topScore = 0;
    public static int counter = 0;
    int typeOfObstacle = 0;

    public ObstacleOrganizer() { //Handles creation of obstacles

        truck = new Truck[10000];
        motorcycle = new Motorcycle[10000];

    }

    public void populate(int i) { //creates obstacles

        typeOfObstacle = (int)(Math.random()*2);
        int numlane = (int)(Math.random() * 4);
        if(typeOfObstacle == 0) {

            truck[i] = new Truck(numlane);
            Thread t = new Thread(truck[i]);
            t.start();
            }


        if(typeOfObstacle == 1){
            motorcycle[i] = new Motorcycle(numlane);
            Thread t = new Thread(motorcycle[i]);
            t.start();
        }

    }

    public void run() {

        int i = 0;


        while(CarListener.over == false) {


            if(RushHourMain.Score < 20) {
                if (i % 15 == 0 && CarListener.start == false) {
                    populate(i);
                }
            }
            else if(RushHourMain.Score < 30){
                if(i% 10 == 0 && CarListener.start == false){
                    populate(i);
                }
            }
            else
                if(i%5 == 0 && CarListener.start == false){
                    populate(i);
                }


            //moves the car for a bit
            //if error happens, program doesn't crash
            try {
                if(i<20) {
                    //pauses for 100 ms
                    Thread.sleep(100);
                } else { //everything faster after certain point
                    Thread.sleep(70);
                }
                i++;
            } catch (InterruptedException e) {
                System.out.println("ERROR IN OBSTACLE");
            }
        }

    }

    public void draw(Canvas canvas) {

        for (int i = 0; i < truck.length; i++) {
            if (truck[i] != null) {
                truck[i].draw(canvas);
            }
        }

        for(int i=0; i<motorcycle.length; i++){
            if(motorcycle[i] != null){
                motorcycle[i].draw(canvas);
            }
        }

    }

    public static boolean touching(Car car) { //checks if obstacle touches car

        if(truck == null){
            return false;
        }
else {
            for (int i = 0; i < truck.length; i++) {
                if (truck[i] != null) {
                    if (truck[i].touching(car)) {
                        return true;
                    }
                }
            }

            for (int i = 0; i < motorcycle.length; i++) {
                if (motorcycle[i] != null) {
                    if (motorcycle[i].touching(car)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

}
