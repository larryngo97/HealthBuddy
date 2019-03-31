package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

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
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        int id = item.getItemId();

        switch(id) //default choices. Replace them in actual activities
        {
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(), "Clicked home!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_exercises:
                Toast.makeText(getApplicationContext(), "Clicked exercises!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "Clicked about!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
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
}
