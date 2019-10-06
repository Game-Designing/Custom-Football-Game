package p019d.p273h.p276c.p281e;

/* renamed from: d.h.c.e.i */
/* compiled from: InterstitialPlacement */
public class C12817i {

    /* renamed from: a */
    private int f39465a;

    /* renamed from: b */
    private String f39466b;

    /* renamed from: c */
    private boolean f39467c;

    /* renamed from: d */
    private C12822n f39468d;

    public C12817i(int placementId, String placementName, boolean isDefault, C12822n placementAvailabilitySettings) {
        this.f39465a = placementId;
        this.f39466b = placementName;
        this.f39467c = isDefault;
        this.f39468d = placementAvailabilitySettings;
    }

    /* renamed from: b */
    public int mo41495b() {
        return this.f39465a;
    }

    /* renamed from: c */
    public String mo41496c() {
        return this.f39466b;
    }

    /* renamed from: d */
    public boolean mo41497d() {
        return this.f39467c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("placement name: ");
        sb.append(this.f39466b);
        return sb.toString();
    }

    /* renamed from: a */
    public C12822n mo41494a() {
        return this.f39468d;
    }
}
