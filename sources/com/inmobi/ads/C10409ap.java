package com.inmobi.ads;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.view.C0642s;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.inmobi.ads.ap */
/* compiled from: NativeDataSource */
final class C10409ap extends C0642s implements C10434ax {

    /* renamed from: a */
    private static final String f31682a = C10409ap.class.getSimpleName();

    /* renamed from: e */
    private static Handler f31683e = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f31684b;

    /* renamed from: c */
    private final C10406ao f31685c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C10419au f31686d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SparseArray<Runnable> f31687f = new SparseArray<>();

    C10409ap(C10406ao aoVar, C10419au auVar) {
        this.f31685c = aoVar;
        this.f31686d = auVar;
    }

    public final int getItemPosition(Object obj) {
        Object tag = obj == null ? null : ((View) obj).getTag();
        if (tag == null || !(tag instanceof Integer)) {
            return -2;
        }
        return ((Integer) tag).intValue();
    }

    public final int getCount() {
        return this.f31685c.mo34105b();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @TargetApi(21)
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        C10402am a = this.f31685c.mo34103a(i);
        if (a == null) {
            return null;
        }
        ViewGroup a2 = this.f31686d.mo34127a(viewGroup, a);
        int abs = Math.abs(this.f31686d.f31709b - i);
        final int i2 = i;
        final ViewGroup viewGroup2 = a2;
        final ViewGroup viewGroup3 = viewGroup;
        final C10402am amVar = a;
        C104112 r1 = new Runnable() {
            public final void run() {
                if (!C10409ap.this.f31684b) {
                    C10409ap.this.f31687f.remove(i2);
                    C10409ap.this.f31686d.mo34129b(viewGroup2, amVar);
                }
            }
        };
        this.f31687f.put(i, r1);
        f31683e.postDelayed(r1, (long) (abs * 50));
        a2.setLayoutParams(NativeViewFactory.m33742a((C10400ak) a, viewGroup));
        a2.setTag(Integer.valueOf(i));
        viewGroup.addView(a2);
        return a2;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, final Object obj) {
        viewGroup.removeView((View) obj);
        Runnable runnable = (Runnable) this.f31687f.get(i);
        if (runnable != null) {
            f31683e.removeCallbacks(runnable);
            NativeViewFactory.class.getSimpleName();
        }
        f31683e.post(new Runnable() {
            public final void run() {
                View view = (View) obj;
                C10409ap.this.f31686d.f31711d.mo33937a(view);
            }
        });
    }

    public final void destroy() {
        this.f31684b = true;
        int size = this.f31687f.size();
        for (int i = 0; i < size; i++) {
            f31683e.removeCallbacks((Runnable) this.f31687f.get(this.f31687f.keyAt(i)));
        }
        this.f31687f.clear();
    }
}
