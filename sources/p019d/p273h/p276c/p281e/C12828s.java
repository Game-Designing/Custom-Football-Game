package p019d.p273h.p276c.p281e;

import java.util.ArrayList;
import java.util.Iterator;
import p019d.p273h.p276c.p284h.C12906a;

/* renamed from: d.h.c.e.s */
/* compiled from: RewardedVideoConfigurations */
public class C12828s {

    /* renamed from: a */
    private ArrayList<C12820l> f39518a = new ArrayList<>();

    /* renamed from: b */
    private C12811c f39519b;

    /* renamed from: c */
    private int f39520c;

    /* renamed from: d */
    private int f39521d;

    /* renamed from: e */
    private String f39522e;

    /* renamed from: f */
    private String f39523f;

    /* renamed from: g */
    private int f39524g;

    /* renamed from: h */
    private C12820l f39525h;

    /* renamed from: i */
    private C12906a f39526i;

    public C12828s(int adaptersSmartLoadAmount, int adaptersSmartLoadTimeout, int manualLoadIntervalInSeconds, C12811c events, C12906a auctionSettings) {
        this.f39520c = adaptersSmartLoadAmount;
        this.f39521d = adaptersSmartLoadTimeout;
        this.f39524g = manualLoadIntervalInSeconds;
        this.f39519b = events;
        this.f39526i = auctionSettings;
    }

    /* renamed from: f */
    public int mo41570f() {
        return this.f39521d;
    }

    /* renamed from: a */
    public void mo41563a(C12820l placement) {
        if (placement != null) {
            this.f39518a.add(placement);
            if (this.f39525h == null) {
                this.f39525h = placement;
            } else if (placement.mo41503b() == 0) {
                this.f39525h = placement;
            }
        }
    }

    /* renamed from: a */
    public C12820l mo41561a(String placementName) {
        Iterator it = this.f39518a.iterator();
        while (it.hasNext()) {
            C12820l placement = (C12820l) it.next();
            if (placement.mo41504c().equals(placementName)) {
                return placement;
            }
        }
        return null;
    }

    /* renamed from: b */
    public C12820l mo41564b() {
        Iterator it = this.f39518a.iterator();
        while (it.hasNext()) {
            C12820l placement = (C12820l) it.next();
            if (placement.mo41507f()) {
                return placement;
            }
        }
        return this.f39525h;
    }

    /* renamed from: e */
    public int mo41569e() {
        return this.f39520c;
    }

    /* renamed from: c */
    public int mo41566c() {
        return this.f39524g;
    }

    /* renamed from: h */
    public C12811c mo41572h() {
        return this.f39519b;
    }

    /* renamed from: a */
    public String mo41562a() {
        return this.f39522e;
    }

    /* renamed from: b */
    public void mo41565b(String backFillProviderName) {
        this.f39522e = backFillProviderName;
    }

    /* renamed from: d */
    public String mo41568d() {
        return this.f39523f;
    }

    /* renamed from: c */
    public void mo41567c(String premiumProviderName) {
        this.f39523f = premiumProviderName;
    }

    /* renamed from: g */
    public C12906a mo41571g() {
        return this.f39526i;
    }
}
