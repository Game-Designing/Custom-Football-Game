package com.inmobi.commons.core.p222e;

import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p219b.C10630a;
import com.inmobi.commons.core.p219b.C10632c;
import com.inmobi.commons.core.p219b.C10633d;
import com.inmobi.commons.core.p219b.C10635e;
import com.inmobi.commons.core.p222e.C10666d.C10667a;
import com.inmobi.commons.core.utilities.p225b.C10690a;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.commons.p217a.C10620b;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.commons.core.e.b */
/* compiled from: TelemetryComponent */
public class C10659b implements C10635e, C10644c {

    /* renamed from: b */
    public static AtomicBoolean f32497b = new AtomicBoolean(false);

    /* renamed from: c */
    private static final String f32498c = C10659b.class.getSimpleName();

    /* renamed from: d */
    private static final Object f32499d = new Object();

    /* renamed from: e */
    private static volatile C10659b f32500e;

    /* renamed from: f */
    private static Map<String, C10664c> f32501f;

    /* renamed from: a */
    public ExecutorService f32502a;

    /* renamed from: g */
    private C10666d f32503g = new C10666d();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C10668e f32504h;

    /* renamed from: i */
    private String f32505i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C10633d f32506j;

    /* renamed from: a */
    public static C10659b m34983a() {
        C10659b bVar = f32500e;
        if (bVar == null) {
            synchronized (f32499d) {
                bVar = f32500e;
                if (bVar == null) {
                    bVar = new C10659b();
                    f32500e = bVar;
                }
            }
        }
        return bVar;
    }

    /* renamed from: b */
    public final void mo34487b() {
        f32497b.set(false);
        C10641b.m34915a().mo34452a((C10639a) this.f32503g, (C10644c) this);
        m34986a("telemetry", this.f32503g.f32519a);
        this.f32505i = this.f32503g.f32520b;
        this.f32502a.execute(new Runnable() {
            public final void run() {
                C10659b.this.f32502a.execute(new Runnable() {
                    public final void run() {
                        if (C10659b.this.f32504h.mo34428a(BuildConfig.APTOIDE_THEME) > 0) {
                            C10659b.m34991d(C10659b.this);
                        }
                    }
                });
            }
        });
    }

    private C10659b() {
        f32501f = new HashMap();
        m34986a("telemetry", this.f32503g.f32519a);
        this.f32505i = this.f32503g.f32520b;
        this.f32504h = new C10668e();
        this.f32502a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public final void mo34486a(String str, JSONObject jSONObject) {
        m34986a(str, new C10664c(str, jSONObject, this.f32503g.f32519a));
    }

    /* renamed from: a */
    private void m34986a(String str, C10664c cVar) {
        if (str != null && !str.trim().equals("")) {
            if (cVar != null) {
                f32501f.put(str, cVar);
            } else {
                f32501f.put(str, new C10664c(str, null, this.f32503g.f32519a));
            }
        }
    }

    /* renamed from: c */
    private static C10664c m34990c(C10669f fVar) {
        m34983a();
        String str = fVar.f32537d;
        if (str == null || str.trim().equals("")) {
            return null;
        }
        return (C10664c) f32501f.get(str);
    }

    /* renamed from: a */
    public static void m34987a(String str, String str2, Map<String, Object> map) {
        try {
            C10669f fVar = new C10669f(str, str2);
            if (map != null && !map.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Entry entry : map.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    fVar.f32539f = jSONObject.toString();
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder("Error forming JSON payload for ");
                    sb.append(str2);
                    sb.append(" Error: ");
                    sb.append(e);
                }
            }
            m34983a().mo34485a(fVar);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
            sb2.append(e2.getMessage());
            sb2.append(")");
        }
    }

    /* renamed from: a */
    public final void mo34485a(final C10669f fVar) {
        C10664c c = m34990c(fVar);
        if (c == null || !c.f32513b || !this.f32503g.f32519a.f32513b) {
            StringBuilder sb = new StringBuilder("Telemetry service is not enabled or registered for component: ");
            sb.append(fVar.f32537d);
            sb.append("|| type = ");
            sb.append(fVar.f32536c);
            sb.append(" Config :");
            sb.append(c);
            return;
        }
        this.f32502a.execute(new Runnable() {
            public final void run() {
                C10659b.this.mo34488b(fVar);
                C10659b.m34991d(C10659b.this);
            }
        });
    }

    /* renamed from: b */
    public final void mo34488b(C10669f fVar) {
        C10664c c = m34990c(fVar);
        if (c != null && c.f32513b) {
            C10666d dVar = this.f32503g;
            if (dVar.f32519a.f32513b) {
                C10668e eVar = this.f32504h;
                long j = dVar.f32524f;
                String str = BuildConfig.APTOIDE_THEME;
                eVar.mo34432b(j, str);
                if ((this.f32504h.mo34428a(str) + 1) - this.f32503g.f32523e >= 0) {
                    C10668e.m35008a();
                }
                C10668e.m35009a(fVar);
                return;
            }
        }
        StringBuilder sb = new StringBuilder("Telemetry service is not enabled or registered for component: ");
        sb.append(fVar.f32537d);
        sb.append("|| type = ");
        sb.append(fVar.f32536c);
        sb.append(" Config :");
        sb.append(c);
    }

    /* renamed from: a */
    public final C10632c mo34417a(String str) {
        List<C10669f> list;
        if (C10691b.m35099a() != 1) {
            list = C10668e.m35007a(this.f32503g.f32526h.f32530c);
        } else {
            list = C10668e.m35007a(this.f32503g.f32527i.f32530c);
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (C10669f fVar : list) {
                arrayList.add(Integer.valueOf(fVar.f32534a));
            }
            String a = m34984a(list);
            if (a != null) {
                return new C10632c(arrayList, a, true);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m34984a(List<C10669f> list) {
        String str = "telemetry";
        try {
            HashMap hashMap = new HashMap();
            hashMap.putAll(C10691b.m35101a(false));
            hashMap.put("im-accid", C10619a.m34847e());
            hashMap.put(MediationMetaData.KEY_VERSION, "2.0.0");
            hashMap.put("component", str);
            hashMap.put("mk-version", C10620b.m34851a());
            hashMap.putAll(C10690a.m35097a().f32621b);
            JSONObject jSONObject = new JSONObject(hashMap);
            JSONArray jSONArray = new JSONArray();
            for (C10669f fVar : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", fVar.f32535b);
                jSONObject2.put("eventType", fVar.f32536c);
                if (!fVar.mo34494a().trim().isEmpty()) {
                    jSONObject2.put("payload", fVar.mo34494a());
                }
                jSONObject2.put("componentType", fVar.f32537d);
                jSONObject2.put("ts", fVar.f32538e);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(str, jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        this.f32503g = (C10666d) aVar;
        this.f32505i = this.f32503g.f32520b;
    }

    /* renamed from: d */
    static /* synthetic */ void m34991d(C10659b bVar) {
        C10659b bVar2 = bVar;
        if (!f32497b.get()) {
            C10666d dVar = bVar2.f32503g;
            int i = dVar.f32522d;
            long j = dVar.f32524f;
            long j2 = dVar.f32521c;
            long j3 = dVar.f32525g;
            C10667a aVar = dVar.f32527i;
            int i2 = aVar.f32529b;
            int i3 = aVar.f32530c;
            C10667a aVar2 = dVar.f32526h;
            int i4 = aVar2.f32529b;
            int i5 = aVar2.f32530c;
            long j4 = aVar.f32528a;
            long j5 = aVar2.f32528a;
            C10630a aVar3 = r2;
            C10630a aVar4 = new C10630a(i, j, j2, j3, i2, i3, i4, i5, j4, j5);
            aVar3.f32396e = bVar2.f32505i;
            String str = BuildConfig.APTOIDE_THEME;
            aVar3.f32393b = str;
            C10633d dVar2 = bVar2.f32506j;
            if (dVar2 == null) {
                bVar2.f32506j = new C10633d(bVar2.f32504h, bVar2, aVar3);
            } else {
                dVar2.mo34440a(aVar3);
            }
            bVar2.f32506j.mo34443a(str);
        }
    }
}
