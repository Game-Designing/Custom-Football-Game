package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.ads.ca */
/* compiled from: ViewableAd */
public abstract class C10503ca {

    /* renamed from: a */
    AdContainer f32007a;

    /* renamed from: b */
    C10504a f32008b;

    /* renamed from: c */
    protected WeakReference<View> f32009c;

    /* renamed from: com.inmobi.ads.ca$a */
    /* compiled from: ViewableAd */
    protected static abstract class C10504a {

        /* renamed from: a */
        private boolean f32010a;

        /* renamed from: a */
        public abstract View mo34111a(View view, ViewGroup viewGroup, boolean z, RenderView renderView);

        protected C10504a() {
        }

        /* renamed from: b */
        public boolean mo34114b() {
            return this.f32010a;
        }

        /* renamed from: a */
        public void mo34112a() {
            if (!this.f32010a) {
                this.f32010a = true;
            }
        }
    }

    /* renamed from: a */
    public abstract View mo33956a(View view, ViewGroup viewGroup, boolean z);

    /* renamed from: a */
    public abstract void mo33957a(int i);

    /* renamed from: a */
    public abstract void mo33958a(Context context, int i);

    /* renamed from: a */
    public abstract void mo33959a(View... viewArr);

    /* renamed from: d */
    public abstract void mo33962d();

    public C10503ca() {
    }

    public C10503ca(AdContainer adContainer) {
        this.f32007a = adContainer;
    }

    /* renamed from: f */
    public C10504a mo33964f() {
        return this.f32008b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo34223a(View view) {
        this.f32009c = new WeakReference<>(view);
    }

    /* renamed from: c */
    public C10478c mo33961c() {
        return new C10478c();
    }

    /* renamed from: b */
    public View mo33960b() {
        WeakReference<View> weakReference = this.f32009c;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* renamed from: a */
    public View mo34004a() {
        return null;
    }

    /* renamed from: e */
    public void mo33963e() {
        WeakReference<View> weakReference = this.f32009c;
        if (weakReference != null) {
            weakReference.clear();
        }
    }
}
