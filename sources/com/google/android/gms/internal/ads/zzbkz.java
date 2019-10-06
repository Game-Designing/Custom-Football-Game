package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public final class zzbkz extends zzaac {

    /* renamed from: b */
    private final Context f25482b;

    /* renamed from: c */
    private final zzbai f25483c;

    /* renamed from: d */
    private final zzclc f25484d;

    /* renamed from: e */
    private final zzcjz<zzams, zzclb> f25485e;

    /* renamed from: f */
    private final zzcpf f25486f;

    /* renamed from: g */
    private final zzcgb f25487g;

    /* renamed from: h */
    private boolean f25488h = false;

    zzbkz(Context context, zzbai zzbai, zzclc zzclc, zzcjz<zzams, zzclb> zzcjz, zzcpf zzcpf, zzcgb zzcgb) {
        this.f25482b = context;
        this.f25483c = zzbai;
        this.f25484d = zzclc;
        this.f25485e = zzcjz;
        this.f25486f = zzcpf;
        this.f25487g = zzcgb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        return;
     */
    /* renamed from: E */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo29344E() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f25488h     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.f25482b     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzacu.m24782a(r0)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzawm r0 = com.google.android.gms.ads.internal.zzk.zzlk()     // Catch:{ all -> 0x0046 }
            android.content.Context r1 = r3.f25482b     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzbai r2 = r3.f25483c     // Catch:{ all -> 0x0046 }
            r0.mo30166a(r1, r2)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzvn r0 = com.google.android.gms.ads.internal.zzk.zzlm()     // Catch:{ all -> 0x0046 }
            android.content.Context r1 = r3.f25482b     // Catch:{ all -> 0x0046 }
            r0.mo32316a(r1)     // Catch:{ all -> 0x0046 }
            r0 = 1
            r3.f25488h = r0     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcgb r0 = r3.f25487g     // Catch:{ all -> 0x0046 }
            r0.mo31156f()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24053_b     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.mo29599a(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcpf r0 = r3.f25486f     // Catch:{ all -> 0x0046 }
            r0.mo31222a()     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkz.mo29344E():void");
    }

    /* renamed from: a */
    public final synchronized void mo29346a(float f) {
        zzk.zzll().mo30263a(f);
    }

    /* renamed from: Ra */
    public final synchronized float mo29345Ra() {
        return zzk.zzll().mo30262a();
    }

    /* renamed from: g */
    public final synchronized void mo29354g(boolean z) {
        zzk.zzll().mo30264a(z);
    }

    /* renamed from: ga */
    public final synchronized boolean mo29355ga() {
        return zzk.zzll().mo30265b();
    }

    /* renamed from: g */
    public final synchronized void mo29353g(String str) {
        zzacu.m24782a(this.f25482b);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24054_c)).booleanValue()) {
                zzk.zzlo().zza(this.f25482b, this.f25483c, str, (Runnable) null);
            }
        }
    }

    /* renamed from: a */
    public final void mo29347a(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbad.m26355b("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        if (context == null) {
            zzbad.m26355b("Context is null. Failed to open debug menu.");
            return;
        }
        zzayb zzayb = new zzayb(context);
        zzayb.mo30269a(str);
        zzayb.mo30276d(this.f25483c.f25057a);
        zzayb.mo30266a();
    }

    /* renamed from: a */
    public final void mo29350a(String str, IObjectWrapper iObjectWrapper) {
        String str2;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24068bd)).booleanValue()) {
            str2 = m27198ib();
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            zzacu.m24782a(this.f25482b);
            boolean booleanValue = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24054_c)).booleanValue() | ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24052_a)).booleanValue();
            C8976Lf lf = null;
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24052_a)).booleanValue()) {
                booleanValue = true;
                lf = new C8976Lf(this, (Runnable) ObjectWrapper.m22187H(iObjectWrapper));
            }
            if (booleanValue) {
                zzk.zzlo().zza(this.f25482b, this.f25483c, str, (Runnable) lf);
            }
        }
    }

    /* renamed from: fa */
    public final String mo29352fa() {
        return this.f25483c.f25057a;
    }

    /* renamed from: p */
    public final void mo29356p(String str) {
        this.f25486f.mo31223a(str);
    }

    /* renamed from: a */
    public final void mo29349a(zzamp zzamp) throws RemoteException {
        this.f25484d.mo31202a(zzamp);
    }

    /* renamed from: a */
    public final void mo29348a(zzait zzait) throws RemoteException {
        this.f25487g.mo31147a(zzait);
    }

    /* renamed from: ba */
    public final List<zzaio> mo29351ba() throws RemoteException {
        return this.f25487g.mo31151b();
    }

    /* renamed from: ib */
    private final String m27198ib() {
        Context applicationContext = this.f25482b.getApplicationContext() == null ? this.f25482b : this.f25482b.getApplicationContext();
        try {
            return Wrappers.m22139a(applicationContext).mo27944a(applicationContext.getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
        } catch (NameNotFoundException | NullPointerException e) {
            zzawz.m26002e("Error getting metadata", e);
            return "";
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30726a(Runnable runnable) {
        Preconditions.m21862a("Adapters must be initialized on the main thread.");
        Map e = zzk.zzlk().mo30177i().mo30222k().mo30163e();
        if (e != null && !e.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzbad.m26358c("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.f25484d.mo31203a()) {
                HashMap hashMap = new HashMap();
                IObjectWrapper a = ObjectWrapper.m22188a(this.f25482b);
                for (zzamm zzamm : e.values()) {
                    for (zzaml zzaml : zzamm.f24451a) {
                        String str = zzaml.f24438k;
                        for (String str2 : zzaml.f24430c) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzcjy a2 = this.f25485e.mo31189a(str3, jSONObject);
                        if (a2 != null) {
                            zzams zzams = (zzams) a2.f26729b;
                            if (!zzams.isInitialized()) {
                                if (zzams.mo29853da()) {
                                    zzams.mo29842a(a, (zzatk) (zzclb) a2.f26730c, (List) entry.getValue());
                                    String str4 = "Initialized rewarded video mediation adapter ";
                                    String valueOf = String.valueOf(str3);
                                    zzbad.m26352a(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str3);
                        sb.append("\"");
                        zzbad.m26358c(sb.toString(), th2);
                    }
                }
            }
        }
    }
}
