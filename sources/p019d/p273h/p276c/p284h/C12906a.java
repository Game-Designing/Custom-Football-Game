package p019d.p273h.p276c.p284h;

/* renamed from: d.h.c.h.a */
/* compiled from: AuctionSettings */
public class C12906a {

    /* renamed from: a */
    private boolean f39625a;

    /* renamed from: b */
    private String f39626b;

    /* renamed from: c */
    private String f39627c;

    /* renamed from: d */
    private long f39628d;

    /* renamed from: e */
    private long f39629e;

    /* renamed from: f */
    private long f39630f;

    /* renamed from: g */
    private boolean f39631g;

    C12906a() {
        String str = "";
        this.f39626b = str;
        this.f39627c = str;
        this.f39625a = false;
        this.f39628d = 0;
        this.f39629e = 0;
        this.f39630f = 0;
        this.f39631g = true;
    }

    C12906a(String blob, String url, boolean isProgrammatic, long minTimeToWaitBeforeFirstAuction, long auctionRetryInterval, long timeToWaitBeforeAuction, boolean isAuctionOnShowStart) {
        this.f39626b = blob;
        this.f39627c = url;
        this.f39625a = isProgrammatic;
        this.f39628d = minTimeToWaitBeforeFirstAuction;
        this.f39629e = auctionRetryInterval;
        this.f39630f = timeToWaitBeforeAuction;
        this.f39631g = isAuctionOnShowStart;
    }

    /* renamed from: d */
    public boolean mo41680d() {
        return this.f39625a;
    }

    /* renamed from: b */
    public String mo41678b() {
        return this.f39626b;
    }

    /* renamed from: g */
    public String mo41683g() {
        return this.f39627c;
    }

    /* renamed from: f */
    public long mo41682f() {
        return this.f39628d;
    }

    /* renamed from: a */
    public long mo41677a() {
        return this.f39629e;
    }

    /* renamed from: e */
    public long mo41681e() {
        return this.f39630f;
    }

    /* renamed from: c */
    public boolean mo41679c() {
        return this.f39631g;
    }
}
