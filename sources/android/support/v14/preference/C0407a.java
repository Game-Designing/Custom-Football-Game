package android.support.v14.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v14.preference.a */
/* compiled from: MultiSelectListPreference */
class C0407a implements Creator<SavedState> {
    C0407a() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
