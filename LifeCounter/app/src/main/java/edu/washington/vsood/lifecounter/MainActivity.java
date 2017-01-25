package edu.washington.vsood.lifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int playerCount;
    View.OnClickListener listener;
    Button[][] btns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
