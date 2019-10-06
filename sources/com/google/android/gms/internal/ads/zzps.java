package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzps extends zzpv {
    public static final Creator<zzps> CREATOR = new C8842Es();

    /* renamed from: b */
    private final String f29144b;

    /* renamed from: c */
    public final String f29145c;

    /* renamed from: d */
    public final String f29146d;

    public zzps(String str, String str2, String str3) {
        super("COMM");
        this.f29144b = str;
        this.f29145c = str2;
        this.f29146d = str3;
    }

    zzps(Parcel parcel) {
        super("COMM");
        this.f29144b = parcel.readString();
        this.f29145c = parcel.readString();
        this.f29146d = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzps.class != obj.getClass()) {
            return false;
        }
        zzps zzps = (zzps) obj;
        if (!zzsy.m31153a((Object) this.f29145c, (Object) zzps.f29145c) || !zzsy.m31153a((Object) this.f29144b, (Object) zzps.f29144b) || !zzsy.m31153a((Object) this.f29146d, (Object) zzps.f29146d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f29144b;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f29145c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f29146d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f29147a);
        parcel.writeString(this.f29144b);
        parcel.writeString(this.f29146d);
    }
}
