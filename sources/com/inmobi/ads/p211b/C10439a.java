package com.inmobi.ads.p211b;

import com.inmobi.ads.C10359a;
import com.inmobi.ads.C10528d;
import com.inmobi.ads.C10537f;
import com.inmobi.ads.C10540h;
import com.inmobi.ads.C10545i;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.p210a.C10362b;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.inmobi.ads.b.a */
/* compiled from: GMAManager */
public final class C10439a {

    /* renamed from: a */
    public C10545i f31754a;

    /* renamed from: b */
    public String f31755b;

    /* renamed from: c */
    public long f31756c;

    /* renamed from: d */
    public C10440b f31757d;

    public C10439a(C10545i iVar, String str) {
        this.f31754a = iVar;
        this.f31755b = str;
    }

    /* renamed from: a */
    public final byte[] mo34142a() throws C10362b {
        List list;
        List list2;
        this.f31754a.mo34296d("AdCacheImpressionRequested");
        this.f31754a.mo34301i();
        C10540h.m34534a();
        C10540h i = this.f31754a.mo34301i();
        C10545i iVar = this.f31754a;
        long j = iVar.f32168d;
        iVar.mo33976b();
        String c = this.f31754a.mo33981c();
        MonetizationContext l = this.f31754a.mo33991l();
        String str = this.f31755b;
        C10540h.m34541c();
        if (i.f32137d.f31927e) {
            list = i.f32135b.mo34258d(j, c, l, str);
        } else {
            list = i.f32135b.mo34257c(j, c, l, str);
        }
        C10359a aVar = list.size() == 0 ? null : (C10359a) list.get(0);
        C10537f t = this.f31754a.mo34306t();
        if (aVar == null) {
            list2 = null;
        } else {
            list2 = Collections.singletonList(aVar);
        }
        this.f31757d = new C10440b(t, list2);
        if (aVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("impId", aVar.f31481g);
            this.f31754a.mo34295c("AdCacheImpressionOffered", (Map<String, Object>) hashMap);
        }
        if (aVar != null) {
            C10540h i2 = this.f31754a.mo34301i();
            String str2 = aVar.f31481g;
            C10528d dVar = i2.f32135b;
            C10528d.m34490b(str2);
        }
        this.f31754a.mo34301i().mo34268a(this.f31754a.mo34307u());
        this.f31756c = System.currentTimeMillis();
        try {
            return this.f31757d.mo34143a();
        } catch (JSONException e) {
            return null;
        }
    }
}
