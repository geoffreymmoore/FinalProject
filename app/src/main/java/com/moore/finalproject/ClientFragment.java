package com.moore.finalproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.moore.finalproject.database.Client;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientFragment extends Fragment {



    public ClientFragment() {
        // Required empty public constructor
    }

    public static ClientFragment newInstance(){
        ClientFragment fragment = new ClientFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_client, container, false);

        return v;
    }

}
