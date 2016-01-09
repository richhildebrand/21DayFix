package richard.the21dayfix;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ColoredCheckBox extends LinearLayout {

    public String CheckBoxColor;

    public ColoredCheckBox(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        inflate(context);
    }

    public void setCheckBoxColor(String color) {
        CheckBoxColor = color;
        applyColor(color);
    }

    private void inflate(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_colored_check_box, this);
    }

    private void applyColor(String color) {
        CheckBox checkBoxOne = (CheckBox) findViewById(R.id.checkbox);
        int textColor = Color.parseColor(color);
        checkBoxOne.setButtonTintList(ColorStateList.valueOf(textColor));
    }
}