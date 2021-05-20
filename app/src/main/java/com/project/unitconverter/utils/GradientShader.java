package com.project.unitconverter.utils;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;

import com.project.unitconverter.R;

public class GradientShader {
    public static Shader getMediumTextShader(Context context)
    {
        return new LinearGradient(0, 15, 650, 15,
                new int[]{context.getResources().getColor(R.color.primary_light,context.getTheme())
                        ,context.getResources().getColor(R.color.primary_dark,context.getTheme())},
                new float[]{0, 1}, Shader.TileMode.REPEAT);
    }
}
