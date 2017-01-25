package edu.washington.vsood.lifecounter;

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

        }
    }
}
