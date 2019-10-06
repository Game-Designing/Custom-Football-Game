package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR = new zao();

    /* renamed from: a */
    private final int f20131a;

    /* renamed from: b */
    private final int f20132b;

    /* renamed from: c */
    private final int f20133c;
    @Deprecated

    /* renamed from: d */
    private final Scope[] f20134d;

    @Constructor
    SignInButtonConfig(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) Scope[] scopeArr) {
        this.f20131a = i;
        this.f20132b = i2;
        this.f20133c = i3;
        this.f20134d = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    /* renamed from: a */
    public int mo27823a() {
        return this.f20132b;
    }

    /* renamed from: c */
    public int mo27824c() {
        return this.f20133c;
    }

    @Deprecated
    /* renamed from: d */
    public Scope[] mo27825d() {
        return this.f20134d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20131a);
        SafeParcelWriter.m21957a(parcel, 2, mo27823a());
        SafeParcelWriter.m21957a(parcel, 3, mo27824c());
        SafeParcelWriter.m21970a(parcel, 4, (T[]) mo27825d(), i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
