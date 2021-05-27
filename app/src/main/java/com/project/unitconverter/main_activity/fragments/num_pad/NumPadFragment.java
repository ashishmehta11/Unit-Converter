package com.project.unitconverter.main_activity.fragments.num_pad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Test;
import com.project.unitconverter.databinding.FragmentNumPadBinding;

/**
 * A fragment representing the number pad view of the screen
 */

public class NumPadFragment extends Fragment {
    private FragmentNumPadBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_num_pad, container, false);
            //binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_num_pad);
            binding.setData(new Test());
        }

        return binding.getRoot();
    }
}