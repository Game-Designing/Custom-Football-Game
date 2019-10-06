package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcgb {

    /* renamed from: a */
    private boolean f26569a = false;

    /* renamed from: b */
    private boolean f26570b = false;

    /* renamed from: c */
    private final long f26571c;

    /* renamed from: d */
    private final zzbbr<Boolean> f26572d = new zzbbr<>();

    /* renamed from: e */
    private final Context f26573e;

    /* renamed from: f */
    private final zzclc f26574f;

    /* renamed from: g */
    private final Executor f26575g;

    /* renamed from: h */
    private final Executor f26576h;

    /* renamed from: i */
    private final ScheduledExecutorService f26577i;

    /* renamed from: j */
    private Map<String, zzaio> f26578j = new ConcurrentHashMap();

    public zzcgb(Executor executor, Context context, Executor executor2, zzclc zzclc, ScheduledExecutorService scheduledExecutorService) {
        this.f26574f = zzclc;
        this.f26573e = context;
        this.f26575g = executor2;
        this.f26577i = scheduledExecutorService;
        this.f26576h = executor;
        this.f26571c = zzk.zzln().mo27934a();
        m28406a("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* renamed from: a */
    public final void mo31147a(zzait zzait) {
        this.f26572d.mo28811a(new C8790Ci(this, zzait), this.f26576h);
    }

    /* renamed from: a */
    public final void mo31156f() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24079dc)).booleanValue() && !this.f26569a) {
            synchronized (this) {
                if (!this.f26569a) {
                    String c = zzk.zzlk().mo30177i().mo30222k().mo30161c();
                    if (TextUtils.isEmpty(c)) {
                        m28407g();
                        return;
                    }
                    this.f26569a = true;
                    m28406a("com.google.android.gms.ads.MobileAds", true, "", (int) (zzk.zzln().mo27934a() - this.f26571c));
                    this.f26575g.execute(new C8811Di(this, c));
                }
            }
        }
    }

    /* renamed from: b */
    public final List<zzaio> mo31151b() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f26578j.keySet()) {
            zzaio zzaio = (zzaio) this.f26578j.get(str);
            arrayList.add(new zzaio(str, zzaio.f24366b, zzaio.f24367c, zzaio.f24368d));
        }
        return arrayList;
    }

    /* renamed from: g */
    private final synchronized void m28407g() {
        if (!this.f26570b) {
            zzk.zzlk().mo30177i().mo30202a((Runnable) new C8832Ei(this));
            this.f26570b = true;
            this.f26577i.schedule(new C8853Fi(this), ((Long) zzyt.m31536e().mo29599a(zzacu.f24091fc)).longValue(), TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m28406a(String str, boolean z, String str2, int i) {
        this.f26578j.put(str, new zzaio(str, z, i, str2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31148a(zzams zzams, zzaiq zzaiq, List list) {
        try {
            zzams.mo29841a(ObjectWrapper.m22188a(this.f26573e), zzaiq, list);
        } catch (RemoteException e) {
            try {
                zzaiq.onInitializationFailed("Failed to create Adapter.");
            } catch (RemoteException e2) {
                zzbad.m26356b("", e2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ Object mo31153c() throws Exception {
        this.f26572d.mo30338b(Boolean.valueOf(true));
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31149a(Object obj, zzbbr zzbbr, String str, long j) {
        synchronized (obj) {
            if (!zzbbr.isDone()) {
                m28406a(str, false, "timeout", (int) (zzk.zzln().mo27934a() - j));
                zzbbr.mo30338b(Boolean.valueOf(false));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ void mo31154d() {
        synchronized (this) {
            if (!this.f26569a) {
                m28406a("com.google.android.gms.ads.MobileAds", false, "timeout", (int) (zzk.zzln().mo27934a() - this.f26571c));
                this.f26572d.mo30338b(Boolean.valueOf(true));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final /* synthetic */ void mo31155e() {
        this.f26575g.execute(new C8937Ji(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31150a(String str) {
        String str2 = "data";
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                Object obj = new Object();
                zzbbr zzbbr = new zzbbr();
                zzbbh a = zzbar.m26378a((zzbbh<V>) zzbbr, ((Long) zzyt.m31536e().mo29599a(zzacu.f24085ec)).longValue(), TimeUnit.SECONDS, this.f26577i);
                long a2 = zzk.zzln().mo27934a();
                Iterator it = keys;
                C8874Gi gi = r1;
                C8874Gi gi2 = new C8874Gi(this, obj, zzbbr, str3, a2);
                a.mo28811a(gi, this.f26575g);
                arrayList.add(a);
                C8958Ki ki = new C8958Ki(this, obj, str3, a2, zzbbr);
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                ArrayList arrayList2 = new ArrayList();
                String str4 = "";
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray(str2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", str4);
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject(str2);
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String str5 = (String) keys2.next();
                                    bundle.putString(str5, optJSONObject2.optString(str5, str4));
                                }
                            }
                            arrayList2.add(new zzaiw(optString, bundle));
                        }
                    } catch (JSONException e) {
                    }
                }
                m28406a(str3, false, str4, 0);
                try {
                    this.f26576h.execute(new C8916Ii(this, this.f26574f.mo31200a(str3, new JSONObject()), ki, arrayList2));
                    keys = it;
                } catch (RemoteException e2) {
                    try {
                        ki.onInitializationFailed("Failed to create Adapter.");
                        keys = it;
                    } catch (RemoteException e3) {
                        zzbad.m26356b(str4, e3);
                        keys = it;
                    }
                }
            }
            zzbar.m26388b(arrayList).mo30334a(new C8895Hi(this), this.f26575g);
        } catch (JSONException e4) {
            zzawz.m26002e("Malformed CLD response", e4);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31152b(zzait zzait) {
        try {
            zzait.mo29756b(mo31151b());
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
