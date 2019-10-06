package com.inmobi.commons.core.p218a;

import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p218a.C10625b.C10626a;
import com.inmobi.commons.core.p219b.C10630a;
import com.inmobi.commons.core.p219b.C10632c;
import com.inmobi.commons.core.p219b.C10633d;
import com.inmobi.commons.core.p219b.C10635e;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.p222e.C10669f;
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
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.commons.core.a.a */
/* compiled from: CrashComponent */
public class C10621a implements C10635e, C10644c {

    /* renamed from: b */
    public static AtomicBoolean f32352b = new AtomicBoolean(false);

    /* renamed from: e */
    private static final String f32353e = C10621a.class.getSimpleName();

    /* renamed from: f */
    private static final Object f32354f = new Object();

    /* renamed from: g */
    private static volatile C10621a f32355g;

    /* renamed from: a */
    public ExecutorService f32356a;

    /* renamed from: c */
    public C10625b f32357c = new C10625b();

    /* renamed from: d */
    public String f32358d;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C10627c f32359h;

    /* renamed from: i */
    private C10633d f32360i;

    /* renamed from: a */
    public static C10621a m34854a() {
        C10621a aVar = f32355g;
        if (aVar == null) {
            synchronized (f32354f) {
                aVar = f32355g;
                if (aVar == null) {
                    aVar = new C10621a();
                    f32355g = aVar;
                }
            }
        }
        return aVar;
    }

    private C10621a() {
        Thread.setDefaultUncaughtExceptionHandler(new C10629e(Thread.getDefaultUncaughtExceptionHandler()));
        C10659b.m34983a().mo34486a("crashReporting", this.f32357c.f32374i);
        C10659b.m34983a().mo34486a("catchReporting", this.f32357c.f32375j);
        this.f32358d = this.f32357c.f32366a;
        this.f32359h = new C10627c();
        this.f32356a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        this.f32357c = (C10625b) aVar;
        this.f32358d = this.f32357c.f32366a;
        C10659b.m34983a().mo34486a("crashReporting", this.f32357c.f32374i);
        C10659b.m34983a().mo34486a("catchReporting", this.f32357c.f32375j);
    }

    /* renamed from: a */
    public final void mo34423a(final C10658a aVar) {
        if (this.f32357c.f32373h) {
            C10659b.m34983a().mo34485a(new C10669f("catchReporting", "CatchEventOccurred"));
            this.f32356a.execute(new Runnable() {
                public final void run() {
                    C10621a.this.mo34422a((C10628d) aVar);
                    C10621a.m34856a(C10621a.this);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo34422a(C10628d dVar) {
        if (!(dVar instanceof C10658a)) {
            if (this.f32357c.f32372g) {
                C10659b.m34983a().mo34488b(new C10669f("crashReporting", "CrashEventOccurred"));
            } else {
                return;
            }
        }
        C10627c cVar = this.f32359h;
        long j = this.f32357c.f32370e;
        String str = BuildConfig.APTOIDE_THEME;
        cVar.mo34432b(j, str);
        if ((this.f32359h.mo34428a(str) + 1) - this.f32357c.f32369d >= 0) {
            C10627c.m34872a();
        }
        C10627c.m34873a(dVar);
    }

    /* renamed from: a */
    public final C10632c mo34417a(String str) {
        List<C10628d> list;
        if (C10691b.m35099a() != 1) {
            list = C10627c.m34871a(this.f32357c.f32376k.f32380c);
        } else {
            list = C10627c.m34871a(this.f32357c.f32377l.f32380c);
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (C10628d dVar : list) {
                arrayList.add(Integer.valueOf(dVar.f32384a));
            }
            String a = m34855a(list);
            if (a != null) {
                return new C10632c(arrayList, a, false);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m34855a(List<C10628d> list) {
        String str = "crash";
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
            for (C10628d dVar : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", dVar.f32385b);
                jSONObject2.put("eventType", dVar.f32386c);
                if (!dVar.mo34435a().trim().isEmpty()) {
                    jSONObject2.put("crash_report", dVar.mo34435a());
                }
                jSONObject2.put("ts", dVar.f32388e);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(str, jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m34856a(C10621a aVar) {
        C10621a aVar2 = aVar;
        if (!f32352b.get()) {
            C10625b bVar = aVar2.f32357c;
            int i = bVar.f32368c;
            long j = bVar.f32370e;
            long j2 = bVar.f32367b;
            long j3 = bVar.f32371f;
            C10626a aVar3 = bVar.f32377l;
            int i2 = aVar3.f32379b;
            int i3 = aVar3.f32380c;
            C10626a aVar4 = bVar.f32376k;
            int i4 = aVar4.f32379b;
            int i5 = aVar4.f32380c;
            long j4 = aVar3.f32378a;
            long j5 = aVar4.f32378a;
            C10630a aVar5 = r2;
            C10630a aVar6 = new C10630a(i, j, j2, j3, i2, i3, i4, i5, j4, j5);
            aVar5.f32396e = aVar2.f32358d;
            String str = BuildConfig.APTOIDE_THEME;
            aVar5.f32393b = str;
            C10633d dVar = aVar2.f32360i;
            if (dVar == null) {
                aVar2.f32360i = new C10633d(aVar2.f32359h, aVar2, aVar5);
            } else {
                dVar.mo34440a(aVar5);
            }
            aVar2.f32360i.mo34443a(str);
        }
    }
}
