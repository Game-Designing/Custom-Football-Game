package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.io.InputStream;

@zzard
public final class zzvs extends AbstractSafeParcelable {
    public static final Creator<zzvs> CREATOR = new zzvt();

    /* renamed from: a */
    private ParcelFileDescriptor f29550a;

    public zzvs() {
        this(null);
    }

    @Constructor
    public zzvs(@Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f29550a = parcelFileDescriptor;
    }

    /* renamed from: a */
    public final synchronized boolean mo32317a() {
        return this.f29550a != null;
    }

    /* renamed from: c */
    public final synchronized InputStream mo32318c() {
        if (this.f29550a == null) {
            return null;
        }
        AutoCloseInputStream autoCloseInputStream = new AutoCloseInputStream(this.f29550a);
        this.f29550a = null;
        return autoCloseInputStream;
    }

    /* renamed from: d */
    private final synchronized ParcelFileDescriptor m31309d() {
        return this.f29550a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) m31309d(), i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
