package nseit.com.tmdb.Common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by vishvendu on 18/8/17.
 */

public class FontTypeFace extends TextView {

    public FontTypeFace(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontTypeFace(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontTypeFace(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");
            setTypeface(tf);
        }
    }

}
