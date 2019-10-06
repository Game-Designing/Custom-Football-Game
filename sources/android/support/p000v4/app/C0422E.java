package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.E */
/* compiled from: FragmentState */
class C0422E implements Creator<FragmentState> {
    C0422E() {
    }

    public FragmentState createFromParcel(Parcel in) {
        return new FragmentState(in);
    }

    public FragmentState[] newArray(int size) {
        return new FragmentState[size];
    }
}
