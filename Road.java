package com.myapps.toualbiamine.rushhour;

/**
 * Created by toualbiamine on 12/17/17.
 */



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;


public class Road extends View{

    int color;

    public Road(Context context) {
        super(context);

        color = 0xff527a7a;
    }

    protected void onDraw(Canvas g) {

        Paint paint = new Paint();
        paint.setColor(color);

        //background
        g.drawRect(0, 0, RushHourMain.WIDTH, RushHourMain.HEIGHT, paint);

        //lines
        paint.setColor(Color.WHITE);

        g.drawRect(RushHourMain.WIDTH / 2, 0, RushHourMain.WIDTH / 2 + 2, RushHourMain.HEIGHT / 4, paint);
        g.drawRect(RushHourMain.WIDTH / 2 / 2, 0, RushHourMain.WIDTH / 2 / 2 + 2, RushHourMain.HEIGHT / 4, paint);
        g.drawRect((RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2), 0, (RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2) + 2, RushHourMain.HEIGHT / 4, paint);

        g.drawRect(RushHourMain.WIDTH / 2, RushHourMain.HEIGHT / 4 + 100, RushHourMain.WIDTH / 2 + 2, RushHourMain.HEIGHT / 4 + 548, paint);
        g.drawRect(RushHourMain.WIDTH / 2 / 2, RushHourMain.HEIGHT / 4 + 100, RushHourMain.WIDTH / 2 / 2 + 2, RushHourMain.HEIGHT / 4 + 548, paint);
        g.drawRect((RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2), RushHourMain.HEIGHT / 4 + 100, (RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2) + 2, RushHourMain.HEIGHT / 4 + 548, paint);

        g.drawRect(RushHourMain.WIDTH / 2, 1096, RushHourMain.WIDTH / 2 + 2, 1544, paint);
        g.drawRect(RushHourMain.WIDTH / 2 / 2, 1096, RushHourMain.WIDTH / 2 / 2 + 2, 1544, paint);
        g.drawRect((RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2), 1096, (RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2) + 2, 1544, paint);

        g.drawRect(RushHourMain.WIDTH / 2 / 2, 1644, RushHourMain.WIDTH / 2 / 2 + 2, RushHourMain.HEIGHT / 4 + 2000, paint);
        g.drawRect((RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2), 1644, (RushHourMain.WIDTH / 2) + (RushHourMain.WIDTH / 2 / 2) + 2, RushHourMain.HEIGHT / 4 + 2000, paint);
        g.drawRect(RushHourMain.WIDTH / 2, 1644, RushHourMain.WIDTH / 2 + 2, RushHourMain.HEIGHT / 4 + 2000, paint);


        RushHourMain.car[0].draw(g);

        if(CarListener.start == false) { //starts game
            RushHourMain.obs.draw(g);
        }

        if(CarListener.start == false && CarListener.over == false){ //Show score at top of window
            paint.setColor(Color.BLACK);
            paint.setTextSize(100);
            if(RushHourMain.Score > ObstacleOrganizer.topScore){
                paint.setColor(Color.YELLOW);
            }
            paint.setTypeface(Typeface.defaultFromStyle((Typeface.BOLD)));
            g.drawText(""+RushHourMain.Score, RushHourMain.WIDTH - 120,
                    RushHourMain.HEIGHT / 2 - 780, paint);
        }


        if(CarListener.over == true ){ //game over
            drawGameOver(g);

        }

        if(CarListener.start == true){ //start of the game
            drawStart(g);
        }

    }


    private void drawGameOver(Canvas canvas){ //Game over window

        Paint paint = new Paint();

        paint.setColor(Color.WHITE);
        paint.setTextSize(80);
        paint.setTextAlign((Paint.Align.CENTER));
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        canvas.drawText("GAME OVER", RushHourMain.WIDTH/2 -10,
                RushHourMain.HEIGHT/2 - 400, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("Score: "+RushHourMain.Score, RushHourMain.WIDTH / 2 -10,
                RushHourMain.HEIGHT / 2 - 200 , paint);
        canvas.drawText("Top score: "+ObstacleOrganizer.topScore, RushHourMain.WIDTH / 2 -10,
                RushHourMain.HEIGHT / 2 - 100, paint);
    }

    private void drawStart(Canvas canvas){ //Start of the game window

        Paint paint = new Paint();


        paint.setColor(Color.BLACK);

        paint.setTextAlign((Paint.Align.CENTER));
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        paint.setTextSize(80);
        canvas.drawText("RUSH HOUR", RushHourMain.WIDTH/2 +5, RushHourMain.HEIGHT/2 - 500, paint);
        paint.setTextSize(45);
        canvas.drawText("You think you are the best driver out here?", RushHourMain.WIDTH/2 - 1,
                RushHourMain.HEIGHT / 2 - 300, paint);
        canvas.drawText("Drive your car by clicking on a different line to move",
                RushHourMain.WIDTH / 2 -10, RushHourMain.HEIGHT / 2 - 200 , paint);
        canvas.drawText( "One rule: DON'T CRASH!", RushHourMain.WIDTH/2 -10,
                RushHourMain.HEIGHT / 2 - 100, paint);

    }

}
