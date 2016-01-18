package richard.the21dayfix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import richard.the21dayfix.Repositories.NumberPickerRepository;

public class CustomNumberPicker extends LinearLayout {

    private NumberPicker _numberPicker;

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
        _numberPicker = (NumberPicker) findViewById(R.id.number_picker);
        _numberPicker.setMinValue(0);
        _numberPicker.setMaxValue(75);

        NumberPickerRepository repository = new NumberPickerRepository();
        int value = repository.GetValue(_numberPicker.getContext());
        _numberPicker.setValue(value);

        _numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                NumberPickerRepository numberPickerRepository = new NumberPickerRepository();
                numberPickerRepository.SaveValue(picker);
            }
        });
    }
}