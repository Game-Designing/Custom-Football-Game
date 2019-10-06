package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.design.internal.e */
/* compiled from: BottomNavigationPresenter */
class C0219e implements Creator<SavedState> {
    C0219e() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
