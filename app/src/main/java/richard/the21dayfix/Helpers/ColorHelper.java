package richard.the21dayfix.Helpers;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.CheckBox;

public class ColorHelper {
    public static ColorStateList GetColorStateListFromHex(String hexValue) {
        int colorAsInt = Color.parseColor(hexValue);
        return ColorStateList.valueOf(colorAsInt);
    }

    public static String GetColorFromHex(String hexValue) {
        return Color.parseColor(hexValue) + "";
    }

    public static String GetColorFromCheckBox(CheckBox checkBox) {
        ColorStateList buttonTintList = checkBox.getButtonTintList();
        return buttonTintList.getDefaultColor() + "";
    }
}
