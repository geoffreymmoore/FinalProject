package com.moore.finalproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScanningFragment extends Fragment {


    public ScanningFragment() {
        // Required empty public constructor
    }

    public static ScanningFragment newInstance(){
        ScanningFragment fragment = new ScanningFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_scanning, container, false);

        return v;
    }

}
