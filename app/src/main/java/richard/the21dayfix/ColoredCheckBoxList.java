package richard.the21dayfix;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ColoredCheckBoxList extends LinearLayout {

    public ColoredCheckBoxList(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        inflate(context);
        String color = getColor(context, attrs);
        setColors(color);
    }

    private void inflate(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_colored_check_box_list, this);
    }

    private String getColor(Context context, AttributeSet attrs) {
        TypedArray coloredCheckBoxAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColoredCheckBoxElement, 0, 0);
        return coloredCheckBoxAttributes.getString(R.styleable.ColoredCheckBoxElement_CheckBoxColor);
    }

    private void setColors(String color) {
        setColor(R.id.checkbox_one, color);
        setColor(R.id.checkbox_two, color);
        setColor(R.id.checkbox_three, color);
        setColor(R.id.checkbox_four, color);
    }

    private void setColor(Integer id, String color) {
        ColoredCheckBox coloredCheckBox = (ColoredCheckBox) findViewById(id);
        coloredCheckBox.setCheckBoxColor(color);
    }

}