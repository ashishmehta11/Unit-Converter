package com.project.unitconverter.data;

import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;
import com.project.unitconverter.utils.GeneralUtils;

public class UnitSelectorRowItem extends BaseObservable {
    private String unitName;
    private ColorStateList txtColor;

    @Bindable
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
        notifyPropertyChanged(BR.unitName);
    }

    public void setItemSelected(boolean itemSelected) {
        if (itemSelected) {

            setTxtColor(txtColor = ColorStateList.valueOf(Color.parseColor(GeneralUtils.bgColorLight)));

        } else {

            setTxtColor(txtColor = ColorStateList.valueOf(Color.parseColor("#ffffff")));

        }
    }


    @Bindable
    public ColorStateList getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(ColorStateList txtColor) {
        this.txtColor = txtColor;
        notifyPropertyChanged(BR.txtColor);
    }


}
