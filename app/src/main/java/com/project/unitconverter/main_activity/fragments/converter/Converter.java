package com.project.unitconverter.main_activity.fragments.converter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

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
        DividerItemDecoration divider = new
                DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(
                requireContext().getResources().getDrawable(R.drawable.divider, getActivity().getTheme())
        );
        LinearLayoutManager layoutManagerL = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManagerR = new LinearLayoutManager(getActivity());
        binding.recyclerLeft.addItemDecoration(divider);
        binding.recyclerRight.addItemDecoration(divider);
        binding.recyclerLeft.setLayoutManager(layoutManagerL);
        binding.recyclerRight.setLayoutManager(layoutManagerR);
        binding.recyclerLeft.setAdapter(new RecyclerLeftAdapter());
        binding.recyclerRight.setAdapter(new RecyclerRightAdapter());
        binding.recyclerLeft.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            int fv = layoutManagerL.findFirstCompletelyVisibleItemPosition();
            int lv = layoutManagerL.findLastCompletelyVisibleItemPosition();
            if (lv - fv == 2) {
                Log.d("Unit Converter", "onScrollChange which to pick left :" + (fv + 1));
            }

        });
        binding.recyclerRight.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            int fv = layoutManagerL.findFirstCompletelyVisibleItemPosition();
            int lv = layoutManagerL.findLastCompletelyVisibleItemPosition();
            if (lv - fv == 2) {
                Log.d("Unit Converter", "onScrollChange which to pick right :" + (fv + 1));
            }
        });
        return binding.getRoot();
    }
}