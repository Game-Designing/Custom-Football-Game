package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.G */
/* compiled from: WebViewLoginMethodHandler */
class C6751G implements Creator<WebViewLoginMethodHandler> {
    C6751G() {
    }

    public WebViewLoginMethodHandler createFromParcel(Parcel source) {
        return new WebViewLoginMethodHandler(source);
    }

    public WebViewLoginMethodHandler[] newArray(int size) {
        return new WebViewLoginMethodHandler[size];
    }
}
