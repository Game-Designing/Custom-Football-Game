package p019d.p143b.p144a.p147c;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7255e;

/* renamed from: d.b.a.c.kc */
public class C7177kc {

    /* renamed from: a */
    private static final Handler f13607a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private WeakReference<C7253c> f13608b = new WeakReference<>(null);

    /* renamed from: c */
    private WeakReference<C7252b> f13609c = new WeakReference<>(null);

    /* renamed from: d */
    private WeakReference<C7255e> f13610d = new WeakReference<>(null);

    /* renamed from: e */
    private C7253c f13611e;

    /* renamed from: f */
    private C7252b f13612f;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23193a(C7251a aVar) {
        C7253c cVar = (C7253c) this.f13608b.get();
        if (cVar != null) {
            f13607a.post(new C7233yc(this, cVar, aVar));
        }
        C7253c cVar2 = this.f13611e;
        if (cVar2 != null) {
            cVar2.adHidden(aVar);
        }
    }

    /* renamed from: a */
    public void mo23194a(C7252b bVar) {
        this.f13609c = new WeakReference<>(bVar);
    }

    /* renamed from: a */
    public void mo23195a(C7253c cVar) {
        this.f13608b = new WeakReference<>(cVar);
    }

    /* renamed from: a */
    public void mo23196a(C7255e eVar) {
        this.f13610d = new WeakReference<>(eVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23197b(C7252b bVar) {
        this.f13612f = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23198b(C7253c cVar) {
        this.f13611e = cVar;
    }
}
