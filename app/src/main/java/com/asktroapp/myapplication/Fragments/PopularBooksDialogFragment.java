package com.asktroapp.myapplication.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.asktroapp.myapplication.R;

/**
 * Created by mobiltek26 on 9/7/16.
 */
public class PopularBooksDialogFragment extends android.support.v4.app.DialogFragment {
    TextView name;
    Button Cancel;
    Button sendRequest;
    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.popular_books_dialog_fragment, null);
        builder.setView(view);

        Bundle mArgs = getArguments();
        String myValue = mArgs.getString("key");

        name = (TextView) view.findViewById(R.id.TextViewName);
        name.setText(myValue);
        Cancel = (Button) view.findViewById(R.id.ButtonCancel);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        sendRequest = (Button) view.findViewById(R.id.sendRequest);

        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Kitap İsteği")
                        .setMessage("Kitap isteğiniz alınmıştır")
                        .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });

        return builder.create();


            }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
