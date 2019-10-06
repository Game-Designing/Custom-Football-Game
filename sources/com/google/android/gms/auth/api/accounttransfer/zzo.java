package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

public class zzo extends zzaz {
    public static final Creator<zzo> CREATOR = new zzp();

    /* renamed from: b */
    private static final C1253b<String, Field<?, ?>> f19322b;

    /* renamed from: c */
    private final int f19323c;

    /* renamed from: d */
    private List<String> f19324d;

    /* renamed from: e */
    private List<String> f19325e;

    /* renamed from: f */
    private List<String> f19326f;

    /* renamed from: g */
    private List<String> f19327g;

    /* renamed from: h */
    private List<String> f19328h;

    public zzo() {
        this.f19323c = 1;
    }

    @Constructor
    zzo(@Param(id = 1) int i, @Param(id = 2) List<String> list, @Param(id = 3) List<String> list2, @Param(id = 4) List<String> list3, @Param(id = 5) List<String> list4, @Param(id = 6) List<String> list5) {
        this.f19323c = i;
        this.f19324d = list;
        this.f19325e = list2;
        this.f19326f = list3;
        this.f19327g = list4;
        this.f19328h = list5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19323c);
        SafeParcelWriter.m21975b(parcel, 2, this.f19324d, false);
        SafeParcelWriter.m21975b(parcel, 3, this.f19325e, false);
        SafeParcelWriter.m21975b(parcel, 4, this.f19326f, false);
        SafeParcelWriter.m21975b(parcel, 5, this.f19327g, false);
        SafeParcelWriter.m21975b(parcel, 6, this.f19328h, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* renamed from: a */
    public Map<String, Field<?, ?>> mo27101a() {
        return f19322b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo27102b(Field field) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo27100a(Field field) {
        switch (field.mo27889a()) {
            case 1:
                return Integer.valueOf(this.f19323c);
            case 2:
                return this.f19324d;
            case 3:
                return this.f19325e;
            case 4:
                return this.f19326f;
            case 5:
                return this.f19327g;
            case 6:
                return this.f19328h;
            default:
                int a = field.mo27889a();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(a);
                throw new IllegalStateException(sb.toString());
        }
    }

    static {
        C1253b<String, Field<?, ?>> bVar = new C1253b<>();
        f19322b = bVar;
        String str = "registered";
        bVar.put(str, Field.m22029d(str, 2));
        String str2 = "in_progress";
        f19322b.put(str2, Field.m22029d(str2, 3));
        C1253b<String, Field<?, ?>> bVar2 = f19322b;
        String str3 = RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION;
        bVar2.put(str3, Field.m22029d(str3, 4));
        String str4 = "failed";
        f19322b.put(str4, Field.m22029d(str4, 5));
        String str5 = "escrowed";
        f19322b.put(str5, Field.m22029d(str5, 6));
    }
}
