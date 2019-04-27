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

public class DialogWeight extends AppCompatDialogFragment {

    EditText edit_weight;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_weight, null);
        edit_weight = v.findViewById(R.id.edit_weight);
        edit_weight.setText(Integer.toString(MainActivity.data_weight));

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        int weight = Integer.parseInt(edit_weight.getText().toString());

                        MainActivity.data_weight = weight;

                        TextView tv_weight = getActivity().findViewById(R.id.settings_text_weight);
                        tv_weight.setText(Integer.toString(weight) + " lbs.");
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Weight")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}