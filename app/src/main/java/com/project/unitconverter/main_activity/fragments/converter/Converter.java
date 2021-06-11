package com.project.unitconverter.main_activity.fragments.converter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.unitconverter.R;
import com.project.unitconverter.databinding.FragmentConverterBinding;
import com.project.unitconverter.main_activity.MainActivityViewModel;

import java.util.Objects;


public class Converter extends Fragment {
    private FragmentConverterBinding binding = null;
    private MainActivityViewModel viewModel;
    private RecyclerLeftAdapter leftAdapter;
    private RecyclerRightAdapter rightAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        leftAdapter = new RecyclerLeftAdapter(viewModel.getData());
        rightAdapter = new RecyclerRightAdapter(viewModel.getData());
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_converter, container, false);
            binding.setData(viewModel.getData());
        }

        binding.edValueLeft.setShowSoftInputOnFocus(false);
//        binding.edValueLeft.setCursorVisible(false);
//        binding.edValueRight.setCursorVisible(false);
        binding.edValueRight.setFocusableInTouchMode(false);
        binding.edValueLeft.requestFocus();

        binding.edValueRight.setShowSoftInputOnFocus(false);

        viewModel.getData().setEdLeft(binding.edValueLeft);
        viewModel.getData().setEdRight(binding.edValueRight);

        DividerItemDecoration divider = new
                DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(
                Objects.requireNonNull(ResourcesCompat.getDrawable(requireContext().getResources(), R.drawable.divider, requireActivity().getTheme()))
        );
        LinearLayoutManager layoutManagerL = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManagerR = new LinearLayoutManager(getActivity());
        binding.recyclerLeft.addItemDecoration(divider);
        binding.recyclerRight.addItemDecoration(divider);
        binding.recyclerLeft.setLayoutManager(layoutManagerL);
        binding.recyclerRight.setLayoutManager(layoutManagerR);
        binding.recyclerLeft.setAdapter(leftAdapter);
        binding.recyclerRight.setAdapter(rightAdapter);
        binding.recyclerLeft.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            int fv = layoutManagerL.findFirstCompletelyVisibleItemPosition();
            int lv = layoutManagerL.findLastCompletelyVisibleItemPosition();
            if (lv - fv == 4) {
                Log.d("Unit Converter", "onScrollChange which to pick left :" + (fv + 2));
                viewModel.getData().setSelectedItemLhs(fv + 3);
            }
//            if (lv - fv ==2) {
//                Log.d("Unit Converter", "onScrollChange which to pick left :" + (fv + 1));
//                viewModel.getData().setSelectedItemLhs(fv+2);
//            }

        });
        binding.recyclerRight.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            int fv = layoutManagerR.findFirstCompletelyVisibleItemPosition();
            int lv = layoutManagerR.findLastCompletelyVisibleItemPosition();
            Log.d("Unit Converter", "onScrollChange right fv:" + fv + " lv=" + lv);
            if (lv - fv == 4) {
                Log.d("Unit Converter", "onScrollChange which to pick right :" + (fv + 2));
                viewModel.getData().setSelectedItemRhs(fv + 3);
            }
//            if (lv - fv ==2) {
//                Log.d("Unit Converter", "onScrollChange which to pick right :" + (fv + 1));
//                viewModel.getData().setSelectedItemRhs(fv+2);
//            }
        });

        viewModel.getUnitFamilyChangedNotifier().observe(getViewLifecycleOwner(), integer -> notifyChange());
        binding.txtNameLeft.setSelected(true);
        binding.txtNameRight.setSelected(true);
        binding.floatingActionButton.setOnClickListener(v -> {
            if (viewModel.getData().islToR()) {
                binding.imgConversionSide.setImageDrawable(ResourcesCompat
                        .getDrawable(requireContext().getResources()
                                , R.drawable.ic_baseline_keyboard_arrow_left_32
                                , requireActivity().getTheme()));
                viewModel.getData().setlToR(false);
                //binding.edValueLeft.clearFocus();
                binding.edValueLeft.setFocusableInTouchMode(false);
                binding.edValueRight.setFocusableInTouchMode(true);
                binding.edValueRight.requestFocus();
                Log.d("Converter", "onCreateView: fab click listener hand over to right is rt focuable:" + binding.edValueRight.isFocusableInTouchMode());
            } else {
                binding.imgConversionSide.setImageDrawable(ResourcesCompat
                        .getDrawable(requireContext().getResources()
                                , R.drawable.ic_baseline_keyboard_arrow_right_24
                                , requireActivity().getTheme()));
                viewModel.getData().setlToR(true);
                //binding.edValueRight.clearFocus();
                binding.edValueRight.setFocusableInTouchMode(false);
                binding.edValueLeft.setFocusableInTouchMode(true);
                binding.edValueLeft.requestFocus();
                Log.d("Converter", "onCreateView: fab click listener hand over to left is lt focuable:" + binding.edValueLeft.isFocusableInTouchMode());
            }
        });

        binding.edValueRight.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override
            public void sendAccessibilityEvent(View host, int eventType) {
                super.sendAccessibilityEvent(host, eventType);
                if (eventType == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
                    Log.d("Converter", "sendAccessibilityEvent: Right sel start :" + binding.edValueRight.getSelectionStart());
                    Log.d("Converter", "sendAccessibilityEvent: Right sel end :" + binding.edValueRight.getSelectionEnd());
                    viewModel.getData().setRightCursorStart(binding.edValueRight.getSelectionStart());
                    viewModel.getData().setRightCursorEnd(binding.edValueRight.getSelectionEnd());
                }
            }
        });

        binding.edValueLeft.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override
            public void sendAccessibilityEvent(View host, int eventType) {
                super.sendAccessibilityEvent(host, eventType);
                if (eventType == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
                    Log.d("Converter", "sendAccessibilityEvent:  Left sel start :" + binding.edValueLeft.getSelectionStart());
                    Log.d("Converter", "sendAccessibilityEvent: Left sel end :" + binding.edValueLeft.getSelectionEnd());
                    viewModel.getData().setLeftCursorStart(binding.edValueLeft.getSelectionStart());
                    viewModel.getData().setLeftCursorEnd(binding.edValueLeft.getSelectionEnd());
                }
            }
        });
        binding.llLeft.setOnClickListener(v -> {
            if (viewModel.getData().islToR())
                binding.edValueLeft.requestFocus();
        });
        binding.llRight.setOnClickListener(v -> {
            if (!viewModel.getData().islToR())
                binding.edValueRight.requestFocus();
        });
        return binding.getRoot();
    }

    private void notifyChange() {
        binding.recyclerLeft.setAdapter(leftAdapter);
        binding.recyclerRight.setAdapter(rightAdapter);
        viewModel.getData().setSelectedItemRhs(3);
        viewModel.getData().setSelectedItemLhs(3);
//        viewModel.getData().setSelectedItemRhs(2);
//        viewModel.getData().setSelectedItemLhs(2);
    }
}