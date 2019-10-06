package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.C */
/* compiled from: FragmentManager */
class C0420C implements Creator<FragmentManagerState> {
    C0420C() {
    }

    public FragmentManagerState createFromParcel(Parcel in) {
        return new FragmentManagerState(in);
    }

    public FragmentManagerState[] newArray(int size) {
        return new FragmentManagerState[size];
    }
}
