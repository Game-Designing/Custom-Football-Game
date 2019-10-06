package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.ads.ce */
/* compiled from: VisibilityTracker */
abstract class C10523ce {

    /* renamed from: d */
    private static final String f32087d = C10523ce.class.getSimpleName();

    /* renamed from: a */
    boolean f32088a;
    /* access modifiers changed from: 0000 */

    /* renamed from: b */
    public final Map<View, C10527d> f32089b;
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public C10526c f32090c;

    /* renamed from: e */
    private final ArrayList<View> f32091e;

    /* renamed from: f */
    private long f32092f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C10524a f32093g;

    /* renamed from: h */
    private final C10525b f32094h;

    /* renamed from: i */
    private final Handler f32095i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f32096j;

    /* renamed from: com.inmobi.ads.ce$a */
    /* compiled from: VisibilityTracker */
    interface C10524a {
        /* renamed from: a */
        boolean mo34077a(View view, View view2, int i, Object obj);
    }

    /* renamed from: com.inmobi.ads.ce$b */
    /* compiled from: VisibilityTracker */
    static class C10525b implements Runnable {

        /* renamed from: a */
        private final ArrayList<View> f32097a = new ArrayList<>();

        /* renamed from: b */
        private final ArrayList<View> f32098b = new ArrayList<>();

        /* renamed from: c */
        private WeakReference<C10523ce> f32099c;

        C10525b(C10523ce ceVar) {
            this.f32099c = new WeakReference<>(ceVar);
        }

        public final void run() {
            C10523ce ceVar = (C10523ce) this.f32099c.get();
            if (ceVar != null) {
                ceVar.f32096j = false;
                for (Entry entry : ceVar.f32089b.entrySet()) {
                    View view = (View) entry.getKey();
                    int i = ((C10527d) entry.getValue()).f32100a;
                    if (ceVar.f32093g.mo34077a(((C10527d) entry.getValue()).f32102c, view, i, ((C10527d) entry.getValue()).f32103d)) {
                        this.f32097a.add(view);
                    } else {
                        this.f32098b.add(view);
                    }
                }
            }
            if (ceVar != null) {
                C10526c d = ceVar.f32090c;
                if (d != null) {
                    d.mo34078a(this.f32097a, this.f32098b);
                }
            }
            this.f32097a.clear();
            this.f32098b.clear();
            if (ceVar != null) {
                ceVar.mo34170b();
            }
        }
    }

    /* renamed from: com.inmobi.ads.ce$c */
    /* compiled from: VisibilityTracker */
    interface C10526c {
        /* renamed from: a */
        void mo34078a(List<View> list, List<View> list2);
    }

    /* renamed from: com.inmobi.ads.ce$d */
    /* compiled from: VisibilityTracker */
    static class C10527d {

        /* renamed from: a */
        int f32100a;

        /* renamed from: b */
        long f32101b;

        /* renamed from: c */
        View f32102c;

        /* renamed from: d */
        Object f32103d;

        C10527d() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo34169a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo34170b();

    C10523ce(C10524a aVar) {
        this(new WeakHashMap(10), aVar, new Handler(Looper.getMainLooper()));
    }

    private C10523ce(Map<View, C10527d> map, C10524a aVar, Handler handler) {
        this.f32092f = 0;
        this.f32088a = true;
        this.f32089b = map;
        this.f32093g = aVar;
        this.f32095i = handler;
        this.f32094h = new C10525b(this);
        this.f32091e = new ArrayList<>(50);
    }

    /* renamed from: c */
    public void mo34247c() {
        this.f32094h.run();
        this.f32095i.removeCallbacksAndMessages(null);
        this.f32096j = false;
        this.f32088a = true;
    }

    /* renamed from: d */
    public void mo34248d() {
        this.f32088a = false;
        mo34251g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo34246a(View view, Object obj, int i) {
        C10527d dVar = (C10527d) this.f32089b.get(view);
        if (dVar == null) {
            dVar = new C10527d();
            this.f32089b.put(view, dVar);
            this.f32092f++;
        }
        dVar.f32100a = i;
        long j = this.f32092f;
        dVar.f32101b = j;
        dVar.f32102c = view;
        dVar.f32103d = obj;
        if (j % 50 == 0) {
            long j2 = j - 50;
            for (Entry entry : this.f32089b.entrySet()) {
                if (((C10527d) entry.getValue()).f32101b < j2) {
                    this.f32091e.add(entry.getKey());
                }
            }
            Iterator it = this.f32091e.iterator();
            while (it.hasNext()) {
                mo34245a((View) it.next());
            }
            this.f32091e.clear();
        }
        if (1 == this.f32089b.size()) {
            mo34248d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo34245a(View view) {
        if (((C10527d) this.f32089b.remove(view)) != null) {
            this.f32092f--;
            if (this.f32089b.size() == 0) {
                mo34247c();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo34250f() {
        this.f32089b.clear();
        this.f32095i.removeMessages(0);
        this.f32096j = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final View mo34244a(Object obj) {
        View view = null;
        if (obj == null) {
            return null;
        }
        Iterator it = this.f32089b.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (((C10527d) entry.getValue()).f32103d.equals(obj)) {
                view = (View) entry.getKey();
                break;
            }
        }
        if (view != null) {
            mo34245a(view);
        }
        return view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo34249e() {
        mo34250f();
        this.f32090c = null;
        this.f32088a = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final void mo34251g() {
        if (!this.f32096j && !this.f32088a) {
            this.f32096j = true;
            this.f32095i.postDelayed(this.f32094h, (long) mo34169a());
        }
    }
}
