package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11836jb;
import java.math.BigDecimal;

public final class PayPalItem implements Parcelable {
    public static final Creator CREATOR = new C11892Q();

    /* renamed from: a */
    private static final String f37371a = PayPalItem.class.getSimpleName();

    /* renamed from: b */
    private final String f37372b;

    /* renamed from: c */
    private final Integer f37373c;

    /* renamed from: d */
    private final BigDecimal f37374d;

    /* renamed from: e */
    private final String f37375e;

    /* renamed from: f */
    private final String f37376f;

    private PayPalItem(Parcel parcel) {
        this.f37372b = parcel.readString();
        this.f37373c = Integer.valueOf(parcel.readInt());
        try {
            this.f37374d = new BigDecimal(parcel.readString());
            this.f37375e = parcel.readString();
            this.f37376f = parcel.readString();
        } catch (NumberFormatException e) {
            Log.e(f37371a, "bad price", e);
            throw new RuntimeException(e);
        }
    }

    /* synthetic */ PayPalItem(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    public final String mo38911a() {
        return this.f37375e;
    }

    /* renamed from: b */
    public final String mo38912b() {
        return this.f37372b;
    }

    /* renamed from: c */
    public final BigDecimal mo38913c() {
        return this.f37374d;
    }

    /* renamed from: d */
    public final Integer mo38914d() {
        return this.f37373c;
    }

    public final int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final String mo38916e() {
        return this.f37376f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayPalItem)) {
            return false;
        }
        PayPalItem payPalItem = (PayPalItem) obj;
        String b = mo38912b();
        String b2 = payPalItem.mo38912b();
        if (b != null ? !b.equals(b2) : b2 != null) {
            return false;
        }
        Integer d = mo38914d();
        Integer d2 = payPalItem.mo38914d();
        if (d != null ? !d.equals(d2) : d2 != null) {
            return false;
        }
        BigDecimal c = mo38913c();
        BigDecimal c2 = payPalItem.mo38913c();
        if (c != null ? !c.equals(c2) : c2 != null) {
            return false;
        }
        String a = mo38911a();
        String a2 = payPalItem.mo38911a();
        if (a != null ? !a.equals(a2) : a2 != null) {
            return false;
        }
        String e = mo38916e();
        String e2 = payPalItem.mo38916e();
        return e != null ? e.equals(e2) : e2 == null;
    }

    /* renamed from: f */
    public final boolean mo38918f() {
        String str;
        String str2 = "paypal.sdk";
        if (this.f37373c.intValue() <= 0) {
            str = "item.quantity must be a positive integer.";
        } else if (!C11836jb.m39183a(this.f37375e)) {
            str = "item.currency field is required, and must be a supported currency.";
        } else if (C11723Fa.m38818a((CharSequence) this.f37372b)) {
            str = "item.name field is required.";
        } else if (C11836jb.m39184a(this.f37374d, this.f37375e, false)) {
            return true;
        } else {
            str = "item.price field is required.";
        }
        Log.e(str2, str);
        return false;
    }

    public final int hashCode() {
        String b = mo38912b();
        int i = 43;
        int hashCode = (b == null ? 43 : b.hashCode()) + 59;
        Integer d = mo38914d();
        int hashCode2 = (hashCode * 59) + (d == null ? 43 : d.hashCode());
        BigDecimal c = mo38913c();
        int hashCode3 = (hashCode2 * 59) + (c == null ? 43 : c.hashCode());
        String a = mo38911a();
        int hashCode4 = (hashCode3 * 59) + (a == null ? 43 : a.hashCode());
        String e = mo38916e();
        int i2 = hashCode4 * 59;
        if (e != null) {
            i = e.hashCode();
        }
        return i2 + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PayPalItem(name=");
        sb.append(mo38912b());
        sb.append(", quantity=");
        sb.append(mo38914d());
        sb.append(", price=");
        sb.append(mo38913c());
        sb.append(", currency=");
        sb.append(mo38911a());
        sb.append(", sku=");
        sb.append(mo38916e());
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37372b);
        parcel.writeInt(this.f37373c.intValue());
        parcel.writeString(this.f37374d.toString());
        parcel.writeString(this.f37375e);
        parcel.writeString(this.f37376f);
    }
}
