package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
public final class zak extends AbstractSafeParcelable {
    public static final Creator<zak> CREATOR = new zan();

    /* renamed from: a */
    private final int f20240a;

    /* renamed from: b */
    private final HashMap<String, Map<String, Field<?, ?>>> f20241b;

    /* renamed from: c */
    private final ArrayList<zal> f20242c = null;

    /* renamed from: d */
    private final String f20243d;

    @Constructor
    zak(@Param(id = 1) int i, @Param(id = 2) ArrayList<zal> arrayList, @Param(id = 3) String str) {
        this.f20240a = i;
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zal = (zal) arrayList.get(i2);
            String str2 = zal.f20245b;
            HashMap hashMap2 = new HashMap();
            int size2 = zal.f20246c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zam = (zam) zal.f20246c.get(i3);
                hashMap2.put(zam.f20248b, zam.f20249c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f20241b = hashMap;
        Preconditions.m21857a(str);
        this.f20243d = str;
        mo27905a();
    }

    /* renamed from: a */
    public final void mo27905a() {
        for (String str : this.f20241b.keySet()) {
            Map map = (Map) this.f20241b.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).mo27891a(this);
            }
        }
    }

    /* renamed from: a */
    public final Map<String, Field<?, ?>> mo27904a(String str) {
        return (Map) this.f20241b.get(str);
    }

    /* renamed from: c */
    public final String mo27906c() {
        return this.f20243d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f20241b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.f20241b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20240a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f20241b.keySet()) {
            arrayList.add(new zal(str, (Map) this.f20241b.get(str)));
        }
        SafeParcelWriter.m21977c(parcel, 2, arrayList, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f20243d, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
