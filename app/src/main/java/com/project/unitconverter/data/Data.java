package com.project.unitconverter.data;


import android.app.Application;
import android.text.Selection;
import android.util.Log;
import android.widget.EditText;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.project.unitconverter.BR;
import com.project.unitconverter.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/**
 * A class which holds the data of the user's input, output and processing.
 * This is a Binding class. Binding means that the views in the .xml files such as (TextView, EditText, etc..) individually connect to variables in this class.
 * Any change in the variables which are bound to the views, results in the change in the value of the view itself and vic-versa.
 */
public class Data extends BaseObservable {
    public static HashMap<Integer, ArrayList<Object[]>> unitRange = new HashMap<>();
    private StringBuilder valueStringLhs = new StringBuilder("01");
    private int selectedUnitIndex = 0, selectedItemLhs, selectedItemRhs;
    private String selectedUnitName;
    private StringBuilder valueStringRhs = new StringBuilder("01");
    private String selectedNameRhs, selectedNameLhs;
    private boolean lToR = true;
    private int leftCursorStart = 0, leftCursorEnd = 0, rightCursorStart = 0, rightCursorEnd = 0;
    private EditText edLeft, edRight;
    private final double K = 273.15;
    public Data(Application application) {
        selectedItemRhs = selectedItemLhs = 3;
//        selectedItemRhs=selectedItemLhs=2;
        if (unitRange.isEmpty())
            buildUnitRange(application);
        setSelectedNameRhs(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemRhs)[0].toString());
        setSelectedNameLhs(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemLhs)[0].toString());
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
                    }
                });
    }

    public static HashMap<Integer, ArrayList<Object[]>> getUnitRange() {
        return unitRange;
    }

    public void btnDeleteClickListener() {
        if (islToR()) {
            if (leftCursorStart == leftCursorEnd && leftCursorEnd > 0) {
                this.valueStringLhs.replace(leftCursorStart - 1, leftCursorEnd, "");
                if (edLeft != null && edRight != null) {
                    edLeft.setCursorVisible(false);
                    notifyPropertyChanged(BR.valueStringLhs);
                    final int[] arr = new int[]{leftCursorStart};
                    edLeft.postDelayed(() -> {
                        int var = edLeft.getText().length() - arr[0];
                        Log.d("Tag", "converter !@ : backspace btn : " + edLeft.getText().toString() + " len : " + edLeft.getText().length() + " var:" + var + " rtCursorSt :" + arr[0]);
                        Selection.setSelection(edLeft.getText(), arr[0] <= 0 ? 0 : (arr[0] - 1));
                        edLeft.setCursorVisible(true);
                    }, 15);
                }
            } else if (leftCursorStart == leftCursorEnd && leftCursorEnd == 0) {
                this.valueStringLhs.replace(0, 0, "");
                if (edLeft != null && edRight != null) {
                    edLeft.setCursorVisible(false);
                    notifyPropertyChanged(BR.valueStringLhs);
                    edLeft.setSelection(0, 0);
                    edLeft.setCursorVisible(true);
                }
            } else {
                this.valueStringLhs.replace(leftCursorStart, leftCursorEnd, "");
                if (edLeft != null && edRight != null) {
                    edLeft.setCursorVisible(false);
                    notifyPropertyChanged(BR.valueStringLhs);
                    final int[] arr = new int[]{leftCursorStart, leftCursorEnd};
                    edLeft.postDelayed(() -> {
                        int var = edLeft.getText().length() - arr[0];
                        Log.d("Tag", "converter !@ : backspace btn : " + edLeft.getText().toString() + " len : " + edLeft.getText().length() + " var:" + var + " rtCursorSt :" + arr[0]);
                        Selection.setSelection(edLeft.getText(), Math.min(arr[0], edLeft.getText().length()));
                        edLeft.setCursorVisible(true);
                    }, 15);
                }
            }
        } else {
            if (rightCursorStart == rightCursorEnd && rightCursorStart > 0) {
                Log.d("Data", "btnDeleteClickListener: rt len :" + this.valueStringRhs.length() + " rtStart :" + rightCursorStart);
                this.valueStringRhs.replace(rightCursorStart - 1, rightCursorEnd, "");
                if (edLeft != null && edRight != null) {
                    edRight.setCursorVisible(false);
                    notifyPropertyChanged(BR.valueStringRhs);
                    final int[] arr = new int[]{rightCursorStart};
                    edRight.postDelayed(() -> {
                        int var = edRight.getText().length() - arr[0];
                        Log.d("Tag", "converter !@ : backspace btn : " + edRight.getText().toString() + " len : " + edRight.getText().length() + " var:" + var + " rtCursorSt :" + arr[0]);
                        Selection.setSelection(edRight.getText(), arr[0] <= 0 ? 0 : (arr[0] - 1));
                        edRight.setCursorVisible(true);
                    }, 15);
                }
            } else if (rightCursorStart == rightCursorEnd && rightCursorEnd == 0) {
                this.valueStringRhs.replace(0, 0, "");
                if (edLeft != null && edRight != null) {
                    edRight.setCursorVisible(false);
                    notifyPropertyChanged(BR.valueStringRhs);
                    edRight.setSelection(0, 0);
                    edRight.setCursorVisible(true);
                }
            } else {
                this.valueStringRhs.replace(rightCursorStart, rightCursorEnd, "");
                if (edLeft != null && edRight != null)
                    edRight.setCursorVisible(false);
                notifyPropertyChanged(BR.valueStringRhs);
                final int[] arr = new int[]{rightCursorStart, rightCursorEnd};
                edRight.postDelayed(() -> {
                    int var = edRight.getText().length() - arr[0];
                    Log.d("Tag", "converter !@ : backspace btn : " + edRight.getText().toString() + " len : " + edRight.getText().length() + " var:" + var + " rtCursorSt :" + arr[0]);
                    Selection.setSelection(edRight.getText(), Math.min(arr[0], edRight.getText().length()));
                    if (edLeft != null && edRight != null)
                        edRight.setCursorVisible(true);
                }, 15);
            }

        }
        if (valueStringRhs.length() <= 0 || valueStringLhs.length() <= 0) {
            if (valueStringRhs.length() <= 0) {
                valueStringRhs.append(0);
                notifyPropertyChanged(BR.valueStringRhs);
            } else {
                valueStringLhs.append(0);
                notifyPropertyChanged(BR.valueStringLhs);
            }
        } else
            convert();

    }

    public void numberClickListener(String val) {
        if (islToR()) {
            if (val.contains(".") && valueStringLhs.toString().contains("."))
                return;
            setValueStringLhs(val, false);
        } else {
            if (val.contains(".") && valueStringRhs.toString().contains("."))
                return;
            setValueStringRhs(val, false);
        }
        convert();
    }


    public void btnExchangeClickListener() {
        String t = valueStringRhs.toString();
        setValueStringRhs(valueStringLhs.toString(), true);
        setValueStringLhs(t, true);
        convert();
    }

    public void decimalClickListener() {
        numberClickListener(".");
    }


    public void btnClearClickListener() {
        if (islToR())
            setValueStringLhs("0", true);
        else
            setValueStringRhs("0", true);
        convert();
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

    public void setValueStringRhs(Object valueStringRhs, boolean toMakeNew) {
        Log.d("COnverter", "setValueStringRhs: valueStringRhs : " + valueStringRhs.toString());
        if (!toMakeNew) {
            if (rightCursorStart == rightCursorEnd) {
                this.valueStringRhs.insert(rightCursorStart, valueStringRhs);
            } else {
                this.valueStringRhs.replace(rightCursorStart, rightCursorEnd, valueStringRhs.toString());
            }
        } else {
            this.valueStringRhs = new StringBuilder();
            this.valueStringRhs.append(valueStringRhs);
        }
        if (edLeft != null && edRight != null)
            edRight.setCursorVisible(false);
        notifyPropertyChanged(BR.valueStringRhs);
        if (edLeft != null && edRight != null) {
            Log.d("Converter", "setValueStringRhs: rightCursor start :" + rightCursorStart + " rightCursor end : " + rightCursorEnd + " txt len " + edRight.getText().length());
            //edRight.requestFocus();
            //edRight.post(()->edRight.selectAll());
            final int[] arr = new int[]{rightCursorStart};
            edRight.postDelayed(() -> {
                int var = edRight.getText().length() - arr[0];
                Log.d("Tag", "converter !@ : text : " + edRight.getText().toString() + " len : " + edRight.getText().length() + " var:" + var + " rtCursorSt :" + arr[0]);
                Selection.setSelection(edRight.getText(), arr[0] >= edRight.getText().length() ? edRight.getText().length() : (arr[0] + 1));
                //edRight.setSelection((edRight.getText().length() - (edRight.getText().length()-rightCursorStart) ));
                edRight.setCursorVisible(true);
            }, 15);
            //edRight.selectAll();
        }

    }

    @Bindable
    public String getValueStringLhs() {
        return valueStringLhs.toString();
    }


    public void setValueStringLhs(Object valueStringLhs, boolean toMakeNew) {
        if (!toMakeNew) {
            if (leftCursorStart == leftCursorEnd) {
                this.valueStringLhs.insert(leftCursorStart, valueStringLhs);
            } else {
                this.valueStringLhs.replace(leftCursorStart, leftCursorEnd, valueStringLhs.toString());
            }
        } else {
            this.valueStringLhs = new StringBuilder();
            this.valueStringLhs.append(valueStringLhs);
        }
        if (edLeft != null && edRight != null)
            edLeft.setCursorVisible(false);
        notifyPropertyChanged(BR.valueStringLhs);
        if (edLeft != null && edRight != null) {
            final int[] arr = new int[]{leftCursorStart};
            edLeft.postDelayed(() -> {
                int var = edLeft.getText().length() - arr[0];
                Log.d("Tag", "converter !@ : text lft: " + edLeft.getText().toString() + " len : " + edLeft.getText().length() + " var:" + var + " ltCursorSt :" + arr[0]);
                Selection.setSelection(edLeft.getText(), arr[0] >= edLeft.getText().length() ? edLeft.getText().length() : (arr[0] + 1));
                edLeft.setCursorVisible(true);
                //edRight.setSelection((edRight.getText().length() - (edRight.getText().length()-rightCursorStart) ));
            }, 15);
            //edLeft.setSelection(leftCursorStart, leftCursorEnd);
        }

    }


    @Bindable
    public String getSelectedNameRhs() {
        return selectedNameRhs;
    }

    public void setSelectedNameRhs(String selectedNameRhs) {
        this.selectedNameRhs = selectedNameRhs;
        notifyPropertyChanged(BR.selectedNameRhs);
        convert();
    }

    @Bindable
    public String getSelectedNameLhs() {
        return selectedNameLhs;
    }

    public void setSelectedNameLhs(String selectedNameLhs) {
        this.selectedNameLhs = selectedNameLhs;
        notifyPropertyChanged(BR.selectedNameLhs);
        convert();
    }


    private void convert() {
        if (!islToR())
            convertRToL();
        if (islToR())
            convertLToR();
    }

    public void setSelectedItemLhs(int selectedItemLhs) {
        this.selectedItemLhs = selectedItemLhs;
        setSelectedNameLhs(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemLhs)[0].toString());
    }


    public void setSelectedItemRhs(int selectedItemRhs) {
        this.selectedItemRhs = selectedItemRhs;
        setSelectedNameRhs(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemRhs)[0].toString());

    }

    private void tempConvertLtoR() {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        double val;
        try {
            val = Double.parseDouble(valueStringLhs.toString());
        } catch (NumberFormatException e) {
            val = 0;
        }
        switch (selectedItemLhs) {
            //Celsius selected
            case 3:
                switch (selectedItemRhs) {
                    // C to C
                    case 3:
                        setValueStringRhs(valueStringLhs.toString(), true);
                        break;
                    //C to F
                    case 4:
                        setValueStringRhs(df.format((1.8 * val) + 32), true);
                        break;
                    //C to K
                    case 5:
                        setValueStringRhs(df.format(val + K), true);
                }
                break;
            // Fahrenheit selected
            case 4:
                switch (selectedItemRhs) {
                    // F to C
                    case 3:
                        setValueStringRhs(df.format((val - 32) * 0.5555555556), true);
                        break;
                    // F to F
                    case 4:
                        setValueStringRhs(valueStringLhs.toString(), true);
                        break;
                    // F to K
                    case 5:
                        setValueStringRhs(df.format(((val - 32) * 0.5555555556) + K), true);
                }
                break;
            // Kelvin Selected
            case 5:
                switch (selectedItemRhs) {
                    // K to C
                    case 3:
                        setValueStringRhs(df.format(val - K), true);
                        break;
                    // K to F
                    case 4:
                        setValueStringRhs(df.format(((val - K) * 1.8) + 32), true);
                        break;
                    // K to K
                    case 5:
                        setValueStringRhs(valueStringLhs.toString(), true);
                }
        }
    }

    private void tempConvertRtoL() {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        double val;
        try {
            val = Double.parseDouble(valueStringLhs.toString());
        } catch (NumberFormatException e) {
            val = 0;
        }
        switch (selectedItemRhs) {
            //Celsius selected
            case 3:
                switch (selectedItemLhs) {
                    // C to C
                    case 3:
                        setValueStringLhs(valueStringRhs.toString(), true);
                        break;
                    //C to F
                    case 4:
                        setValueStringLhs(df.format((1.8 * val) + 32), true);
                        break;
                    //C to K
                    case 5:
                        setValueStringLhs(df.format(val + K), true);
                }
                break;
            // Fahrenheit selected
            case 4:
                switch (selectedItemLhs) {
                    // F to C
                    case 3:
                        setValueStringLhs(df.format((val - 32) * 0.5555555556), true);
                        break;
                    // F to F
                    case 4:
                        setValueStringLhs(valueStringRhs.toString(), true);
                        break;
                    // F to K
                    case 5:
                        setValueStringLhs(df.format(((val - 32) * 0.5555555556) + K), true);
                }
                break;
            // Kelvin Selected
            case 5:
                switch (selectedItemLhs) {
                    // K to C
                    case 3:
                        setValueStringLhs(df.format(val - K), true);
                        break;
                    // K to F
                    case 4:
                        setValueStringLhs(df.format(((val - K) * 1.8) + 32), true);
                        break;
                    // K to K
                    case 5:
                        setValueStringLhs(valueStringRhs.toString(), true);
                }
        }
    }

    private void convertLToR() {
        if (selectedUnitIndex == 3) {
            tempConvertLtoR();
            return;
        }
        double val;
        try {
            val = Double.parseDouble(valueStringLhs.toString());
        } catch (NumberFormatException e) {
            val = 0;
        }
        val *= Double
                .parseDouble(
                        Objects
                                .requireNonNull(unitRange
                                        .get(selectedUnitIndex))
                                .get(selectedItemLhs)[2]
                                .toString());
        //Divide val with the change rate of convertedVal
        double convertedVal = Double.parseDouble(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemRhs)[2].toString());
        convertedVal = val / convertedVal;
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        setValueStringRhs(df.format(convertedVal), true);
    }

    private void convertRToL() {
        if (selectedUnitIndex == 3) {
            tempConvertRtoL();
            return;
        }
        double val;
        try {
            val = Double.parseDouble(valueStringLhs.toString());
        } catch (NumberFormatException e) {
            val = 0;
        }
        val *= Double.parseDouble(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemRhs)[2].toString());
        //Divide val with the change rate of convertedVal
        double convertedVal = Double.parseDouble(Objects.requireNonNull(unitRange.get(selectedUnitIndex)).get(selectedItemLhs)[2].toString());
        convertedVal = val / convertedVal;

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        setValueStringLhs(df.format(convertedVal), true);
    }

    public boolean islToR() {
        return lToR;
    }

    public void setlToR(boolean lToR) {
        this.lToR = lToR;
        convert();
    }


    public void setLeftCursorStart(int leftCursorStart) {
        this.leftCursorStart = leftCursorStart;
    }


    public void setLeftCursorEnd(int leftCursorEnd) {
        this.leftCursorEnd = leftCursorEnd;
    }


    public void setRightCursorStart(int rightCursorStart) {
        this.rightCursorStart = rightCursorStart;
    }


    public void setRightCursorEnd(int rightCursorEnd) {
        this.rightCursorEnd = rightCursorEnd;
    }

    public void setEdLeft(EditText edLeft) {
        this.edLeft = edLeft;
    }

    public void setEdRight(EditText edRight) {
        this.edRight = edRight;
    }
}
