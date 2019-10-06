package p019d.p273h.p276c.p281e;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: d.h.c.e.e */
/* compiled from: BannerConfigurations */
public class C12813e {

    /* renamed from: a */
    private C12811c f39446a;

    /* renamed from: b */
    private int f39447b;

    /* renamed from: c */
    private long f39448c;

    /* renamed from: d */
    private ArrayList<C12814f> f39449d = new ArrayList<>();

    /* renamed from: e */
    private C12814f f39450e;

    /* renamed from: f */
    private int f39451f;

    public C12813e(int adaptersSmartLoadAmount, long adaptersSmartLoadTimeoutInMillis, C12811c events, int refreshInterval) {
        this.f39447b = adaptersSmartLoadAmount;
        this.f39448c = adaptersSmartLoadTimeoutInMillis;
        this.f39446a = events;
        this.f39451f = refreshInterval;
    }

    /* renamed from: a */
    public long mo41472a() {
        return this.f39448c;
    }

    /* renamed from: b */
    public C12811c mo41475b() {
        return this.f39446a;
    }

    /* renamed from: a */
    public void mo41474a(C12814f placement) {
        if (placement != null) {
            this.f39449d.add(placement);
            if (this.f39450e == null) {
                this.f39450e = placement;
            } else if (placement.mo41495b() == 0) {
                this.f39450e = placement;
            }
        }
    }

    /* renamed from: a */
    public C12814f mo41473a(String placementName) {
        Iterator it = this.f39449d.iterator();
        while (it.hasNext()) {
            C12814f placement = (C12814f) it.next();
            if (placement.mo41496c().equals(placementName)) {
                return placement;
            }
        }
        return null;
    }

    /* renamed from: d */
    public C12814f mo41477d() {
        Iterator it = this.f39449d.iterator();
        while (it.hasNext()) {
            C12814f placement = (C12814f) it.next();
            if (placement.mo41497d()) {
                return placement;
            }
        }
        return this.f39450e;
    }

    /* renamed from: c */
    public int mo41476c() {
        return this.f39451f;
    }
}
