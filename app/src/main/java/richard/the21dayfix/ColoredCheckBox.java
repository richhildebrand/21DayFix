package richard.the21dayfix;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import richard.the21dayfix.Helpers.ColorHelper;
import richard.the21dayfix.Repositories.CheckBoxRepository;

public class ColoredCheckBox extends LinearLayout {

    private CheckBox _checkBox;

    public ColoredCheckBox(Context context) {
        super(context);
        inflate(context);
        _checkBox = (CheckBox) findViewById(R.id.checkbox);
        addOnClickListenerToCheckBox();
    }

    public void setCheckBoxColor(String colorAsHex) {
        ColorStateList colorStateList = ColorHelper.GetColorStateListFromHex(colorAsHex);
        _checkBox.setButtonTintList(colorStateList);
    }

    public void setCheckBoxTag(String tag) {
        _checkBox.setTag(tag);
    }

    public void setCheckBoxState(boolean isChecked) {
        _checkBox.setChecked(isChecked);
    }

    private void inflate(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_colored_check_box, this);
    }

    private void addOnClickListenerToCheckBox() {
        _checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = (CheckBox)view;
                CheckBoxRepository checkBoxRepository = new CheckBoxRepository();
                checkBoxRepository.SaveCheckBoxState(checkBox);
            }
        });
    }
}