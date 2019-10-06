package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.k */
/* compiled from: DeviceAuthMethodHandler */
class C6766k implements Creator {
    C6766k() {
    }

    public DeviceAuthMethodHandler createFromParcel(Parcel source) {
        return new DeviceAuthMethodHandler(source);
    }

    public DeviceAuthMethodHandler[] newArray(int size) {
        return new DeviceAuthMethodHandler[size];
    }
}
