package com.project.unitconverter.main_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Data;
import com.project.unitconverter.databinding.ActivityMainBinding;

/**
 * The Main Activity where the one and only screen of the application is controlled.
 * Other parts of the screen are divided into fragments like FragmentNumPad
 */

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    ActivityMainBinding binding; // Data binding object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializing the binding instance with the layout to be used.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Setting test class instance as the variable to be used by ActivityMainBinding
        binding.setData(new Data());
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        CardView cv = new CardView(this);

    }
}