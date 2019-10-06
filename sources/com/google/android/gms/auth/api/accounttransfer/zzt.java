package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
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
import java.util.Map;
import java.util.Set;
import p002b.p003c.p053g.p061f.C1255d;

public class zzt extends zzaz {
    public static final Creator<zzt> CREATOR = new zzu();

    /* renamed from: b */
    private static final HashMap<String, Field<?, ?>> f19336b;
    @Indicator

    /* renamed from: c */
    private final Set<Integer> f19337c;

    /* renamed from: d */
    private final int f19338d;

    /* renamed from: e */
    private String f19339e;

    /* renamed from: f */
    private int f19340f;

    /* renamed from: g */
    private byte[] f19341g;

    /* renamed from: h */
    private PendingIntent f19342h;

    /* renamed from: i */
    private DeviceMetaData f19343i;

    @Constructor
    zzt(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2, @Param(id = 4) byte[] bArr, @Param(id = 5) PendingIntent pendingIntent, @Param(id = 6) DeviceMetaData deviceMetaData) {
        this.f19337c = set;
        this.f19338d = i;
        this.f19339e = str;
        this.f19340f = i2;
        this.f19341g = bArr;
        this.f19342h = pendingIntent;
        this.f19343i = deviceMetaData;
    }

    public zzt() {
        this.f19337c = new C1255d(3);
        this.f19338d = 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        Set<Integer> set = this.f19337c;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.m21957a(parcel, 1, this.f19338d);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.m21965a(parcel, 2, this.f19339e, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.m21957a(parcel, 3, this.f19340f);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.m21969a(parcel, 4, this.f19341g, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            SafeParcelWriter.m21962a(parcel, 5, (Parcelable) this.f19342h, i, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            SafeParcelWriter.m21962a(parcel, 6, (Parcelable) this.f19343i, i, true);
        }
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo27102b(Field field) {
        return this.f19337c.contains(Integer.valueOf(field.mo27889a()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo27100a(Field field) {
        int a = field.mo27889a();
        if (a == 1) {
            return Integer.valueOf(this.f19338d);
        }
        if (a == 2) {
            return this.f19339e;
        }
        if (a == 3) {
            return Integer.valueOf(this.f19340f);
        }
        if (a == 4) {
            return this.f19341g;
        }
        int a2 = field.mo27889a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a2);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public /* synthetic */ Map mo27101a() {
        return f19336b;
    }

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        f19336b = hashMap;
        String str = "accountType";
        hashMap.put(str, Field.m22028c(str, 2));
        String str2 = "status";
        f19336b.put(str2, Field.m22026b(str2, 3));
        String str3 = "transferBytes";
        f19336b.put(str3, Field.m22023a(str3, 4));
    }
}
