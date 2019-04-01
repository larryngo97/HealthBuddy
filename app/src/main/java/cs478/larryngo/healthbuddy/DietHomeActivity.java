package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;
import java.util.Arrays;

public class DietHomeActivity extends DrawerActivity {

    private GridView gv;
    private ArrayList<String> dietNames = new ArrayList<String>(Arrays.asList("Ketogenic", "Vegan", "Paleo"));
    private ArrayList<Integer> dietIcons = new ArrayList<Integer>(Arrays.asList(R.drawable.ic_keto, R.drawable.ic_vegan, R.drawable.ic_paleo));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_diet);

        gv = (GridView)findViewById(R.id.diet_gridView);
        gv.setAdapter(new ImageAdapter(getApplicationContext(), dietNames, dietIcons));
        registerForContextMenu(gv);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DietViewActivity.class);
                intent.putExtra("EXTRA_DIET_VIEW_NAME", dietNames.get(position));
                intent.putExtra("EXTRA_DIET_VIEW_POSITION", position);
                startActivity(intent);
            }
        });
    }
}
