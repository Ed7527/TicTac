package com.edwardtorpy.tictac;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean redTurn;
    int[][] gameState;

    public void dropCoin(View view) {



        ImageView imageView = (ImageView) view;

        if (redTurn) {
            imageView.setImageResource(R.drawable.red);

            redTurn = false;
        } else {
            imageView.setImageResource(R.drawable.yellow);

            redTurn = true;
        }

        imageView.animate().alpha(1f).setDuration(1000);

    }

    public void resetGameState(){

        for (int gameStateColumn = 0; gameStateColumn < 3; gameStateColumn++) {

            for (int gameStateRow = 0; gameStateRow < 3; gameStateRow++) {

                gameState[gameStateColumn][gameStateRow] = 2;

            }

        }

    }

    public void resetButton(View view){

        resetBoard();

    }

    public void resetBoard(){


        for (int i =0; i < 9 ; i++) {
            int imageViewID = getResources().getIdentifier("imageView" + i, "id", getPackageName());

            ImageView imageView = (ImageView) findViewById(imageViewID);
            imageView.setAlpha(0f);
        }

        //Toast.makeText(this, imageView.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetBoard();
        redTurn = true;
    }
}
