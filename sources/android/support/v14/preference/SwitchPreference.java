package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p001v7.preference.C0796B;
import android.support.p001v7.preference.C0797C;
import android.support.p001v7.preference.C0805H;
import android.support.p001v7.preference.TwoStatePreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class SwitchPreference extends TwoStatePreference {

    /* renamed from: S */
    private final C0406a f1333S;

    /* renamed from: T */
    private CharSequence f1334T;

    /* renamed from: U */
    private CharSequence f1335U;

    /* renamed from: android.support.v14.preference.SwitchPreference$a */
    private class C0406a implements OnCheckedChangeListener {
        private C0406a() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!SwitchPreference.this.mo6353a((Object) Boolean.valueOf(isChecked))) {
                buttonView.setChecked(!isChecked);
            } else {
                SwitchPreference.this.mo6416f(isChecked);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f1333S = new C0406a();
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.SwitchPreference, defStyleAttr, defStyleRes);
        mo6415d(C0509e.m2560b(a, C0805H.SwitchPreference_summaryOn, C0805H.SwitchPreference_android_summaryOn));
        mo6414c(C0509e.m2560b(a, C0805H.SwitchPreference_summaryOff, C0805H.SwitchPreference_android_summaryOff));
        mo4899f(C0509e.m2560b(a, C0805H.SwitchPreference_switchTextOn, C0805H.SwitchPreference_android_switchTextOn));
        mo4898e(C0509e.m2560b(a, C0805H.SwitchPreference_switchTextOff, C0805H.SwitchPreference_android_switchTextOff));
        mo6417g(C0509e.m2554a(a, C0805H.SwitchPreference_disableDependentsState, C0805H.SwitchPreference_android_disableDependentsState, false));
        a.recycle();
    }

    public SwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SwitchPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.switchPreferenceStyle, 16843629));
    }

    /* renamed from: a */
    public void mo4896a(C0796B holder) {
        super.mo4896a(holder);
        m2030c(holder.mo6283a(16908352));
        mo6412b(holder);
    }

    /* renamed from: f */
    public void mo4899f(CharSequence onText) {
        this.f1334T = onText;
        mo6302H();
    }

    /* renamed from: e */
    public void mo4898e(CharSequence offText) {
        this.f1335U = offText;
        mo6302H();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4897a(View view) {
        super.mo4897a(view);
        m2031d(view);
    }

    /* renamed from: d */
    private void m2031d(View view) {
        if (((AccessibilityManager) mo6373f().getSystemService("accessibility")).isEnabled()) {
            m2030c(view.findViewById(16908352));
            mo6413b(view.findViewById(16908304));
        }
    }

    /* renamed from: c */
    private void m2030c(View view) {
        if (view instanceof Switch) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f2488P);
        }
        if (view instanceof Switch) {
            Switch switchView = (Switch) view;
            switchView.setTextOn(this.f1334T);
            switchView.setTextOff(this.f1335U);
            switchView.setOnCheckedChangeListener(this.f1333S);
        }
    }
}
