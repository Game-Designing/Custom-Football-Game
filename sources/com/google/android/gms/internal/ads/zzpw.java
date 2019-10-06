package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzpw extends zzpv {
    public static final Creator<zzpw> CREATOR = new C8863Fs();

    /* renamed from: b */
    private final String f29148b;

    /* renamed from: c */
    private final String f29149c;

    public zzpw(String str, String str2, String str3) {
        super(str);
        this.f29148b = null;
        this.f29149c = str3;
    }

    zzpw(Parcel parcel) {
        super(parcel.readString());
        this.f29148b = parcel.readString();
        this.f29149c = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzpw.class != obj.getClass()) {
            return false;
        }
        zzpw zzpw = (zzpw) obj;
        if (!this.f29147a.equals(zzpw.f29147a) || !zzsy.m31153a((Object) this.f29148b, (Object) zzpw.f29148b) || !zzsy.m31153a((Object) this.f29149c, (Object) zzpw.f29149c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = (this.f29147a.hashCode() + 527) * 31;
        String str = this.f29148b;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f29149c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f29147a);
        parcel.writeString(this.f29148b);
        parcel.writeString(this.f29149c);
    }
}
