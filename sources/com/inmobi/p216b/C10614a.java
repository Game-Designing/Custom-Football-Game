package com.inmobi.p216b;

import com.inmobi.ads.C10478c;
import com.inmobi.ads.C10478c.C10479a;
import com.inmobi.ads.C10478c.C10488j;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p219b.C10630a;
import com.inmobi.commons.core.p219b.C10632c;
import com.inmobi.commons.core.p219b.C10633d;
import com.inmobi.commons.core.p219b.C10635e;
import com.inmobi.commons.core.p223f.C10670a;
import com.inmobi.commons.core.p223f.C10671b;
import com.inmobi.commons.core.utilities.p225b.C10690a;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.commons.p217a.C10620b;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.b.a */
/* compiled from: TRCComponent */
public class C10614a implements C10635e, C10644c {

    /* renamed from: b */
    public static AtomicBoolean f32330b = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f32331f = C10614a.class.getSimpleName();

    /* renamed from: g */
    private static final Object f32332g = new Object();

    /* renamed from: h */
    private static volatile C10614a f32333h;

    /* renamed from: a */
    public ExecutorService f32334a = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public C10478c f32335c = new C10478c();

    /* renamed from: d */
    public C10670a f32336d = new C10670a();

    /* renamed from: e */
    public String f32337e = this.f32335c.f31890b;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C10633d f32338i;

    /* renamed from: a */
    static /* synthetic */ void m34822a(C10614a aVar) {
        aVar.m34827b("banner");
        aVar.m34827b("int");
        aVar.m34827b("native");
    }

    /* renamed from: a */
    static /* synthetic */ void m34823a(C10614a aVar, C10671b bVar) {
        C10479a b = aVar.f32335c.mo34204b(bVar.f32550j);
        aVar.f32336d.mo34432b(b.f31909b, bVar.f32550j);
        if (aVar.f32336d.mo34428a(bVar.f32550j) - b.f31910c >= 0) {
            C10670a.m35022d(bVar.f32550j);
        }
        C10670a.m35020a(bVar);
    }

    /* renamed from: a */
    public static C10614a m34820a() {
        C10614a aVar = f32333h;
        if (aVar == null) {
            synchronized (f32332g) {
                aVar = f32333h;
                if (aVar == null) {
                    aVar = new C10614a();
                    f32333h = aVar;
                }
            }
        }
        return aVar;
    }

    private C10614a() {
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        this.f32335c = (C10478c) aVar;
        this.f32337e = this.f32335c.f31890b;
    }

    /* renamed from: b */
    private void m34827b(final String str) {
        this.f32334a.execute(new Runnable() {
            public final void run() {
                C10670a aVar = C10614a.this.f32336d;
                if (C10670a.m35021c(str)) {
                    C10614a.m34824a(C10614a.this, str);
                }
            }
        });
    }

    /* renamed from: a */
    public final C10632c mo34417a(String str) {
        List<C10671b> list;
        C10479a b = this.f32335c.mo34204b(str);
        if (C10691b.m35099a() != 1) {
            list = C10670a.m35019a(b.f31913f.f31958c, str);
        } else {
            list = C10670a.m35019a(b.f31914g.f31958c, str);
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (C10671b bVar : list) {
                arrayList.add(Integer.valueOf(bVar.f32541a));
            }
            String a = m34821a(list);
            if (a != null) {
                return new C10632c(arrayList, a, false);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m34821a(List<C10671b> list) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.putAll(C10691b.m35101a(false));
            hashMap.put("im-accid", C10619a.m34847e());
            hashMap.put(MediationMetaData.KEY_VERSION, "2.0.0");
            hashMap.put("component", "trc");
            hashMap.put("adtype", ((C10671b) list.get(0)).f32550j);
            hashMap.put("mk-version", C10620b.m34851a());
            hashMap.putAll(C10690a.m35097a().f32621b);
            JSONObject jSONObject = new JSONObject(hashMap);
            JSONArray jSONArray = new JSONArray();
            for (C10671b bVar : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("event-id", bVar.f32542b);
                jSONObject2.put("ad-markup-type", bVar.f32543c);
                jSONObject2.put("event-name", bVar.f32544d);
                jSONObject2.put("im-plid", bVar.f32545e);
                jSONObject2.put("request-id", bVar.f32546f);
                jSONObject2.put("event-type", bVar.f32547g);
                jSONObject2.put("d-nettype-raw", bVar.f32548h);
                jSONObject2.put("ts", bVar.f32549i);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("extra-info", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m34824a(C10614a aVar, String str) {
        C10614a aVar2 = aVar;
        String str2 = str;
        if (!f32330b.get()) {
            C10479a b = aVar2.f32335c.mo34204b(str2);
            int i = b.f31908a;
            long j = b.f31909b;
            long j2 = b.f31911d;
            long j3 = b.f31912e;
            C10488j jVar = b.f31914g;
            int i2 = jVar.f31957b;
            int i3 = jVar.f31958c;
            C10488j jVar2 = b.f31913f;
            int i4 = jVar2.f31957b;
            int i5 = jVar2.f31958c;
            long j4 = jVar.f31956a;
            long j5 = jVar2.f31956a;
            C10630a aVar3 = r3;
            C10630a aVar4 = new C10630a(i, j, j2, j3, i2, i3, i4, i5, j4, j5);
            C10614a aVar5 = aVar;
            aVar3.f32396e = aVar5.f32337e;
            String str3 = str;
            aVar3.f32393b = str3;
            C10633d dVar = aVar5.f32338i;
            if (dVar == null) {
                aVar5.f32338i = new C10633d(aVar5.f32336d, aVar5, aVar3);
            } else {
                dVar.mo34440a(aVar3);
            }
            aVar5.f32338i.mo34443a(str3);
        }
    }
}
