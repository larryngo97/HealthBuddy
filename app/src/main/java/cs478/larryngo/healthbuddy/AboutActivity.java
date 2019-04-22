package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends Fragment{

    private final String TAG = "About";
    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_about, container, false);
        TextView tv_header_class;
        TextView tv_header_group;
        TextView tv_body_message;

        tv_header_class = (TextView) view.findViewById(R.id.about_header_classtitle);
        tv_header_group = (TextView) view.findViewById(R.id.about_header_groupnumber);
        tv_body_message = (TextView) view.findViewById(R.id.about_body_authors);

        tv_header_class.setText("CS422 SPR19");
        tv_header_group.setText("Group 12");
        tv_body_message.setText("Larry Ngo\n\nDarell Escofe\n\nDesiree Murray\n\nEric Huynh\n\nKevin Benitez");
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
