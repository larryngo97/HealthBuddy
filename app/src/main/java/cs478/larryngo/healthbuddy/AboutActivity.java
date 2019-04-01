package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends DrawerActivity implements NavigationView.OnNavigationItemSelectedListener{

    private final String TAG = "About";
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

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class); //starts up intent
        startActivity(intent); //starts the intent
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
