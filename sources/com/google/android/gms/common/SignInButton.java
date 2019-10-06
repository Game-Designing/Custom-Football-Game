package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements OnClickListener {

    /* renamed from: a */
    private int f19535a;

    /* renamed from: b */
    private int f19536b;

    /* renamed from: c */
    private View f19537c;

    /* renamed from: d */
    private OnClickListener f19538d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public final void setSize(int i) {
        mo27317a(i, this.f19536b);
    }

    public final void setColorScheme(int i) {
        mo27317a(this.f19535a, i);
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        mo27317a(this.f19535a, this.f19536b);
    }

    /* renamed from: a */
    public final void mo27317a(int i, int i2) {
        this.f19535a = i;
        this.f19536b = i2;
        Context context = getContext();
        View view = this.f19537c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f19537c = SignInButtonCreator.m21881a(context, this.f19535a, this.f19536b);
        } catch (RemoteCreatorException e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f19535a;
            int i4 = this.f19536b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.mo27828a(context.getResources(), i3, i4);
            this.f19537c = signInButtonImpl;
        }
        addView(this.f19537c);
        this.f19537c.setEnabled(isEnabled());
        this.f19537c.setOnClickListener(this);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f19538d = onClickListener;
        View view = this.f19537c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f19537c.setEnabled(z);
    }

    public final void onClick(View view) {
        OnClickListener onClickListener = this.f19538d;
        if (onClickListener != null && view == this.f19537c) {
            onClickListener.onClick(this);
        }
    }
}
