package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.widget.EdgeEffect;

/* renamed from: android.support.v4.widget.m */
/* compiled from: EdgeEffectCompat */
public final class C0706m {

    /* renamed from: a */
    private static final C0708b f2063a;

    /* renamed from: android.support.v4.widget.m$a */
    /* compiled from: EdgeEffectCompat */
    static class C0707a extends C0708b {
        C0707a() {
        }

        /* renamed from: a */
        public void mo6017a(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
            edgeEffect.onPull(deltaDistance, displacement);
        }
    }

    /* renamed from: android.support.v4.widget.m$b */
    /* compiled from: EdgeEffectCompat */
    static class C0708b {
        C0708b() {
        }

        /* renamed from: a */
        public void mo6017a(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
            edgeEffect.onPull(deltaDistance);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f2063a = new C0707a();
        } else {
            f2063a = new C0708b();
        }
    }

    /* renamed from: a */
    public static void m3330a(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
        f2063a.mo6017a(edgeEffect, deltaDistance, displacement);
    }
}
