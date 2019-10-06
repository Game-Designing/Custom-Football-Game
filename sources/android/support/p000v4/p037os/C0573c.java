package android.support.p000v4.p037os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.os.c */
/* compiled from: ResultReceiver */
class C0573c implements Creator<ResultReceiver> {
    C0573c() {
    }

    public ResultReceiver createFromParcel(Parcel in) {
        return new ResultReceiver(in);
    }

    public ResultReceiver[] newArray(int size) {
        return new ResultReceiver[size];
    }
}
