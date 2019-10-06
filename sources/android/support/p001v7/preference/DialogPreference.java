package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.p036a.C0509e;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.DialogPreference */
public abstract class DialogPreference extends Preference {

    /* renamed from: N */
    private CharSequence f2397N;

    /* renamed from: O */
    private CharSequence f2398O;

    /* renamed from: P */
    private Drawable f2399P;

    /* renamed from: Q */
    private CharSequence f2400Q;

    /* renamed from: R */
    private CharSequence f2401R;

    /* renamed from: S */
    private int f2402S;

    /* renamed from: android.support.v7.preference.DialogPreference$a */
    public interface C0801a {
        Preference findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.DialogPreference, defStyleAttr, defStyleRes);
        this.f2397N = C0509e.m2560b(a, C0805H.DialogPreference_dialogTitle, C0805H.DialogPreference_android_dialogTitle);
        if (this.f2397N == null) {
            this.f2397N = mo6326A();
        }
        this.f2398O = C0509e.m2560b(a, C0805H.DialogPreference_dialogMessage, C0805H.DialogPreference_android_dialogMessage);
        this.f2399P = C0509e.m2552a(a, C0805H.DialogPreference_dialogIcon, C0805H.DialogPreference_android_dialogIcon);
        this.f2400Q = C0509e.m2560b(a, C0805H.DialogPreference_positiveButtonText, C0805H.DialogPreference_android_positiveButtonText);
        this.f2401R = C0509e.m2560b(a, C0805H.DialogPreference_negativeButtonText, C0805H.DialogPreference_android_negativeButtonText);
        this.f2402S = C0509e.m2557b(a, C0805H.DialogPreference_dialogLayout, C0805H.DialogPreference_android_dialogLayout, 0);
        a.recycle();
    }

    public DialogPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DialogPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.dialogPreferenceStyle, 16842897));
    }

    /* renamed from: U */
    public CharSequence mo6298U() {
        return this.f2397N;
    }

    /* renamed from: T */
    public CharSequence mo6297T() {
        return this.f2398O;
    }

    /* renamed from: R */
    public Drawable mo6295R() {
        return this.f2399P;
    }

    /* renamed from: W */
    public CharSequence mo6300W() {
        return this.f2400Q;
    }

    /* renamed from: V */
    public CharSequence mo6299V() {
        return this.f2401R;
    }

    /* renamed from: S */
    public int mo6296S() {
        return this.f2402S;
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public void mo6294K() {
        mo6386x().mo6508a((Preference) this);
    }
}
