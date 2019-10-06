package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Credential> CREATOR = new zzc();

    /* renamed from: a */
    private final String f19344a;

    /* renamed from: b */
    private final String f19345b;

    /* renamed from: c */
    private final Uri f19346c;

    /* renamed from: d */
    private final List<IdToken> f19347d;

    /* renamed from: e */
    private final String f19348e;

    /* renamed from: f */
    private final String f19349f;

    /* renamed from: g */
    private final String f19350g;

    /* renamed from: h */
    private final String f19351h;

    public static class Builder {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if ("https".equalsIgnoreCase(r0.getScheme()) != false) goto L_0x006b;
     */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Credential(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.lang.String r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) java.lang.String r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) android.net.Uri r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) java.util.List<com.google.android.gms.auth.api.credentials.IdToken> r8, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) java.lang.String r9, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) java.lang.String r10, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 9) java.lang.String r11, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 10) java.lang.String r12) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.String r0 = "credential identifier cannot be null"
            com.google.android.gms.common.internal.Preconditions.m21858a(r5, r0)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = r5.trim()
            java.lang.String r0 = "credential identifier cannot be empty"
            com.google.android.gms.common.internal.Preconditions.m21859a(r5, r0)
            if (r9 == 0) goto L_0x0025
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x001d
            goto L_0x0025
        L_0x001d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Password must not be empty if set"
            r5.<init>(r6)
            throw r5
        L_0x0025:
            if (r10 == 0) goto L_0x0082
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 != 0) goto L_0x006e
            android.net.Uri r0 = android.net.Uri.parse(r10)
            boolean r2 = r0.isAbsolute()
            if (r2 == 0) goto L_0x006d
            boolean r2 = r0.isHierarchical()
            if (r2 == 0) goto L_0x006d
            java.lang.String r2 = r0.getScheme()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x006d
            java.lang.String r2 = r0.getAuthority()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0053
            goto L_0x006d
        L_0x0053:
            java.lang.String r2 = r0.getScheme()
            java.lang.String r3 = "http"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x006b
            java.lang.String r0 = r0.getScheme()
            java.lang.String r2 = "https"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x006e
        L_0x006b:
            r1 = 1
            goto L_0x006f
        L_0x006d:
            goto L_0x006f
        L_0x006e:
        L_0x006f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007a
            goto L_0x0082
        L_0x007a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Account type must be a valid Http/Https URI"
            r5.<init>(r6)
            throw r5
        L_0x0082:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x0097
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Password and AccountType are mutually exclusive"
            r5.<init>(r6)
            throw r5
        L_0x0097:
            if (r6 == 0) goto L_0x00a4
            java.lang.String r0 = r6.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a4
            r6 = 0
        L_0x00a4:
            r4.f19345b = r6
            r4.f19346c = r7
            if (r8 != 0) goto L_0x00b0
            java.util.List r6 = java.util.Collections.emptyList()
            goto L_0x00b4
        L_0x00b0:
            java.util.List r6 = java.util.Collections.unmodifiableList(r8)
        L_0x00b4:
            r4.f19347d = r6
            r4.f19344a = r5
            r4.f19348e = r9
            r4.f19349f = r10
            r4.f19350g = r11
            r4.f19351h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.Credential.<init>(java.lang.String, java.lang.String, android.net.Uri, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: e */
    public String mo27121e() {
        return this.f19344a;
    }

    /* renamed from: g */
    public String mo27124g() {
        return this.f19345b;
    }

    /* renamed from: i */
    public Uri mo27127i() {
        return this.f19346c;
    }

    /* renamed from: f */
    public List<IdToken> mo27123f() {
        return this.f19347d;
    }

    /* renamed from: h */
    public String mo27125h() {
        return this.f19348e;
    }

    /* renamed from: a */
    public String mo27118a() {
        return this.f19349f;
    }

    /* renamed from: d */
    public String mo27120d() {
        return this.f19350g;
    }

    /* renamed from: c */
    public String mo27119c() {
        return this.f19351h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, mo27121e(), false);
        SafeParcelWriter.m21965a(parcel, 2, mo27124g(), false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) mo27127i(), i, false);
        SafeParcelWriter.m21977c(parcel, 4, mo27123f(), false);
        SafeParcelWriter.m21965a(parcel, 5, mo27125h(), false);
        SafeParcelWriter.m21965a(parcel, 6, mo27118a(), false);
        SafeParcelWriter.m21965a(parcel, 9, mo27120d(), false);
        SafeParcelWriter.m21965a(parcel, 10, mo27119c(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        if (!TextUtils.equals(this.f19344a, credential.f19344a) || !TextUtils.equals(this.f19345b, credential.f19345b) || !Objects.m21851a(this.f19346c, credential.f19346c) || !TextUtils.equals(this.f19348e, credential.f19348e) || !TextUtils.equals(this.f19349f, credential.f19349f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.m21849a(this.f19344a, this.f19345b, this.f19346c, this.f19348e, this.f19349f);
    }
}
