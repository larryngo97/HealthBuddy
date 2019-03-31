package cs478.larryngo.healthbuddy;

import android.os.Bundle;

public class ExercisesViewActivity extends DrawerActivity {

    private String activityLabel = "NULL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_view);
        setTitle(activityLabel + " Workouts"); //title of the activity
    }
}
