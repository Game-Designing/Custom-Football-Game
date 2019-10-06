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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzl extends zzaz {
    public static final Creator<zzl> CREATOR = new zzm();

    /* renamed from: b */
    private static final HashMap<String, Field<?, ?>> f19316b;
    @Indicator

    /* renamed from: c */
    private final Set<Integer> f19317c;

    /* renamed from: d */
    private final int f19318d;

    /* renamed from: e */
    private ArrayList<zzr> f19319e;

    /* renamed from: f */
    private int f19320f;

    /* renamed from: g */
    private zzo f19321g;

    @Constructor
    zzl(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) ArrayList<zzr> arrayList, @Param(id = 3) int i2, @Param(id = 4) zzo zzo) {
        this.f19317c = set;
        this.f19318d = i;
        this.f19319e = arrayList;
        this.f19320f = i2;
        this.f19321g = zzo;
    }

    public zzl() {
        this.f19317c = new HashSet(1);
        this.f19318d = 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        Set<Integer> set = this.f19317c;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.m21957a(parcel, 1, this.f19318d);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.m21977c(parcel, 2, this.f19319e, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.m21957a(parcel, 3, this.f19320f);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.m21962a(parcel, 4, (Parcelable) this.f19321g, i, true);
        }
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo27102b(Field field) {
        return this.f19317c.contains(Integer.valueOf(field.mo27889a()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo27100a(Field field) {
        int a = field.mo27889a();
        if (a == 1) {
            return Integer.valueOf(this.f19318d);
        }
        if (a == 2) {
            return this.f19319e;
        }
        if (a == 4) {
            return this.f19321g;
        }
        int a2 = field.mo27889a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a2);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public final /* synthetic */ Map mo27101a() {
        return f19316b;
    }

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        f19316b = hashMap;
        String str = "authenticatorData";
        hashMap.put(str, Field.m22027b(str, 2, zzr.class));
        String str2 = "progress";
        f19316b.put(str2, Field.m22024a(str2, 4, zzo.class));
    }
}
