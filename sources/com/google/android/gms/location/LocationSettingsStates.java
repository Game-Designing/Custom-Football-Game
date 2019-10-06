package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR = new zzai();

    /* renamed from: a */
    private final boolean f30519a;

    /* renamed from: b */
    private final boolean f30520b;

    /* renamed from: c */
    private final boolean f30521c;

    /* renamed from: d */
    private final boolean f30522d;

    /* renamed from: e */
    private final boolean f30523e;

    /* renamed from: f */
    private final boolean f30524f;

    @Constructor
    public LocationSettingsStates(@Param(id = 1) boolean z, @Param(id = 2) boolean z2, @Param(id = 3) boolean z3, @Param(id = 4) boolean z4, @Param(id = 5) boolean z5, @Param(id = 6) boolean z6) {
        this.f30519a = z;
        this.f30520b = z2;
        this.f30521c = z3;
        this.f30522d = z4;
        this.f30523e = z5;
        this.f30524f = z6;
    }

    /* renamed from: a */
    public final boolean mo33039a() {
        return this.f30524f;
    }

    /* renamed from: c */
    public final boolean mo33040c() {
        return this.f30521c;
    }

    /* renamed from: d */
    public final boolean mo33041d() {
        return this.f30522d;
    }

    /* renamed from: e */
    public final boolean mo33042e() {
        return this.f30519a;
    }

    /* renamed from: f */
    public final boolean mo33043f() {
        return this.f30523e;
    }

    /* renamed from: g */
    public final boolean mo33044g() {
        return this.f30520b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 1, mo33042e());
        SafeParcelWriter.m21968a(parcel, 2, mo33044g());
        SafeParcelWriter.m21968a(parcel, 3, mo33040c());
        SafeParcelWriter.m21968a(parcel, 4, mo33041d());
        SafeParcelWriter.m21968a(parcel, 5, mo33043f());
        SafeParcelWriter.m21968a(parcel, 6, mo33039a());
        SafeParcelWriter.m21954a(parcel, a);
    }
}
