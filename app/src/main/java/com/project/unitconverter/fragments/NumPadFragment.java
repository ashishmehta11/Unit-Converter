package com.project.unitconverter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.unitconverter.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumPadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumPadFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_num_pad, container, false);
    }
}