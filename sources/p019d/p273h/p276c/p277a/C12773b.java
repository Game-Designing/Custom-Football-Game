package p019d.p273h.p276c.p277a;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.a.b */
/* compiled from: ConfigValidationResult */
public class C12773b {

    /* renamed from: a */
    private boolean f39282a = true;

    /* renamed from: b */
    private C12799b f39283b = null;

    /* renamed from: a */
    public void mo41314a(C12799b error) {
        this.f39282a = false;
        this.f39283b = error;
    }

    /* renamed from: b */
    public boolean mo41315b() {
        return this.f39282a;
    }

    /* renamed from: a */
    public C12799b mo41313a() {
        return this.f39283b;
    }

    public String toString() {
        String str = "valid:";
        if (mo41315b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f39282a);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f39282a);
        sb2.append(", IronSourceError:");
        sb2.append(this.f39283b);
        return sb2.toString();
    }
}
