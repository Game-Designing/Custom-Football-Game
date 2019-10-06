package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.ads.zzbp.zza;

public final class zzdbd extends AbstractSafeParcelable {
    public static final Creator<zzdbd> CREATOR = new zzdbe();

    /* renamed from: a */
    private final int f27761a;

    /* renamed from: b */
    private zza f27762b = null;

    /* renamed from: c */
    private byte[] f27763c;

    @Constructor
    zzdbd(@Param(id = 1) int i, @Param(id = 2) byte[] bArr) {
        this.f27761a = i;
        this.f27763c = bArr;
        m29124c();
    }

    /* renamed from: a */
    public final zza mo31363a() {
        if (!(this.f27762b != null)) {
            try {
                this.f27762b = zza.m27352a(this.f27763c, zzdno.m29867c());
                this.f27763c = null;
            } catch (zzdok e) {
                throw new IllegalStateException(e);
            }
        }
        m29124c();
        return this.f27762b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f27761a);
        byte[] bArr = this.f27763c;
        if (bArr == null) {
            bArr = this.f27762b.toByteArray();
        }
        SafeParcelWriter.m21969a(parcel, 2, bArr, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* renamed from: c */
    private final void m29124c() {
        if (this.f27762b == null && this.f27763c != null) {
            return;
        }
        if (this.f27762b != null && this.f27763c == null) {
            return;
        }
        if (this.f27762b != null && this.f27763c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.f27762b == null && this.f27763c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }
}
