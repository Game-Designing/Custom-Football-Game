package p024io.fabric.sdk.android;

import android.util.Log;

/* renamed from: io.fabric.sdk.android.c */
/* compiled from: DefaultLogger */
public class C13917c implements C13929o {

    /* renamed from: a */
    private int f42215a;

    public C13917c(int logLevel) {
        this.f42215a = logLevel;
    }

    public C13917c() {
        this.f42215a = 4;
    }

    /* renamed from: a */
    public boolean mo43323a(String tag, int level) {
        return this.f42215a <= level || Log.isLoggable(tag, level);
    }

    /* renamed from: c */
    public void mo43327c(String tag, String text, Throwable throwable) {
        if (mo43323a(tag, 3)) {
            Log.d(tag, text, throwable);
        }
    }

    /* renamed from: e */
    public void mo43331e(String tag, String text, Throwable throwable) {
        if (mo43323a(tag, 2)) {
            Log.v(tag, text, throwable);
        }
    }

    /* renamed from: d */
    public void mo43329d(String tag, String text, Throwable throwable) {
        if (mo43323a(tag, 4)) {
            Log.i(tag, text, throwable);
        }
    }

    /* renamed from: a */
    public void mo43322a(String tag, String text, Throwable throwable) {
        if (mo43323a(tag, 5)) {
            Log.w(tag, text, throwable);
        }
    }

    /* renamed from: b */
    public void mo43325b(String tag, String text, Throwable throwable) {
        if (mo43323a(tag, 6)) {
            Log.e(tag, text, throwable);
        }
    }

    /* renamed from: c */
    public void mo43326c(String tag, String text) {
        mo43327c(tag, text, null);
    }

    /* renamed from: e */
    public void mo43330e(String tag, String text) {
        mo43331e(tag, text, null);
    }

    /* renamed from: d */
    public void mo43328d(String tag, String text) {
        mo43329d(tag, text, null);
    }

    /* renamed from: a */
    public void mo43321a(String tag, String text) {
        mo43322a(tag, text, (Throwable) null);
    }

    /* renamed from: b */
    public void mo43324b(String tag, String text) {
        mo43325b(tag, text, null);
    }

    /* renamed from: a */
    public void mo43319a(int priority, String tag, String msg) {
        mo43320a(priority, tag, msg, false);
    }

    /* renamed from: a */
    public void mo43320a(int priority, String tag, String msg, boolean forceLog) {
        if (forceLog || mo43323a(tag, priority)) {
            Log.println(priority, tag, msg);
        }
    }
}
