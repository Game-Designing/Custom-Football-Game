package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.List;

@zzard
public final class zzari extends AbstractSafeParcelable {
    public static final Creator<zzari> CREATOR = new zzarj();

    /* renamed from: A */
    private final boolean f24658A;

    /* renamed from: B */
    private final boolean f24659B;

    /* renamed from: C */
    private final zzato f24660C;

    /* renamed from: D */
    private final List<String> f24661D;

    /* renamed from: E */
    private final List<String> f24662E;

    /* renamed from: F */
    private final boolean f24663F;

    /* renamed from: G */
    private final zzark f24664G;

    /* renamed from: H */
    private final boolean f24665H;

    /* renamed from: I */
    private String f24666I;

    /* renamed from: J */
    private final List<String> f24667J;

    /* renamed from: K */
    private final boolean f24668K;

    /* renamed from: L */
    private final String f24669L;

    /* renamed from: M */
    private final zzauy f24670M;

    /* renamed from: N */
    private final String f24671N;

    /* renamed from: O */
    private final boolean f24672O;

    /* renamed from: P */
    private final boolean f24673P;

    /* renamed from: Q */
    private Bundle f24674Q;

    /* renamed from: R */
    private final boolean f24675R;

    /* renamed from: S */
    private final int f24676S;

    /* renamed from: T */
    private final boolean f24677T;

    /* renamed from: U */
    private final List<String> f24678U;

    /* renamed from: V */
    private final boolean f24679V;

    /* renamed from: W */
    private final String f24680W;

    /* renamed from: X */
    private String f24681X;

    /* renamed from: Y */
    private boolean f24682Y;

    /* renamed from: Z */
    private boolean f24683Z;

    /* renamed from: a */
    private final int f24684a;

    /* renamed from: b */
    private final String f24685b;

    /* renamed from: c */
    private String f24686c;

    /* renamed from: d */
    private final List<String> f24687d;

    /* renamed from: e */
    private final int f24688e;

    /* renamed from: f */
    private final List<String> f24689f;

    /* renamed from: g */
    private final long f24690g;

    /* renamed from: h */
    private final boolean f24691h;

    /* renamed from: i */
    private final long f24692i;

    /* renamed from: j */
    private final List<String> f24693j;

    /* renamed from: k */
    private final long f24694k;

    /* renamed from: l */
    private final int f24695l;

    /* renamed from: m */
    private final String f24696m;

    /* renamed from: n */
    private final long f24697n;

    /* renamed from: o */
    private final String f24698o;

    /* renamed from: p */
    private final boolean f24699p;

    /* renamed from: q */
    private final String f24700q;

    /* renamed from: r */
    private final String f24701r;

    /* renamed from: s */
    private final boolean f24702s;

    /* renamed from: t */
    private final boolean f24703t;

    /* renamed from: u */
    private final boolean f24704u;

    /* renamed from: v */
    private final boolean f24705v;

    /* renamed from: w */
    private final boolean f24706w;

    /* renamed from: x */
    private zzaru f24707x;

    /* renamed from: y */
    private String f24708y;

    /* renamed from: z */
    private final String f24709z;

    @Constructor
    zzari(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) List<String> list, @Param(id = 5) int i2, @Param(id = 6) List<String> list2, @Param(id = 7) long j, @Param(id = 8) boolean z, @Param(id = 9) long j2, @Param(id = 10) List<String> list3, @Param(id = 11) long j3, @Param(id = 12) int i3, @Param(id = 13) String str3, @Param(id = 14) long j4, @Param(id = 15) String str4, @Param(id = 18) boolean z2, @Param(id = 19) String str5, @Param(id = 21) String str6, @Param(id = 22) boolean z3, @Param(id = 23) boolean z4, @Param(id = 24) boolean z5, @Param(id = 25) boolean z6, @Param(id = 26) boolean z7, @Param(id = 28) zzaru zzaru, @Param(id = 29) String str7, @Param(id = 30) String str8, @Param(id = 31) boolean z8, @Param(id = 32) boolean z9, @Param(id = 33) zzato zzato, @Param(id = 34) List<String> list4, @Param(id = 35) List<String> list5, @Param(id = 36) boolean z10, @Param(id = 37) zzark zzark, @Param(id = 38) boolean z11, @Param(id = 39) String str9, @Param(id = 40) List<String> list6, @Param(id = 42) boolean z12, @Param(id = 43) String str10, @Param(id = 44) zzauy zzauy, @Param(id = 45) String str11, @Param(id = 46) boolean z13, @Param(id = 47) boolean z14, @Param(id = 48) Bundle bundle, @Param(id = 49) boolean z15, @Param(id = 50) int i4, @Param(id = 51) boolean z16, @Param(id = 52) List<String> list7, @Param(id = 53) boolean z17, @Param(id = 54) String str12, @Param(id = 55) String str13, @Param(id = 56) boolean z18, @Param(id = 57) boolean z19) {
        this.f24684a = i;
        this.f24685b = str;
        this.f24686c = str2;
        List<String> list8 = null;
        this.f24687d = list != null ? Collections.unmodifiableList(list) : null;
        this.f24688e = i2;
        this.f24689f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f24690g = j;
        this.f24691h = z;
        this.f24692i = j2;
        this.f24693j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f24694k = j3;
        this.f24695l = i3;
        this.f24696m = str3;
        this.f24697n = j4;
        this.f24698o = str4;
        this.f24699p = z2;
        this.f24700q = str5;
        this.f24701r = str6;
        this.f24702s = z3;
        this.f24703t = z4;
        this.f24704u = z5;
        this.f24705v = z6;
        this.f24672O = z13;
        this.f24706w = z7;
        this.f24707x = zzaru;
        this.f24708y = str7;
        this.f24709z = str8;
        if (this.f24686c == null) {
            zzaru zzaru2 = this.f24707x;
            if (zzaru2 != null) {
                zzarz zzarz = (zzarz) zzaru2.mo30027a(zzarz.CREATOR);
                if (zzarz != null && !TextUtils.isEmpty(zzarz.f24724a)) {
                    this.f24686c = zzarz.f24724a;
                }
            }
        }
        this.f24658A = z8;
        this.f24659B = z9;
        this.f24660C = zzato;
        this.f24661D = list4;
        this.f24662E = list5;
        this.f24663F = z10;
        this.f24664G = zzark;
        this.f24665H = z11;
        this.f24666I = str9;
        this.f24667J = list6;
        this.f24668K = z12;
        this.f24669L = str10;
        this.f24670M = zzauy;
        this.f24671N = str11;
        this.f24673P = z14;
        this.f24674Q = bundle;
        this.f24675R = z15;
        this.f24676S = i4;
        this.f24677T = z16;
        if (list7 != null) {
            list8 = Collections.unmodifiableList(list7);
        }
        this.f24678U = list8;
        this.f24679V = z17;
        this.f24680W = str12;
        this.f24681X = str13;
        this.f24682Y = z18;
        this.f24683Z = z19;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f24684a);
        SafeParcelWriter.m21965a(parcel, 2, this.f24685b, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f24686c, false);
        SafeParcelWriter.m21975b(parcel, 4, this.f24687d, false);
        SafeParcelWriter.m21957a(parcel, 5, this.f24688e);
        SafeParcelWriter.m21975b(parcel, 6, this.f24689f, false);
        SafeParcelWriter.m21958a(parcel, 7, this.f24690g);
        SafeParcelWriter.m21968a(parcel, 8, this.f24691h);
        SafeParcelWriter.m21958a(parcel, 9, this.f24692i);
        SafeParcelWriter.m21975b(parcel, 10, this.f24693j, false);
        SafeParcelWriter.m21958a(parcel, 11, this.f24694k);
        SafeParcelWriter.m21957a(parcel, 12, this.f24695l);
        SafeParcelWriter.m21965a(parcel, 13, this.f24696m, false);
        SafeParcelWriter.m21958a(parcel, 14, this.f24697n);
        SafeParcelWriter.m21965a(parcel, 15, this.f24698o, false);
        SafeParcelWriter.m21968a(parcel, 18, this.f24699p);
        SafeParcelWriter.m21965a(parcel, 19, this.f24700q, false);
        SafeParcelWriter.m21965a(parcel, 21, this.f24701r, false);
        SafeParcelWriter.m21968a(parcel, 22, this.f24702s);
        SafeParcelWriter.m21968a(parcel, 23, this.f24703t);
        SafeParcelWriter.m21968a(parcel, 24, this.f24704u);
        SafeParcelWriter.m21968a(parcel, 25, this.f24705v);
        SafeParcelWriter.m21968a(parcel, 26, this.f24706w);
        SafeParcelWriter.m21962a(parcel, 28, (Parcelable) this.f24707x, i, false);
        SafeParcelWriter.m21965a(parcel, 29, this.f24708y, false);
        SafeParcelWriter.m21965a(parcel, 30, this.f24709z, false);
        SafeParcelWriter.m21968a(parcel, 31, this.f24658A);
        SafeParcelWriter.m21968a(parcel, 32, this.f24659B);
        SafeParcelWriter.m21962a(parcel, 33, (Parcelable) this.f24660C, i, false);
        SafeParcelWriter.m21975b(parcel, 34, this.f24661D, false);
        SafeParcelWriter.m21975b(parcel, 35, this.f24662E, false);
        SafeParcelWriter.m21968a(parcel, 36, this.f24663F);
        SafeParcelWriter.m21962a(parcel, 37, (Parcelable) this.f24664G, i, false);
        SafeParcelWriter.m21968a(parcel, 38, this.f24665H);
        SafeParcelWriter.m21965a(parcel, 39, this.f24666I, false);
        SafeParcelWriter.m21975b(parcel, 40, this.f24667J, false);
        SafeParcelWriter.m21968a(parcel, 42, this.f24668K);
        SafeParcelWriter.m21965a(parcel, 43, this.f24669L, false);
        SafeParcelWriter.m21962a(parcel, 44, (Parcelable) this.f24670M, i, false);
        SafeParcelWriter.m21965a(parcel, 45, this.f24671N, false);
        SafeParcelWriter.m21968a(parcel, 46, this.f24672O);
        SafeParcelWriter.m21968a(parcel, 47, this.f24673P);
        SafeParcelWriter.m21959a(parcel, 48, this.f24674Q, false);
        SafeParcelWriter.m21968a(parcel, 49, this.f24675R);
        SafeParcelWriter.m21957a(parcel, 50, this.f24676S);
        SafeParcelWriter.m21968a(parcel, 51, this.f24677T);
        SafeParcelWriter.m21975b(parcel, 52, this.f24678U, false);
        SafeParcelWriter.m21968a(parcel, 53, this.f24679V);
        SafeParcelWriter.m21965a(parcel, 54, this.f24680W, false);
        SafeParcelWriter.m21965a(parcel, 55, this.f24681X, false);
        SafeParcelWriter.m21968a(parcel, 56, this.f24682Y);
        SafeParcelWriter.m21968a(parcel, 57, this.f24683Z);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
