package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.p212c.C10491a;
import java.util.Map;

/* renamed from: com.inmobi.ads.bi */
/* compiled from: Placement */
public final class C10455bi {

    /* renamed from: a */
    public long f31801a;

    /* renamed from: b */
    public String f31802b;

    /* renamed from: c */
    public Map<String, String> f31803c;

    /* renamed from: d */
    public String f31804d;

    /* renamed from: e */
    String f31805e;

    /* renamed from: f */
    public MonetizationContext f31806f = MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY;

    /* renamed from: a */
    public static C10455bi m34229a(long j, Map<String, String> map, String str, String str2) {
        C10455bi biVar = new C10455bi(j, C10491a.m34325a(map), str);
        biVar.f31804d = str2;
        biVar.f31803c = map;
        return biVar;
    }

    private C10455bi(long j, String str, String str2) {
        this.f31801a = j;
        this.f31802b = str;
        this.f31805e = str2;
        if (this.f31802b == null) {
            this.f31802b = "";
        }
    }

    public C10455bi(ContentValues contentValues) {
        this.f31801a = contentValues.getAsLong("placement_id").longValue();
        this.f31802b = contentValues.getAsString("tp_key");
        this.f31805e = contentValues.getAsString("ad_type");
        this.f31806f = MonetizationContext.m33595a(contentValues.getAsString("m10_context"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C10455bi.class != obj.getClass()) {
            return false;
        }
        C10455bi biVar = (C10455bi) obj;
        if (this.f31801a != biVar.f31801a || this.f31806f != biVar.f31806f || !this.f31802b.equals(biVar.f31802b) || !this.f31805e.equals(biVar.f31805e)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.f31801a;
        return (((((int) (j ^ (j >>> 32))) * 31) + this.f31805e.hashCode()) * 30) + this.f31806f.hashCode();
    }
}
