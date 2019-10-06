package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new zza();

    /* renamed from: a */
    private final int f19595a;

    /* renamed from: b */
    private final String f19596b;

    @Constructor
    Scope(@Param(id = 1) int i, @Param(id = 2) String str) {
        Preconditions.m21859a(str, (Object) "scopeUri must not be null or empty");
        this.f19595a = i;
        this.f19596b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    @KeepForSdk
    /* renamed from: a */
    public final String mo27412a() {
        return this.f19596b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f19596b.equals(((Scope) obj).f19596b);
    }

    public final int hashCode() {
        return this.f19596b.hashCode();
    }

    public final String toString() {
        return this.f19596b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19595a);
        SafeParcelWriter.m21965a(parcel, 2, mo27412a(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
