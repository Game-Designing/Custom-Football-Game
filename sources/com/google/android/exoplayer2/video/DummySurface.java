package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;

@TargetApi(17)
public final class DummySurface extends Surface {

    /* renamed from: a */
    private static int f18891a;

    /* renamed from: b */
    private static boolean f18892b;

    /* renamed from: c */
    public final boolean f18893c;

    /* renamed from: d */
    private final C8546a f18894d;

    /* renamed from: e */
    private boolean f18895e;

    /* renamed from: com.google.android.exoplayer2.video.DummySurface$a */
    private static class C8546a extends HandlerThread implements Callback {

        /* renamed from: a */
        private EGLSurfaceTexture f18896a;

        /* renamed from: b */
        private Handler f18897b;

        /* renamed from: c */
        private Error f18898c;

        /* renamed from: d */
        private RuntimeException f18899d;

        /* renamed from: e */
        private DummySurface f18900e;

        public C8546a() {
            super("dummySurface");
        }

        /* renamed from: a */
        public DummySurface mo26171a(int secureMode) {
            start();
            this.f18897b = new Handler(getLooper(), this);
            this.f18896a = new EGLSurfaceTexture(this.f18897b);
            boolean wasInterrupted = false;
            synchronized (this) {
                this.f18897b.obtainMessage(1, secureMode, 0).sendToTarget();
                while (this.f18900e == null && this.f18899d == null && this.f18898c == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        wasInterrupted = true;
                    }
                }
            }
            if (wasInterrupted) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f18899d;
            if (runtimeException == null) {
                Error error = this.f18898c;
                if (error == null) {
                    DummySurface dummySurface = this.f18900e;
                    C8514e.m20486a(dummySurface);
                    return dummySurface;
                }
                throw error;
            }
            throw runtimeException;
        }

        /* renamed from: a */
        public void mo26172a() {
            C8514e.m20486a(this.f18897b);
            this.f18897b.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message msg) {
            int i = msg.what;
            if (i == 1) {
                try {
                    m20658b(msg.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e) {
                    C8526n.m20530a("DummySurface", "Failed to initialize dummy surface", e);
                    this.f18899d = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    try {
                        C8526n.m20530a("DummySurface", "Failed to initialize dummy surface", e2);
                        this.f18898c = e2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i != 2) {
                return true;
            } else {
                try {
                    m20657b();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }

        /* renamed from: b */
        private void m20658b(int secureMode) {
            C8514e.m20486a(this.f18896a);
            this.f18896a.mo26057a(secureMode);
            this.f18900e = new DummySurface(this, this.f18896a.mo26056a(), secureMode != 0);
        }

        /* renamed from: b */
        private void m20657b() {
            C8514e.m20486a(this.f18896a);
            this.f18896a.mo26058b();
        }
    }

    /* renamed from: a */
    public static synchronized boolean m20655a(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            z = true;
            if (!f18892b) {
                f18891a = C8509F.f18793a < 24 ? 0 : m20656b(context);
                f18892b = true;
            }
            if (f18891a == 0) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static DummySurface m20653a(Context context, boolean secure) {
        m20654a();
        int i = 0;
        C8514e.m20490b(!secure || m20655a(context));
        C8546a thread = new C8546a();
        if (secure) {
            i = f18891a;
        }
        return thread.mo26171a(i);
    }

    private DummySurface(C8546a thread, SurfaceTexture surfaceTexture, boolean secure) {
        super(surfaceTexture);
        this.f18894d = thread;
        this.f18893c = secure;
    }

    public void release() {
        super.release();
        synchronized (this.f18894d) {
            if (!this.f18895e) {
                this.f18894d.mo26172a();
                this.f18895e = true;
            }
        }
    }

    /* renamed from: a */
    private static void m20654a() {
        if (C8509F.f18793a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if ("XT1650".equals(com.google.android.exoplayer2.util.C8509F.f18796d) != false) goto L_0x001b;
     */
    @android.annotation.TargetApi(24)
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m20656b(android.content.Context r4) {
        /*
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r1 = 26
            r2 = 0
            if (r0 >= r1) goto L_0x001c
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18795c
            java.lang.String r3 = "samsung"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r3 = "XT1650"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x001c
        L_0x001b:
            return r2
        L_0x001c:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            if (r0 >= r1) goto L_0x002d
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r1 = "android.hardware.vr.high_performance"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 != 0) goto L_0x002d
            return r2
        L_0x002d:
            android.opengl.EGLDisplay r0 = android.opengl.EGL14.eglGetDisplay(r2)
            r1 = 12373(0x3055, float:1.7338E-41)
            java.lang.String r1 = android.opengl.EGL14.eglQueryString(r0, r1)
            if (r1 != 0) goto L_0x003a
            return r2
        L_0x003a:
            java.lang.String r3 = "EGL_EXT_protected_content"
            boolean r3 = r1.contains(r3)
            if (r3 != 0) goto L_0x0043
            return r2
        L_0x0043:
            java.lang.String r2 = "EGL_KHR_surfaceless_context"
            boolean r2 = r1.contains(r2)
            if (r2 == 0) goto L_0x004d
            r2 = 1
            goto L_0x004e
        L_0x004d:
            r2 = 2
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DummySurface.m20656b(android.content.Context):int");
    }
}
