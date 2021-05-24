package com.project.unitconverter.data;


import androidx.databinding.BaseObservable;

import java.util.Stack;

public class Test extends BaseObservable {
    Stack<Integer> operands = new Stack<Integer>();
    Stack<String> operators = new Stack<String>();

    public void clickerListener(String val) {

    }

}
