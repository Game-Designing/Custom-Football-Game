package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.C0277X;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p151c.p152a.C7281d;
import p019d.p151c.p152a.p153a.C7277g;

/* renamed from: com.braintreepayments.cardform.view.a */
/* compiled from: ErrorEditText */
public class C5900a extends C0277X {

    /* renamed from: c */
    private Animation f10307c;

    /* renamed from: d */
    private boolean f10308d;

    /* renamed from: e */
    private boolean f10309e;

    public C5900a(Context context) {
        super(context);
        m10771m();
    }

    public C5900a(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10771m();
    }

    public C5900a(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10771m();
    }

    /* renamed from: m */
    private void m10771m() {
        this.f10307c = AnimationUtils.loadAnimation(getContext(), C7281d.bt_error_animation);
        this.f10308d = false;
        m10772n();
    }

    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setError(null);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (!focused && !mo18431k() && !TextUtils.isEmpty(getText())) {
            setError(getErrorMessage());
        }
    }

    public void setFieldHint(int hint) {
        setFieldHint(getContext().getString(hint));
    }

    public void setFieldHint(String hint) {
        if (getTextInputLayoutParent() != null) {
            getTextInputLayoutParent().setHint(hint);
        } else {
            setHint(hint);
        }
    }

    /* renamed from: i */
    public View mo18492i() {
        View next;
        if (getImeActionId() == 2) {
            return null;
        }
        try {
            next = focusSearch(2);
        } catch (IllegalArgumentException e) {
            next = focusSearch(Opcodes.IXOR);
        }
        if (next == null || !next.requestFocus()) {
            return null;
        }
        return next;
    }

    public void setOptional(boolean optional) {
        this.f10309e = optional;
    }

    /* renamed from: j */
    public boolean mo18493j() {
        return this.f10309e;
    }

    public void setError(String errorMessage) {
        this.f10308d = !TextUtils.isEmpty(errorMessage);
        TextInputLayout textInputLayout = getTextInputLayoutParent();
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(!TextUtils.isEmpty(errorMessage));
            textInputLayout.setError(errorMessage);
        }
        Animation animation = this.f10307c;
        if (animation != null && this.f10308d) {
            startAnimation(animation);
            C7277g.m15845a(getContext(), 10);
        }
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return true;
    }

    public String getErrorMessage() {
        return null;
    }

    /* renamed from: l */
    public void mo18494l() {
        if (mo18431k() || mo18493j()) {
            setError(null);
        } else {
            setError(getErrorMessage());
        }
    }

    /* renamed from: h */
    public void mo18491h() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public TextInputLayout getTextInputLayoutParent() {
        if (getParent() == null || !(getParent().getParent() instanceof TextInputLayout)) {
            return null;
        }
        return (TextInputLayout) getParent().getParent();
    }

    /* renamed from: n */
    private void m10772n() {
        if (VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            setTextDirection(3);
            setGravity(5);
        }
    }
}
