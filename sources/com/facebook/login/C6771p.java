package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.p */
/* compiled from: GetTokenLoginMethodHandler */
class C6771p implements Creator {
    C6771p() {
    }

    public GetTokenLoginMethodHandler createFromParcel(Parcel source) {
        return new GetTokenLoginMethodHandler(source);
    }

    public GetTokenLoginMethodHandler[] newArray(int size) {
        return new GetTokenLoginMethodHandler[size];
    }
}
