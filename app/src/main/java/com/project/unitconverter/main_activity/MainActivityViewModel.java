package com.project.unitconverter.main_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A ViewModel is a class which acts as an intermediate between the Activity.java file and other .java files related to data
 * A ViewModel is basically used to isolate and differentiate the rending and handling of views and the flow of data & processing of data.
 * This differentiation is helpful in writing a neat anc clean, user readable code.
 */

public class MainActivityViewModel extends AndroidViewModel implements IMainActivityOperations {
    final private Application application;
    final private Data data;
    final private List<Object[]> unitFamilies = new ArrayList<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        data = new Data();
        populateUnitFamilies();
    }

    private void populateUnitFamilies() {
        unitFamilies.add(
                new Object[]{"Luminance"
                        , application.getResources().getDrawable(R.drawable.ic_light_bulb_white, application.getTheme())
                        , application.getResources().getDrawable(R.drawable.ic_light_bulb_pink, application.getTheme())});
        for (int i = 1; i < 10; i++)
            unitFamilies.add(
                    new Object[]{"Time"
                            , application.getResources().getDrawable(R.drawable.ic_time_white, application.getTheme())
                            , application.getResources().getDrawable(R.drawable.ic_time_pink, application.getTheme())});
    }

    public Data getData() {
        return data;
    }

    public List<Object[]> getUnitFamilies() {
        return unitFamilies;
    }
}
