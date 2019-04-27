package cs478.larryngo.healthbuddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class NutritionFoodFragment extends Fragment {

    private final String TAG = "Nutrition";
    private Context context;
    private TextView tv_meter_subtitle;
    private TextView tv_meter_reading;
    private int caloriesConsumed;
    private float caloriesLimit = MainActivity.data_caloriesLimit;
    private String text_meter_subtitle;

    private ProgressBar iv_meter;
    private float percentage = 80.0f;
    private String percentageString;

    BarChart barChart;
    ArrayList<String> dates;
    ArrayList<BarEntry> entries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nutrition_food, container, false);
        context = getContext();

        tv_meter_subtitle = (TextView) view.findViewById(R.id.nutrition_progressbar_meter_subtitle);
        tv_meter_reading = (TextView) view.findViewById(R.id.nutrition_progressbar_percentage);
        iv_meter = (ProgressBar) view.findViewById(R.id.nutrition_progressbar_meter);
        barChart = (BarChart) view.findViewById(R.id.nutrition_graph);

        TextView tv_meter_circle_red = view.findViewById(R.id.nutrition_progressbar_legend_text_red);
        tv_meter_circle_red.setText("< 50% or > 150%");

        TextView tv_meter_circle_orange = view.findViewById(R.id.nutrition_progressbar_legend_text_orange);
        tv_meter_circle_orange.setText("< 75% or > 125%");

        TextView tv_meter_circle_yellow = view.findViewById(R.id.nutrition_progressbar_legend_text_yellow);
        tv_meter_circle_yellow.setText("< 90% or > 110%");

        TextView tv_meter_circle_green = view.findViewById(R.id.nutrition_progressbar_legend_text_green);
        tv_meter_circle_green.setText("> 90% or < 110%");

        caloriesConsumed = MainActivity.data_caloriesConsumed;
        setNewMeter(0); //sets the calorie meter, implement actual use in the future

        iv_meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewMeter(1); //for debug purposes. remove in the future
            }
        });

        Button addButton = (Button) view.findViewById(R.id.nutrition_button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NutritionDietFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter {
        private String[] mValues;
        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return mValues[(int) value];
        }
    }

    public void barSetData()
    {
        barChart.clear();
        barChart.getDescription().setEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setFitBars(true);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 1925)); //sunday
        entries.add(new BarEntry(1, 2295)); //monday
        entries.add(new BarEntry(2, caloriesConsumed)); //tuesday
        entries.add(new BarEntry(3, 0)); //wednesday
        entries.add(new BarEntry(4, 0)); //thursday
        entries.add(new BarEntry(5, 0)); //friday
        entries.add(new BarEntry(6, 0)); //saturday

        BarDataSet set = new BarDataSet(entries, "Days");

        String[] chartDays = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        XAxis xAxis = barChart.getXAxis();
        YAxis yAxis = barChart.getAxisLeft();

        xAxis.setValueFormatter(new MyXAxisValueFormatter(chartDays));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(16f);
        xAxis.setTextColor(Color.WHITE);

        yAxis.setAxisMinimum(0);
        yAxis.setTextSize(16f);
        yAxis.setTextColor(Color.WHITE);
        barChart.getAxisRight().setEnabled(false);


        int[] barColors = new int[] {R.color.color_lightblue, R.color.color_lightblue, R.color.color_lightgreen,
                R.color.color_lightblue, R.color.color_lightblue, R.color.color_lightblue, R.color.color_lightblue,};

        set.setValueTextSize(16f);
        set.setValueTextColor(Color.WHITE);
        set.setColors(barColors, context);
        set.setDrawValues(true);

        Legend legend = barChart.getLegend();
        legend.setTextColor(Color.WHITE);
        legend.setTextSize(16f);

        BarData data = new BarData(set);
        barChart.setData(data);
        barChart.invalidate();
        barChart.animateY(500);
    }

    public void setNewMeter(int random)
    {
        caloriesConsumed = MainActivity.data_caloriesConsumed;
        if(random == 1)
        {
            Random rand = new Random();
            caloriesConsumed = rand.nextInt((int)caloriesLimit * 2);
        }

        percentage = (caloriesConsumed / caloriesLimit) * 100;
        text_meter_subtitle = "Daily calories:\n" + caloriesConsumed + " / " + (int)caloriesLimit;
        tv_meter_subtitle.setText(text_meter_subtitle);

        Log.i(TAG, "Percentage: " + percentage);
        percentageString = String.format(Locale.US, "%.2f", percentage) + "%";

        tv_meter_reading.setText(percentageString);
        iv_meter.setProgress((int)percentage);

        if(percentage < 50.0 || percentage > 150.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_red), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 75.0 || percentage > 125.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_redorange), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 90.0 || percentage > 110.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_yellow), PorterDuff.Mode.SRC_IN);
        }
        else if(percentage < 100.0 || percentage >= 100.0)
        {
            iv_meter.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_darkgreen), PorterDuff.Mode.SRC_IN);
        }

        barSetData();
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
