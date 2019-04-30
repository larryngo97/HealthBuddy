package cs478.larryngo.healthbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> icons;
    private List<String> name;


    public ImageAdapter(Context c, ArrayList<String> title, ArrayList<Integer> icons) {
        this.mContext = c;
        this.name = title;
        this.icons = icons;
    }

    public ImageAdapter(Context c, ArrayList<Integer> icons) {
        this.mContext = c;
        this.icons = icons;
    }

    public int getCount() {
        return icons.size();
    }

    public long getItemId(int position) {
        return icons.get(position);
    }

    public Object getItem(int id) //never needed
    {
        return null;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //grabs inflate info
            gridView = inflater.inflate(R.layout.gridview_exercises, null); //inflates the grid

        }
        ImageView iconView = gridView.findViewById(R.id.gv_item_image);
        TextView nameView = gridView.findViewById(R.id.gv_item_name);

        iconView.setImageResource(icons.get(position)); //sets the picture
        nameView.setText(name.get(position)); //displays the name of the phone to the grid

        return gridView;
    }

}