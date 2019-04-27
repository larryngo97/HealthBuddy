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

public class DialogOccupation extends AppCompatDialogFragment {

    EditText edit_occupation;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_occupation, null);
        edit_occupation = v.findViewById(R.id.edit_occupation);
        edit_occupation.setText(MainActivity.data_occupation);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        String occupation = edit_occupation.getText().toString();

                        MainActivity.data_occupation = occupation;

                        TextView tv_occupation = getActivity().findViewById(R.id.settings_text_occupation);
                        tv_occupation.setText(occupation);
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Occupation")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}