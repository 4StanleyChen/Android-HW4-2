package com.example.anley.hw4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityNotification extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(ActivityNotification.this);
        tv.setText("Greeting");
        setContentView(tv);
    }
}
