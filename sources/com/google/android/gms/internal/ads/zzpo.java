package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class zzpo implements Parcelable {
    public static final Creator<zzpo> CREATOR = new C8800Cs();

    /* renamed from: a */
    private final zza[] f29139a;

    public interface zza extends Parcelable {
    }

    public zzpo(List<? extends zza> list) {
        this.f29139a = new zza[list.size()];
        list.toArray(this.f29139a);
    }

    zzpo(Parcel parcel) {
        this.f29139a = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaArr = this.f29139a;
            if (i < zzaArr.length) {
                zzaArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final int mo32088a() {
        return this.f29139a.length;
    }

    /* renamed from: a */
    public final zza mo32089a(int i) {
        return this.f29139a[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzpo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f29139a, ((zzpo) obj).f29139a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f29139a);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f29139a.length);
        for (zza writeParcelable : this.f29139a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
