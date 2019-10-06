package android.support.p001v7.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p001v7.preference.Preference.BaseSavedState;

/* renamed from: android.support.v7.preference.m */
/* compiled from: Preference */
class C0829m implements Creator<BaseSavedState> {
    C0829m() {
    }

    public BaseSavedState createFromParcel(Parcel in) {
        return new BaseSavedState(in);
    }

    public BaseSavedState[] newArray(int size) {
        return new BaseSavedState[size];
    }
}
