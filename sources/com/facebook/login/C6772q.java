package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.q */
/* compiled from: KatanaProxyLoginMethodHandler */
class C6772q implements Creator<KatanaProxyLoginMethodHandler> {
    C6772q() {
    }

    public KatanaProxyLoginMethodHandler createFromParcel(Parcel source) {
        return new KatanaProxyLoginMethodHandler(source);
    }

    public KatanaProxyLoginMethodHandler[] newArray(int size) {
        return new KatanaProxyLoginMethodHandler[size];
    }
}
