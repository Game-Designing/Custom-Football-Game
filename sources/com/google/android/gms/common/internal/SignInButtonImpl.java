package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.base.C8625R;
import com.google.android.gms.common.util.DeviceProperties;
import p002b.p003c.p053g.p054a.p055a.C1200a;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: a */
    public final void mo27828a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = C8625R.drawable.common_google_signin_btn_icon_dark;
        int i5 = C8625R.drawable.common_google_signin_btn_icon_light;
        int a = m21885a(i2, i4, i5, i5);
        int i6 = C8625R.drawable.common_google_signin_btn_text_dark;
        int i7 = C8625R.drawable.common_google_signin_btn_text_light;
        int a2 = m21885a(i2, i6, i7, i7);
        String str = "Unknown button size: ";
        if (i == 0 || i == 1) {
            a = a2;
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(str);
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        Drawable i8 = C1200a.m5741i(resources.getDrawable(a));
        C1200a.m5726a(i8, resources.getColorStateList(C8625R.color.common_google_signin_btn_tint));
        C1200a.m5729a(i8, Mode.SRC_ATOP);
        setBackgroundDrawable(i8);
        int i9 = C8625R.color.common_google_signin_btn_text_dark;
        int i10 = C8625R.color.common_google_signin_btn_text_light;
        ColorStateList colorStateList = resources.getColorStateList(m21885a(i2, i9, i10, i10));
        Preconditions.m21857a(colorStateList);
        setTextColor(colorStateList);
        if (i == 0) {
            setText(resources.getString(C8625R.string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(C8625R.string.common_signin_button_text_long));
        } else if (i == 2) {
            setText(null);
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(str);
            sb2.append(i);
            throw new IllegalStateException(sb2.toString());
        }
        setTransformationMethod(null);
        if (DeviceProperties.m22094c(getContext())) {
            setGravity(19);
        }
    }

    /* renamed from: a */
    private static int m21885a(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
