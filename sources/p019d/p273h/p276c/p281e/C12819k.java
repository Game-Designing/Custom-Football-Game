package p019d.p273h.p276c.p281e;

/* renamed from: d.h.c.e.k */
/* compiled from: OfferwallPlacement */
public class C12819k {

    /* renamed from: a */
    private int f39471a;

    /* renamed from: b */
    private String f39472b;

    /* renamed from: c */
    private boolean f39473c;

    public C12819k(int placementId, String placementName, boolean isDefault) {
        this.f39471a = placementId;
        this.f39472b = placementName;
        this.f39473c = isDefault;
    }

    /* renamed from: a */
    public int mo41500a() {
        return this.f39471a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("placement name: ");
        sb.append(this.f39472b);
        sb.append(", placement id: ");
        sb.append(this.f39471a);
        return sb.toString();
    }
}
