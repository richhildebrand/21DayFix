package richard.the21dayfix.Repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.CheckBox;

public class CheckBoxRepository {
    public void SaveCheckBoxState(CheckBox checkBox) {
        Boolean isChecked = checkBox.isChecked();
        String tag = checkBox.getTag().toString();
        ColorStateList buttonTintList = checkBox.getButtonTintList();
        String color = buttonTintList.getDefaultColor() + "";

        SharedPreferences sharedPreferences = checkBox.getContext().getSharedPreferences(color, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(tag, isChecked);
        editor.commit();
    }

    public Boolean GetCheckBoxState(String color, String tag, Context context) {
        String key = Color.parseColor(color) + "";
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(tag, false);
    }
}
