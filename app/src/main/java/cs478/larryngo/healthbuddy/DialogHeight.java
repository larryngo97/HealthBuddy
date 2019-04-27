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

public class DialogHeight extends AppCompatDialogFragment {

    EditText edit_feet;
    EditText edit_inch;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_height, null);
        edit_feet = v.findViewById(R.id.edit_feet);
        edit_inch = v.findViewById(R.id.edit_inch);
        edit_feet.setText(Integer.toString(MainActivity.data_height_ft));
        edit_inch.setText(Integer.toString(MainActivity.data_height_in));

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        int feet = Integer.parseInt(edit_feet.getText().toString());
                        int inch = Integer.parseInt(edit_inch.getText().toString());
                        if(inch > 12)
                        {
                            inch = 12;
                            Toast.makeText(getContext(), "Set inches to 12 (Cannot be > 12)", Toast.LENGTH_SHORT).show();
                        }

                        MainActivity.data_height_ft = feet;
                        MainActivity.data_height_in = inch;

                        TextView tv_height = getActivity().findViewById(R.id.settings_text_height);
                        tv_height.setText(feet + " ft. " + inch + " in.");
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Height")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}
