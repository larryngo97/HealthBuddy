package cs478.larryngo.healthbuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialogCalories extends AppCompatDialogFragment {

    EditText edit_calories;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_calories, null);
        edit_calories = v.findViewById(R.id.edit_calories);
        edit_calories.setText(Integer.toString(MainActivity.data_caloriesLimit));

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        int calories = Integer.parseInt(edit_calories.getText().toString());
                        if(calories < 1000)
                        {
                            calories = 1000;
                            Toast.makeText(getContext(), "Calories cannot be lower than 1000!", Toast.LENGTH_SHORT).show();
                        }

                        MainActivity.data_caloriesLimit = calories;

                        TextView tv_calories = getActivity().findViewById(R.id.settings_text_calories);
                        tv_calories.setText("Calorie limit: " + Integer.toString(calories) + " kcal");
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Calorie Limit")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}