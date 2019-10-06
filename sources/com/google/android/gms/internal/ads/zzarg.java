package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@zzard
public final class zzarg extends AbstractSafeParcelable {
    public static final Creator<zzarg> CREATOR = new zzarh();

    /* renamed from: A */
    private final long f24599A;

    /* renamed from: B */
    private final String f24600B;

    /* renamed from: C */
    private final float f24601C;

    /* renamed from: D */
    private final int f24602D;

    /* renamed from: E */
    private final int f24603E;

    /* renamed from: F */
    private final boolean f24604F;

    /* renamed from: G */
    private final boolean f24605G;

    /* renamed from: H */
    private final String f24606H;

    /* renamed from: I */
    private final boolean f24607I;

    /* renamed from: J */
    private final String f24608J;

    /* renamed from: K */
    private final boolean f24609K;

    /* renamed from: L */
    private final int f24610L;

    /* renamed from: M */
    private final Bundle f24611M;

    /* renamed from: N */
    private final String f24612N;

    /* renamed from: O */
    private final zzaax f24613O;

    /* renamed from: P */
    private final boolean f24614P;

    /* renamed from: Q */
    private final Bundle f24615Q;

    /* renamed from: R */
    private final String f24616R;

    /* renamed from: S */
    private final String f24617S;

    /* renamed from: T */
    private final String f24618T;

    /* renamed from: U */
    private final boolean f24619U;

    /* renamed from: V */
    private final List<Integer> f24620V;

    /* renamed from: W */
    private final String f24621W;

    /* renamed from: X */
    private final List<String> f24622X;

    /* renamed from: Y */
    private final int f24623Y;

    /* renamed from: Z */
    private final boolean f24624Z;

    /* renamed from: a */
    private final int f24625a;

    /* renamed from: aa */
    private final boolean f24626aa;

    /* renamed from: b */
    private final Bundle f24627b;

    /* renamed from: ba */
    private final boolean f24628ba;

    /* renamed from: c */
    private final zzxz f24629c;

    /* renamed from: ca */
    private final ArrayList<String> f24630ca;

    /* renamed from: d */
    private final zzyd f24631d;

    /* renamed from: da */
    private final String f24632da;

    /* renamed from: e */
    private final String f24633e;

    /* renamed from: ea */
    private final zzaiy f24634ea;

    /* renamed from: f */
    private final ApplicationInfo f24635f;

    /* renamed from: fa */
    private final String f24636fa;

    /* renamed from: g */
    private final PackageInfo f24637g;

    /* renamed from: ga */
    private final Bundle f24638ga;

    /* renamed from: h */
    private final String f24639h;

    /* renamed from: i */
    private final String f24640i;

    /* renamed from: j */
    private final String f24641j;

    /* renamed from: k */
    private final zzbai f24642k;

    /* renamed from: l */
    private final Bundle f24643l;

    /* renamed from: m */
    private final int f24644m;

    /* renamed from: n */
    private final List<String> f24645n;

    /* renamed from: o */
    private final Bundle f24646o;

    /* renamed from: p */
    private final boolean f24647p;

    /* renamed from: q */
    private final int f24648q;

    /* renamed from: r */
    private final int f24649r;

    /* renamed from: s */
    private final float f24650s;

    /* renamed from: t */
    private final String f24651t;

    /* renamed from: u */
    private final long f24652u;

    /* renamed from: v */
    private final String f24653v;

    /* renamed from: w */
    private final List<String> f24654w;

    /* renamed from: x */
    private final String f24655x;

    /* renamed from: y */
    private final zzady f24656y;

    /* renamed from: z */
    private final List<String> f24657z;

    @Constructor
    zzarg(@Param(id = 1) int i, @Param(id = 2) Bundle bundle, @Param(id = 3) zzxz zzxz, @Param(id = 4) zzyd zzyd, @Param(id = 5) String str, @Param(id = 6) ApplicationInfo applicationInfo, @Param(id = 7) PackageInfo packageInfo, @Param(id = 8) String str2, @Param(id = 9) String str3, @Param(id = 10) String str4, @Param(id = 11) zzbai zzbai, @Param(id = 12) Bundle bundle2, @Param(id = 13) int i2, @Param(id = 14) List<String> list, @Param(id = 15) Bundle bundle3, @Param(id = 16) boolean z, @Param(id = 18) int i3, @Param(id = 19) int i4, @Param(id = 20) float f, @Param(id = 21) String str5, @Param(id = 25) long j, @Param(id = 26) String str6, @Param(id = 27) List<String> list2, @Param(id = 28) String str7, @Param(id = 29) zzady zzady, @Param(id = 30) List<String> list3, @Param(id = 31) long j2, @Param(id = 33) String str8, @Param(id = 34) float f2, @Param(id = 40) boolean z2, @Param(id = 35) int i5, @Param(id = 36) int i6, @Param(id = 37) boolean z3, @Param(id = 38) boolean z4, @Param(id = 39) String str9, @Param(id = 41) String str10, @Param(id = 42) boolean z5, @Param(id = 43) int i7, @Param(id = 44) Bundle bundle4, @Param(id = 45) String str11, @Param(id = 46) zzaax zzaax, @Param(id = 47) boolean z6, @Param(id = 48) Bundle bundle5, @Param(id = 49) String str12, @Param(id = 50) String str13, @Param(id = 51) String str14, @Param(id = 52) boolean z7, @Param(id = 53) List<Integer> list4, @Param(id = 54) String str15, @Param(id = 55) List<String> list5, @Param(id = 56) int i8, @Param(id = 57) boolean z8, @Param(id = 58) boolean z9, @Param(id = 59) boolean z10, @Param(id = 60) ArrayList<String> arrayList, @Param(id = 61) String str16, @Param(id = 63) zzaiy zzaiy, @Param(id = 64) String str17, @Param(id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.f24625a = i;
        this.f24627b = bundle;
        this.f24629c = zzxz;
        this.f24631d = zzyd;
        this.f24633e = str;
        this.f24635f = applicationInfo;
        this.f24637g = packageInfo;
        this.f24639h = str2;
        this.f24640i = str3;
        this.f24641j = str4;
        this.f24642k = zzbai;
        this.f24643l = bundle2;
        this.f24644m = i2;
        this.f24645n = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.f24657z = list6;
        this.f24646o = bundle3;
        this.f24647p = z;
        this.f24648q = i3;
        this.f24649r = i4;
        this.f24650s = f;
        this.f24651t = str5;
        this.f24652u = j;
        this.f24653v = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.f24654w = list7;
        this.f24655x = str7;
        this.f24656y = zzady;
        this.f24599A = j2;
        this.f24600B = str8;
        this.f24601C = f2;
        this.f24607I = z2;
        this.f24602D = i5;
        this.f24603E = i6;
        this.f24604F = z3;
        this.f24605G = z4;
        this.f24606H = str9;
        this.f24608J = str10;
        this.f24609K = z5;
        this.f24610L = i7;
        this.f24611M = bundle4;
        this.f24612N = str11;
        this.f24613O = zzaax;
        this.f24614P = z6;
        this.f24615Q = bundle5;
        this.f24616R = str12;
        this.f24617S = str13;
        this.f24618T = str14;
        this.f24619U = z7;
        this.f24620V = list4;
        this.f24621W = str15;
        this.f24622X = list5;
        this.f24623Y = i8;
        this.f24624Z = z8;
        this.f24626aa = z9;
        this.f24628ba = z10;
        this.f24630ca = arrayList;
        this.f24632da = str16;
        this.f24634ea = zzaiy;
        this.f24636fa = str17;
        this.f24638ga = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f24625a);
        SafeParcelWriter.m21959a(parcel, 2, this.f24627b, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f24629c, i, false);
        SafeParcelWriter.m21962a(parcel, 4, (Parcelable) this.f24631d, i, false);
        SafeParcelWriter.m21965a(parcel, 5, this.f24633e, false);
        SafeParcelWriter.m21962a(parcel, 6, (Parcelable) this.f24635f, i, false);
        SafeParcelWriter.m21962a(parcel, 7, (Parcelable) this.f24637g, i, false);
        SafeParcelWriter.m21965a(parcel, 8, this.f24639h, false);
        SafeParcelWriter.m21965a(parcel, 9, this.f24640i, false);
        SafeParcelWriter.m21965a(parcel, 10, this.f24641j, false);
        SafeParcelWriter.m21962a(parcel, 11, (Parcelable) this.f24642k, i, false);
        SafeParcelWriter.m21959a(parcel, 12, this.f24643l, false);
        SafeParcelWriter.m21957a(parcel, 13, this.f24644m);
        SafeParcelWriter.m21975b(parcel, 14, this.f24645n, false);
        SafeParcelWriter.m21959a(parcel, 15, this.f24646o, false);
        SafeParcelWriter.m21968a(parcel, 16, this.f24647p);
        SafeParcelWriter.m21957a(parcel, 18, this.f24648q);
        SafeParcelWriter.m21957a(parcel, 19, this.f24649r);
        SafeParcelWriter.m21956a(parcel, 20, this.f24650s);
        SafeParcelWriter.m21965a(parcel, 21, this.f24651t, false);
        SafeParcelWriter.m21958a(parcel, 25, this.f24652u);
        SafeParcelWriter.m21965a(parcel, 26, this.f24653v, false);
        SafeParcelWriter.m21975b(parcel, 27, this.f24654w, false);
        SafeParcelWriter.m21965a(parcel, 28, this.f24655x, false);
        SafeParcelWriter.m21962a(parcel, 29, (Parcelable) this.f24656y, i, false);
        SafeParcelWriter.m21975b(parcel, 30, this.f24657z, false);
        SafeParcelWriter.m21958a(parcel, 31, this.f24599A);
        SafeParcelWriter.m21965a(parcel, 33, this.f24600B, false);
        SafeParcelWriter.m21956a(parcel, 34, this.f24601C);
        SafeParcelWriter.m21957a(parcel, 35, this.f24602D);
        SafeParcelWriter.m21957a(parcel, 36, this.f24603E);
        SafeParcelWriter.m21968a(parcel, 37, this.f24604F);
        SafeParcelWriter.m21968a(parcel, 38, this.f24605G);
        SafeParcelWriter.m21965a(parcel, 39, this.f24606H, false);
        SafeParcelWriter.m21968a(parcel, 40, this.f24607I);
        SafeParcelWriter.m21965a(parcel, 41, this.f24608J, false);
        SafeParcelWriter.m21968a(parcel, 42, this.f24609K);
        SafeParcelWriter.m21957a(parcel, 43, this.f24610L);
        SafeParcelWriter.m21959a(parcel, 44, this.f24611M, false);
        SafeParcelWriter.m21965a(parcel, 45, this.f24612N, false);
        SafeParcelWriter.m21962a(parcel, 46, (Parcelable) this.f24613O, i, false);
        SafeParcelWriter.m21968a(parcel, 47, this.f24614P);
        SafeParcelWriter.m21959a(parcel, 48, this.f24615Q, false);
        SafeParcelWriter.m21965a(parcel, 49, this.f24616R, false);
        SafeParcelWriter.m21965a(parcel, 50, this.f24617S, false);
        SafeParcelWriter.m21965a(parcel, 51, this.f24618T, false);
        SafeParcelWriter.m21968a(parcel, 52, this.f24619U);
        SafeParcelWriter.m21966a(parcel, 53, this.f24620V, false);
        SafeParcelWriter.m21965a(parcel, 54, this.f24621W, false);
        SafeParcelWriter.m21975b(parcel, 55, this.f24622X, false);
        SafeParcelWriter.m21957a(parcel, 56, this.f24623Y);
        SafeParcelWriter.m21968a(parcel, 57, this.f24624Z);
        SafeParcelWriter.m21968a(parcel, 58, this.f24626aa);
        SafeParcelWriter.m21968a(parcel, 59, this.f24628ba);
        SafeParcelWriter.m21975b(parcel, 60, this.f24630ca, false);
        SafeParcelWriter.m21965a(parcel, 61, this.f24632da, false);
        SafeParcelWriter.m21962a(parcel, 63, (Parcelable) this.f24634ea, i, false);
        SafeParcelWriter.m21965a(parcel, 64, this.f24636fa, false);
        SafeParcelWriter.m21959a(parcel, 65, this.f24638ga, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
