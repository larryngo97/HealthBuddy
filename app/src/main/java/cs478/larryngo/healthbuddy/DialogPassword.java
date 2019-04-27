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

public class DialogPassword extends AppCompatDialogFragment {

    EditText edit_password;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_password, null);
        edit_password = v.findViewById(R.id.edit_password);
        edit_password.setText(MainActivity.data_password);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch(which)
                {
                    case AlertDialog.BUTTON_POSITIVE:
                        String password = edit_password.getText().toString();
                        MainActivity.data_password = password;
                        Toast.makeText(getContext(), "Password set!", Toast.LENGTH_SHORT).show();
                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Password")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }
}