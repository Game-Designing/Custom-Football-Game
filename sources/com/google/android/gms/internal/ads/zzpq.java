package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class zzpq extends zzpv {
    public static final Creator<zzpq> CREATOR = new C8821Ds();

    /* renamed from: b */
    private final String f29140b;

    /* renamed from: c */
    private final String f29141c;

    /* renamed from: d */
    private final int f29142d;

    /* renamed from: e */
    private final byte[] f29143e;

    public zzpq(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f29140b = str;
        this.f29141c = null;
        this.f29142d = 3;
        this.f29143e = bArr;
    }

    zzpq(Parcel parcel) {
        super("APIC");
        this.f29140b = parcel.readString();
        this.f29141c = parcel.readString();
        this.f29142d = parcel.readInt();
        this.f29143e = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzpq.class != obj.getClass()) {
            return false;
        }
        zzpq zzpq = (zzpq) obj;
        if (this.f29142d != zzpq.f29142d || !zzsy.m31153a((Object) this.f29140b, (Object) zzpq.f29140b) || !zzsy.m31153a((Object) this.f29141c, (Object) zzpq.f29141c) || !Arrays.equals(this.f29143e, zzpq.f29143e)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = (this.f29142d + 527) * 31;
        String str = this.f29140b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f29141c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.f29143e);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f29140b);
        parcel.writeString(this.f29141c);
        parcel.writeInt(this.f29142d);
        parcel.writeByteArray(this.f29143e);
    }
}
