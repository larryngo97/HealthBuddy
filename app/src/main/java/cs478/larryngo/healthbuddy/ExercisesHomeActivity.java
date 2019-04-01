package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ExercisesHomeActivity extends DrawerActivity implements View.OnClickListener {

    private final String TAG = "Exercises Home";
    private CardView cv_chest, cv_shoulders, cv_arms, cv_legs;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_home);

        cv_chest = (CardView) findViewById(R.id.exercises_cv_chest);
        cv_shoulders = (CardView) findViewById(R.id.exercises_cv_shoulders);
        cv_arms = (CardView) findViewById(R.id.exercises_cv_arms);
        cv_legs = (CardView) findViewById(R.id.exercises_cv_legs);

        cv_chest.setOnClickListener(this);
        cv_shoulders.setOnClickListener(this);
        cv_arms.setOnClickListener(this);
        cv_legs.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(getApplicationContext(), ExercisesViewActivity.class);

        switch(id)
        {
            case R.id.exercises_cv_chest:
                Toast.makeText(getApplicationContext(), "Clicked chest!", Toast.LENGTH_SHORT).show();
                intent.putExtra("EXTRA_EXERCISE_HEADER", "Chest");
                intent.putExtra("EXTRA_KEY_USER_SELECTION", 1);
                startActivity(intent);
                break;
            case R.id.exercises_cv_shoulders:
                Toast.makeText(getApplicationContext(), "Clicked shoulders!", Toast.LENGTH_SHORT).show();
                intent.putExtra("EXTRA_EXERCISE_HEADER", "Shoulders");
                intent.putExtra("EXTRA_KEY_USER_SELECTION", 2);
                startActivity(intent);
                break;
            case R.id.exercises_cv_arms:
                Toast.makeText(getApplicationContext(), "Clicked arms!", Toast.LENGTH_SHORT).show();
                intent.putExtra("EXTRA_EXERCISE_HEADER", "Arms");
                intent.putExtra("EXTRA_KEY_USER_SELECTION", 3);
                startActivity(intent);
                break;
            case R.id.exercises_cv_legs:
                Toast.makeText(getApplicationContext(), "Clicked legs!", Toast.LENGTH_SHORT).show();
                intent.putExtra("EXTRA_EXERCISE_HEADER", "Legs");
                intent.putExtra("EXTRA_KEY_USER_SELECTION", 4);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        int id = item.getItemId();

        switch(id)
        {
            case R.id.nav_home:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_exercises:
                break;
            case R.id.nav_nutrition:
                Toast.makeText(getApplicationContext(), "Clicked nutrition!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_achievements:
                Toast.makeText(getApplicationContext(), "Clicked achievements!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_schedule:
                Toast.makeText(getApplicationContext(), "Clicked schedule!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(), "Clicked schedule!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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