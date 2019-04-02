package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class NutritionActivity extends DrawerActivity{

    private final String TAG = "Nutrition";
    private TextView tv_meter_subtitle;
    private TextView tv_meter_reading;
    private int caloriesCount = 0;
    private float dailyCalories = 2000;
    private String text_meter_subtitle = "Daily calories:\n" + caloriesCount + " / " + (int)dailyCalories;

    private ProgressBar iv_meter;
    private float percentage = 80.0f;
    private String percentageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_home);

        tv_meter_subtitle = (TextView) findViewById(R.id.nutrition_progressbar_meter_subtitle);
        tv_meter_reading = (TextView) findViewById(R.id.nutrition_progressbar_percentage);
        iv_meter = (ProgressBar) findViewById(R.id.nutrition_progressbar_meter);
        setNewMeter(); //randomly sets the calorie meter, implement actual use in the future
        iv_meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewMeter(); //for debug purposes. remove in the future
            }
        });

        Button addButton = (Button) findViewById(R.id.nutrition_button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DietHomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setNewMeter()
    {
        Random rand = new Random();
        float rn = rand.nextInt(3001);

        percentage = (rn / dailyCalories) * 100;

        caloriesCount = (int)rn;
        text_meter_subtitle = "Daily calories:\n" + caloriesCount + " / " + (int)dailyCalories;
        tv_meter_subtitle.setText(text_meter_subtitle);

        Log.i(TAG, "Percentage: " + percentage);
        percentageString = String.format(Locale.US, "%.2f", percentage) + "%";

        if(percentage > 100.0)
        {
            tv_meter_reading.setTextSize(28);
        }
        else
        {
            tv_meter_reading.setTextSize(32);
        }

        tv_meter_reading.setText(percentageString);
        iv_meter.setProgress((int)percentage);

        if(percentage < 25.0 || percentage > 175.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_red), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 50.0 || percentage > 150.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_redorange), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 75.0 || percentage > 125.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_yellow), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 100.0 || percentage >= 100.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_neongreen), PorterDuff.Mode.SRC_IN);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class); //starts up intent
        startActivity(intent); //starts the intent
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "++ ON START ++");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "++ ON RESUME ++");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "++ ON PAUSE ++");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "++ ON STOP ++");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "++ ON DESTROY ++");
        super.onDestroy();
    }
}
