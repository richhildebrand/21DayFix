package richard.the21dayfix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ColoredCheckBox extends LinearLayout
{
    public ColoredCheckBox(Context context)
    {
        super(context);
        initControl(context);
    }

    public ColoredCheckBox(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initControl(context);
    }

/*    public GhostSurfaceCameraView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }*/

    private void initControl(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_colored_check_box, this);
    }
}