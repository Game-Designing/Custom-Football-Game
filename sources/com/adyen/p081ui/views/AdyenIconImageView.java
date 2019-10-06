package com.adyen.p081ui.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p001v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.adyen.p081ui.p084c.C5630c;

/* renamed from: com.adyen.ui.views.AdyenIconImageView */
public class AdyenIconImageView extends AppCompatImageView {
    public AdyenIconImageView(Context context) {
        super(context);
    }

    public AdyenIconImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdyenIconImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageDrawable(C5630c.m9927a(getContext(), bm, getMeasuredHeight()));
    }
}
