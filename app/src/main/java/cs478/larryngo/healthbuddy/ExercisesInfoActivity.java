package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ExercisesInfoActivity extends AppCompatActivity {

    private final String TAG = "Exercises Info";
    private ImageView iv_exercise;
    private TextView tv_header;
    private TextView tv_difficulty;
    private TextView tv_instructions;
    private TextView tv_website;

    private String text_header;
    private String text_difficulty;
    private String text_instructions;
    private String text_website;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_info);

        iv_exercise = (ImageView) findViewById(R.id.exercises_info_image);
        tv_header = (TextView) findViewById(R.id.exercises_info_header);
        tv_difficulty = (TextView) findViewById(R.id.exercises_info_difficulty);
        tv_instructions = (TextView) findViewById(R.id.exercises_info_instructions);
        tv_website = (TextView) findViewById(R.id.exercises_info_learnmore);

        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
