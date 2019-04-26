package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_settings, container, false);

        TextView tv_header = view.findViewById(R.id.app_bar_header);
        tv_header.setText("Settings");

        ImageView iv_back = view.findViewById(R.id.app_bar_backarrow);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.popBackStack();
            }
        });

        LinearLayout layout_name = view.findViewById(R.id.settings_layout_name);
        TextView tv_name = view.findViewById(R.id.settings_text_name);
        tv_name.setText(MainActivity.data_firstName + " " + MainActivity.data_lastName);

        LinearLayout layout_email = view.findViewById(R.id.settings_layout_email);
        TextView tv_email = view.findViewById(R.id.settings_text_email);
        tv_email.setText(MainActivity.data_email);

        LinearLayout layout_password = view.findViewById(R.id.settings_layout_password);
        TextView tv_password = view.findViewById(R.id.settings_text_password);

        LinearLayout layout_height = view.findViewById(R.id.settings_layout_height);
        TextView tv_height = view.findViewById(R.id.settings_text_height);
        tv_height.setText(MainActivity.data_height_ft + " ft. " + MainActivity.data_height_in + " in.");

        LinearLayout layout_weight = view.findViewById(R.id.settings_layout_weight);
        TextView tv_weight = view.findViewById(R.id.settings_text_weight);
        tv_weight.setText(MainActivity.data_weight + " lbs.");

        LinearLayout layout_calories = view.findViewById(R.id.settings_layout_calories);
        TextView tv_calories = view.findViewById(R.id.settings_text_calories);
        tv_calories.setText("Calorie limit: " + MainActivity.data_caloriesLimit + " kcal");

        LinearLayout layout_occupation = view.findViewById(R.id.settings_layout_occupation);
        TextView tv_occupation = view.findViewById(R.id.settings_text_occupation);
        tv_occupation.setText(MainActivity.data_occupation);
        return view;
    }
}
