package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p001v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* renamed from: android.support.v7.preference.SwitchPreferenceCompat */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: S */
    private final C0816a f2482S;

    /* renamed from: T */
    private CharSequence f2483T;

    /* renamed from: U */
    private CharSequence f2484U;

    /* renamed from: android.support.v7.preference.SwitchPreferenceCompat$a */
    private class C0816a implements OnCheckedChangeListener {
        private C0816a() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!SwitchPreferenceCompat.this.mo6353a((Object) Boolean.valueOf(isChecked))) {
                buttonView.setChecked(!isChecked);
            } else {
                SwitchPreferenceCompat.this.mo6416f(isChecked);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f2482S = new C0816a();
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.SwitchPreferenceCompat, defStyleAttr, defStyleRes);
        mo6415d(C0509e.m2560b(a, C0805H.SwitchPreferenceCompat_summaryOn, C0805H.SwitchPreferenceCompat_android_summaryOn));
        mo6414c(C0509e.m2560b(a, C0805H.SwitchPreferenceCompat_summaryOff, C0805H.SwitchPreferenceCompat_android_summaryOff));
        mo6410f(C0509e.m2560b(a, C0805H.SwitchPreferenceCompat_switchTextOn, C0805H.SwitchPreferenceCompat_android_switchTextOn));
        mo6409e(C0509e.m2560b(a, C0805H.SwitchPreferenceCompat_switchTextOff, C0805H.SwitchPreferenceCompat_android_switchTextOff));
        mo6417g(C0509e.m2554a(a, C0805H.SwitchPreferenceCompat_disableDependentsState, C0805H.SwitchPreferenceCompat_android_disableDependentsState, false));
        a.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attrs) {
        this(context, attrs, C0797C.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void mo4896a(C0796B holder) {
        super.mo4896a(holder);
        m3891c(holder.mo6283a(C0802E.switchWidget));
        mo6412b(holder);
    }

    /* renamed from: f */
    public void mo6410f(CharSequence onText) {
        this.f2483T = onText;
        mo6302H();
    }

    /* renamed from: e */
    public void mo6409e(CharSequence offText) {
        this.f2484U = offText;
        mo6302H();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4897a(View view) {
        super.mo4897a(view);
        m3892d(view);
    }

    /* renamed from: d */
    private void m3892d(View view) {
        if (((AccessibilityManager) mo6373f().getSystemService("accessibility")).isEnabled()) {
            m3891c(view.findViewById(C0802E.switchWidget));
            mo6413b(view.findViewById(16908304));
        }
    }

    /* renamed from: c */
    private void m3891c(View view) {
        if (view instanceof SwitchCompat) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f2488P);
        }
        if (view instanceof SwitchCompat) {
            SwitchCompat switchView = (SwitchCompat) view;
            switchView.setTextOn(this.f2483T);
            switchView.setTextOff(this.f2484U);
            switchView.setOnCheckedChangeListener(this.f2482S);
        }
    }
}
