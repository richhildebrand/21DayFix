package richard.the21dayfix.Repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;

import richard.the21dayfix.Helpers.ColorHelper;

public class CheckBoxRepository {
    public void SaveCheckBoxState(CheckBox checkBox) {
        Boolean isChecked = checkBox.isChecked();
        String tag = checkBox.getTag().toString();
        String color = ColorHelper.GetColorFromCheckBox(checkBox);

        SharedPreferences sharedPreferences = checkBox.getContext().getSharedPreferences(color, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(tag, isChecked);
        editor.commit();
    }

    public Boolean GetCheckBoxState(String colorAsHex, String tag, Context context) {
        String key = ColorHelper.GetColorFromHex(colorAsHex);
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(tag, false);
    }
}
