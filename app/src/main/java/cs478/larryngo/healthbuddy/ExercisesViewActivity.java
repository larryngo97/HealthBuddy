package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExercisesViewActivity extends DrawerActivity {

    private final String TAG = "Exercises View";

    private GridView gv;
    private TextView tv_header;
    private String text_header = "NULL";
    private int KEY_USER_SELECTION;

    private ArrayList<String> exercise_names, exercise_difficulty, exercise_instructions, exercise_website;
    private ArrayList<Integer> exercise_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_view);
        tv_header = (TextView) findViewById(R.id.exercises_view_header);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            text_header = extras.getString("EXTRA_EXERCISE_HEADER");
            tv_header.setText(text_header);

            KEY_USER_SELECTION = extras.getInt("EXTRA_KEY_USER_SELECTION");
            exercise_names = new ArrayList<String>();
            exercise_difficulty = new ArrayList<String>();
            exercise_instructions = new ArrayList<String>();
            exercise_website = new ArrayList<String>();
            exercise_images = new ArrayList<Integer>();

            switch(KEY_USER_SELECTION)
            {
                case 1: //chest
                    exercise_names.add("Bench Press");
                    exercise_names.add("Push-ups");
                    exercise_images.add(R.drawable.gif_benchpress_150x150);
                    exercise_images.add(R.drawable.gif_pushups_150x150);
                    exercise_difficulty.add("***");
                    break;
                case 2: //shoulder
                    exercise_names.add("Shoulder Press");
                    exercise_names.add("Side Laterals");
                    exercise_images.add(R.drawable.gif_shoulderpress_150x150);
                    exercise_images.add(R.drawable.gif_side_laterals_150x150);
                    break;
                case 3: //arms
                    exercise_names.add("Dumbbell Curl");
                    exercise_names.add("Seated Dumbbell Press");
                    exercise_images.add(R.drawable.gif_dumbbellcurl_150x150);
                    exercise_images.add(R.drawable.gif_seated_dumbell_press_150x150);
                    break;
                case 4: //legs
                    exercise_names.add("Squats");
                    exercise_names.add("Lunges");
                    exercise_images.add(R.drawable.gif_squats_150x150);
                    exercise_images.add(R.drawable.gif_lunges_150x150);
                    break;
                default:
                    break;
            }
            gv = (GridView)findViewById(R.id.exercises_gridView);
            gv.setAdapter(new ImageAdapter(getApplicationContext(), exercise_names, exercise_images));
            registerForContextMenu(gv);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent (getApplicationContext(), ExercisesInfoActivity.class);
                    intent.putExtra("EXTRA_EXERCISE_INFO_IMAGE", exercise_images.get(position));
                    intent.putExtra("EXTRA_EXERCISE_INFO_HEADER", exercise_names.get(position));
                    startActivity(intent);
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
