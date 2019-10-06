package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@zzard
public final class zzxz extends AbstractSafeParcelable {
    public static final Creator<zzxz> CREATOR = new zzyb();

    /* renamed from: a */
    public final int f29723a;
    @Deprecated

    /* renamed from: b */
    public final long f29724b;

    /* renamed from: c */
    public final Bundle f29725c;
    @Deprecated

    /* renamed from: d */
    public final int f29726d;

    /* renamed from: e */
    public final List<String> f29727e;

    /* renamed from: f */
    public final boolean f29728f;

    /* renamed from: g */
    public final int f29729g;

    /* renamed from: h */
    public final boolean f29730h;

    /* renamed from: i */
    public final String f29731i;

    /* renamed from: j */
    public final zzaca f29732j;

    /* renamed from: k */
    public final Location f29733k;

    /* renamed from: l */
    public final String f29734l;

    /* renamed from: m */
    public final Bundle f29735m;

    /* renamed from: n */
    public final Bundle f29736n;

    /* renamed from: o */
    public final List<String> f29737o;

    /* renamed from: p */
    public final String f29738p;

    /* renamed from: q */
    public final String f29739q;
    @Deprecated

    /* renamed from: r */
    public final boolean f29740r;

    /* renamed from: s */
    public final zzxt f29741s;

    /* renamed from: t */
    public final int f29742t;

    /* renamed from: u */
    public final String f29743u;

    @Constructor
    public zzxz(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) Bundle bundle, @Param(id = 4) int i2, @Param(id = 5) List<String> list, @Param(id = 6) boolean z, @Param(id = 7) int i3, @Param(id = 8) boolean z2, @Param(id = 9) String str, @Param(id = 10) zzaca zzaca, @Param(id = 11) Location location, @Param(id = 12) String str2, @Param(id = 13) Bundle bundle2, @Param(id = 14) Bundle bundle3, @Param(id = 15) List<String> list2, @Param(id = 16) String str3, @Param(id = 17) String str4, @Param(id = 18) boolean z3, @Param(id = 19) zzxt zzxt, @Param(id = 20) int i4, @Param(id = 21) String str5) {
        this.f29723a = i;
        this.f29724b = j;
        this.f29725c = bundle == null ? new Bundle() : bundle;
        this.f29726d = i2;
        this.f29727e = list;
        this.f29728f = z;
        this.f29729g = i3;
        this.f29730h = z2;
        this.f29731i = str;
        this.f29732j = zzaca;
        this.f29733k = location;
        this.f29734l = str2;
        this.f29735m = bundle2 == null ? new Bundle() : bundle2;
        this.f29736n = bundle3;
        this.f29737o = list2;
        this.f29738p = str3;
        this.f29739q = str4;
        this.f29740r = z3;
        this.f29741s = zzxt;
        this.f29742t = i4;
        this.f29743u = str5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29723a);
        SafeParcelWriter.m21958a(parcel, 2, this.f29724b);
        SafeParcelWriter.m21959a(parcel, 3, this.f29725c, false);
        SafeParcelWriter.m21957a(parcel, 4, this.f29726d);
        SafeParcelWriter.m21975b(parcel, 5, this.f29727e, false);
        SafeParcelWriter.m21968a(parcel, 6, this.f29728f);
        SafeParcelWriter.m21957a(parcel, 7, this.f29729g);
        SafeParcelWriter.m21968a(parcel, 8, this.f29730h);
        SafeParcelWriter.m21965a(parcel, 9, this.f29731i, false);
        SafeParcelWriter.m21962a(parcel, 10, (Parcelable) this.f29732j, i, false);
        SafeParcelWriter.m21962a(parcel, 11, (Parcelable) this.f29733k, i, false);
        SafeParcelWriter.m21965a(parcel, 12, this.f29734l, false);
        SafeParcelWriter.m21959a(parcel, 13, this.f29735m, false);
        SafeParcelWriter.m21959a(parcel, 14, this.f29736n, false);
        SafeParcelWriter.m21975b(parcel, 15, this.f29737o, false);
        SafeParcelWriter.m21965a(parcel, 16, this.f29738p, false);
        SafeParcelWriter.m21965a(parcel, 17, this.f29739q, false);
        SafeParcelWriter.m21968a(parcel, 18, this.f29740r);
        SafeParcelWriter.m21962a(parcel, 19, (Parcelable) this.f29741s, i, false);
        SafeParcelWriter.m21957a(parcel, 20, this.f29742t);
        SafeParcelWriter.m21965a(parcel, 21, this.f29743u, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxz)) {
            return false;
        }
        zzxz zzxz = (zzxz) obj;
        if (this.f29723a != zzxz.f29723a || this.f29724b != zzxz.f29724b || !Objects.m21851a(this.f29725c, zzxz.f29725c) || this.f29726d != zzxz.f29726d || !Objects.m21851a(this.f29727e, zzxz.f29727e) || this.f29728f != zzxz.f29728f || this.f29729g != zzxz.f29729g || this.f29730h != zzxz.f29730h || !Objects.m21851a(this.f29731i, zzxz.f29731i) || !Objects.m21851a(this.f29732j, zzxz.f29732j) || !Objects.m21851a(this.f29733k, zzxz.f29733k) || !Objects.m21851a(this.f29734l, zzxz.f29734l) || !Objects.m21851a(this.f29735m, zzxz.f29735m) || !Objects.m21851a(this.f29736n, zzxz.f29736n) || !Objects.m21851a(this.f29737o, zzxz.f29737o) || !Objects.m21851a(this.f29738p, zzxz.f29738p) || !Objects.m21851a(this.f29739q, zzxz.f29739q) || this.f29740r != zzxz.f29740r || this.f29742t != zzxz.f29742t || !Objects.m21851a(this.f29743u, zzxz.f29743u)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f29723a), Long.valueOf(this.f29724b), this.f29725c, Integer.valueOf(this.f29726d), this.f29727e, Boolean.valueOf(this.f29728f), Integer.valueOf(this.f29729g), Boolean.valueOf(this.f29730h), this.f29731i, this.f29732j, this.f29733k, this.f29734l, this.f29735m, this.f29736n, this.f29737o, this.f29738p, this.f29739q, Boolean.valueOf(this.f29740r), Integer.valueOf(this.f29742t), this.f29743u);
    }
}
