package com.project.unitconverter.main_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.project.unitconverter.data.Data;

/**
 * A ViewModel is a class which acts as an intermediate between the Activity.java file and other .java files related to data
 * A ViewModel is basically used to isolate and differentiate the rending and handling of views and the flow of data & processing of data.
 * This differentiation is helpful in writing a neat anc clean, user readable code.
 */

public class MainActivityViewModel extends AndroidViewModel implements IMainActivityOperations {
    final private Application application;
    final private Data data;
    private MutableLiveData<Integer> unitFamilyChangedNotifier;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        data = new Data(application);
        unitFamilyChangedNotifier = new MutableLiveData<Integer>();
    }

    public Data getData() {
        return data;
    }

    public Application getApplication() {
        return application;
    }

    public MutableLiveData<Integer> getUnitFamilyChangedNotifier() {
        return unitFamilyChangedNotifier;
    }

    public void setUnitFamilyChangedNotifier(int val) {
        this.unitFamilyChangedNotifier.setValue(val);
        ;
    }
}
