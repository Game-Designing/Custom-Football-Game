package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

@VisibleForTesting
public final class zzbh extends AbstractSafeParcelable implements Geofence {
    public static final Creator<zzbh> CREATOR = new zzbi();

    /* renamed from: a */
    private final String f29961a;

    /* renamed from: b */
    private final long f29962b;

    /* renamed from: c */
    private final short f29963c;

    /* renamed from: d */
    private final double f29964d;

    /* renamed from: e */
    private final double f29965e;

    /* renamed from: f */
    private final float f29966f;

    /* renamed from: g */
    private final int f29967g;

    /* renamed from: h */
    private final int f29968h;

    /* renamed from: i */
    private final int f29969i;

    @Constructor
    public zzbh(@Param(id = 1) String str, @Param(id = 7) int i, @Param(id = 3) short s, @Param(id = 4) double d, @Param(id = 5) double d2, @Param(id = 6) float f, @Param(id = 2) long j, @Param(id = 8) int i2, @Param(id = 9) int i3) {
        if (str == null || str.length() > 100) {
            String str2 = "requestId is null or too long: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (f <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f);
            throw new IllegalArgumentException(sb.toString());
        } else if (d > 90.0d || d < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d2 > 180.0d || d2 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d2);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            int i4 = i & 7;
            if (i4 != 0) {
                this.f29963c = s;
                this.f29961a = str;
                this.f29964d = d;
                this.f29965e = d2;
                this.f29966f = f;
                this.f29962b = j;
                this.f29967g = i4;
                this.f29968h = i2;
                this.f29969i = i3;
                return;
            }
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i);
            throw new IllegalArgumentException(sb4.toString());
        }
    }

    /* renamed from: a */
    public final String mo32518a() {
        return this.f29961a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbh)) {
            return false;
        }
        zzbh zzbh = (zzbh) obj;
        return this.f29966f == zzbh.f29966f && this.f29964d == zzbh.f29964d && this.f29965e == zzbh.f29965e && this.f29963c == zzbh.f29963c;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f29964d);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f29965e);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f29966f)) * 31) + this.f29963c) * 31) + this.f29967g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.f29963c != 1 ? null : "CIRCLE";
        objArr[1] = this.f29961a.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f29967g);
        objArr[3] = Double.valueOf(this.f29964d);
        objArr[4] = Double.valueOf(this.f29965e);
        objArr[5] = Float.valueOf(this.f29966f);
        objArr[6] = Integer.valueOf(this.f29968h / 1000);
        objArr[7] = Integer.valueOf(this.f29969i);
        objArr[8] = Long.valueOf(this.f29962b);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, mo32518a(), false);
        SafeParcelWriter.m21958a(parcel, 2, this.f29962b);
        SafeParcelWriter.m21967a(parcel, 3, this.f29963c);
        SafeParcelWriter.m21955a(parcel, 4, this.f29964d);
        SafeParcelWriter.m21955a(parcel, 5, this.f29965e);
        SafeParcelWriter.m21956a(parcel, 6, this.f29966f);
        SafeParcelWriter.m21957a(parcel, 7, this.f29967g);
        SafeParcelWriter.m21957a(parcel, 8, this.f29968h);
        SafeParcelWriter.m21957a(parcel, 9, this.f29969i);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
