package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.g */
/* compiled from: BackStackRecord */
class C0471g implements Creator<BackStackState> {
    C0471g() {
    }

    public BackStackState createFromParcel(Parcel in) {
        return new BackStackState(in);
    }

    public BackStackState[] newArray(int size) {
        return new BackStackState[size];
    }
}
