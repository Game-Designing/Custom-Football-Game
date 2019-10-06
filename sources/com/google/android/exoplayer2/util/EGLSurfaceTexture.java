package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

@TargetApi(17)
public final class EGLSurfaceTexture implements OnFrameAvailableListener, Runnable {

    /* renamed from: a */
    private static final int[] f18785a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: b */
    private final Handler f18786b;

    /* renamed from: c */
    private final int[] f18787c;

    /* renamed from: d */
    private final C8508a f18788d;

    /* renamed from: e */
    private EGLDisplay f18789e;

    /* renamed from: f */
    private EGLContext f18790f;

    /* renamed from: g */
    private EGLSurface f18791g;

    /* renamed from: h */
    private SurfaceTexture f18792h;

    public static final class GlException extends RuntimeException {
        private GlException(String msg) {
            super(msg);
        }
    }

    /* renamed from: com.google.android.exoplayer2.util.EGLSurfaceTexture$a */
    public interface C8508a {
        /* renamed from: a */
        void mo26061a();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    public EGLSurfaceTexture(Handler handler, C8508a callback) {
        this.f18786b = handler;
        this.f18788d = callback;
        this.f18787c = new int[1];
    }

    /* renamed from: a */
    public void mo26057a(int secureMode) {
        this.f18789e = m20425d();
        EGLConfig config = m20420a(this.f18789e);
        this.f18790f = m20421a(this.f18789e, config, secureMode);
        this.f18791g = m20422a(this.f18789e, config, this.f18790f, secureMode);
        m20423a(this.f18787c);
        this.f18792h = new SurfaceTexture(this.f18787c[0]);
        this.f18792h.setOnFrameAvailableListener(this);
    }

    /* renamed from: b */
    public void mo26058b() {
        this.f18786b.removeCallbacks(this);
        try {
            if (this.f18792h != null) {
                this.f18792h.release();
                GLES20.glDeleteTextures(1, this.f18787c, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f18789e;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f18789e;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f18791g;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f18789e, this.f18791g);
            }
            EGLContext eGLContext = this.f18790f;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f18789e, eGLContext);
            }
            if (C8509F.f18793a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f18789e;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f18789e);
            }
            this.f18789e = null;
            this.f18790f = null;
            this.f18791g = null;
            this.f18792h = null;
        }
    }

    /* renamed from: a */
    public SurfaceTexture mo26056a() {
        SurfaceTexture surfaceTexture = this.f18792h;
        C8514e.m20486a(surfaceTexture);
        return surfaceTexture;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f18786b.post(this);
    }

    public void run() {
        m20424c();
        SurfaceTexture surfaceTexture = this.f18792h;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException e) {
            }
        }
    }

    /* renamed from: c */
    private void m20424c() {
        C8508a aVar = this.f18788d;
        if (aVar != null) {
            aVar.mo26061a();
        }
    }

    /* renamed from: d */
    private static EGLDisplay m20425d() {
        EGLDisplay display = EGL14.eglGetDisplay(0);
        if (display != null) {
            int[] version = new int[2];
            if (EGL14.eglInitialize(display, version, 0, version, 1)) {
                return display;
            }
            throw new GlException("eglInitialize failed");
        }
        throw new GlException("eglGetDisplay failed");
    }

    /* renamed from: a */
    private static EGLConfig m20420a(EGLDisplay display) {
        EGLConfig[] configs = new EGLConfig[1];
        int[] numConfigs = new int[1];
        boolean success = EGL14.eglChooseConfig(display, f18785a, 0, configs, 0, 1, numConfigs, 0);
        if (success && numConfigs[0] > 0 && configs[0] != null) {
            return configs[0];
        }
        throw new GlException(C8509F.m20445a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(success), Integer.valueOf(numConfigs[0]), configs[0]));
    }

    /* renamed from: a */
    private static EGLContext m20421a(EGLDisplay display, EGLConfig config, int secureMode) {
        int[] glAttributes;
        if (secureMode == 0) {
            glAttributes = new int[]{12440, 2, 12344};
        } else {
            glAttributes = new int[]{12440, 2, 12992, 1, 12344};
        }
        EGLContext context = EGL14.eglCreateContext(display, config, EGL14.EGL_NO_CONTEXT, glAttributes, 0);
        if (context != null) {
            return context;
        }
        throw new GlException("eglCreateContext failed");
    }

    /* renamed from: a */
    private static EGLSurface m20422a(EGLDisplay display, EGLConfig config, EGLContext context, int secureMode) {
        EGLSurface surface;
        int[] pbufferAttributes;
        if (secureMode == 1) {
            surface = EGL14.EGL_NO_SURFACE;
        } else {
            if (secureMode == 2) {
                pbufferAttributes = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                pbufferAttributes = new int[]{12375, 1, 12374, 1, 12344};
            }
            EGLSurface surface2 = EGL14.eglCreatePbufferSurface(display, config, pbufferAttributes, 0);
            if (surface2 != null) {
                surface = surface2;
            } else {
                throw new GlException("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(display, surface, surface, context)) {
            return surface;
        }
        throw new GlException("eglMakeCurrent failed");
    }

    /* renamed from: a */
    private static void m20423a(int[] textureIdHolder) {
        GLES20.glGenTextures(1, textureIdHolder, 0);
        int errorCode = GLES20.glGetError();
        if (errorCode != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("glGenTextures failed. Error: ");
            sb.append(Integer.toHexString(errorCode));
            throw new GlException(sb.toString());
        }
    }
}
