package richard.the21dayfix;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ColoredCheckBox extends LinearLayout {

    public ColoredCheckBox(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        inflate(context);
        String checkBoxColor = getColor(context, attrs);
        applyColors(checkBoxColor);
    }

    private void inflate(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_colored_check_box, this);
    }

    private String getColor(Context context, AttributeSet attrs) {
        TypedArray coloredCheckBoxAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColoredCheckBoxElement, 0, 0);
        return coloredCheckBoxAttributes.getString(R.styleable.ColoredCheckBoxElement_CheckBoxColor);
    }

    private void applyColors(String color) {
        applyColor(R.id.checkbox_one, color);
        applyColor(R.id.checkbox_two, color);
        applyColor(R.id.checkbox_three, color);
        applyColor(R.id.checkbox_four, color);
    }

    private void applyColor(Integer id, String color) {
        CheckBox checkBoxOne = (CheckBox) findViewById(id);
        int textColor = Color.parseColor(color);
        checkBoxOne.setButtonTintList(ColorStateList.valueOf(textColor));
    }
}