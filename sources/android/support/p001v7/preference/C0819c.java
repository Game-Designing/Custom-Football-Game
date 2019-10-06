package android.support.p001v7.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v7.preference.c */
/* compiled from: CollapsiblePreferenceGroupController */
class C0819c implements Creator<SavedState> {
    C0819c() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
