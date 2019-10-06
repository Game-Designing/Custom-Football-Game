package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.internal.d */
/* compiled from: DeviceShareDialogFragment */
class C6793d implements Creator<RequestState> {
    C6793d() {
    }

    public RequestState createFromParcel(Parcel in) {
        return new RequestState(in);
    }

    public RequestState[] newArray(int size) {
        return new RequestState[size];
    }
}
