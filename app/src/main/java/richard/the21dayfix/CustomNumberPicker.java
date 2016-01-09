package richard.the21dayfix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class CustomNumberPicker extends LinearLayout {

    public CustomNumberPicker(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        inflate(context);
        initPicker();
    }
    private void inflate(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_number_picker, this);
    }

    private void initPicker() {
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.number_picker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(75);
    }
}