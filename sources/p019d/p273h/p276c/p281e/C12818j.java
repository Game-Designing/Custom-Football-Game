package p019d.p273h.p276c.p281e;

import java.util.ArrayList;

/* renamed from: d.h.c.e.j */
/* compiled from: OfferwallConfigurations */
public class C12818j {

    /* renamed from: a */
    private ArrayList<C12819k> f39469a = new ArrayList<>();

    /* renamed from: b */
    private C12819k f39470b;

    /* renamed from: a */
    public void mo41499a(C12819k placement) {
        if (placement != null) {
            this.f39469a.add(placement);
            if (this.f39470b == null) {
                this.f39470b = placement;
            } else if (placement.mo41500a() == 0) {
                this.f39470b = placement;
            }
        }
    }
}
