package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.content.p036a.C0509e;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* renamed from: android.support.v7.preference.CheckBoxPreference */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: S */
    private final C0798a f2391S;

    /* renamed from: android.support.v7.preference.CheckBoxPreference$a */
    private class C0798a implements OnCheckedChangeListener {
        private C0798a() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!CheckBoxPreference.this.mo6353a((Object) Boolean.valueOf(isChecked))) {
                buttonView.setChecked(!isChecked);
            } else {
                CheckBoxPreference.this.mo6416f(isChecked);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f2391S = new C0798a();
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.CheckBoxPreference, defStyleAttr, defStyleRes);
        mo6415d(C0509e.m2560b(a, C0805H.CheckBoxPreference_summaryOn, C0805H.CheckBoxPreference_android_summaryOn));
        mo6414c(C0509e.m2560b(a, C0805H.CheckBoxPreference_summaryOff, C0805H.CheckBoxPreference_android_summaryOff));
        mo6417g(C0509e.m2554a(a, C0805H.CheckBoxPreference_disableDependentsState, C0805H.CheckBoxPreference_android_disableDependentsState, false));
        a.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.checkBoxPreferenceStyle, 16842895));
    }

    /* renamed from: a */
    public void mo4896a(C0796B holder) {
        super.mo4896a(holder);
        m3713c(holder.mo6283a(16908289));
        mo6412b(holder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4897a(View view) {
        super.mo4897a(view);
        m3714d(view);
    }

    /* renamed from: d */
    private void m3714d(View view) {
        if (((AccessibilityManager) mo6373f().getSystemService("accessibility")).isEnabled()) {
            m3713c(view.findViewById(16908289));
            mo6413b(view.findViewById(16908304));
        }
    }

    /* renamed from: c */
    private void m3713c(View view) {
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f2488P);
        }
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f2391S);
        }
    }
}
