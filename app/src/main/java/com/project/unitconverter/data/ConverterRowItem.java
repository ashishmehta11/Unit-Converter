package com.project.unitconverter.data;

import androidx.core.view.GravityCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;

public class ConverterRowItem extends BaseObservable {
    private String name, value;
    private int gravity = GravityCompat.END;

    @Bindable
    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }
}
