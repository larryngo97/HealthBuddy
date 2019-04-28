package cs478.larryngo.healthbuddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
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

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class NutritionFoodFragment extends Fragment {

    private final String TAG = "Nutrition";
    private Context context;
    private int caloriesConsumed;
    private float caloriesLimit = MainActivity.data_caloriesLimit;

    private final double RED_LOW = 50.0;
    private final double RED_HIGH = 150.0;

    private final double ORANGE_LOW = 75.0;
    private final double ORANGE_HIGH = 125.0;

    private final double YELLOW_LOW = 90.0;
    private final double YELLOW_HIGH = 110.0;

    private int[] barColors = new int[] {R.color.color_red, R.color.color_redorange, R.color.color_yellow, R.color.color_darkgreen};
    private int[] pieColors = new int[] {R.color.color_purple, R.color.color_magenta, R.color.color_lightgreen};

    private CircularProgressBar pb_meter;
    private TextView tv_meter_subtitle;
    private String text_meter_subtitle;
    private TextView tv_meter_reading;
    private float percentage = 80.0f;
    private String percentageString;

    BarChart barChart;
    ArrayList<String> dates;
    ArrayList<BarEntry> entries;

    private PieChart pc_meter;
    private TextView pc_label_fats;
    private TextView pc_label_protein;
    private TextView pc_label_carbs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nutrition_food, container, false);
        context = getContext();

        tv_meter_subtitle = (TextView) view.findViewById(R.id.nutrition_progressbar_meter_subtitle);
        tv_meter_reading = (TextView) view.findViewById(R.id.nutrition_progressbar_percentage);
        pb_meter = (CircularProgressBar) view.findViewById(R.id.nutrition_progressbar_meter);
        barChart = (BarChart) view.findViewById(R.id.nutrition_graph);

        caloriesConsumed = MainActivity.data_caloriesConsumed;

        pb_meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewMeter(1); //for debug purposes. remove in the future
            }
        });

        pc_meter = (PieChart) view.findViewById(R.id.nutrition_progressbar_piechart);
        pc_label_fats = (TextView) view.findViewById(R.id.nutrition_piechart_text_fats);
        pc_label_protein = (TextView) view.findViewById(R.id.nutrition_piechart_text_protein);
        pc_label_carbs = (TextView) view.findViewById(R.id.nutrition_piechart_text_carbs);

        setNewMeter(0); //sets the calorie meter, implement actual use in the future
        return view;
    }

    public int getColor(double numerator, double denominator)
    {
        double percentage = (numerator / denominator) * 100.0;
        if(percentage < RED_LOW || percentage > RED_HIGH)
            return barColors[0];
        else if(percentage < ORANGE_LOW || percentage > ORANGE_HIGH)
            return barColors[1];
        else if(percentage < YELLOW_LOW || percentage > YELLOW_HIGH)
            return barColors[2];
        else
            return barColors[3];
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

    public void pieSetData()
    {
        int fats = MainActivity.data_calories_fats;
        int protein = MainActivity.data_calories_protein;
        int carbs = MainActivity.data_calories_carbs;

        //pc_meter.setUsePercentValues(true);
        pc_meter.getDescription().setEnabled(false);
        pc_meter.getLegend().setEnabled(false);
        pc_meter.setExtraOffsets(5, 10, 5, 5);
        pc_meter.setDragDecelerationFrictionCoef(0.95f);
        pc_meter.setDrawHoleEnabled(true);
        pc_meter.setHoleColor(Color.WHITE);
        pc_meter.setTransparentCircleRadius(60f);
        pc_meter.setDrawEntryLabels(false);
        pc_meter.setDrawCenterText(true);
        pc_meter.setCenterTextSize(14f);
        pc_meter.setCenterTextTypeface(Typeface.MONOSPACE);
        //pc_meter.setCenterText("Calorie Breakdown");
        pc_meter.animateY(1000, Easing.EaseInOutCubic);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(fats, "Fats"));
        yValues.add(new PieEntry(protein, "Protein"));
        yValues.add(new PieEntry(carbs, "Carbs"));

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(pieColors, context);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(16f);
        data.setValueTextColor(ContextCompat.getColor(getContext(), R.color.color_white));
        pc_meter.setData(data);

        float calorieTotal = fats + protein + carbs;
        String fatPercentage = String.format(Locale.US, "%.1f", fats / calorieTotal * 100);
        String proteinPercentage = String.format(Locale.US, "%.1f", protein / calorieTotal * 100);
        String carbsPercentage = String.format(Locale.US, "%.1f", carbs / calorieTotal * 100);
        pc_label_fats.setText("Fats: " + fatPercentage + "%");
        pc_label_protein.setText("Protein: " + proteinPercentage + "%");
        pc_label_carbs.setText("Carbs: " + carbsPercentage + "%");


    }

    public void barSetData()
    {
        barChart.clear();
        barChart.getDescription().setEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setFitBars(true);
        barChart.getLegend().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        YAxis yAxis = barChart.getAxisLeft();

        String[] chartDays = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        xAxis.setValueFormatter(new MyXAxisValueFormatter(chartDays));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(16f);
        xAxis.setTextColor(Color.BLACK);

        yAxis.setAxisMinimum(0);
        yAxis.setTextSize(16f);
        yAxis.setTextColor(Color.BLACK);

        Random rand = new Random();
        int sundayCalories = rand.nextInt(((int)caloriesLimit + 500) - 1000) + 1000;
        int mondayCalories = rand.nextInt(((int)caloriesLimit + 500) - 1000) + 1000;
        int tuesdayCalories = caloriesConsumed;
        int wednesdayCalories = 0;
        int thursdayCalories = 0;
        int fridayCalories = 0;
        int saturdayCalories = 0;

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, sundayCalories)); //sunday
        entries.add(new BarEntry(1, mondayCalories)); //monday
        entries.add(new BarEntry(2, tuesdayCalories)); //tuesday
        entries.add(new BarEntry(3, wednesdayCalories)); //wednesday
        entries.add(new BarEntry(4, thursdayCalories)); //thursday
        entries.add(new BarEntry(5, fridayCalories)); //friday
        entries.add(new BarEntry(6, saturdayCalories)); //saturday

        BarDataSet set = new BarDataSet(entries, "Days");

        set.setValueTextSize(16f);
        set.setValueTextColor(Color.BLACK);
        set.setColors(new int[] {getColor(sundayCalories, caloriesLimit), getColor(mondayCalories, caloriesLimit), getColor(tuesdayCalories, caloriesLimit),
                getColor(wednesdayCalories, caloriesLimit), getColor(thursdayCalories, caloriesLimit), getColor(fridayCalories, caloriesLimit), getColor(saturdayCalories, caloriesLimit)}, context);
        set.setDrawValues(true);


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
        pb_meter.setProgressWithAnimation((int)percentage, 1000);

        pb_meter.setColor(ContextCompat.getColor(getContext(), getColor(caloriesConsumed, caloriesLimit)));
        barSetData();
        pieSetData();
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
