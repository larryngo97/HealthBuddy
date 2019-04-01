package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ExercisesInfoActivity extends DrawerActivity {

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
            iv_exercise.setImageResource(extras.getInt("EXTRA_EXERCISE_INFO_IMAGE"));
            text_header = extras.getString("EXTRA_EXERCISE_INFO_HEADER");
            text_difficulty = extras.getString("EXTRA_EXERCISE_INFO_DIFFICULTY");
            text_instructions = extras.getString("EXTRA_EXERCISE_INFO_INSTRUCTIONS");
            text_website = extras.getString("EXTRA_EXERCISE_INFO_WEBSITE");

            tv_header.setText(text_header);
            tv_difficulty.setText(text_difficulty);
            tv_instructions.setText(text_instructions);
            tv_website.setText(text_website);

            tv_website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(text_website));
                    startActivity(browser);
                }
            });
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
