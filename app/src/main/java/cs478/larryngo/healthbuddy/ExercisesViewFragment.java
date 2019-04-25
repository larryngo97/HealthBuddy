package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ExercisesViewFragment extends ExercisesHomeFragment {

    private final String TAG = "Exercises View";

    private GridView gv;
    private TextView tv_header;
    private RelativeLayout rl_background;
    private String text_header = "NULL";
    private int KEY_USER_SELECTION;

    private ArrayList<String> exercise_names, exercise_difficulty, exercise_instructions, exercise_website;
    private ArrayList<Integer> exercise_images;

    protected static Integer EXTRA_EXERCISE_INFO_IMAGE;
    protected static String EXTRA_EXERCISE_INFO_HEADER;
    protected static String EXTRA_EXERCISE_INFO_DIFFICULTY;
    protected static String EXTRA_EXERCISE_INFO_INSTRUCTIONS;
    protected static String EXTRA_EXERCISE_INFO_WEBSITE;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exercises_view, container, false);
        tv_header = (TextView) view.findViewById(R.id.exercises_view_header);
        text_header = ExercisesHomeFragment.EXTRA_EXERCISE_HEADER;
        tv_header.setText(text_header);

        KEY_USER_SELECTION = ExercisesHomeFragment.EXTRA_EXERCISE_SELECTION;

        rl_background = view.findViewById(R.id.exercises_view_bg);
        Integer bg_image = ExercisesHomeFragment.exercise_backgrounds.get(EXTRA_EXERCISE_SELECTION - 1);
        rl_background.setBackgroundResource(bg_image);

        exercise_names = new ArrayList<String>();
        exercise_difficulty = new ArrayList<String>();
        exercise_instructions = new ArrayList<String>();
        exercise_website = new ArrayList<String>();
        exercise_images = new ArrayList<Integer>();

        switch(KEY_USER_SELECTION)
        {
            case 1: //chest
                exercise_names.add("Bench Press");
                exercise_images.add(R.drawable.gif_benchpress);
                exercise_difficulty.add("DIFFICULTY: 4/5");
                exercise_instructions.add(
                        "1. Begin by lying flat on the bench, with your body in a natural and relaxed position.\n\n" +
                                "2. Put your arms straight out to either side of you, and then bend your elbows, bringing your hands up to touch the bar.\n\n" +
                                "3. Begin with just the bar weight to warm up before heavy lifting.\n\n" +
                                "4. Rack the bar and add weight.\n\n" +
                                "5. Be sure to have a spotter to help you whenever you lift a heavy weight.\n\n" +
                                "6. Lift the bar up, slowly bring it down to just above your sternum, and explode upward for one rep.\n\n" +
                                "7. Drink plenty of water and take at least two minute breaks between each set.\n");
                exercise_website.add("https://www.wikihow.com/Bench-Press");


                exercise_names.add("Push-ups");
                exercise_images.add(R.drawable.gif_pushups);
                exercise_difficulty.add("DIFFICULTY: *");
                exercise_instructions.add(
                        "1. Assume a face-down prone position on the floor.\n\n" +
                                "2. Raise yourself using your arms.\n\n" +
                                "3. Pick the type of push up that works best for you: Regular, Diamond, Wide-arm\n");
                exercise_website.add("https://www.wikihow.com/Do-a-Push-Up");

                break;
            case 2: //shoulder
                exercise_names.add("Shoulder Press");
                exercise_images.add(R.drawable.gif_shoulderpress);
                exercise_difficulty.add("DIFFICULTY: 3/5");
                exercise_instructions.add(
                        "1. Stand up behind the bar.\n\n" +
                                "2. Pick up the bar.\n\n" +
                                "3. Roll your shoulder blades back and position your arms.\n\n" +
                                "4. Push the bar up over your head.\n\n" +
                                "5. Hold the bar.\n\n" +
                                "6. Bring the bar back down, gently.\n");
                exercise_website.add("https://www.wikihow.fitness/Do-Shoulder-Presses");

                exercise_names.add("Side Laterals");
                exercise_images.add(R.drawable.gif_side_laterals);
                exercise_difficulty.add("DIFFICULTY: 3/5");
                exercise_instructions.add(
                        "1. Choose your weights.\n\n" +
                                "2. Stand or sit with a dumbbell in each hand.\n\n" +
                                "3. Straighten your back and keep your chest out and open.\n\n" +
                                "4. Keep your chest up, with a slight bend in your elbows.\n\n" +
                                "5. Hold a dumbbell in both hands and at your sides.\n\n" +
                                "6. Raise the dumbbells out to the sides, just below shoulder-height.\n\n" +
                                "7. Hold the raise for two to three seconds with a slight bend in your elbow.\n\n" +
                                "8. Lower your arms slowly back to the start position.\n");
                exercise_website.add("https://www.wikihow.com/Do-a-Lateral-Raise");
                break;
            case 3: //arms
                exercise_names.add("Dumbbell Curl");
                exercise_images.add(R.drawable.gif_dumbbellcurl);
                exercise_difficulty.add("DIFFICULTY: 3/5");
                exercise_instructions.add(
                        "1. Position your feet.\n\n" +
                                "2. Pick up the dumbbells.\n\n" +
                                "3. Brace and align your torso.\n\n" +
                                "4. Bend your elbows slightly.\n\n" +
                                "5. Exhale.\n\n" +
                                "6. Lift the dumbbell.\n\n" +
                                "7. Hold and squeeze.\n\n" +
                                "8. Inhale.\n\n" +
                                "9. Lower the dumbbell.\n");
                exercise_website.add("https://www.wikihow.fitness/Do-Dumbbell-Hammer-Curls");


                exercise_names.add("Seated Dumbbell Press");
                exercise_images.add(R.drawable.gif_seated_dumbell_press);
                exercise_difficulty.add("DIFFICULTY: 3/5");
                exercise_instructions.add(
                        "1. Lie on a flat bench.\n\n" +
                                "2. Raise the dumbbells to your sides.\n\n" +
                                "3. Press the dumbbells up as you exhale.\n\n" +
                                "4. Lower the dumbbells slowly on an inhale.\n");
                exercise_website.add("https://www.wikihow.com/Dumbbell-Press");
                break;
            case 4: //legs
                exercise_names.add("Squats");
                exercise_images.add(R.drawable.gif_squats);
                exercise_difficulty.add("DIFFICULTY: 2/5");
                exercise_instructions.add(
                        "1. Plant your feet on the ground.\n\n" +
                                "2. Bend your knees.\n\n" +
                                "3. Lower yourself in a controlled manner.\n");
                exercise_website.add("https://www.wikihow.life/Do-a-Squat");

                exercise_names.add("Lunges");
                exercise_images.add(R.drawable.gif_lunges);
                exercise_difficulty.add("DIFFICULTY: 1/5");
                exercise_instructions.add(
                        "1. Start in a standing position.\n\n" +
                                "2. Take a big step forward with your right leg.\n\n" +
                                "3. Lower your body until your right knee is at a 90-degree angle.\n\n" +
                                "4. Push yourself upwards with your right foot.\n\n" +
                                "5. Repeat steps 1-4 with your left leg.\n");
                exercise_website.add("https://www.wikihow.com/Do-Lunges");
                break;
            default:
                break;
        }
        gv = (GridView)view.findViewById(R.id.exercises_view_gridView);
        gv.setAdapter(new ImageAdapter(getActivity(), exercise_names, exercise_images));
        registerForContextMenu(gv);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EXTRA_EXERCISE_INFO_IMAGE = exercise_images.get(position);
                EXTRA_EXERCISE_INFO_HEADER = exercise_names.get(position);
                EXTRA_EXERCISE_INFO_DIFFICULTY = exercise_difficulty.get(position);
                EXTRA_EXERCISE_INFO_INSTRUCTIONS = exercise_instructions.get(position);
                EXTRA_EXERCISE_INFO_WEBSITE = exercise_website.get(position);

                MainActivity.fm.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.fragment_container, new ExercisesInfoFragment()).addToBackStack(null).commit();
            }
        });
        return view;
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
