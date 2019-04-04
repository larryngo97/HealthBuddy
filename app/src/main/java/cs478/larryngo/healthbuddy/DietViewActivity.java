package cs478.larryngo.healthbuddy;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class DietViewActivity extends DrawerActivity {

    private final String TAG = "Diet View";


    private ArrayList<Integer> dietInfographic = new ArrayList<Integer>(Arrays.asList(R.drawable.diet_infographic_keto,
            R.drawable.diet_infographic_vegan, R.drawable.diet_infographic_paleo));

    private ImageView iv_image;
    private TextView tv_header;
    private String text_header;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        tv_header = (TextView) findViewById(R.id.image_layout_header);
        iv_image = (ImageView) findViewById(R.id.image_layout_image);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            text_header = extras.getString("EXTRA_DIET_VIEW_NAME");
            tv_header.setText(text_header);

            position = extras.getInt("EXTRA_DIET_VIEW_POSITION");
            iv_image.setImageResource(dietInfographic.get(position));
        }
    }
}
