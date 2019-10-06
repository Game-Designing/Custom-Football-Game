package android.support.p001v7.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v7.preference.M */
/* compiled from: TwoStatePreference */
class C0810M implements Creator<SavedState> {
    C0810M() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
