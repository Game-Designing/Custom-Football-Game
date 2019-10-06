package com.flurry.sdk;

import com.flurry.sdk.C7589rc;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.flurry.sdk.Ac */
public abstract class C7353Ac<ReportInfo extends C7589rc> {

    /* renamed from: a */
    private static final String f14364a = C7353Ac.class.getSimpleName();

    /* renamed from: b */
    protected static long f14365b = 10000;

    /* renamed from: c */
    private final int f14366c = MoPubClientPositioning.NO_REPEAT;

    /* renamed from: d */
    private final C7443Qb<List<ReportInfo>> f14367d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<ReportInfo> f14368e = new ArrayList();

    /* renamed from: f */
    public boolean f14369f;

    /* renamed from: g */
    private int f14370g;

    /* renamed from: h */
    protected long f14371h;

    /* renamed from: i */
    public final Runnable f14372i = new C7596sc(this);

    /* renamed from: j */
    public final C7452Sb<C7553lb> f14373j = new C7601tc(this);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C7443Qb<List<ReportInfo>> mo23796a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23797a(ReportInfo reportinfo);

    public C7353Ac() {
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.NetworkStateEvent", this.f14373j);
        this.f14367d = mo23796a();
        this.f14371h = f14365b;
        this.f14370g = -1;
        C7379Fb.m16300a().mo23817b(new C7606uc(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo23798a(List<ReportInfo> list) {
        C7354Ad.m16260a();
        List list2 = (List) this.f14367d.mo23881a();
        if (list2 != null) {
            list.addAll(list2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m16244b() {
        if (!this.f14369f) {
            if (this.f14370g >= 0) {
                C7513ec.m16639a(3, f14364a, "Transmit is in progress");
                return;
            }
            m16245c();
            if (this.f14368e.isEmpty()) {
                this.f14371h = f14365b;
                this.f14370g = -1;
                return;
            }
            this.f14370g = 0;
            C7379Fb.m16300a().mo23817b(new C7613vc(this));
        }
    }

    /* renamed from: c */
    private synchronized void m16245c() {
        Iterator it = this.f14368e.iterator();
        while (it.hasNext()) {
            C7589rc rcVar = (C7589rc) it.next();
            if (rcVar.f15060b) {
                String str = f14364a;
                StringBuilder sb = new StringBuilder("Url transmitted - ");
                sb.append(rcVar.f15062d);
                sb.append(" Attempts: ");
                sb.append(rcVar.f15061c);
                C7513ec.m16639a(3, str, sb.toString());
                it.remove();
            } else if (rcVar.f15061c > rcVar.f15064f) {
                String str2 = f14364a;
                StringBuilder sb2 = new StringBuilder("Exceeded max no of attempts - ");
                sb2.append(rcVar.f15062d);
                sb2.append(" Attempts: ");
                sb2.append(rcVar.f15061c);
                C7513ec.m16639a(3, str2, sb2.toString());
                it.remove();
            } else if (System.currentTimeMillis() > rcVar.f15059a && rcVar.f15061c > 0) {
                String str3 = f14364a;
                StringBuilder sb3 = new StringBuilder("Expired: Time expired - ");
                sb3.append(rcVar.f15062d);
                sb3.append(" Attempts: ");
                sb3.append(rcVar.f15061c);
                C7513ec.m16639a(3, str3, sb3.toString());
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m16247d() {
        C7354Ad.m16260a();
        C7589rc rcVar = null;
        if (C7570ob.m16755a().f14971d) {
            while (true) {
                if (this.f14370g >= this.f14368e.size()) {
                    break;
                }
                List<ReportInfo> list = this.f14368e;
                int i = this.f14370g;
                this.f14370g = i + 1;
                C7589rc rcVar2 = (C7589rc) list.get(i);
                if (!rcVar2.f15060b) {
                    rcVar = rcVar2;
                    break;
                }
            }
        } else {
            C7513ec.m16639a(3, f14364a, "Network is not available, aborting transmission");
        }
        if (rcVar == null) {
            m16248e();
        } else {
            mo23797a((ReportInfo) rcVar);
        }
    }

    /* renamed from: e */
    private synchronized void m16248e() {
        m16245c();
        mo23800b(this.f14368e);
        if (this.f14369f) {
            C7513ec.m16639a(3, f14364a, "Reporter paused");
            this.f14371h = f14365b;
        } else if (this.f14368e.isEmpty()) {
            C7513ec.m16639a(3, f14364a, "All reports sent successfully");
            this.f14371h = f14365b;
        } else {
            this.f14371h <<= 1;
            String str = f14364a;
            StringBuilder sb = new StringBuilder("One or more reports failed to send, backing off: ");
            sb.append(this.f14371h);
            sb.append("ms");
            C7513ec.m16639a(3, str, sb.toString());
            C7379Fb.m16300a().mo23816a(this.f14372i, this.f14371h);
        }
        this.f14370g = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo23800b(List<ReportInfo> list) {
        C7354Ad.m16260a();
        this.f14367d.mo23882a(new ArrayList(list));
    }

    /* renamed from: b */
    public final synchronized void mo23799b(ReportInfo reportinfo) {
        if (reportinfo != null) {
            this.f14368e.add(reportinfo);
            C7379Fb.m16300a().mo23817b(new C7623xc(this));
        }
    }

    /* renamed from: c */
    public final synchronized void mo23801c(ReportInfo reportinfo) {
        reportinfo.f15060b = true;
        C7379Fb.m16300a().mo23817b(new C7628yc(this));
    }

    /* renamed from: d */
    public final synchronized void mo23802d(ReportInfo reportinfo) {
        reportinfo.mo23860a();
        C7379Fb.m16300a().mo23817b(new C7634zc(this));
    }
}
