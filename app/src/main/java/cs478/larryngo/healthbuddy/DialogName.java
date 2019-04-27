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

public class DialogName extends AppCompatDialogFragment {

    EditText edit_firstname;
    EditText edit_lastname;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_name, null);
        edit_firstname = v.findViewById(R.id.edit_firstname);
        edit_lastname = v.findViewById(R.id.edit_lastname);
        edit_firstname.setText(MainActivity.data_firstName);
        edit_lastname.setText(MainActivity.data_lastName);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        String firstname = edit_firstname.getText().toString();
                        String lastname = edit_lastname.getText().toString();

                        MainActivity.data_firstName = firstname;
                        MainActivity.data_lastName = lastname;

                        TextView tv_name = getActivity().findViewById(R.id.settings_text_name);
                        tv_name.setText(firstname + " " + lastname);
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set First and Last Name")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}
