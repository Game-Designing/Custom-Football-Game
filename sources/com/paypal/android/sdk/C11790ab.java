package com.paypal.android.sdk;

import android.os.Parcel;

/* renamed from: com.paypal.android.sdk.ab */
public abstract class C11790ab {

    /* renamed from: a */
    protected String f37118a;

    /* renamed from: b */
    protected long f37119b;

    public C11790ab() {
    }

    public C11790ab(Parcel parcel) {
        this.f37118a = parcel.readString();
        this.f37119b = parcel.readLong();
    }

    /* renamed from: a */
    public final boolean mo38702a() {
        return this.f37119b > System.currentTimeMillis();
    }

    /* renamed from: b */
    public final String mo38703b() {
        return this.f37118a;
    }
}
