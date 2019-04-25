package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private final String TAG = "Navigation Drawer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View drawerHeader = navigationView.getHeaderView(0);
        ImageView profile = (ImageView) drawerHeader.findViewById(R.id.nav_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If current activity = the profile activity, then just close the drawer, do not start a new profile activity
                if(DrawerActivity.this.getClass().getSimpleName().equals(ProfileFragment.class.getSimpleName()))
                {
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); //finds drawer
                    if (drawer.isDrawerOpen(GravityCompat.START)) //if the drawer is open
                    {
                        drawer.closeDrawer(GravityCompat.START); //close the drawer
                    }
                }
                else //start profile activity
                {
                    Intent intent = new Intent(getApplicationContext(), ProfileFragment.class);
                    startActivity(intent);
                }
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;

        Fragment fragment = null;
        FragmentManager fm = MainActivity.fm;
        int id = item.getItemId();
        switch(id)
        {
            case R.id.nav_home:
                fragment = new MainHomeFragment();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.nav_exercises:
                fragment = new ExercisesHomeFragment();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.nav_nutrition:
                fragment = new NutritionFoodFragment();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.nav_achievements:
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.nav_schedule:
                Toast.makeText(getApplicationContext(), "Clicked schedule!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(), "Clicked settings!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                fragment = new AboutFragment();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            default:
                break;
        }

        if(fragment != null)
        {
            fm.beginTransaction().replace(R.id.fragment_container,
                    fragment).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
