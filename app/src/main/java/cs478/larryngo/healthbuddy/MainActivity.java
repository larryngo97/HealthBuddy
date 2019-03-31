package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends DrawerActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private CardView cv_profile, cv_exercises, cv_nutrition, cv_achievements, cv_schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adds the views to the respective locations
        cv_profile = (CardView) findViewById(R.id.main_cv_profile);
        cv_exercises = (CardView) findViewById(R.id.main_cv_exercises);
        cv_nutrition = (CardView) findViewById(R.id.main_cv_nutrition);
        cv_achievements = (CardView) findViewById(R.id.main_cv_achievements);
        cv_schedule = (CardView) findViewById(R.id.main_cv_schedule);

        //sets on click listeners for each option
        cv_profile.setOnClickListener(this);
        cv_exercises.setOnClickListener(this);
        cv_nutrition.setOnClickListener(this);
        cv_achievements.setOnClickListener(this);
        cv_schedule.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;

        switch(id)
        {
            case R.id.main_cv_profile:
                Toast.makeText(MainActivity.this, "Clicked profile!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_cv_exercises:
                intent = new Intent(getApplicationContext(), ExercisesHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.main_cv_nutrition:
                Toast.makeText(MainActivity.this, "Clicked nutrition!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_cv_achievements:
                Toast.makeText(MainActivity.this, "Clicked achievements!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_cv_schedule:
                Toast.makeText(MainActivity.this, "Clicked schedule!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        int id = item.getItemId();
        switch(id)
        {
            case R.id.nav_home:
                break;
            case R.id.nav_exercises:
                intent = new Intent(getApplicationContext(), ExercisesHomeActivity.class);
                startActivity(intent);
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
}
