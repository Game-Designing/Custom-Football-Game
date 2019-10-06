package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.Fragment.SavedState;

/* renamed from: android.support.v4.app.n */
/* compiled from: Fragment */
class C0481n implements Creator<SavedState> {
    C0481n() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in, null);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
