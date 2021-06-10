package com.project.unitconverter.data;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class which holds the data of the user's input, output and processing.
 * This is a Binding class. Binding means that the views in the .xml files such as (TextView, EditText, etc..) individually connect to variables in this class.
 * Any change in the variables which are bound to the views, results in the change in the value of the view itself and vic-versa.
 */
public class Data extends BaseObservable {
    public static HashMap<Integer, ArrayList<Object[]>> unitRange = new HashMap<>();
    private StringBuilder valueStringLhs = new StringBuilder("0");
    private int selectedUnitIndex = 0;
    private String selectedUnitName;
    private StringBuilder valueStringRhs = new StringBuilder("0");
    private String selectedNameRhs, selectedNameLhs;

    public Data() {
        unitRange.put(0
                , new ArrayList<Object[]>() {
                    {
                        add(new Object[]{"Nanoseconds", "ns", 1000000000});
                        add(new Object[]{"Microseconds", "us", 1000000});
                        add(new Object[]{"Milliseconds", "nms", 1000});
                        add(new Object[]{"Second", "s", 1});
                        add(new Object[]{"Minute", "min", 60});
                        add(new Object[]{"Hour", "hr", 3600});
                        add(new Object[]{"Day", "day", (3600 * 24)});
                        add(new Object[]{"Week", "week", (3600 * 24 * 7)});
                        add(new Object[]{"Month", "m", (3600 * 24 * 30)});
                        add(new Object[]{"Year", "y", (3600 * 24 * 30 * 12)});
                    }
                });

    }

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

    @Bindable
    public String getValueStringRhs() {
        return valueStringRhs.toString();
    }

    public void setValueStringRhs(String valueStringRhs) {
        this.valueStringRhs.append(valueStringRhs);
        notifyPropertyChanged(BR.valueStringRhs);
    }

    public void setValueStringRhs(int valueStringRhs) {
        this.valueStringRhs.append(valueStringRhs);
        notifyPropertyChanged(BR.valueStringRhs);
    }

    @Bindable
    public String getValueStringLhs() {
        return valueStringLhs.toString();
    }

    public void setValueStringLhs(String valueStringLhs) {
        this.valueStringLhs.append(valueStringLhs);
        notifyPropertyChanged(BR.valueStringLhs);
    }

    public void setValueStringLhs(int valueStringLhs) {
        this.valueStringLhs.append(valueStringLhs);
        notifyPropertyChanged(BR.valueStringLhs);
    }

    @Bindable
    public String getSelectedNameRhs() {
        return selectedNameRhs;
    }

    public void setSelectedNameRhs(String selectedNameRhs) {
        this.selectedNameRhs = selectedNameRhs;
        notifyPropertyChanged(BR.selectedNameRhs);
    }

    @Bindable
    public String getSelectedNameLhs() {
        return selectedNameLhs;
    }

    public void setSelectedNameLhs(String selectedNameLhs) {
        this.selectedNameLhs = selectedNameLhs;
        notifyPropertyChanged(BR.selectedNameLhs);
    }
}
