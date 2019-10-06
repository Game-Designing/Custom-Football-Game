package p019d.p273h.p276c.p281e;

import java.util.ArrayList;
import java.util.Iterator;
import p019d.p273h.p276c.p284h.C12906a;

/* renamed from: d.h.c.e.h */
/* compiled from: InterstitialConfigurations */
public class C12816h {

    /* renamed from: a */
    private ArrayList<C12817i> f39457a = new ArrayList<>();

    /* renamed from: b */
    private C12811c f39458b;

    /* renamed from: c */
    private int f39459c;

    /* renamed from: d */
    private int f39460d;

    /* renamed from: e */
    private String f39461e;

    /* renamed from: f */
    private String f39462f;

    /* renamed from: g */
    private C12906a f39463g;

    /* renamed from: h */
    private C12817i f39464h;

    public C12816h(int adaptersSmartLoadAmount, int adaptersSmartLoadTimeout, C12811c events, C12906a auctionSettings) {
        this.f39459c = adaptersSmartLoadAmount;
        this.f39460d = adaptersSmartLoadTimeout;
        this.f39458b = events;
        this.f39463g = auctionSettings;
    }

    /* renamed from: a */
    public void mo41485a(C12817i placement) {
        if (placement != null) {
            this.f39457a.add(placement);
            if (this.f39464h == null) {
                this.f39464h = placement;
            } else if (placement.mo41495b() == 0) {
                this.f39464h = placement;
            }
        }
    }

    /* renamed from: a */
    public C12817i mo41483a(String placementName) {
        Iterator it = this.f39457a.iterator();
        while (it.hasNext()) {
            C12817i placement = (C12817i) it.next();
            if (placement.mo41496c().equals(placementName)) {
                return placement;
            }
        }
        return null;
    }

    /* renamed from: b */
    public C12817i mo41486b() {
        Iterator it = this.f39457a.iterator();
        while (it.hasNext()) {
            C12817i placement = (C12817i) it.next();
            if (placement.mo41497d()) {
                return placement;
            }
        }
        return this.f39464h;
    }

    /* renamed from: c */
    public int mo41488c() {
        return this.f39459c;
    }

    /* renamed from: d */
    public int mo41490d() {
        return this.f39460d;
    }

    /* renamed from: f */
    public C12811c mo41492f() {
        return this.f39458b;
    }

    /* renamed from: a */
    public String mo41484a() {
        return this.f39461e;
    }

    /* renamed from: b */
    public void mo41487b(String backFillProviderName) {
        this.f39461e = backFillProviderName;
    }

    /* renamed from: g */
    public String mo41493g() {
        return this.f39462f;
    }

    /* renamed from: c */
    public void mo41489c(String premiumProviderName) {
        this.f39462f = premiumProviderName;
    }

    /* renamed from: e */
    public C12906a mo41491e() {
        return this.f39463g;
    }
}
