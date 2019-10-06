package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.math.BigDecimal;
import java.util.Currency;

/* renamed from: com.paypal.android.sdk.eq */
public class C11815eq implements Parcelable {
    public static final Creator CREATOR = new C11856ob();

    /* renamed from: a */
    private static /* synthetic */ boolean f37189a = (!C11815eq.class.desiredAssertionStatus());

    /* renamed from: b */
    private BigDecimal f37190b;

    /* renamed from: c */
    private Currency f37191c;

    public C11815eq(Parcel parcel) {
        this.f37190b = new BigDecimal(parcel.readString());
        try {
            this.f37191c = Currency.getInstance(parcel.readString());
        } catch (IllegalArgumentException e) {
            Log.e("MoneySpec", "Exception reading currency code from parcel", e);
            throw new RuntimeException(e);
        }
    }

    public C11815eq(BigDecimal bigDecimal, String str) {
        this.f37190b = bigDecimal;
        this.f37191c = Currency.getInstance(str);
    }

    /* renamed from: a */
    public final BigDecimal mo38779a() {
        return this.f37190b;
    }

    /* renamed from: b */
    public final Currency mo38780b() {
        return this.f37191c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (f37189a || (obj instanceof C11815eq)) {
            C11815eq eqVar = (C11815eq) obj;
            return eqVar.f37190b == this.f37190b && eqVar.f37191c.equals(this.f37191c);
        }
        throw new AssertionError();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37190b.toString());
        parcel.writeString(this.f37191c.getCurrencyCode());
    }
}
