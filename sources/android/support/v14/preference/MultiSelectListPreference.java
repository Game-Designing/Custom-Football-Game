package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p001v7.preference.C0797C;
import android.support.p001v7.preference.C0805H;
import android.support.p001v7.preference.Preference.BaseSavedState;
import android.support.p001v7.preference.internal.AbstractMultiSelectListPreference;
import android.util.AttributeSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference extends AbstractMultiSelectListPreference {

    /* renamed from: T */
    private CharSequence[] f1329T;

    /* renamed from: U */
    private CharSequence[] f1330U;

    /* renamed from: V */
    private Set<String> f1331V;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0407a();

        /* renamed from: a */
        Set<String> f1332a;

        SavedState(Parcel source) {
            super(source);
            int size = source.readInt();
            this.f1332a = new HashSet();
            String[] strings = new String[size];
            source.readStringArray(strings);
            Collections.addAll(this.f1332a, strings);
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f1332a.size());
            Set<String> set = this.f1332a;
            dest.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f1331V = new HashSet();
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.MultiSelectListPreference, defStyleAttr, defStyleRes);
        this.f1329T = C0509e.m2563d(a, C0805H.MultiSelectListPreference_entries, C0805H.MultiSelectListPreference_android_entries);
        this.f1330U = C0509e.m2563d(a, C0805H.MultiSelectListPreference_entryValues, C0805H.MultiSelectListPreference_android_entryValues);
        a.recycle();
    }

    public MultiSelectListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.dialogPreferenceStyle, 16842897));
    }

    /* renamed from: X */
    public CharSequence[] mo4888X() {
        return this.f1329T;
    }

    /* renamed from: Y */
    public CharSequence[] mo4889Y() {
        return this.f1330U;
    }

    /* renamed from: c */
    public void mo4894c(Set<String> values) {
        this.f1331V.clear();
        this.f1331V.addAll(values);
        mo6361b(values);
    }

    /* renamed from: Z */
    public Set<String> mo4890Z() {
        return this.f1331V;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4891a(TypedArray a, int index) {
        CharSequence[] defaultValues = a.getTextArray(index);
        Set<String> result = new HashSet<>();
        for (CharSequence defaultValue : defaultValues) {
            result.add(defaultValue.toString());
        }
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4893a(boolean restoreValue, Object defaultValue) {
        mo4894c(restoreValue ? mo6342a(this.f1331V) : (Set) defaultValue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public Parcelable mo4887N() {
        Parcelable superState = super.mo4887N();
        if (mo6330E()) {
            return superState;
        }
        SavedState myState = new SavedState(superState);
        myState.f1332a = mo4890Z();
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
        mo4894c(myState.f1332a);
    }
}
