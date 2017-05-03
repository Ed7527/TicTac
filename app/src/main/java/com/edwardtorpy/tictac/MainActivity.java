package com.edwardtorpy.tictac;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean redTurn;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningCombinations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropCoin(View view) {

        ImageView imageView = (ImageView) view;

        int position = Integer.valueOf(imageView.getTag().toString());

        if (gameState[position] == 2) {
            if (redTurn) {
                imageView.setImageResource(R.drawable.red);
                gameState[position] = 0;

                redTurn = false;
            } else {
                imageView.setImageResource(R.drawable.yellow);
                gameState[position] = 1;

                redTurn = true;
            }

            imageView.animate().alpha(1f).setDuration(300);
        }

        checkWin();

    }

    public void checkWin(){

        for (int[] winningCombo : winningCombinations ){

            if (gameState[winningCombo[0]] == gameState[winningCombo[1]]
                    && gameState[winningCombo[1]] == gameState[winningCombo[2]]
                    && gameState[winningCombo[0]] != 2){

                if (redTurn) {
                    //It has changed to red's turn but yellow has one so red doesn't get to play
                    Toast.makeText(this, "Yellow won", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Red won", Toast.LENGTH_SHORT).show();
                }
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

            gameState[i] = 2;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetBoard();
        redTurn = true;
    }
}
