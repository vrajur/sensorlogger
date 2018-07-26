package com.example.vinay.sensorlogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MySensorHandler sensorHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorHandler = new MySensorHandler();
        sensorHandler.initializeSensors(this);
        MainActivityButtonSetup.setup(this);

        // Toggle Start Button:
        ((Button) findViewById(R.id.button)).performClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            sensorHandler.stopLogging(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
