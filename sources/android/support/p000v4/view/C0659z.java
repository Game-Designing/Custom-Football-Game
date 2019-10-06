package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import p002b.p003c.p047a.C1157a;

/* renamed from: android.support.v4.view.z */
/* compiled from: ViewGroupCompat */
public final class C0659z {

    /* renamed from: a */
    static final C0662c f1875a;

    /* renamed from: android.support.v4.view.z$a */
    /* compiled from: ViewGroupCompat */
    static class C0660a extends C0662c {
        C0660a() {
        }
    }

    /* renamed from: android.support.v4.view.z$b */
    /* compiled from: ViewGroupCompat */
    static class C0661b extends C0660a {
        C0661b() {
        }

        /* renamed from: a */
        public boolean mo5756a(ViewGroup group) {
            return group.isTransitionGroup();
        }
    }

    /* renamed from: android.support.v4.view.z$c */
    /* compiled from: ViewGroupCompat */
    static class C0662c {
        C0662c() {
        }

        /* renamed from: a */
        public boolean mo5756a(ViewGroup group) {
            Boolean explicit = (Boolean) group.getTag(C1157a.tag_transition_group);
            return ((explicit == null || !explicit.booleanValue()) && group.getBackground() == null && C0646w.m2979m(group) == null) ? false : true;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1875a = new C0661b();
        } else if (i >= 18) {
            f1875a = new C0660a();
        } else {
            f1875a = new C0662c();
        }
    }

    /* renamed from: a */
    public static boolean m3096a(ViewGroup group) {
        return f1875a.mo5756a(group);
    }
}
