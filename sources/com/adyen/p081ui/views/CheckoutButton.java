package com.adyen.p081ui.views;

import android.content.Context;
import android.support.p001v7.widget.AppCompatButton;
import android.util.AttributeSet;

/* renamed from: com.adyen.ui.views.CheckoutButton */
public class CheckoutButton extends AppCompatButton {
    public CheckoutButton(Context context) {
        super(context);
    }

    public CheckoutButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckoutButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            getBackground().setAlpha(255);
        } else {
            getBackground().setAlpha(96);
        }
    }
}
