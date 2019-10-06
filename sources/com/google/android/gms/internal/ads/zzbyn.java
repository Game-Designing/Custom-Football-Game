package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbyn extends zzbpc {

    /* renamed from: f */
    private final Executor f26085f;

    /* renamed from: g */
    private final zzbyt f26086g;

    /* renamed from: h */
    private final zzbzb f26087h;

    /* renamed from: i */
    private final zzbzl f26088i;

    /* renamed from: j */
    private final zzbyx f26089j;

    /* renamed from: k */
    private final zzbzc f26090k;

    /* renamed from: l */
    private final zzdte<zzccb> f26091l;

    /* renamed from: m */
    private final zzdte<zzcbz> f26092m;

    /* renamed from: n */
    private final zzdte<zzccg> f26093n;

    /* renamed from: o */
    private final zzdte<zzcbw> f26094o;

    /* renamed from: p */
    private final zzdte<zzccd> f26095p;

    /* renamed from: q */
    private zzcab f26096q;

    /* renamed from: r */
    private boolean f26097r;

    /* renamed from: s */
    private final zzavf f26098s;

    /* renamed from: t */
    private final zzdh f26099t;

    /* renamed from: u */
    private final zzbai f26100u;

    /* renamed from: v */
    private final Context f26101v;

    public zzbyn(Executor executor, zzbyt zzbyt, zzbzb zzbzb, zzbzl zzbzl, zzbyx zzbyx, zzbzc zzbzc, zzdte<zzccb> zzdte, zzdte<zzcbz> zzdte2, zzdte<zzccg> zzdte3, zzdte<zzcbw> zzdte4, zzdte<zzccd> zzdte5, zzavf zzavf, zzdh zzdh, zzbai zzbai, Context context) {
        this.f26085f = executor;
        this.f26086g = zzbyt;
        this.f26087h = zzbzb;
        this.f26088i = zzbzl;
        this.f26089j = zzbyx;
        this.f26090k = zzbzc;
        this.f26091l = zzdte;
        this.f26092m = zzdte2;
        this.f26093n = zzdte3;
        this.f26094o = zzdte4;
        this.f26095p = zzdte5;
        this.f26098s = zzavf;
        this.f26099t = zzdh;
        this.f26100u = zzbai;
        this.f26101v = context;
    }

    /* renamed from: c */
    public final void mo28633c() {
        this.f26085f.execute(new C9602nh(this));
        if (this.f26086g.mo31016n() != 7) {
            Executor executor = this.f26085f;
            zzbzb zzbzb = this.f26087h;
            zzbzb.getClass();
            executor.execute(C9624oh.m23995a(zzbzb));
        }
        super.mo28633c();
    }

    /* renamed from: a */
    public final synchronized void mo30972a(String str) {
        this.f26087h.mo30952a(str);
    }

    /* renamed from: h */
    public final synchronized void mo30980h() {
        if (!this.f26097r) {
            this.f26087h.mo30954b();
        }
    }

    /* renamed from: a */
    public final synchronized void mo30963a(Bundle bundle) {
        this.f26087h.mo30957c(bundle);
    }

    /* renamed from: c */
    public final synchronized boolean mo30977c(Bundle bundle) {
        if (this.f26097r) {
            return true;
        }
        boolean a = this.f26087h.mo30953a(bundle);
        this.f26097r = a;
        return a;
    }

    /* renamed from: b */
    public final synchronized void mo30974b(Bundle bundle) {
        this.f26087h.mo30955b(bundle);
    }

    /* renamed from: a */
    public final synchronized void mo30853a() {
        this.f26085f.execute(new C9646ph(this));
        super.mo30853a();
    }

    /* renamed from: a */
    public final synchronized void mo30971a(zzcab zzcab) {
        this.f26096q = zzcab;
        this.f26088i.mo31068a(zzcab);
        this.f26087h.mo30947a(zzcab.mo31050a(), zzcab.mo31055d(), zzcab.mo31057f(), (OnTouchListener) zzcab, (OnClickListener) zzcab);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24127lc)).booleanValue()) {
            zzdc a = this.f26099t.mo31483a();
            if (a != null) {
                a.zzb(zzcab.mo31050a());
            }
        }
        if (zzcab.mo31054c() != null) {
            zzcab.mo31054c().mo32250a((zzue) this.f26098s);
        }
    }

    /* renamed from: b */
    public final synchronized void mo30975b(zzcab zzcab) {
        this.f26087h.mo30945a(zzcab.mo31050a(), zzcab.mo31056e());
        if (zzcab.mo31053b() != null) {
            zzcab.mo31053b().setClickable(false);
            zzcab.mo31053b().removeAllViews();
        }
        if (zzcab.mo31054c() != null) {
            zzcab.mo31054c().mo32251b((zzue) this.f26098s);
        }
        this.f26096q = null;
    }

    /* renamed from: a */
    public final synchronized void mo30966a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24015Te)).booleanValue()) {
            this.f26088i.mo31071b(this.f26096q);
        }
        this.f26087h.mo30944a(view, view2, map, map2, z);
    }

    /* renamed from: a */
    public final synchronized void mo30965a(View view, MotionEvent motionEvent, View view2) {
        this.f26087h.mo30943a(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo30967a(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f26097r     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x0013
            com.google.android.gms.internal.ads.zzbzb r6 = r2.f26087h     // Catch:{ all -> 0x005d }
            r6.mo30946a(r3, r4, r5)     // Catch:{ all -> 0x005d }
            r2.f26097r = r0     // Catch:{ all -> 0x005d }
            monitor-exit(r2)
            return
        L_0x0013:
            if (r6 != 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzacu.f23995Qc     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x005d }
            java.lang.Object r6 = r1.mo29599a(r6)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x005d }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x005d }
            if (r6 == 0) goto L_0x005b
            if (r4 == 0) goto L_0x005b
            java.util.Set r6 = r4.entrySet()     // Catch:{ all -> 0x005d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x005d }
        L_0x0031:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x005d }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x005d }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x005d }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x005d }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005d }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x005a
            boolean r1 = m27957b(r1)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzbzb r6 = r2.f26087h     // Catch:{ all -> 0x005d }
            r6.mo30946a(r3, r4, r5)     // Catch:{ all -> 0x005d }
            r2.f26097r = r0     // Catch:{ all -> 0x005d }
            monitor-exit(r2)
            return
        L_0x005a:
            goto L_0x0031
        L_0x005b:
            monitor-exit(r2)
            return
        L_0x005d:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0061
        L_0x0060:
            throw r3
        L_0x0061:
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyn.mo30967a(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    /* renamed from: a */
    public final synchronized void mo30964a(View view) {
        this.f26087h.mo30942a(view);
    }

    /* renamed from: a */
    public final synchronized void mo30970a(zzagd zzagd) {
        this.f26087h.mo30951a(zzagd);
    }

    /* renamed from: f */
    public final synchronized void mo30978f() {
        this.f26087h.mo30959r();
    }

    /* renamed from: a */
    public final synchronized void mo30969a(zzaak zzaak) {
        this.f26087h.mo30950a(zzaak);
    }

    /* renamed from: a */
    public final synchronized void mo30968a(zzaag zzaag) {
        this.f26087h.mo30949a(zzaag);
    }

    /* renamed from: l */
    public final synchronized void mo30984l() {
        this.f26087h.mo30960y();
    }

    /* renamed from: g */
    public final synchronized void mo30979g() {
        if (this.f26096q == null) {
            zzbad.m26352a("Ad should be associated with an ad view before calling recordCustomClickGesture()");
            return;
        }
        this.f26085f.execute(new C9667qh(this, this.f26096q instanceof zzbzi));
    }

    /* renamed from: b */
    public static boolean m27957b(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    /* renamed from: i */
    public final boolean mo30981i() {
        return this.f26089j.mo31030b();
    }

    /* renamed from: b */
    private final void m27956b(String str) {
        String str2;
        if (this.f26089j.mo31032d()) {
            zzbgz s = this.f26086g.mo31021s();
            zzbgz r = this.f26086g.mo31020r();
            if (s != null || r != null) {
                boolean z = true;
                boolean z2 = s != null;
                if (r == null) {
                    z = false;
                }
                if (z2) {
                    str2 = null;
                } else if (z) {
                    s = r;
                    str2 = "javascript";
                } else {
                    s = null;
                    str2 = null;
                }
                if (s.getWebView() != null && zzk.zzlv().mo30001b(this.f26101v)) {
                    zzbai zzbai = this.f26100u;
                    int i = zzbai.f25058b;
                    int i2 = zzbai.f25059c;
                    StringBuilder sb = new StringBuilder(23);
                    sb.append(i);
                    sb.append(".");
                    sb.append(i2);
                    IObjectWrapper a = zzk.zzlv().mo29996a(sb.toString(), s.getWebView(), "", "javascript", str2, str);
                    if (a != null) {
                        this.f26086g.mo30991a(a);
                        s.mo28719a(a);
                        if (z) {
                            View view = r.getView();
                            if (view != null) {
                                zzk.zzlv().mo29999a(a, view);
                            }
                        }
                        zzk.zzlv().mo29998a(a);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo30976c(View view) {
        IObjectWrapper t = this.f26086g.mo31022t();
        boolean z = this.f26086g.mo31021s() != null;
        if (this.f26089j.mo31032d() && t != null && z && view != null) {
            zzk.zzlv().mo29999a(t, view);
        }
    }

    /* renamed from: m */
    public final zzaee mo30985m() {
        return new zzbym(this.f26086g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30973a(boolean z) {
        this.f26087h.mo30948a(this.f26096q.mo31050a(), this.f26096q.mo31056e(), this.f26096q.mo31055d(), z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final /* synthetic */ void mo30982j() {
        this.f26087h.destroy();
        this.f26086g.mo30987a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final /* synthetic */ void mo30983k() {
        try {
            int n = this.f26086g.mo31016n();
            String str = "Google";
            if (n == 1) {
                if (this.f26090k.mo31033a() != null) {
                    m27956b(str);
                    this.f26090k.mo31033a().mo29698a((zzafa) this.f26091l.get());
                }
            } else if (n == 2) {
                if (this.f26090k.mo31035b() != null) {
                    m27956b(str);
                    this.f26090k.mo31035b().mo29697a((zzaew) this.f26092m.get());
                }
            } else if (n == 3) {
                if (this.f26090k.mo31034a(this.f26086g.mo31007e()) != null) {
                    this.f26090k.mo31034a(this.f26086g.mo31007e()).mo29700a((zzafe) this.f26095p.get());
                }
            } else if (n == 6) {
                if (this.f26090k.mo31037c() != null) {
                    m27956b(str);
                    this.f26090k.mo31037c().mo29702a((zzagg) this.f26093n.get());
                }
            } else if (n != 7) {
                zzbad.m26355b("Wrong native template id!");
            } else {
                if (this.f26090k.mo31039e() != null) {
                    this.f26090k.mo31039e().mo29769a((zzaja) this.f26094o.get());
                }
            }
        } catch (RemoteException e) {
            zzbad.m26356b("RemoteException when notifyAdLoad is called", e);
        }
    }
}
