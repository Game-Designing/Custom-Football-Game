package com.inmobi.ads;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.inmobi.ads.C10478c.C10490l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.ads.y */
/* compiled from: ImpressionTracker */
class C10608y {

    /* renamed from: b */
    private static final String f32311b = C10608y.class.getSimpleName();
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public final Map<View, C10611b> f32312a;

    /* renamed from: c */
    private final C10523ce f32313c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<View, C10611b> f32314d;

    /* renamed from: e */
    private final Handler f32315e;

    /* renamed from: f */
    private final C10612c f32316f;

    /* renamed from: g */
    private final long f32317g;

    /* renamed from: h */
    private C10526c f32318h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C10610a f32319i;

    /* renamed from: com.inmobi.ads.y$a */
    /* compiled from: ImpressionTracker */
    interface C10610a {
        /* renamed from: a */
        void mo34076a(View view, Object obj);
    }

    /* renamed from: com.inmobi.ads.y$b */
    /* compiled from: ImpressionTracker */
    private static class C10611b {

        /* renamed from: a */
        Object f32321a;

        /* renamed from: b */
        int f32322b;

        /* renamed from: c */
        int f32323c;

        /* renamed from: d */
        long f32324d = Long.MAX_VALUE;

        C10611b(Object obj, int i, int i2) {
            this.f32321a = obj;
            this.f32322b = i;
            this.f32323c = i2;
        }
    }

    /* renamed from: com.inmobi.ads.y$c */
    /* compiled from: ImpressionTracker */
    static class C10612c implements Runnable {

        /* renamed from: a */
        private final ArrayList<View> f32325a = new ArrayList<>();

        /* renamed from: b */
        private WeakReference<C10608y> f32326b;

        C10612c(C10608y yVar) {
            this.f32326b = new WeakReference<>(yVar);
        }

        public final void run() {
            C10608y yVar = (C10608y) this.f32326b.get();
            if (yVar != null) {
                for (Entry entry : yVar.f32314d.entrySet()) {
                    View view = (View) entry.getKey();
                    C10611b bVar = (C10611b) entry.getValue();
                    if (C10608y.m34804a(bVar.f32324d, bVar.f32323c) && this.f32326b.get() != null) {
                        yVar.f32319i.mo34076a(view, bVar.f32321a);
                        this.f32325a.add(view);
                    }
                }
                Iterator it = this.f32325a.iterator();
                while (it.hasNext()) {
                    yVar.m34802a((View) it.next());
                }
                this.f32325a.clear();
                if (!yVar.f32314d.isEmpty()) {
                    yVar.m34808d();
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m34804a(long j, int i) {
        return SystemClock.uptimeMillis() - j >= ((long) i);
    }

    C10608y(C10490l lVar, C10523ce ceVar, C10610a aVar) {
        this(new WeakHashMap(), new WeakHashMap(), ceVar, new Handler(), lVar, aVar);
    }

    private C10608y(Map<View, C10611b> map, Map<View, C10611b> map2, C10523ce ceVar, Handler handler, C10490l lVar, C10610a aVar) {
        this.f32312a = map;
        this.f32314d = map2;
        this.f32313c = ceVar;
        this.f32317g = (long) lVar.f31967d;
        this.f32318h = new C10526c() {
            /* renamed from: a */
            public final void mo34078a(List<View> list, List<View> list2) {
                for (View view : list) {
                    C10611b bVar = (C10611b) C10608y.this.f32312a.get(view);
                    if (bVar == null) {
                        C10608y.this.m34802a(view);
                    } else {
                        C10611b bVar2 = (C10611b) C10608y.this.f32314d.get(view);
                        if (bVar2 == null || !bVar.f32321a.equals(bVar2.f32321a)) {
                            bVar.f32324d = SystemClock.uptimeMillis();
                            C10608y.this.f32314d.put(view, bVar);
                        }
                    }
                }
                for (View remove : list2) {
                    C10608y.this.f32314d.remove(remove);
                }
                C10608y.this.m34808d();
            }
        };
        this.f32313c.f32090c = this.f32318h;
        this.f32315e = handler;
        this.f32316f = new C10612c(this);
        this.f32319i = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34413a(View view, Object obj, int i, int i2) {
        C10611b bVar = (C10611b) this.f32312a.get(view);
        if (bVar == null || !bVar.f32321a.equals(obj)) {
            m34802a(view);
            C10611b bVar2 = new C10611b(obj, i, i2);
            this.f32312a.put(view, bVar2);
            this.f32313c.mo34246a(view, obj, bVar2.f32322b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34802a(View view) {
        this.f32312a.remove(view);
        this.f32314d.remove(view);
        this.f32313c.mo34245a(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final View mo34411a(Object obj) {
        View view;
        Iterator it = this.f32312a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            Entry entry = (Entry) it.next();
            if (((C10611b) entry.getValue()).f32321a.equals(obj)) {
                view = (View) entry.getKey();
                break;
            }
        }
        if (view != null) {
            m34802a(view);
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34412a() {
        this.f32313c.mo34250f();
        this.f32315e.removeCallbacksAndMessages(null);
        this.f32314d.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo34414b() {
        for (Entry entry : this.f32312a.entrySet()) {
            this.f32313c.mo34246a((View) entry.getKey(), ((C10611b) entry.getValue()).f32321a, ((C10611b) entry.getValue()).f32322b);
        }
        m34808d();
        this.f32313c.mo34248d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo34415c() {
        this.f32312a.clear();
        this.f32314d.clear();
        this.f32313c.mo34250f();
        this.f32315e.removeMessages(0);
        this.f32313c.mo34249e();
        this.f32318h = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34808d() {
        if (!this.f32315e.hasMessages(0)) {
            this.f32315e.postDelayed(this.f32316f, this.f32317g);
        }
    }
}
