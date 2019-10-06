package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;
import android.arch.lifecycle.C0148d.C0149b;

/* renamed from: android.arch.lifecycle.g */
/* compiled from: LifecycleRegistry */
/* synthetic */ class C0151g {

    /* renamed from: a */
    static final /* synthetic */ int[] f211a = new int[C0000a.values().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f212b = new int[C0149b.values().length];

    static {
        try {
            f212b[C0149b.INITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f212b[C0149b.CREATED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f212b[C0149b.STARTED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f212b[C0149b.RESUMED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f212b[C0149b.DESTROYED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f211a[C0000a.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f211a[C0000a.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f211a[C0000a.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f211a[C0000a.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f211a[C0000a.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f211a[C0000a.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f211a[C0000a.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError e12) {
        }
    }
}
