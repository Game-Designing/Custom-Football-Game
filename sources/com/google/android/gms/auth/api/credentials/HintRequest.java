package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR = new zzj();

    /* renamed from: a */
    private final int f19373a;

    /* renamed from: b */
    private final CredentialPickerConfig f19374b;

    /* renamed from: c */
    private final boolean f19375c;

    /* renamed from: d */
    private final boolean f19376d;

    /* renamed from: e */
    private final String[] f19377e;

    /* renamed from: f */
    private final boolean f19378f;

    /* renamed from: g */
    private final String f19379g;

    /* renamed from: h */
    private final String f19380h;

    public static final class Builder {

        /* renamed from: a */
        private CredentialPickerConfig f19381a = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().mo27133a();

        /* renamed from: b */
        private boolean f19382b = false;
    }

    @Constructor
    HintRequest(@Param(id = 1000) int i, @Param(id = 1) CredentialPickerConfig credentialPickerConfig, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) String[] strArr, @Param(id = 5) boolean z3, @Param(id = 6) String str, @Param(id = 7) String str2) {
        this.f19373a = i;
        Preconditions.m21857a(credentialPickerConfig);
        this.f19374b = credentialPickerConfig;
        this.f19375c = z;
        this.f19376d = z2;
        Preconditions.m21857a(strArr);
        this.f19377e = strArr;
        if (this.f19373a < 2) {
            this.f19378f = true;
            this.f19379g = null;
            this.f19380h = null;
            return;
        }
        this.f19378f = z3;
        this.f19379g = str;
        this.f19380h = str2;
    }

    /* renamed from: c */
    public final CredentialPickerConfig mo27144c() {
        return this.f19374b;
    }

    /* renamed from: f */
    public final boolean mo27147f() {
        return this.f19375c;
    }

    /* renamed from: a */
    public final String[] mo27143a() {
        return this.f19377e;
    }

    /* renamed from: g */
    public final boolean mo27148g() {
        return this.f19378f;
    }

    /* renamed from: e */
    public final String mo27146e() {
        return this.f19379g;
    }

    /* renamed from: d */
    public final String mo27145d() {
        return this.f19380h;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 1, (Parcelable) mo27144c(), i, false);
        SafeParcelWriter.m21968a(parcel, 2, mo27147f());
        SafeParcelWriter.m21968a(parcel, 3, this.f19376d);
        SafeParcelWriter.m21971a(parcel, 4, mo27143a(), false);
        SafeParcelWriter.m21968a(parcel, 5, mo27148g());
        SafeParcelWriter.m21965a(parcel, 6, mo27146e(), false);
        SafeParcelWriter.m21965a(parcel, 7, mo27145d(), false);
        SafeParcelWriter.m21957a(parcel, 1000, this.f19373a);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
