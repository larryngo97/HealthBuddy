package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class NutritionDietFragment extends Fragment {

    private GridView gv;
    private ArrayList<String> dietNames = new ArrayList<String>(Arrays.asList("Ketogenic", "Vegan", "Paleo"));
    private ArrayList<Integer> dietIcons = new ArrayList<Integer>(Arrays.asList(R.drawable.ic_keto, R.drawable.ic_vegan, R.drawable.ic_paleo));

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nutrition_diet, container, false);

        gv = (GridView)view.findViewById(R.id.diet_gridView);
        gv.setAdapter(new ImageAdapter(getActivity(), dietNames, dietIcons));
        registerForContextMenu(gv);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NutritionDietViewFragment.class);
                intent.putExtra("EXTRA_DIET_VIEW_NAME", dietNames.get(position));
                intent.putExtra("EXTRA_DIET_VIEW_POSITION", position);
                startActivity(intent);
            }
        });

        return view;
    }
}
