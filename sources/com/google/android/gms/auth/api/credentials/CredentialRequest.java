package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zzg();

    /* renamed from: a */
    private final int f19360a;

    /* renamed from: b */
    private final boolean f19361b;

    /* renamed from: c */
    private final String[] f19362c;

    /* renamed from: d */
    private final CredentialPickerConfig f19363d;

    /* renamed from: e */
    private final CredentialPickerConfig f19364e;

    /* renamed from: f */
    private final boolean f19365f;

    /* renamed from: g */
    private final String f19366g;

    /* renamed from: h */
    private final String f19367h;

    /* renamed from: i */
    private final boolean f19368i;

    public static final class Builder {

        /* renamed from: a */
        private boolean f19369a = false;

        /* renamed from: b */
        private boolean f19370b = false;

        /* renamed from: c */
        private String f19371c = null;
    }

    @Constructor
    CredentialRequest(@Param(id = 1000) int i, @Param(id = 1) boolean z, @Param(id = 2) String[] strArr, @Param(id = 3) CredentialPickerConfig credentialPickerConfig, @Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @Param(id = 5) boolean z2, @Param(id = 6) String str, @Param(id = 7) String str2, @Param(id = 8) boolean z3) {
        this.f19360a = i;
        this.f19361b = z;
        Preconditions.m21857a(strArr);
        this.f19362c = strArr;
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().mo27133a();
        }
        this.f19363d = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().mo27133a();
        }
        this.f19364e = credentialPickerConfig2;
        if (i < 3) {
            this.f19365f = true;
            this.f19366g = null;
            this.f19367h = null;
        } else {
            this.f19365f = z2;
            this.f19366g = str;
            this.f19367h = str2;
        }
        this.f19368i = z3;
    }

    /* renamed from: h */
    public final boolean mo27140h() {
        return this.f19361b;
    }

    /* renamed from: a */
    public final String[] mo27134a() {
        return this.f19362c;
    }

    /* renamed from: d */
    public final CredentialPickerConfig mo27136d() {
        return this.f19363d;
    }

    /* renamed from: c */
    public final CredentialPickerConfig mo27135c() {
        return this.f19364e;
    }

    /* renamed from: g */
    public final boolean mo27139g() {
        return this.f19365f;
    }

    /* renamed from: f */
    public final String mo27138f() {
        return this.f19366g;
    }

    /* renamed from: e */
    public final String mo27137e() {
        return this.f19367h;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 1, mo27140h());
        SafeParcelWriter.m21971a(parcel, 2, mo27134a(), false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) mo27136d(), i, false);
        SafeParcelWriter.m21962a(parcel, 4, (Parcelable) mo27135c(), i, false);
        SafeParcelWriter.m21968a(parcel, 5, mo27139g());
        SafeParcelWriter.m21965a(parcel, 6, mo27138f(), false);
        SafeParcelWriter.m21965a(parcel, 7, mo27137e(), false);
        SafeParcelWriter.m21957a(parcel, 1000, this.f19360a);
        SafeParcelWriter.m21968a(parcel, 8, this.f19368i);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
