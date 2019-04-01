package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends DrawerActivity{

    private final String TAG = "Profile";
    private String text_profileName = "Larry Ngo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tv_profileName = (TextView) findViewById(R.id.profile_name);
        tv_profileName.setText(text_profileName);

        ImageView iv_profilePicture = (ImageView) findViewById(R.id.profile_picture);
        iv_profilePicture.setImageResource(R.drawable.ic_profile_icon);
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
