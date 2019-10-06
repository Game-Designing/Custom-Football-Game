package p002b.p003c.p062h.p071g;

import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0590K;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: b.c.h.g.i */
/* compiled from: ViewPropertyAnimatorCompatSet */
public class C1311i {

    /* renamed from: a */
    final ArrayList<C0587I> f4188a = new ArrayList<>();

    /* renamed from: b */
    private long f4189b = -1;

    /* renamed from: c */
    private Interpolator f4190c;

    /* renamed from: d */
    C0589J f4191d;

    /* renamed from: e */
    private boolean f4192e;

    /* renamed from: f */
    private final C0590K f4193f = new C1310h(this);

    /* renamed from: a */
    public C1311i mo9268a(C0587I animator) {
        if (!this.f4192e) {
            this.f4188a.add(animator);
        }
        return this;
    }

    /* renamed from: a */
    public C1311i mo9269a(C0587I anim1, C0587I anim2) {
        this.f4188a.add(anim1);
        anim2.mo5478b(anim1.mo5476b());
        this.f4188a.add(anim2);
        return this;
    }

    /* renamed from: c */
    public void mo9274c() {
        if (!this.f4192e) {
            Iterator it = this.f4188a.iterator();
            while (it.hasNext()) {
                C0587I animator = (C0587I) it.next();
                long j = this.f4189b;
                if (j >= 0) {
                    animator.mo5471a(j);
                }
                Interpolator interpolator = this.f4190c;
                if (interpolator != null) {
                    animator.mo5474a(interpolator);
                }
                if (this.f4191d != null) {
                    animator.mo5472a((C0589J) this.f4193f);
                }
                animator.mo5479c();
            }
            this.f4192e = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo9273b() {
        this.f4192e = false;
    }

    /* renamed from: a */
    public void mo9272a() {
        if (this.f4192e) {
            Iterator it = this.f4188a.iterator();
            while (it.hasNext()) {
                ((C0587I) it.next()).mo5475a();
            }
            this.f4192e = false;
        }
    }

    /* renamed from: a */
    public C1311i mo9267a(long duration) {
        if (!this.f4192e) {
            this.f4189b = duration;
        }
        return this;
    }

    /* renamed from: a */
    public C1311i mo9271a(Interpolator interpolator) {
        if (!this.f4192e) {
            this.f4190c = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public C1311i mo9270a(C0589J listener) {
        if (!this.f4192e) {
            this.f4191d = listener;
        }
        return this;
    }
}
