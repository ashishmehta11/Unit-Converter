package com.project.unitconverter.data;


import android.app.Application;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;
import com.project.unitconverter.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A class which holds the data of the user's input, output and processing.
 * This is a Binding class. Binding means that the views in the .xml files such as (TextView, EditText, etc..) individually connect to variables in this class.
 * Any change in the variables which are bound to the views, results in the change in the value of the view itself and vic-versa.
 */
public class Data extends BaseObservable {
    public static HashMap<Integer, ArrayList<Object[]>> unitRange = new HashMap<>();
    private StringBuilder valueStringLhs = new StringBuilder("1");
    private int selectedUnitIndex = 0, selectedItemLhs, selectedItemRhs;
    private String selectedUnitName;
    private StringBuilder valueStringRhs = new StringBuilder("1");
    private String selectedNameRhs, selectedNameLhs;

    public Data(Application application) {
        selectedItemRhs = selectedItemLhs = 3;
//        selectedItemRhs=selectedItemLhs=2;
        if (unitRange.isEmpty())
            buildUnitRange(application);
        setSelectedNameRhs(unitRange.get(selectedUnitIndex).get(selectedItemRhs)[0].toString());
        setSelectedNameLhs(unitRange.get(selectedUnitIndex).get(selectedItemLhs)[0].toString());
    }

    public static HashMap<Integer, ArrayList<Object[]>> getUnitRange() {
        return unitRange;
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

    private void buildUnitRange(Application application) {
        unitRange.putIfAbsent(0
                , new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Time"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_time_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_time_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
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
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(1
                , new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Data"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_pendrive_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_pendrive_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Bit", "b", 8});
                        add(new Object[]{"Nibble", "nb", 2});
                        add(new Object[]{"Byte", "by", 1});
                        add(new Object[]{"Kilobytes", "kb", Math.pow(1024, 1)});
                        add(new Object[]{"Megabytes", "mb", Math.pow(1024, 2)});
                        add(new Object[]{"Gigabytes", "gb", Math.pow(1024, 3)});
                        add(new Object[]{"Terabytes", "tb", Math.pow(1024, 4)});
                        add(new Object[]{"Petabytes", "pb", Math.pow(1024, 5)});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
    }

    public int getSelectedItemLhs() {
        return selectedItemLhs;
    }

    public void setSelectedItemLhs(int selectedItemLhs) {
        this.selectedItemLhs = selectedItemLhs;
        setSelectedNameLhs(unitRange.get(selectedUnitIndex).get(selectedItemLhs)[0].toString());
    }

    public int getSelectedItemRhs() {
        return selectedItemRhs;
    }

    public void setSelectedItemRhs(int selectedItemRhs) {
        this.selectedItemRhs = selectedItemRhs;
        setSelectedNameRhs(unitRange.get(selectedUnitIndex).get(selectedItemRhs)[0].toString());

    }
}
