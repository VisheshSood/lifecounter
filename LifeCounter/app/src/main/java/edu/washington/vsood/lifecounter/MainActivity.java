package edu.washington.vsood.lifecounter;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;
import android.content.res.Resources;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int[] playerLives = {20, 20, 20, 20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When there is a change in rotation, the lives need to be updated to match
        //previous stored lives
        for (int i = 1; i <= playerLives.length; i++) {
           updateLives(i);
        }

        //Initialize the buttons and implement their on click listeners...
        List<Button> buttonList = new ArrayList<>();
        Button[][] buttonArray = new Button [4][4];

        for (int i = 1; i <= playerLives.length; i++) {
            Button one = (Button)findViewById(getResources().getIdentifier("p" + i + "m1", "id", getPackageName()));
            Button two = (Button)findViewById(getResources().getIdentifier("p" + i + "m5", "id", getPackageName()));;
            Button three  = (Button)findViewById(getResources().getIdentifier("p" + i + "a1", "id", getPackageName()));
            Button four = (Button)findViewById(getResources().getIdentifier("p" + i + "a5", "id", getPackageName()));

            one.setOnClickListener(new ButtonClickListener());
            two.setOnClickListener(new ButtonClickListener());
            three.setOnClickListener(new ButtonClickListener());
            four.setOnClickListener(new ButtonClickListener());

            buttonArray[i-1][0] = one;
            buttonArray[i-1][1] = two;
            buttonArray[i-1][2] = three;
            buttonArray[i-1][3] = four;


        }
    }

    //Need a helper method to make updating the player lives less redundant.
    private void updateLives(int playerID) {
        Resources r = getResources();
        ((TextView)findViewById(r.getIdentifier("life" + playerID,"id", getPackageName()))).setText("Life: " + Integer.toString(playerLives[playerID-1]));
    }

    //private class to make the button presses less redundant and maybe get extra credit for it...
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String tag = view.getResources().getResourceName(view.getId());
            tag = tag.substring(Math.max(tag.length() - 4, 0));
            int playerID = Integer.parseInt(tag.substring(1,2));
            String operation = tag.substring(2,3);
            int value = Integer.parseInt(tag.substring(3));
            if (operation.equals("a")) {
                playerLives[playerID - 1] += value;
            } else {
                playerLives[playerID - 1] -= value;
            }
            if (playerLives[playerID - 1] <= 0) {
                TextView loser = (TextView) findViewById(getResources().getIdentifier("loserTag", "id", getPackageName()));
                loser.setText("Player " + playerID + " LOSES!");
                loser.setVisibility(view.VISIBLE);
            }
            updateLives(playerID);
        }
    }
}
