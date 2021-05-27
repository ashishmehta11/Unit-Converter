package com.project.unitconverter.main_activity.fragments.unit_selector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Test;
import com.project.unitconverter.databinding.FragmentUnitSelectorBinding;


public class UnitSelector extends Fragment {
    FragmentUnitSelectorBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_unit_selector, container, false);
            binding.setData(new Test());
        }
        return binding.getRoot();
    }
}