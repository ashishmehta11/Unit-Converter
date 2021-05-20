package com.project.unitconverter.main_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.TextView;

import com.project.unitconverter.R;
import com.project.unitconverter.databinding.ActivityMainBinding;
import com.project.unitconverter.utils.GradientShader;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setData(null);
    }
}