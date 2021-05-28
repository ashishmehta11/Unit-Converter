package com.project.unitconverter.data;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;

/**
 * A class which holds the data of the user's input, output and processing.
 * This is a Binding class. Binding means that the views in the .xml files such as (TextView, EditText, etc..) individually connect to variables in this class.
 * Any change in the variables which are bound to the views, results in the change in the value of the view itself and vic-versa.
 */

public class Data extends BaseObservable {
    private StringBuilder valueStringLhs = new StringBuilder();
    private StringBuilder valueStringRhs = new StringBuilder();
    private int selectedUnitIndex = 0;
    private String selectedUnitName;

    public void btnDeleteClickListener() {

    }

    public void numberClickListener(String val) {

    }


    public void btnExchangeClickListener() {

    }

    public void decimalClickListener() {

    }


    public void btnClearClickListener() {

    }


    public int getSelectedUnitIndex() {
        return selectedUnitIndex;
    }

    public void setSelectedUnitIndex(int selectedUnitIndex) {
        this.selectedUnitIndex = selectedUnitIndex;
    }

    @Bindable
    public String getSelectedUnitName() {
        return selectedUnitName;
    }

    public void setSelectedUnitName(String selectedUnitName) {
        this.selectedUnitName = selectedUnitName;
        notifyPropertyChanged(BR.selectedUnitName);
    }

    public StringBuilder getValueStringRhs() {
        return valueStringRhs;
    }

    public void setValueStringRhs(StringBuilder valueStringRhs) {
        this.valueStringRhs = valueStringRhs;
    }

    public StringBuilder getValueStringLhs() {
        return valueStringLhs;
    }

    public void setValueStringLhs(StringBuilder valueStringLhs) {
        this.valueStringLhs = valueStringLhs;
    }
}
