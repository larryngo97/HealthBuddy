package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tv_header_class;
        TextView tv_header_group;
        TextView tv_body_message;

        tv_header_class = (TextView) findViewById(R.id.about_header_classtitle);
        tv_header_group = (TextView) findViewById(R.id.about_header_groupnumber);
        tv_body_message = (TextView) findViewById(R.id.about_body_authors);

        tv_header_class.setText("CS422 SPR19");
        tv_header_group.setText("Group 12");
        tv_body_message.setText("Larry Ngo\n\nDarell Escofe\n\nDesiree Murray\n\nEric Huynh\n\nKevin Benitez");

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        int id = item.getItemId();

        switch(id)
        {
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
