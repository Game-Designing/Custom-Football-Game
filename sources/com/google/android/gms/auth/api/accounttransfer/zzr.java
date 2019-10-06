package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p005cm.aptoide.p006pt.downloadmanager.Constants;

public class zzr extends zzaz {
    public static final Creator<zzr> CREATOR = new zzs();

    /* renamed from: b */
    private static final HashMap<String, Field<?, ?>> f19329b;
    @Indicator

    /* renamed from: c */
    private final Set<Integer> f19330c;

    /* renamed from: d */
    private final int f19331d;

    /* renamed from: e */
    private zzt f19332e;

    /* renamed from: f */
    private String f19333f;

    /* renamed from: g */
    private String f19334g;

    /* renamed from: h */
    private String f19335h;

    public zzr() {
        this.f19330c = new HashSet(3);
        this.f19331d = 1;
    }

    @Constructor
    zzr(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) zzt zzt, @Param(id = 3) String str, @Param(id = 4) String str2, @Param(id = 5) String str3) {
        this.f19330c = set;
        this.f19331d = i;
        this.f19332e = zzt;
        this.f19333f = str;
        this.f19334g = str2;
        this.f19335h = str3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        Set<Integer> set = this.f19330c;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.m21957a(parcel, 1, this.f19331d);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f19332e, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.m21965a(parcel, 3, this.f19333f, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.m21965a(parcel, 4, this.f19334g, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            SafeParcelWriter.m21965a(parcel, 5, this.f19335h, true);
        }
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo27102b(Field field) {
        return this.f19330c.contains(Integer.valueOf(field.mo27889a()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo27100a(Field field) {
        int a = field.mo27889a();
        if (a == 1) {
            return Integer.valueOf(this.f19331d);
        }
        if (a == 2) {
            return this.f19332e;
        }
        if (a == 3) {
            return this.f19333f;
        }
        if (a == 4) {
            return this.f19334g;
        }
        int a2 = field.mo27889a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a2);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public /* synthetic */ Map mo27101a() {
        return f19329b;
    }

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        f19329b = hashMap;
        String str = "authenticatorInfo";
        hashMap.put(str, Field.m22024a(str, 2, zzt.class));
        String str2 = "signature";
        f19329b.put(str2, Field.m22028c(str2, 3));
        HashMap<String, Field<?, ?>> hashMap2 = f19329b;
        String str3 = Constants.PACKAGE;
        hashMap2.put(str3, Field.m22028c(str3, 4));
    }
}
