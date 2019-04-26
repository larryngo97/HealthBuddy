package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static cs478.larryngo.healthbuddy.MainActivity.data_firstName;

public class MainHomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        TextView home_welcome = view.findViewById(R.id.home_header_welcome);
        home_welcome.setText ("Welcome back, " + MainActivity.data_firstName + "!");

        TextView home_weight = view.findViewById(R.id.home_text_scale);
        home_weight.setText(MainActivity.data_weight + " lbs.");

        ImageView iv_profile = view.findViewById(R.id.home_icon_profile);
        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ProfileFragment();
                MainActivity.fm.beginTransaction().setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_down, R.anim.slide_out_up)
                        .replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
            }
        });
        return view;
    }
}
