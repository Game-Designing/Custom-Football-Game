package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.a */
/* compiled from: AccessToken */
class C6559a implements Creator {
    C6559a() {
    }

    public AccessToken createFromParcel(Parcel source) {
        return new AccessToken(source);
    }

    public AccessToken[] newArray(int size) {
        return new AccessToken[size];
    }
}
