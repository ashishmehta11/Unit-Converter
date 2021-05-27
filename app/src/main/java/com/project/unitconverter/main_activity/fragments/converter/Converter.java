package com.project.unitconverter.main_activity.fragments.converter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.unitconverter.R;
import com.project.unitconverter.databinding.FragmentConverterBinding;
import com.project.unitconverter.main_activity.MainActivityViewModel;


public class Converter extends Fragment {
    private FragmentConverterBinding binding = null;
    private MainActivityViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_converter, container, false);
            binding.setData(viewModel.getData());
        }
        return binding.getRoot();
    }
}