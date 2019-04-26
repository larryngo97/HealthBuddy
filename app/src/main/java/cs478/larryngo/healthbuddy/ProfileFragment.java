package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private final String TAG = "Profile";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);


        TextView tv_profileName = (TextView) view.findViewById(R.id.profile_name);
        tv_profileName.setText(MainActivity.data_firstName + " " + MainActivity.data_lastName);

        TextView tv_profileOccupation = view.findViewById(R.id.profile_occupation);
        tv_profileOccupation.setText(MainActivity.data_occupation);

        TextView tv_profileDate = view.findViewById(R.id.profile_date);
        tv_profileDate.setText(MainActivity.data_date);

        ImageView iv_profilePicture = (ImageView) view.findViewById(R.id.profile_picture);
        iv_profilePicture.setImageResource(R.drawable.ic_profile_icon);

        ImageView iv_settings = (ImageView) view.findViewById(R.id.profile_icon_settings);
        iv_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SettingsFragment();
                MainActivity.fm.beginTransaction().setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_down, R.anim.slide_out_up)
                        .replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        Log.i(TAG, "++ ON START ++");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "++ ON RESUME ++");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "++ ON PAUSE ++");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "++ ON STOP ++");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "++ ON DESTROY ++");
        super.onDestroy();
    }
}
