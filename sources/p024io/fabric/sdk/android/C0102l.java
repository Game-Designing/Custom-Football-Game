package p024io.fabric.sdk.android;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.services.concurrency.C0104j;
import p024io.fabric.sdk.android.services.concurrency.C13960s;

/* renamed from: io.fabric.sdk.android.l */
/* compiled from: Kit */
public abstract class C0102l<Result> implements Comparable<C0102l> {

    /* renamed from: a */
    C13920f f143a;

    /* renamed from: b */
    C13927k<Result> f144b = new C13927k<>(this);

    /* renamed from: c */
    Context f145c;

    /* renamed from: d */
    C13925j<Result> f146d;

    /* renamed from: e */
    C13868y f147e;

    /* renamed from: f */
    final C0104j f148f = ((C0104j) getClass().getAnnotation(C0104j.class));

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract Result mo2534g();

    /* renamed from: u */
    public abstract String mo2535u();

    /* renamed from: w */
    public abstract String mo2536w();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3302a(Context context, C13920f fabric, C13925j<Result> callback, C13868y idManager) {
        this.f143a = fabric;
        this.f145c = new C13922g(context, mo2535u(), mo3311v());
        this.f146d = callback;
        this.f147e = idManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public final void mo3313y() {
        this.f144b.mo43406a(this.f143a.mo43338b(), null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public boolean mo3314z() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3304b(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3303a(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public C13868y mo3310t() {
        return this.f147e;
    }

    /* renamed from: i */
    public Context mo3307i() {
        return this.f145c;
    }

    /* renamed from: s */
    public C13920f mo3309s() {
        return this.f143a;
    }

    /* renamed from: v */
    public String mo3311v() {
        StringBuilder sb = new StringBuilder();
        sb.append(".Fabric");
        sb.append(File.separator);
        sb.append(mo2535u());
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(C0102l another) {
        if (mo3305b(another)) {
            return 1;
        }
        if (another.mo3305b(this)) {
            return -1;
        }
        if (mo3312x() && !another.mo3312x()) {
            return 1;
        }
        if (mo3312x() || !another.mo3312x()) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo3305b(C0102l target) {
        if (mo3312x()) {
            for (Class<?> dep : this.f148f.value()) {
                if (dep.isAssignableFrom(target.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public boolean mo3312x() {
        return this.f148f != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Collection<C13960s> mo3308j() {
        return this.f144b.mo43383c();
    }
}
