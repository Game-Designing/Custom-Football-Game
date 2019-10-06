package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
public final class StringToIntConverter extends AbstractSafeParcelable implements FieldConverter<String, Integer> {
    public static final Creator<StringToIntConverter> CREATOR = new zac();

    /* renamed from: a */
    private final int f20193a;

    /* renamed from: b */
    private final HashMap<String, Integer> f20194b;

    /* renamed from: c */
    private final SparseArray<String> f20195c;

    /* renamed from: d */
    private final ArrayList<zaa> f20196d;

    public static final class zaa extends AbstractSafeParcelable {
        public static final Creator<zaa> CREATOR = new zad();

        /* renamed from: a */
        private final int f20197a;

        /* renamed from: b */
        final String f20198b;

        /* renamed from: c */
        final int f20199c;

        @Constructor
        zaa(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
            this.f20197a = i;
            this.f20198b = str;
            this.f20199c = i2;
        }

        zaa(String str, int i) {
            this.f20197a = 1;
            this.f20198b = str;
            this.f20199c = i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int a = SafeParcelWriter.m21953a(parcel);
            SafeParcelWriter.m21957a(parcel, 1, this.f20197a);
            SafeParcelWriter.m21965a(parcel, 2, this.f20198b, false);
            SafeParcelWriter.m21957a(parcel, 3, this.f20199c);
            SafeParcelWriter.m21954a(parcel, a);
        }
    }

    @Constructor
    StringToIntConverter(@Param(id = 1) int i, @Param(id = 2) ArrayList<zaa> arrayList) {
        this.f20193a = i;
        this.f20194b = new HashMap<>();
        this.f20195c = new SparseArray<>();
        this.f20196d = null;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            zaa zaa2 = (zaa) obj;
            mo27874a(zaa2.f20198b, zaa2.f20199c);
        }
    }

    @KeepForSdk
    public StringToIntConverter() {
        this.f20193a = 1;
        this.f20194b = new HashMap<>();
        this.f20195c = new SparseArray<>();
        this.f20196d = null;
    }

    @KeepForSdk
    /* renamed from: a */
    public final StringToIntConverter mo27874a(String str, int i) {
        this.f20194b.put(str, Integer.valueOf(i));
        this.f20195c.put(i, str);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20193a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f20194b.keySet()) {
            arrayList.add(new zaa(str, ((Integer) this.f20194b.get(str)).intValue()));
        }
        SafeParcelWriter.m21977c(parcel, 2, arrayList, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo27875a(Object obj) {
        String str = (String) this.f20195c.get(((Integer) obj).intValue());
        if (str == null) {
            String str2 = "gms_unknown";
            if (this.f20194b.containsKey(str2)) {
                return str2;
            }
        }
        return str;
    }
}
