package com.fyber.inneractive.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.fyber.inneractive.sdk.util.C8003h.C8004a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.fyber.inneractive.sdk.util.w */
public final class C8034w {

    /* renamed from: a */
    public static String f16376a = "IAVisibilityTracker";

    /* renamed from: b */
    public Map<Context, Pair<ViewTreeObserver, OnPreDrawListener>> f16377b;

    /* renamed from: c */
    public WeakHashMap<Context, WeakHashMap<View, C8039b>> f16378c;

    /* renamed from: d */
    C8003h<Rect> f16379d;

    /* renamed from: e */
    C8003h<HashSet<View>> f16380e;

    /* renamed from: com.fyber.inneractive.sdk.util.w$a */
    private static class C8038a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static C8034w f16385a = new C8034w(0);
    }

    /* renamed from: com.fyber.inneractive.sdk.util.w$b */
    public interface C8039b {
        /* renamed from: a */
        void mo24708a(float f, Rect rect);
    }

    /* synthetic */ C8034w(byte b) {
        this();
    }

    private C8034w() {
        this.f16378c = new WeakHashMap<>();
        this.f16377b = new WeakHashMap();
        this.f16379d = new C8003h<>(new C8004a<Rect>() {
            /* renamed from: a */
            public final /* synthetic */ Object mo24843a() {
                return new Rect();
            }
        });
        this.f16380e = new C8003h<>(new C8004a<HashSet<View>>() {
            /* renamed from: a */
            public final /* synthetic */ Object mo24843a() {
                return new HashSet();
            }
        });
    }

    /* renamed from: a */
    public static C8034w m18120a() {
        return C8038a.f16385a;
    }

    /* renamed from: a */
    public final void mo24870a(View view, C8039b bVar) {
        mo24868a(view.getContext(), view, bVar);
    }

    /* renamed from: a */
    public final void mo24868a(final Context context, View view, C8039b bVar) {
        View view2;
        StringBuilder sb = new StringBuilder();
        sb.append(m18124c());
        sb.append("trackView called with context: ");
        sb.append(context);
        sb.append(" view: ");
        sb.append(view);
        IAlog.m18021b(sb.toString());
        if (context != null) {
            WeakHashMap weakHashMap = (WeakHashMap) this.f16378c.get(context);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                this.f16378c.put(context, weakHashMap);
                if (context instanceof Activity) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                } else {
                    view2 = view.getRootView();
                }
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    C80373 r2 = new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            C8034w.m18122a(C8034w.this, context);
                            return true;
                        }
                    };
                    viewTreeObserver.addOnPreDrawListener(r2);
                    this.f16377b.put(context, new Pair(viewTreeObserver, r2));
                }
            }
            weakHashMap.put(view, bVar);
            m18123b();
            return;
        }
        throw new IllegalStateException("View must be attached to an Activity context");
    }

    /* renamed from: a */
    public final void mo24869a(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(m18124c());
        sb.append("unTrackView called with view");
        IAlog.m18021b(sb.toString());
        Context context = view.getContext();
        if (context != null) {
            Map map = (Map) this.f16378c.get(context);
            if (map != null) {
                m18121a(context, map, view);
            } else {
                for (Context context2 : new HashSet(this.f16378c.keySet())) {
                    m18121a(context2, (Map) this.f16378c.get(context2), view);
                }
            }
            m18123b();
            return;
        }
        throw new IllegalStateException("View must be attached to an Activity context");
    }

    /* renamed from: a */
    private void m18121a(Context context, Map<View, C8039b> map, View view) {
        if (map.remove(view) != null) {
            if (IAlog.f16291a <= 2) {
                IAlog.m18019a("removeViewFromContext found view for removal!");
            }
            if (map.isEmpty()) {
                this.f16378c.remove(context);
                Pair pair = (Pair) this.f16377b.get(context);
                if (pair != null) {
                    if (((ViewTreeObserver) pair.first).isAlive()) {
                        ((ViewTreeObserver) pair.first).removeOnPreDrawListener((OnPreDrawListener) pair.second);
                    }
                    this.f16377b.remove(context);
                }
            }
        }
    }

    /* renamed from: b */
    private void m18123b() {
        for (Context context : this.f16378c.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(m18124c());
            sb.append("tracking context: ");
            sb.append(context);
            IAlog.m18021b(sb.toString());
            for (View view : ((WeakHashMap) this.f16378c.get(context)).keySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m18124c());
                sb2.append("tracking view: ");
                sb2.append(view);
                IAlog.m18021b(sb2.toString());
            }
        }
    }

    /* renamed from: c */
    private static String m18124c() {
        StringBuilder sb = new StringBuilder();
        sb.append(f16376a);
        sb.append(": ");
        return sb.toString();
    }

    /* renamed from: a */
    static /* synthetic */ void m18122a(C8034w wVar, Context context) {
        if (context != null) {
            WeakHashMap weakHashMap = (WeakHashMap) wVar.f16378c.get(context);
            if (weakHashMap != null) {
                HashSet hashSet = (HashSet) wVar.f16380e.mo24841a();
                hashSet.addAll(weakHashMap.keySet());
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    C8039b bVar = (C8039b) weakHashMap.get(view);
                    float f = 0.0f;
                    Rect rect = (Rect) wVar.f16379d.mo24841a();
                    if (view != null && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(rect)) {
                        f = ((float) (rect.height() * rect.width())) / ((float) (view.getHeight() * view.getWidth()));
                    }
                    bVar.mo24708a(f, rect);
                    wVar.f16379d.mo24842a(rect);
                }
                hashSet.clear();
                wVar.f16380e.mo24842a(hashSet);
            }
        }
    }
}
