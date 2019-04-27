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

public class DialogEmail extends AppCompatDialogFragment {

    EditText edit_email;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_email, null);
        edit_email = v.findViewById(R.id.edit_email);
        edit_email.setText(MainActivity.data_email);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        String email = edit_email.getText().toString();

                        MainActivity.data_email = email;

                        TextView tv_email = getActivity().findViewById(R.id.settings_text_email);
                        tv_email.setText(email);
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Email")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}