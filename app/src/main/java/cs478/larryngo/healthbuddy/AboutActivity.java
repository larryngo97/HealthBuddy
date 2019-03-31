package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

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
}
