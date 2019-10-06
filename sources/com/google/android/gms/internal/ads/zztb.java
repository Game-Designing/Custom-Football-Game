package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class zztb implements Parcelable {
    public static final Creator<zztb> CREATOR = new C9265Ys();

    /* renamed from: a */
    public final int f29359a;

    /* renamed from: b */
    public final int f29360b;

    /* renamed from: c */
    public final int f29361c;

    /* renamed from: d */
    public final byte[] f29362d;

    /* renamed from: e */
    private int f29363e;

    public zztb(int i, int i2, int i3, byte[] bArr) {
        this.f29359a = i;
        this.f29360b = i2;
        this.f29361c = i3;
        this.f29362d = bArr;
    }

    zztb(Parcel parcel) {
        this.f29359a = parcel.readInt();
        this.f29360b = parcel.readInt();
        this.f29361c = parcel.readInt();
        this.f29362d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zztb.class != obj.getClass()) {
            return false;
        }
        zztb zztb = (zztb) obj;
        if (this.f29359a == zztb.f29359a && this.f29360b == zztb.f29360b && this.f29361c == zztb.f29361c && Arrays.equals(this.f29362d, zztb.f29362d)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        int i = this.f29359a;
        int i2 = this.f29360b;
        int i3 = this.f29361c;
        boolean z = this.f29362d != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        String str = ", ";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        sb.append(str);
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.f29363e == 0) {
            this.f29363e = ((((((this.f29359a + 527) * 31) + this.f29360b) * 31) + this.f29361c) * 31) + Arrays.hashCode(this.f29362d);
        }
        return this.f29363e;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f29359a);
        parcel.writeInt(this.f29360b);
        parcel.writeInt(this.f29361c);
        parcel.writeInt(this.f29362d != null ? 1 : 0);
        byte[] bArr = this.f29362d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
