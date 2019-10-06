package p019d.p143b.p144a.p147c;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: d.b.a.c.hb */
class C7164hb {

    /* renamed from: a */
    private int f13587a;

    /* renamed from: b */
    private final Queue<C7231ya> f13588b = new LinkedList();

    /* renamed from: c */
    private final Object f13589c = new Object();

    C7164hb(int i) {
        mo23162a(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo23161a() {
        int size;
        synchronized (this.f13589c) {
            size = this.f13588b.size();
        }
        return size;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23162a(int i) {
        if (i > 25) {
            i = 25;
        }
        this.f13587a = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23163a(C7231ya yaVar) {
        synchronized (this.f13589c) {
            if (mo23161a() <= 25) {
                this.f13588b.offer(yaVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo23164b() {
        return this.f13587a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo23165c() {
        boolean z;
        synchronized (this.f13589c) {
            z = mo23161a() >= this.f13587a;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo23166d() {
        boolean z;
        synchronized (this.f13589c) {
            z = mo23161a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C7231ya mo23167e() {
        C7231ya yaVar;
        try {
            synchronized (this.f13589c) {
                yaVar = !mo23166d() ? (C7231ya) this.f13588b.poll() : null;
            }
            return yaVar;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C7231ya mo23168f() {
        C7231ya yaVar;
        synchronized (this.f13589c) {
            yaVar = (C7231ya) this.f13588b.peek();
        }
        return yaVar;
    }
}
