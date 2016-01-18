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
        Integer numberOfCheckBoxes = getNumberOfCheckBoxes(context, attrs);
        setColors(color, numberOfCheckBoxes, context);
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

    private Integer getNumberOfCheckBoxes(Context context, AttributeSet attrs) {
        TypedArray coloredCheckBoxAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColoredCheckBoxElement, 0, 0);
        return coloredCheckBoxAttributes.getInteger(R.styleable.ColoredCheckBoxElement_CheckBoxCount, 0);
    }

    private void setColors(String color, Integer numberOfCheckBoxes, Context context) {
        for (int i = 1; i<= numberOfCheckBoxes; i++)
        {
            LinearLayout container = (LinearLayout) findViewById(R.id.colored_check_box_list);
            ColoredCheckBox checkBox = new ColoredCheckBox(context);
            checkBox.setCheckBoxColor(color);
            String tag = "checkBox_" + i;
            checkBox.setCheckBoxTag(tag);

            CheckBoxRepository checkBoxRepository = new CheckBoxRepository();
            Boolean isChecked = checkBoxRepository.GetCheckBoxState(color, tag, checkBox.getContext());
            checkBox.setCheckBoxState(isChecked);
            container.addView(checkBox);
        }
    }
}