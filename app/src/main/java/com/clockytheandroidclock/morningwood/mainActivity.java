package com.clockytheandroidclock.morningwood;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.widget.TextView;
import android.content.Context;
import android.widget.Button;

import java.util.Calendar;

public class mainActivity extends AppCompatActivity {

    //Make our alarm manager

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.context = this;

        //initialize alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initialize our timepicker
        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);

        //initialize text update box
        update_text = (TextView) findViewById(R.id.update_text);

        //create instance of a calendar
        final Calendar calendar = Calendar.getInstance();

        Button startAlarm = (Button) findViewById(R.id.Alarm_On);

        //make an onclick listener
        startAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getCurrentMinute());

                int hour = alarm_timepicker.getCurrentHour();
                int minute = alarm_timepicker.getCurrentMinute();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                //method that changes the update text
                set_alarm_text("Alarm On");
            }
        });

        Button endAlarm = (Button) findViewById(R.id.Alarm_Off);

        //make an onclick listener
        endAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //method that changes the update text
                //TODO: Temporary use that btn to move to QuizActivity
                //set_alarm_text("Alarm Off");
                doQuiz();
            }
        });


    }

    private void set_alarm_text(String output){
        update_text.setText(output);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doQuiz() {
        Intent intent = new Intent(mainActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}
