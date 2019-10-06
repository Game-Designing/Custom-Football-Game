package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import java.lang.reflect.Method;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p151c.p152a.C7287j;
import p019d.p151c.p152a.p153a.C7273c;

public class ExpirationDateEditText extends C5900a implements TextWatcher, OnClickListener {

    /* renamed from: f */
    private boolean f10303f;

    /* renamed from: g */
    private OnClickListener f10304g;

    /* renamed from: h */
    private boolean f10305h = true;

    /* renamed from: i */
    private C5906g f10306i;

    public ExpirationDateEditText(Context context) {
        super(context);
        m10765o();
    }

    public ExpirationDateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10765o();
    }

    public ExpirationDateEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10765o();
    }

    /* renamed from: o */
    private void m10765o() {
        setInputType(2);
        setFilters(new InputFilter[]{new LengthFilter(6)});
        addTextChangedListener(this);
        setShowKeyboardOnFocus(!this.f10305h);
        setCursorVisible(true ^ this.f10305h);
        super.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void setActivity(Activity activity) {
        this.f10306i = C5906g.m10780a(activity, this);
    }

    public void setOnClickListener(OnClickListener l) {
        this.f10304g = l;
    }

    public void onClick(View v) {
        if (this.f10305h) {
            mo18491h();
            this.f10306i.show();
        }
        OnClickListener onClickListener = this.f10304g;
        if (onClickListener != null) {
            onClickListener.onClick(v);
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (this.f10306i != null) {
            if (focused && this.f10305h) {
                mo18491h();
                this.f10306i.show();
            } else if (this.f10305h) {
                this.f10306i.dismiss();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C5906g gVar = this.f10306i;
        if (gVar != null && gVar.isShowing()) {
            this.f10306i.dismiss();
        }
    }

    public String getMonth() {
        if (getString().length() < 2) {
            return "";
        }
        return getString().substring(0, 2);
    }

    public String getYear() {
        String string = getString();
        if (string.length() == 4 || string.length() == 6) {
            return getString().substring(2);
        }
        return "";
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return mo18493j() || C7273c.m15832a(getMonth(), getYear());
    }

    public String getErrorMessage() {
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(C7287j.bt_expiration_required);
        }
        return getContext().getString(C7287j.bt_expiration_invalid);
    }

    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        this.f10303f = lengthAfter > lengthBefore;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f10303f && editable.length() == 1 && Character.getNumericValue(editable.charAt(0)) >= 2) {
            m10764b(editable);
        }
        for (Object span : editable.getSpans(0, editable.length(), C5907h.class)) {
            editable.removeSpan(span);
        }
        m10763a(editable);
        if (((getSelectionStart() == 4 && !editable.toString().endsWith("20")) || getSelectionStart() == 6) && mo18431k()) {
            mo18492i();
        }
    }

    private void setShowKeyboardOnFocus(boolean showKeyboardOnFocus) {
        if (VERSION.SDK_INT >= 21) {
            setShowSoftInputOnFocus(showKeyboardOnFocus);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(this, new Object[]{Boolean.valueOf(showKeyboardOnFocus)});
        } catch (Exception e) {
            try {
                Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(this, new Object[]{Boolean.valueOf(showKeyboardOnFocus)});
            } catch (Exception e2) {
                this.f10305h = false;
            }
        }
    }

    /* renamed from: b */
    private void m10764b(Editable editable) {
        editable.replace(0, 1, BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID).append(editable.charAt(0));
    }

    /* renamed from: a */
    private void m10763a(Editable editable) {
        if (2 <= editable.length()) {
            editable.setSpan(new C5907h(), 1, 2, 33);
        }
    }

    private String getString() {
        Editable editable = getText();
        return editable != null ? editable.toString() : "";
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
}
