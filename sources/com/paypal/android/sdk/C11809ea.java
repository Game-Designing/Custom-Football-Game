package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Random;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.paypal.android.sdk.ea */
public final class C11809ea extends C11790ab implements Parcelable {
    public static final Creator CREATOR = new C11798cb();

    public C11809ea() {
        this.f37119b = System.currentTimeMillis() + BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS;
        Random random = new Random(this.f37119b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append((char) ((Math.abs(random.nextInt()) % 10) + 48));
        }
        this.f37118a = sb.toString();
    }

    public C11809ea(Parcel parcel) {
        super(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37118a);
        parcel.writeLong(this.f37119b);
    }
}
