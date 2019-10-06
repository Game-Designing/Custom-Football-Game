package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.a */
/* compiled from: CustomTabLoginMethodHandler */
class C6756a implements Creator {
    C6756a() {
    }

    public CustomTabLoginMethodHandler createFromParcel(Parcel source) {
        return new CustomTabLoginMethodHandler(source);
    }

    public CustomTabLoginMethodHandler[] newArray(int size) {
        return new CustomTabLoginMethodHandler[size];
    }
}
