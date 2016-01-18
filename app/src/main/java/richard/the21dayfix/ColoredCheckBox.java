package richard.the21dayfix;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ColoredCheckBox extends LinearLayout {

    public String CheckBoxColor;

    public ColoredCheckBox(Context context) {
        super(context);
        inflate(context);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        addOnClickListener(checkBox);
    }

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

    private void applyColor(String colorAsString) {
        CheckBox checkBoxOne = (CheckBox) findViewById(R.id.checkbox);
        int colorAsInt = Color.parseColor(colorAsString);
        ColorStateList color = ColorStateList.valueOf(colorAsInt);
        checkBoxOne.setButtonTintList(color);
    }

    public void setCheckBoxTag(String tag) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        checkBox.setTag(tag);
    }

    public void setCheckBoxState(boolean isChecked) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        checkBox.setChecked(isChecked);
    }

    private void addOnClickListener(final CheckBox checkBox) {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkbox = (CheckBox)view;
                CheckBoxRepository checkBoxRepository = new CheckBoxRepository();
                checkBoxRepository.SaveCheckBoxState(checkBox);
            }
        });
    }
}