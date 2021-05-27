package com.project.unitconverter.data;


import androidx.databinding.BaseObservable;

import java.util.Stack;

/**
 * A class which holds the data of the user's input, output and processing.
 * This is a Binding class. Binding means that the views in the .xml files such as (TextView, EditText, etc..) individually connect to variables in this class.
 * Any change in the variables which are bound to the views, results in the change in the value of the view itself and vic-versa.
 */

public class Data extends BaseObservable {
    Stack<Integer> operands = new Stack<Integer>();
    Stack<String> operators = new Stack<String>();
    StringBuilder valueString = new StringBuilder();

    public void operatorClickListener(String val) {

    }

    public void operandClickListener(double val) {

    }

    public void btnEqualsClickListener() {

    }

    public void btnTransferClickListener() {

    }

    public void decimalClickListener() {

    }

    public void plusMinusClickListener() {

    }
}
