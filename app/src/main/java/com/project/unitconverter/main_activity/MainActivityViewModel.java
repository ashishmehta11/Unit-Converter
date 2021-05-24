package com.project.unitconverter.main_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * A ViewModel is a class which acts as an intermediate between the Activity.java file and other .java files related to data
 * A ViewModel is basically used to isolate and differentiate the rending and handling of views and the flow of data & processing of data.
 * This differentiation is helpful in writing a neat anc clean, user readable code.
 */

public class MainActivityViewModel extends AndroidViewModel implements IMainActivityOperations {
    private Application application;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }
}
