package com.project.unitconverter.main_activity.fragments.unit_selector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.unitconverter.R;
import com.project.unitconverter.databinding.FragmentUnitSelectorBinding;
import com.project.unitconverter.main_activity.MainActivityViewModel;

import java.util.HashMap;


public class UnitSelector extends Fragment {
    private FragmentUnitSelectorBinding binding = null;
    private MainActivityViewModel viewModel;
    HashMap<Integer, Object[]> hm = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        for (int i = 0; i < 10; i++)
            hm.put(i,
                    new Object[]{"Luminance"
                            , getResources().getDrawable(R.drawable.ic_light_bulb_white, requireActivity().getTheme())
                            , getResources().getDrawable(R.drawable.ic_light_bulb_pink, requireActivity().getTheme())});
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_unit_selector, container, false);
            binding.setData(viewModel.getData());
        }
        UnitSelectionRecyclerAdapter adapter = new UnitSelectionRecyclerAdapter(hm, viewModel.getData());
        binding.recyclerViewUnits.setAdapter(adapter);
        return binding.getRoot();
    }
}