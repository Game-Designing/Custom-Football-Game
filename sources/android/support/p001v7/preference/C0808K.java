package android.support.p001v7.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v7.preference.K */
/* compiled from: SeekBarPreference */
class C0808K implements Creator<SavedState> {
    C0808K() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
