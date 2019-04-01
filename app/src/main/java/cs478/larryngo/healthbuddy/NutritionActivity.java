package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NutritionActivity extends DrawerActivity{

    private final String TAG = "Nutrition";
    private TextView tv_meter_subtitle;
    private String text_meter_subtitle = "Daily calories: 1706 / 2000";

    private ImageView iv_meter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_home);

        tv_meter_subtitle = (TextView) findViewById(R.id.nutrition_image1_subtitle);
        tv_meter_subtitle.setText(text_meter_subtitle);

        iv_meter = (ImageView) findViewById(R.id.nutrition_image1);
        iv_meter.setImageResource(R.drawable.nutrition_circle_meter);

        Button addButton = (Button) findViewById(R.id.nutrition_button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DietHomeActivity.class);
                startActivity(intent);
            }
        });
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
