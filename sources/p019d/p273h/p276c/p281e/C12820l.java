package p019d.p273h.p276c.p281e;

/* renamed from: d.h.c.e.l */
/* compiled from: Placement */
public class C12820l {

    /* renamed from: a */
    private int f39474a;

    /* renamed from: b */
    private String f39475b;

    /* renamed from: c */
    private boolean f39476c;

    /* renamed from: d */
    private String f39477d;

    /* renamed from: e */
    private int f39478e;

    /* renamed from: f */
    private C12822n f39479f;

    public C12820l(int placementId, String placementName, boolean isDefault, String rewardName, int rewardAmount, C12822n placementAvailabilitySettings) {
        this.f39474a = placementId;
        this.f39475b = placementName;
        this.f39476c = isDefault;
        this.f39477d = rewardName;
        this.f39478e = rewardAmount;
        this.f39479f = placementAvailabilitySettings;
    }

    /* renamed from: b */
    public int mo41503b() {
        return this.f39474a;
    }

    /* renamed from: c */
    public String mo41504c() {
        return this.f39475b;
    }

    /* renamed from: f */
    public boolean mo41507f() {
        return this.f39476c;
    }

    /* renamed from: e */
    public String mo41506e() {
        return this.f39477d;
    }

    /* renamed from: d */
    public int mo41505d() {
        return this.f39478e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("placement name: ");
        sb.append(this.f39475b);
        sb.append(", reward name: ");
        sb.append(this.f39477d);
        sb.append(" , amount:");
        sb.append(this.f39478e);
        return sb.toString();
    }

    /* renamed from: a */
    public C12822n mo41502a() {
        return this.f39479f;
    }
}
