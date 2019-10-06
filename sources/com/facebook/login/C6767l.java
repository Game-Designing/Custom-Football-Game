package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.l */
/* compiled from: FacebookLiteLoginMethodHandler */
class C6767l implements Creator<FacebookLiteLoginMethodHandler> {
    C6767l() {
    }

    public FacebookLiteLoginMethodHandler createFromParcel(Parcel source) {
        return new FacebookLiteLoginMethodHandler(source);
    }

    public FacebookLiteLoginMethodHandler[] newArray(int size) {
        return new FacebookLiteLoginMethodHandler[size];
    }
}
