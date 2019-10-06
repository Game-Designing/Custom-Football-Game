package com.inmobi.ads;

import android.net.Uri;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.commons.core.configs.C10651g;
import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.utilities.p225b.C10690a;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.commons.core.utilities.p225b.C10697g;
import com.inmobi.commons.core.utilities.uid.C10711d;
import com.inmobi.p207a.C10296m;
import com.inmobi.p207a.p208a.C10279c;
import com.inmobi.p207a.p209b.C10281a;
import com.inmobi.p207a.p209b.C10282b;
import com.mopub.common.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.ads.f */
/* compiled from: AdNetworkRequest */
public final class C10537f extends C10676c {

    /* renamed from: B */
    private static final String f32116B = C10537f.class.getSimpleName();

    /* renamed from: a */
    public long f32117a;

    /* renamed from: b */
    String f32118b = "json";

    /* renamed from: c */
    public String f32119c;

    /* renamed from: d */
    int f32120d = 1;

    /* renamed from: e */
    public String f32121e;

    /* renamed from: f */
    public String f32122f;

    /* renamed from: g */
    public Map<String, String> f32123g;

    /* renamed from: h */
    Map<String, String> f32124h;

    /* renamed from: i */
    public final String f32125i;

    /* renamed from: j */
    public MonetizationContext f32126j;

    /* renamed from: k */
    public final C10595r f32127k;

    /* renamed from: l */
    boolean f32128l = false;

    public C10537f(String str, long j, C10711d dVar, String str2) {
        super("POST", str, m34528a(str), dVar, m34528a(str), 0);
        this.f32117a = j;
        this.f32577o.put("im-plid", String.valueOf(this.f32117a));
        this.f32577o.putAll(C10697g.m35128d());
        this.f32577o.putAll(C10692c.m35107c());
        this.f32577o.put("u-appIS", C10690a.m35097a().f32620a);
        this.f32577o.putAll(C10296m.m33551a().mo33657f());
        this.f32577o.putAll(C10296m.m33551a().mo33656e());
        Map<String, String> map = this.f32577o;
        C10281a a = C10282b.m33530a();
        HashMap hashMap = new HashMap();
        if (a != null) {
            hashMap.put("c-ap-bssid", String.valueOf(a.f31152a));
        }
        map.putAll(hashMap);
        this.f32577o.putAll(C10279c.m33525b());
        this.f32577o.putAll(C10279c.m33526c());
        this.f32577o.putAll(C10279c.m33522a());
        this.f32125i = UUID.randomUUID().toString();
        this.f32577o.put("client-request-id", this.f32125i);
        if (str2 != null) {
            this.f32577o.put("u-appcache", str2);
        }
        this.f32577o.put("sdk-flavor", "row");
        this.f32127k = new C10595r();
        this.f32577o.put("skdv", this.f32588z.f32468c);
        Map<String, String> map2 = this.f32577o;
        C10595r rVar = this.f32127k;
        C10651g gVar = this.f32588z;
        map2.put("skdm", rVar.mo34405a(gVar.f32467b, gVar.f32466a));
    }

    /* renamed from: a */
    private static boolean m34528a(String str) {
        if (str == null) {
            return true;
        }
        Uri parse = Uri.parse(str);
        if (!Constants.HTTP.equals(parse.getScheme())) {
            if ("https".equals(parse.getScheme())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo34263a() {
        super.mo34263a();
        this.f32577o.put("format", this.f32118b);
        this.f32577o.put("mk-ads", String.valueOf(this.f32120d));
        this.f32577o.put("adtype", this.f32121e);
        String str = this.f32122f;
        if (str != null) {
            this.f32577o.put("p-keywords", str);
        }
        MonetizationContext monetizationContext = this.f32126j;
        String str2 = "M10N_CONTEXT_ACTIVITY";
        if (monetizationContext != null && monetizationContext == MonetizationContext.MONETIZATION_CONTEXT_OTHER) {
            str2 = "M10N_CONTEXT_OTHER";
        }
        this.f32577o.put("m10n_context", str2);
        Map<String, String> map = this.f32123g;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!this.f32577o.containsKey(entry.getKey())) {
                    this.f32577o.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Map<String, String> map2 = this.f32124h;
        if (map2 != null) {
            this.f32577o.putAll(map2);
        }
    }

    /* renamed from: b */
    public final boolean mo34264b() {
        return this.f32128l || super.mo34264b();
    }

    /* renamed from: c */
    public final String mo34265c() {
        String str = "preload-request";
        if (this.f32124h.containsKey(str)) {
            return (String) this.f32124h.get(str);
        }
        return BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
    }
}
