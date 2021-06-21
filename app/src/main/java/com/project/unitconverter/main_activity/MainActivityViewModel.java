package com.project.unitconverter.main_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A ViewModel is a class which acts as an intermediate between the Activity.java file and other .java files related to data
 * A ViewModel is basically used to isolate and differentiate the rending and handling of views and the flow of data & processing of data.
 * This differentiation is helpful in writing a neat anc clean, user readable code.
 */

public class MainActivityViewModel extends AndroidViewModel implements IMainActivityOperations {
    final private Application application;
    final private Data data;
    public static HashMap<Integer, ArrayList<Object[]>> unitRange = new HashMap<>();
    private final MutableLiveData<Integer> unitFamilyChangedNotifier;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        unitFamilyChangedNotifier = new MutableLiveData<>();
        if (unitRange.isEmpty()) buildUnitRange();
        data = new Data();
    }

    public Data getData() {
        return data;
    }

    public MutableLiveData<Integer> getUnitFamilyChangedNotifier() {
        return unitFamilyChangedNotifier;
    }

    public void setUnitFamilyChangedNotifier(int val) {
        this.unitFamilyChangedNotifier.setValue(val);

    }

    private void buildUnitRange() {
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
                        add(new Object[]{"Milliseconds", "ms", 1000});
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
                        add(new Object[]{"Bit", "b", 1});
                        add(new Object[]{"Nibble", "nb", 4});
                        add(new Object[]{"Byte", "by", 8});
                        add(new Object[]{"Kilobytes", "kb", Math.pow((1024), 1) * 8});
                        add(new Object[]{"Megabytes", "mb", Math.pow(1024, 2) * 8});
                        add(new Object[]{"Gigabytes", "gb", Math.pow(1024, 3) * 8});
                        add(new Object[]{"Terabytes", "tb", Math.pow(1024, 4) * 8});
                        add(new Object[]{"Petabytes", "pb", Math.pow(1024, 5) * 8});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(2,
                new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Area"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_area_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_area_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Square centimeter", "cm\u00B2", 1});
                        add(new Object[]{"Square feet", "ft\u00B2", 929.03});
                        add(new Object[]{"Square inches", "in\u00B2", 6.4516});
                        add(new Object[]{"Square metres", "m\u00B2", 10000});
                        add(new Object[]{"Hectares", "ha", 100000000});
                        add(new Object[]{"Ares", "a", 1000000});
                        add(new Object[]{"Acres", "ac", 40468564.224});
                        add(new Object[]{"Square Kilometre", "km\u00B2", 10000000000.0});
                        add(new Object[]{"Square Mile", "mi\u00B2", 25900000000.0});
                        add(new Object[]{"Square yard", "yd\u00B2", 8361.27});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(3,
                new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Temperature"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_thermometer_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_thermometer_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Celsius", "\u00B0C", 1});
                        add(new Object[]{"Fahrenheit", "\u00B0F", -17.2222222222});
                        add(new Object[]{"Kelvin", "K", -272.15});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(4,
                new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Length"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_length_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_length_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Millimetres", "mm", 1});
                        add(new Object[]{"Centimetres", "cm", 10});
                        add(new Object[]{"Metres", "m", 1000});
                        add(new Object[]{"Kilometres", "km", 1000000});
                        add(new Object[]{"Inches", "in", 25.4});
                        add(new Object[]{"Feet", "ft", 304.8});
                        add(new Object[]{"Yards", "yd", 914.4});
                        add(new Object[]{"Miles", "mi", 1609344});
                        add(new Object[]{"Nautical miles", "NM", 1852000});
                        add(new Object[]{"Mils", "mil", 0.0254});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(5,
                new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Volume"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_volume_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_volume_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Uk gallons", "gal", 4546.09});
                        add(new Object[]{"US gallon", "gal", 3785.411784});
                        add(new Object[]{"Litres", "l", 1000});
                        add(new Object[]{"Millilitres", "ml", 1});
                        add(new Object[]{"Cubic centimetres(cc)", "cm\u00B3", 1});
                        add(new Object[]{"Cubic metres", "m\u00B3", 1000000});
                        add(new Object[]{"Cubic inches", "in\u00B3", 16.387064});
                        add(new Object[]{"Cubic feet", "ft\u00B3", 28316.846592});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(6,
                new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Weight"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_weight_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_weight_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Gram", "g", 1});
                        add(new Object[]{"Tons", "t", 1000000});
                        add(new Object[]{"UK tons", "t", 1016046.9088});
                        add(new Object[]{"US tons", "t", 907184.74});
                        add(new Object[]{"Kilogram", "kg", 1000});
                        add(new Object[]{"Milligrams", "mg", 0.001});
                        add(new Object[]{"Micrograms", "ug", 0.000001});
                        add(new Object[]{"Stones", "st", 6350.29});
                        add(new Object[]{"Pounds", "lb", 453.59237});
                        add(new Object[]{"Ounces", "oz", 28.349523125});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
        unitRange.putIfAbsent(7,
                new ArrayList<Object[]>() {
                    {
                        add(new Object[]{
                                "Speed"
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_speed_white, application.getTheme()))
                                , Objects.requireNonNull(ResourcesCompat.getDrawable(application.getResources(), R.drawable.ic_speed_pink, application.getTheme()))
                        });
                        add(new Object[]{});
                        add(new Object[]{});
                        add(new Object[]{"Metres per second", "m/s", 1});
                        add(new Object[]{"Metres per hour", "m/h", 0.0002777778});
                        add(new Object[]{"Kilometres per second", "km/s", 1000});
                        add(new Object[]{"Kilometres per hour", "km/h", 0.2777777778});
                        add(new Object[]{"Inches per second", "in/s", 0.0254});
                        add(new Object[]{"Inches per hour", "in/h", 0.0000070556});
                        add(new Object[]{"Feet per second", "ft/s", 0.3048});
                        add(new Object[]{"Feet per hour", "ft/h", 0.0000846667});
                        add(new Object[]{"Miles per second", "mi/s", 1609.344});
                        add(new Object[]{"Miles per hour", "mi/h", 0.44704});
                        add(new Object[]{"Knots", "kn", 0.5144444444});
                        add(new Object[]{});
                        add(new Object[]{});
                    }
                });
    }
}
