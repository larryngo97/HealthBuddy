package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingsFragment extends Fragment{
    private final String TAG = "Settings";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_settings, container, false);

        TextView tv_header = view.findViewById(R.id.app_bar_header);
        tv_header.setText("Settings");

        LinearLayout layout_name = view.findViewById(R.id.settings_layout_name);
        TextView tv_name = view.findViewById(R.id.settings_text_name);
        tv_name.setText(MainActivity.data_firstName + " " + MainActivity.data_lastName);
        Button btn_name = view.findViewById(R.id.settings_button_name);
        btn_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogName dialogName = new DialogName();
                dialogName.show(MainActivity.fm, "Name Dialog");
            }
        });

        LinearLayout layout_email = view.findViewById(R.id.settings_layout_email);
        TextView tv_email = view.findViewById(R.id.settings_text_email);
        tv_email.setText(MainActivity.data_email);
        Button btn_email = view.findViewById(R.id.settings_button_email);
        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogEmail dialogEmail = new DialogEmail();
                dialogEmail.show(MainActivity.fm, "Email Dialog");
            }
        });

        LinearLayout layout_password = view.findViewById(R.id.settings_layout_password);
        TextView tv_password = view.findViewById(R.id.settings_text_password);
        Button btn_password = view.findViewById(R.id.settings_button_password);
        btn_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPassword dialogPassword = new DialogPassword();
                dialogPassword.show(MainActivity.fm, "Password Dialog");
            }
        });

        LinearLayout layout_occupation = view.findViewById(R.id.settings_layout_occupation);
        TextView tv_occupation = view.findViewById(R.id.settings_text_occupation);
        tv_occupation.setText(MainActivity.data_occupation);
        Button btn_occupation = view.findViewById(R.id.settings_button_occupation);
        btn_occupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogOccupation dialogOccupation = new DialogOccupation();
                dialogOccupation.show(MainActivity.fm, "Occupation Dialog");
            }
        });

        LinearLayout layout_height = view.findViewById(R.id.settings_layout_height);
        TextView tv_height = view.findViewById(R.id.settings_text_height);
        tv_height.setText(MainActivity.data_height_ft + " ft. " + MainActivity.data_height_in + " in.");
        Button btn_height = view.findViewById(R.id.settings_button_height);
        btn_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHeight dialogHeight = new DialogHeight();
                dialogHeight.show(MainActivity.fm, "Height Dialog");
            }
        });

        LinearLayout layout_weight = view.findViewById(R.id.settings_layout_weight);
        TextView tv_weight = view.findViewById(R.id.settings_text_weight);
        tv_weight.setText(MainActivity.data_weight + " lbs.");
        Button btn_weight = view.findViewById(R.id.settings_button_weight);
        btn_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogWeight dialogWeight = new DialogWeight();
                dialogWeight.show(MainActivity.fm, "Height Dialog");
            }
        });

        LinearLayout layout_calories = view.findViewById(R.id.settings_layout_calories);
        TextView tv_calories = view.findViewById(R.id.settings_text_calories);
        tv_calories.setText("Calorie limit: " + MainActivity.data_caloriesLimit + " kcal");
        Button btn_calories = view.findViewById(R.id.settings_button_calories);
        btn_calories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCalories dialogCalories = new DialogCalories();
                dialogCalories.show(MainActivity.fm, "Calories Dialog");
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
