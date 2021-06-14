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

    private void convertLToR() {
        double val = Double.parseDouble(valueStringLhs.toString());
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
        double val = Double.parseDouble(valueStringRhs.toString());
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
