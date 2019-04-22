package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class NutritionActivity extends Fragment {

    private final String TAG = "Nutrition";
    private TextView tv_meter_subtitle;
    private TextView tv_meter_reading;
    private int caloriesCount = 0;
    private float dailyCalories = 2000;
    private String text_meter_subtitle = "Daily calories:\n" + caloriesCount + " / " + (int)dailyCalories;

    private ProgressBar iv_meter;
    private float percentage = 80.0f;
    private String percentageString;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nutrition_home, container, false);
        tv_meter_subtitle = (TextView) view.findViewById(R.id.nutrition_progressbar_meter_subtitle);
        tv_meter_reading = (TextView) view.findViewById(R.id.nutrition_progressbar_percentage);
        iv_meter = (ProgressBar) view.findViewById(R.id.nutrition_progressbar_meter);

        setNewMeter(); //randomly sets the calorie meter, implement actual use in the future
        iv_meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewMeter(); //for debug purposes. remove in the future
            }
        });

        Button addButton = (Button) view.findViewById(R.id.nutrition_button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DietHomeActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void setNewMeter()
    {
        Random rand = new Random();
        float rn = rand.nextInt(4000);

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

        if(percentage < 50.0 || percentage > 150.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_red), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 75.0 || percentage > 130.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_redorange), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 90.0 || percentage > 110.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_yellow), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 100.0 || percentage >= 100.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_darkgreen), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override
    public void onStart() {
        Log.i(TAG, "++ ON START ++");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "++ ON RESUME ++");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "++ ON PAUSE ++");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "++ ON STOP ++");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "++ ON DESTROY ++");
        super.onDestroy();
    }
}
