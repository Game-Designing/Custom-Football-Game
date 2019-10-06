package android.support.constraint.p034a.p035a;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: android.support.constraint.a.a.r */
/* compiled from: ResolutionNode */
public class C0191r {

    /* renamed from: a */
    HashSet<C0191r> f518a = new HashSet<>(2);

    /* renamed from: b */
    int f519b = 0;

    /* renamed from: a */
    public void mo3973a(C0191r node) {
        this.f518a.add(node);
    }

    /* renamed from: d */
    public void mo3965d() {
        this.f519b = 0;
        this.f518a.clear();
    }

    /* renamed from: b */
    public void mo3974b() {
        this.f519b = 0;
        Iterator it = this.f518a.iterator();
        while (it.hasNext()) {
            ((C0191r) it.next()).mo3974b();
        }
    }

    /* renamed from: a */
    public void mo3972a() {
        this.f519b = 1;
        Iterator it = this.f518a.iterator();
        while (it.hasNext()) {
            ((C0191r) it.next()).mo3966e();
        }
    }

    /* renamed from: c */
    public boolean mo3975c() {
        return this.f519b == 1;
    }

    /* renamed from: e */
    public void mo3966e() {
    }
}
