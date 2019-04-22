package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;


public class MainActivity extends DrawerActivity {

    private final String TAG = "Home";
    protected static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView botNavBar = findViewById(R.id.navigation_bottom);
        botNavBar.setOnNavigationItemSelectedListener(navListener);

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.fragment_container,
                new MainFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId())
                {
                    case R.id.nav_bot_home:
                        fragment = new MainFragment();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.nav_bot_exercises:
                        fragment = new ExercisesHomeActivity();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.nav_bot_nutrition:
                        fragment = new NutritionActivity();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.nav_bot_favorite:
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                }

                if(fragment != null)
                {
                    fm.beginTransaction().replace(R.id.fragment_container,
                            fragment).addToBackStack(null).commit();
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
