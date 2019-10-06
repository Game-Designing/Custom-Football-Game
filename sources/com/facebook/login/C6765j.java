package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.j */
/* compiled from: DeviceAuthDialog */
class C6765j implements Creator<RequestState> {
    C6765j() {
    }

    public RequestState createFromParcel(Parcel in) {
        return new RequestState(in);
    }

    public RequestState[] newArray(int size) {
        return new RequestState[size];
    }
}
