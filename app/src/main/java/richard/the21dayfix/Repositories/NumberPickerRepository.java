package richard.the21dayfix.Repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.NumberPicker;

public class NumberPickerRepository {
    private String _key = "water";

    public void SaveValue(NumberPicker numberPicker) {
        int number = numberPicker.getValue();

        SharedPreferences sharedPreferences = numberPicker.getContext().getSharedPreferences(_key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(_key, number);
        editor.commit();
    }

    public int GetValue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(_key, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(_key, 0);
    }
}
