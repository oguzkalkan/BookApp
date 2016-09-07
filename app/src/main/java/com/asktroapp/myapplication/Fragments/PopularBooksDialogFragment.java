package com.asktroapp.myapplication.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.asktroapp.myapplication.R;

/**
 * Created by mobiltek26 on 9/7/16.
 */
public class PopularBooksDialogFragment extends android.support.v4.app.DialogFragment {
    TextView name;
    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment, null);
        builder.setView(view);

        Bundle mArgs = getArguments();
        String myValue = mArgs.getString("key");

        name = (TextView) view.findViewById(R.id.TextViewName);
        name.setText(myValue);

        return builder.create();


            }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
