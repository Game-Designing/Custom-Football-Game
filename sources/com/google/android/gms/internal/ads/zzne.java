package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public final class zzne implements Parcelable, Comparator<zza> {
    public static final Creator<zzne> CREATOR = new C9201Vr();

    /* renamed from: a */
    private final zza[] f28954a;

    /* renamed from: b */
    private int f28955b;

    /* renamed from: c */
    public final int f28956c;

    public static final class zza implements Parcelable {
        public static final Creator<zza> CREATOR = new C9222Wr();

        /* renamed from: a */
        private int f28957a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final UUID f28958b;

        /* renamed from: c */
        private final String f28959c;

        /* renamed from: d */
        private final byte[] f28960d;

        /* renamed from: e */
        public final boolean f28961e;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            zzsk.m31078a(uuid);
            this.f28958b = uuid;
            zzsk.m31078a(str);
            this.f28959c = str;
            zzsk.m31078a(bArr);
            this.f28960d = bArr;
            this.f28961e = false;
        }

        zza(Parcel parcel) {
            this.f28958b = new UUID(parcel.readLong(), parcel.readLong());
            this.f28959c = parcel.readString();
            this.f28960d = parcel.createByteArray();
            this.f28961e = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            if (!this.f28959c.equals(zza.f28959c) || !zzsy.m31153a((Object) this.f28958b, (Object) zza.f28958b) || !Arrays.equals(this.f28960d, zza.f28960d)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            if (this.f28957a == 0) {
                this.f28957a = (((this.f28958b.hashCode() * 31) + this.f28959c.hashCode()) * 31) + Arrays.hashCode(this.f28960d);
            }
            return this.f28957a;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f28958b.getMostSignificantBits());
            parcel.writeLong(this.f28958b.getLeastSignificantBits());
            parcel.writeString(this.f28959c);
            parcel.writeByteArray(this.f28960d);
            parcel.writeByte(this.f28961e ? (byte) 1 : 0);
        }
    }

    public zzne(zza... zzaArr) {
        this(true, zzaArr);
    }

    private zzne(boolean z, zza... zzaArr) {
        zza[] zzaArr2 = (zza[]) zzaArr.clone();
        Arrays.sort(zzaArr2, this);
        int i = 1;
        while (i < zzaArr2.length) {
            if (!zzaArr2[i - 1].f28958b.equals(zzaArr2[i].f28958b)) {
                i++;
            } else {
                String valueOf = String.valueOf(zzaArr2[i].f28958b);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.f28954a = zzaArr2;
        this.f28956c = zzaArr2.length;
    }

    zzne(Parcel parcel) {
        this.f28954a = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.f28956c = this.f28954a.length;
    }

    /* renamed from: a */
    public final zza mo32026a(int i) {
        return this.f28954a[i];
    }

    public final int hashCode() {
        if (this.f28955b == 0) {
            this.f28955b = Arrays.hashCode(this.f28954a);
        }
        return this.f28955b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzne.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f28954a, ((zzne) obj).f28954a);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f28954a, 0);
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zza zza2 = (zza) obj;
        zza zza3 = (zza) obj2;
        if (zzkt.f28759b.equals(zza2.f28958b)) {
            return zzkt.f28759b.equals(zza3.f28958b) ? 0 : 1;
        }
        return zza2.f28958b.compareTo(zza3.f28958b);
    }
}
