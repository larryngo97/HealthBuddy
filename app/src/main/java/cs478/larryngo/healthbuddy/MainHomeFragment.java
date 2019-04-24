package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainHomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        TextView tv_layer1_statistics = (TextView) view.findViewById(R.id.home_statistics);
        tv_layer1_statistics.setText(
                "     -- Today's Summary -- \n" +
                "Total Calories: 0/2000 (0.00%)\n" +
                "Average heart rate: 89 BPM\n" +
                "Current Weight: 120 lbs\n" +
                "Workout duration: 48 minutes");
        return view;
    }
}
