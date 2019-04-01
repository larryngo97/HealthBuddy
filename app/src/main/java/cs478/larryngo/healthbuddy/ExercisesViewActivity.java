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
                    exercise_images.add(R.drawable.gif_benchpress_150x150);
                    exercise_difficulty.add("DIFFICULTY: ****");
                    exercise_instructions.add(
                            "1. Begin by lying flat on the bench, with your body in a natural and relaxed position.\n" +
                            "2. Put your arms straight out to either side of you, and then bend your elbows, bringing your hands up to touch the bar.\n" +
                            "3. Begin with just the bar weight to warm up before heavy lifting.\n" +
                            "4. Rack the bar and add weight.\n" +
                            "5. Be sure to have a spotter to help you whenever you lift a heavy weight.\n" +
                            "6. Lift the bar up, slowly bring it down to just above your sternum, and explode upward for one rep.\n" +
                            "7. Drink plenty of water and take at least two minute breaks between each set.");
                    exercise_website.add("https://www.wikihow.com/Bench-Press");


                    exercise_names.add("Push-ups");
                    exercise_images.add(R.drawable.gif_pushups_150x150);
                    exercise_difficulty.add("DIFFICULTY: *");
                    exercise_instructions.add(
                            "1. Assume a face-down prone position on the floor.\n" +
                            "2. Raise yourself using your arms.\n" +
                            "3. Pick the type of push up that works best for you: Regular, Diamond, Wide-arm");
                    exercise_website.add("https://www.wikihow.com/Do-a-Push-Up");

                    break;
                case 2: //shoulder
                    exercise_names.add("Shoulder Press");
                    exercise_images.add(R.drawable.gif_shoulderpress_150x150);
                    exercise_difficulty.add("DIFFICULTY: ***");
                    exercise_instructions.add(
                            "1. Stand up behind the bar.\n" +
                            "2. Pick up the bar.\n" +
                            "3. Roll your shoulder blades back and position your arms.\n" +
                            "4. Push the bar up over your head.\n" +
                            "5. Hold the bar.\n" +
                            "6. Bring the bar back down, gently.");
                    exercise_website.add("https://www.wikihow.fitness/Do-Shoulder-Presses");

                    exercise_names.add("Side Laterals");
                    exercise_images.add(R.drawable.gif_side_laterals_150x150);
                    exercise_difficulty.add("DIFFICULTY: ***");
                    exercise_instructions.add(
                            "1. Choose your weights.\n" +
                            "2. Stand or sit with a dumbbell in each hand.\n" +
                            "3. Straighten your back and keep your chest out and open.\n" +
                            "4. Keep your chest up, with a slight bend in your elbows.\n" +
                            "5. Hold a dumbbell in both hands and at your sides.\n" +
                            "6. Raise the dumbbells out to the sides, just below shoulder-height.\n" +
                            "7. Hold the raise for two to three seconds with a slight bend in your elbow.\n" +
                            "8. Lower your arms slowly back to the start position.");
                    exercise_website.add("https://www.wikihow.com/Do-a-Lateral-Raise");
                    break;
                case 3: //arms
                    exercise_names.add("Dumbbell Curl");
                    exercise_images.add(R.drawable.gif_dumbbellcurl_150x150);
                    exercise_difficulty.add("DIFFICULTY: ***");
                    exercise_instructions.add(
                            "1. Position your feet.\n" +
                            "2. Pick up the dumbbells.\n" +
                            "3. Brace and align your torso.\n" +
                            "4. Bend your elbows slightly.\n" +
                            "5. Exhale.\n" +
                            "6. Lift the dumbbell.\n" +
                            "7. Hold and squeeze.\n" +
                            "8. Inhale.\n" +
                            "9. Lower the dumbbell.");
                    exercise_website.add("https://www.wikihow.fitness/Do-Dumbbell-Hammer-Curls");


                    exercise_names.add("Seated Dumbbell Press");
                    exercise_images.add(R.drawable.gif_seated_dumbell_press_150x150);
                    exercise_difficulty.add("DIFFICULTY: ***");
                    exercise_instructions.add(
                            "1. Lie on a flat bench.\n" +
                            "2. Raise the dumbbells to your sides.\n" +
                            "3. Press the dumbbells up as you exhale.\n" +
                            "4. Lower the dumbbells slowly on an inhale.");
                    exercise_website.add("https://www.wikihow.com/Dumbbell-Press");
                    break;
                case 4: //legs
                    exercise_names.add("Squats");
                    exercise_images.add(R.drawable.gif_squats_150x150);
                    exercise_difficulty.add("DIFFICULTY: **");
                    exercise_instructions.add(
                            "1. Plant your feet on the ground.\n" +
                            "2. Bend your knees.\n" +
                            "3. Lower yourself in a controlled manner.");
                    exercise_website.add("https://www.wikihow.life/Do-a-Squat");

                    exercise_names.add("Lunges");
                    exercise_images.add(R.drawable.gif_lunges_150x150);
                    exercise_difficulty.add("DIFFICULTY: *");
                    exercise_instructions.add(
                            "1. Start in a standing position.\n" +
                            "2. Take a big step forward with your right leg.\n" +
                            "3. Lower your body until your right knee is at a 90-degree angle.\n" +
                            "4. Push yourself upwards with your right foot.\n" +
                            "5. Repeat steps 1-4 with your left leg.");
                    exercise_website.add("https://www.wikihow.com/Do-Lunges");
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
                    intent.putExtra("EXTRA_EXERCISE_INFO_DIFFICULTY", exercise_difficulty.get(position));
                    intent.putExtra("EXTRA_EXERCISE_INFO_INSTRUCTIONS", exercise_instructions.get(position));
                    intent.putExtra("EXTRA_EXERCISE_INFO_WEBSITE", exercise_website.get(position));
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
