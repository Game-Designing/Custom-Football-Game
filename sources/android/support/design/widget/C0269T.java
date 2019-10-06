package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: android.support.design.widget.T */
/* compiled from: SnackbarManager */
class C0269T {

    /* renamed from: a */
    private static C0269T f1051a;

    /* renamed from: b */
    private final Object f1052b = new Object();

    /* renamed from: c */
    private final Handler f1053c = new Handler(Looper.getMainLooper(), new C0265S(this));

    /* renamed from: d */
    private C0271b f1054d;

    /* renamed from: e */
    private C0271b f1055e;

    /* renamed from: android.support.design.widget.T$a */
    /* compiled from: SnackbarManager */
    interface C0270a {
        /* renamed from: a */
        void mo4577a(int i);

        void show();
    }

    /* renamed from: android.support.design.widget.T$b */
    /* compiled from: SnackbarManager */
    private static class C0271b {

        /* renamed from: a */
        final WeakReference<C0270a> f1056a;

        /* renamed from: b */
        int f1057b;

        /* renamed from: c */
        boolean f1058c;

        C0271b(int duration, C0270a callback) {
            this.f1056a = new WeakReference<>(callback);
            this.f1057b = duration;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4579a(C0270a callback) {
            return callback != null && this.f1056a.get() == callback;
        }
    }

    /* renamed from: a */
    static C0269T m1643a() {
        if (f1051a == null) {
            f1051a = new C0269T();
        }
        return f1051a;
    }

    private C0269T() {
    }

    /* renamed from: a */
    public void mo4569a(int duration, C0270a callback) {
        synchronized (this.f1052b) {
            if (m1647f(callback)) {
                this.f1054d.f1057b = duration;
                this.f1053c.removeCallbacksAndMessages(this.f1054d);
                m1646b(this.f1054d);
                return;
            }
            if (m1648g(callback)) {
                this.f1055e.f1057b = duration;
            } else {
                this.f1055e = new C0271b(duration, callback);
            }
            if (this.f1054d == null || !m1644a(this.f1054d, 4)) {
                this.f1054d = null;
                m1645b();
            }
        }
    }

    /* renamed from: a */
    public void mo4570a(C0270a callback, int event) {
        synchronized (this.f1052b) {
            if (m1647f(callback)) {
                m1644a(this.f1054d, event);
            } else if (m1648g(callback)) {
                m1644a(this.f1055e, event);
            }
        }
    }

    /* renamed from: b */
    public void mo4573b(C0270a callback) {
        synchronized (this.f1052b) {
            if (m1647f(callback)) {
                this.f1054d = null;
                if (this.f1055e != null) {
                    m1645b();
                }
            }
        }
    }

    /* renamed from: c */
    public void mo4574c(C0270a callback) {
        synchronized (this.f1052b) {
            if (m1647f(callback)) {
                m1646b(this.f1054d);
            }
        }
    }

    /* renamed from: d */
    public void mo4575d(C0270a callback) {
        synchronized (this.f1052b) {
            if (m1647f(callback) && !this.f1054d.f1058c) {
                this.f1054d.f1058c = true;
                this.f1053c.removeCallbacksAndMessages(this.f1054d);
            }
        }
    }

    /* renamed from: e */
    public void mo4576e(C0270a callback) {
        synchronized (this.f1052b) {
            if (m1647f(callback) && this.f1054d.f1058c) {
                this.f1054d.f1058c = false;
                m1646b(this.f1054d);
            }
        }
    }

    /* renamed from: a */
    public boolean mo4572a(C0270a callback) {
        boolean z;
        synchronized (this.f1052b) {
            if (!m1647f(callback)) {
                if (!m1648g(callback)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private void m1645b() {
        C0271b bVar = this.f1055e;
        if (bVar != null) {
            this.f1054d = bVar;
            this.f1055e = null;
            C0270a callback = (C0270a) this.f1054d.f1056a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.f1054d = null;
            }
        }
    }

    /* renamed from: a */
    private boolean m1644a(C0271b record, int event) {
        C0270a callback = (C0270a) record.f1056a.get();
        if (callback == null) {
            return false;
        }
        this.f1053c.removeCallbacksAndMessages(record);
        callback.mo4577a(event);
        return true;
    }

    /* renamed from: f */
    private boolean m1647f(C0270a callback) {
        C0271b bVar = this.f1054d;
        return bVar != null && bVar.mo4579a(callback);
    }

    /* renamed from: g */
    private boolean m1648g(C0270a callback) {
        C0271b bVar = this.f1055e;
        return bVar != null && bVar.mo4579a(callback);
    }

    /* renamed from: b */
    private void m1646b(C0271b r) {
        int i = r.f1057b;
        if (i != -2) {
            int durationMs = 2750;
            if (i > 0) {
                durationMs = r.f1057b;
            } else if (i == -1) {
                durationMs = 1500;
            }
            this.f1053c.removeCallbacksAndMessages(r);
            Handler handler = this.f1053c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, r), (long) durationMs);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4571a(C0271b record) {
        synchronized (this.f1052b) {
            if (this.f1054d == record || this.f1055e == record) {
                m1644a(record, 2);
            }
        }
    }
}
