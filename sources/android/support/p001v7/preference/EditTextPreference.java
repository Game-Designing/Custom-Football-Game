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

/* renamed from: android.support.v7.preference.EditTextPreference */
public class EditTextPreference extends DialogPreference {

    /* renamed from: T */
    private String f2408T;

    /* renamed from: android.support.v7.preference.EditTextPreference$SavedState */
    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0821e();

        /* renamed from: a */
        String f2409a;

        public SavedState(Parcel source) {
            super(source);
            this.f2409a = source.readString();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.f2409a);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }

    public EditTextPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EditTextPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public EditTextPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.editTextPreferenceStyle, 16842898));
    }

    /* renamed from: d */
    public void mo6307d(String text) {
        boolean wasBlocking = mo6305P();
        this.f2408T = text;
        mo6364c(text);
        boolean isBlocking = mo6305P();
        if (isBlocking != wasBlocking) {
            mo6359b(isBlocking);
        }
    }

    /* renamed from: X */
    public String mo6306X() {
        return this.f2408T;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4891a(TypedArray a, int index) {
        return a.getString(index);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4893a(boolean restoreValue, Object defaultValue) {
        mo6307d(restoreValue ? mo6355b(this.f2408T) : (String) defaultValue);
    }

    /* renamed from: P */
    public boolean mo6305P() {
        return TextUtils.isEmpty(this.f2408T) || super.mo6305P();
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public Parcelable mo4887N() {
        Parcelable superState = super.mo4887N();
        if (mo6330E()) {
            return superState;
        }
        SavedState myState = new SavedState(superState);
        myState.f2409a = mo6306X();
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
        mo6307d(myState.f2409a);
    }
}
