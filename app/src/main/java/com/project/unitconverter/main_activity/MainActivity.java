package com.project.unitconverter.main_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Test;
import com.project.unitconverter.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setData(new Test());
    }
}