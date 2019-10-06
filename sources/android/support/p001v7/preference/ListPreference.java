package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p001v7.preference.Preference.BaseSavedState;
import android.text.TextUtils;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.ListPreference */
public class ListPreference extends DialogPreference {

    /* renamed from: T */
    private CharSequence[] f2413T;

    /* renamed from: U */
    private CharSequence[] f2414U;

    /* renamed from: V */
    private String f2415V;

    /* renamed from: W */
    private String f2416W;

    /* renamed from: X */
    private boolean f2417X;

    /* renamed from: android.support.v7.preference.ListPreference$SavedState */
    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0823g();

        /* renamed from: a */
        String f2418a;

        public SavedState(Parcel source) {
            super(source);
            this.f2418a = source.readString();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.f2418a);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }

    public ListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.ListPreference, defStyleAttr, defStyleRes);
        this.f2413T = C0509e.m2563d(a, C0805H.ListPreference_entries, C0805H.ListPreference_android_entries);
        this.f2414U = C0509e.m2563d(a, C0805H.ListPreference_entryValues, C0805H.ListPreference_android_entryValues);
        a.recycle();
        TypedArray a2 = context.obtainStyledAttributes(attrs, C0805H.Preference, defStyleAttr, defStyleRes);
        this.f2416W = C0509e.m2560b(a2, C0805H.Preference_summary, C0805H.Preference_android_summary);
        a2.recycle();
    }

    public ListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ListPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.dialogPreferenceStyle, 16842897));
    }

    /* renamed from: X */
    public CharSequence[] mo6315X() {
        return this.f2413T;
    }

    /* renamed from: Z */
    public CharSequence[] mo6317Z() {
        return this.f2414U;
    }

    /* renamed from: e */
    public void mo6321e(String value) {
        boolean changed = !TextUtils.equals(this.f2415V, value);
        if (changed || !this.f2417X) {
            this.f2415V = value;
            this.f2417X = true;
            mo6364c(value);
            if (changed) {
                mo6302H();
            }
        }
    }

    /* renamed from: z */
    public CharSequence mo6322z() {
        CharSequence entry = mo6316Y();
        String str = this.f2416W;
        if (str == null) {
            return super.mo6322z();
        }
        Object[] objArr = new Object[1];
        objArr[0] = entry == null ? "" : entry;
        return String.format(str, objArr);
    }

    /* renamed from: a */
    public void mo6318a(CharSequence summary) {
        super.mo6318a(summary);
        if (summary == null && this.f2416W != null) {
            this.f2416W = null;
        } else if (summary != null && !summary.equals(this.f2416W)) {
            this.f2416W = summary.toString();
        }
    }

    /* renamed from: aa */
    public String mo6319aa() {
        return this.f2415V;
    }

    /* renamed from: Y */
    public CharSequence mo6316Y() {
        int index = mo6303ba();
        if (index >= 0) {
            CharSequence[] charSequenceArr = this.f2413T;
            if (charSequenceArr != null) {
                return charSequenceArr[index];
            }
        }
        return null;
    }

    /* renamed from: d */
    public int mo6320d(String value) {
        if (value != null) {
            CharSequence[] charSequenceArr = this.f2414U;
            if (charSequenceArr != null) {
                for (int i = charSequenceArr.length - 1; i >= 0; i--) {
                    if (this.f2414U[i].equals(value)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /* renamed from: ba */
    private int mo6303ba() {
        return mo6320d(this.f2415V);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4891a(TypedArray a, int index) {
        return a.getString(index);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4893a(boolean restoreValue, Object defaultValue) {
        mo6321e(restoreValue ? mo6355b(this.f2415V) : (String) defaultValue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public Parcelable mo4887N() {
        Parcelable superState = super.mo4887N();
        if (mo6330E()) {
            return superState;
        }
        SavedState myState = new SavedState(superState);
        myState.f2418a = mo6319aa();
        return myState;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4892a(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            super.mo4892a(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.mo4892a(myState.getSuperState());
        mo6321e(myState.f2418a);
    }
}
