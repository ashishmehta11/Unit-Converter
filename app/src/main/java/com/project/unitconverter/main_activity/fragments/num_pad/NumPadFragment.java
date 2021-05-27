package com.project.unitconverter.main_activity.fragments.num_pad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.unitconverter.R;
import com.project.unitconverter.databinding.FragmentNumPadBinding;
import com.project.unitconverter.main_activity.MainActivityViewModel;

/**
 * A fragment representing the number pad view of the screen
 */

public class NumPadFragment extends Fragment {
    private FragmentNumPadBinding binding = null;
    private MainActivityViewModel viewModel = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_num_pad, container, false);
            //binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_num_pad);
            binding.setData(viewModel.getData());
        }
        return binding.getRoot();
    }
}