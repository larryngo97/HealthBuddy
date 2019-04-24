package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private final String TAG = "Home";
    protected static FragmentManager fm;
    BottomNavigationView botNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        botNavBar = findViewById(R.id.navigation_bottom);
        botNavBar.setOnNavigationItemSelectedListener(navListener);

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.fragment_container,
                new MainHomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId())
                {
                    case R.id.nav_bot_home:
                        fragment = new MainHomeFragment();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.nav_bot_exercises:
                        fragment = new ExercisesHomeFragment();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.nav_bot_nutrition:
                        fragment = new NutritionFragment();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.nav_bot_favorite:
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                }

                if(fragment != null)
                {
                    fm.beginTransaction().setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_down, R.anim.slide_out_up)
                            .replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
                }

                return true;
            }
        };



    @Override
    public void onBackPressed() {
        int backStackCount = fm.getBackStackEntryCount(); //gets count of the back stack
        if (backStackCount != 0) //if theres a current back stack
        {
            Log.i(TAG, "++ POPPING STACK ++");
            fm.popBackStack(); //pops the stack, reformats the layout //pops the back stack to 0
            Log.i(TAG, "++ CURRENT BACK STACK COUNT: " + backStackCount + " ++");

            if(backStackCount == 1)
            {
                Log.i(TAG, "Setting to home");
                botNavBar.getMenu().getItem(0).setChecked(true);
            }
        }
        else
        {
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
