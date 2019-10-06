package com.adyen.p081ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* renamed from: com.adyen.ui.views.CheckoutCheckBox */
public class CheckoutCheckBox extends CheckBox {
    public CheckoutCheckBox(Context context) {
        super(context);
    }

    public CheckoutCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckoutCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public CheckoutCheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /* renamed from: a */
    public void mo17791a() {
        if (VERSION.SDK_INT >= 21) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                background.setState(new int[]{16842919, 16842910});
                new Handler().postDelayed(new C5650k(this, background), 200);
            }
        }
    }
}
