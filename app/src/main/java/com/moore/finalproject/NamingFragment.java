package com.moore.finalproject;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NamingFragment extends Fragment {

    // define variables for the widgets
    private EditText prefixET, boxET, incrementingET, namingET, differentControlNumET;
    private RadioGroup namingRadioGroup;
    private RadioButton fileNameSameRB, fileNameDifferentRB;

    public NamingFragment() {
        // Required empty public constructor
    }

    public static NamingFragment newInstance(){
        NamingFragment fragment = new NamingFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_naming, container, false);

        // get references to widgets
        prefixET = (EditText) v.findViewById(R.id.prefixET);
        boxET = (EditText) v.findViewById(R.id.boxET);
        incrementingET = (EditText) v.findViewById(R.id.incrementingET);
        namingET = (EditText) v.findViewById(R.id.namingET);
        namingRadioGroup = (RadioGroup) v.findViewById(R.id.namingRadioGroup);
        fileNameSameRB = (RadioButton) v.findViewById(R.id.fileNameSameRB);
        fileNameDifferentRB = (RadioButton) v.findViewById(R.id.fileNameDifferentRB);
        differentControlNumET = (EditText) v.findViewById(R.id.differentControlNumET);


        // Set the Listener
        incrementingET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    String namingString;

                    namingString = prefixET.getText().toString() + boxET.getText().toString() + incrementingET.getText().toString();

                    namingET.setText(namingString);
                }
                return false;
            }
        });

        namingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.fileNameSameRB:
                        differentControlNumET.setVisibility(View.GONE);
                        fileNameDifferentRB.setChecked(false);
                        break;
                    case R.id.fileNameDifferentRB:
                        differentControlNumET.setVisibility(View.VISIBLE);
                        fileNameSameRB.setChecked(false);
                        break;
                }
            }
        });



        // Inflate the layout for this fragment
        return v;
    }

}
