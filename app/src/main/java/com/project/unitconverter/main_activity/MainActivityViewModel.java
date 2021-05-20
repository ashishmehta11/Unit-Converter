package com.project.unitconverter.main_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel implements IMainActivityOperations {
    private Application application;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }
}
