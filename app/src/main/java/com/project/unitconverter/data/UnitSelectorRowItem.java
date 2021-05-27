package com.project.unitconverter.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;

public class UnitSelectorRowItem extends BaseObservable {
    private boolean itemSelected = false;

    @Bindable
    public boolean isItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
        notifyPropertyChanged(BR.itemSelected);
    }
}
