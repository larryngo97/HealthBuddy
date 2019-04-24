package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class ExercisesHomeFragment extends Fragment implements View.OnClickListener {

    private final String TAG = "Exercises Home";
    private CardView cv_chest, cv_shoulders, cv_arms, cv_legs;
    protected static String EXTRA_EXERCISE_HEADER = "NULL";
    protected static int EXTRA_EXERCISE_SELECTION = 0;
    protected static ArrayList<Integer> exercise_backgrounds = new ArrayList<Integer>(Arrays.asList(
            R.drawable.bg_chest, R.drawable.bg_shoulders, R.drawable.bg_arms, R.drawable.bg_legs));
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exercises_home, container, false);
        cv_chest = (CardView) view.findViewById(R.id.exercises_cv_chest);
        cv_shoulders = (CardView) view.findViewById(R.id.exercises_cv_shoulders);
        cv_arms = (CardView) view.findViewById(R.id.exercises_cv_arms);
        cv_legs = (CardView) view.findViewById(R.id.exercises_cv_legs);

        cv_chest.setOnClickListener(this);
        cv_shoulders.setOnClickListener(this);
        cv_arms.setOnClickListener(this);
        cv_legs.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        //Fragment fragment = new Fragment();
        //Bundle bundle = new Bundle();

        switch(id)
        {
            case R.id.exercises_cv_chest:
                EXTRA_EXERCISE_HEADER = "Chest";
                EXTRA_EXERCISE_SELECTION = 1;
                //bundle.putString("EXTRA_EXERCISE_HEADER", "Chest");
                //bundle.putInt("EXTRA_KEY_USER_SELECTION", 1);
                break;
            case R.id.exercises_cv_shoulders:
                EXTRA_EXERCISE_HEADER = "Shoulders";
                EXTRA_EXERCISE_SELECTION = 2;
                //bundle.putString("EXTRA_EXERCISE_HEADER", "Shoulders");
                //bundle.putInt("EXTRA_KEY_USER_SELECTION", 2);
                break;
            case R.id.exercises_cv_arms:
                EXTRA_EXERCISE_HEADER = "Arms";
                EXTRA_EXERCISE_SELECTION = 3;
                //bundle.putString("EXTRA_EXERCISE_HEADER", "Arms");
                //bundle.putInt("EXTRA_KEY_USER_SELECTION", 3);
                break;
            case R.id.exercises_cv_legs:
                EXTRA_EXERCISE_HEADER = "Legs";
                EXTRA_EXERCISE_SELECTION = 4;
                //bundle.putString("EXTRA_EXERCISE_HEADER", "Legs");
                //bundle.putInt("EXTRA_KEY_USER_SELECTION", 4);
                break;
            default:
                break;
        }
        //fragment.setArguments(bundle);

        MainActivity.fm.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.fragment_container, new ExercisesViewFragment()).addToBackStack(null).commit();


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