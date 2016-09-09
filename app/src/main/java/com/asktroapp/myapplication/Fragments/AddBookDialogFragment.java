package com.asktroapp.myapplication.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.asktroapp.myapplication.R;

/**
 * Created by mobiltek26 on 9/9/16.
 */
public class AddBookDialogFragment extends DialogFragment{

    Button Cancel,BookAdd;
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.add_book_dialog_fragment, null);
        builder.setView(view);

        Cancel = (Button) view.findViewById(R.id.btnCancel);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        BookAdd = (Button) view.findViewById(R.id.btnAdd);

        BookAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setMessage("Kitabınız kaydedilmiştir")
                        .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_info)
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
