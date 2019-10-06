package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
@zzard
public final class zzbdd extends Thread implements OnFrameAvailableListener, C8785Cd {

    /* renamed from: a */
    private static final float[] f25119a = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: A */
    private volatile boolean f25120A;

    /* renamed from: B */
    private volatile boolean f25121B;

    /* renamed from: b */
    private final C8743Ad f25122b;

    /* renamed from: c */
    private final float[] f25123c;

    /* renamed from: d */
    private final float[] f25124d;

    /* renamed from: e */
    private final float[] f25125e;

    /* renamed from: f */
    private final float[] f25126f;

    /* renamed from: g */
    private final float[] f25127g;

    /* renamed from: h */
    private final float[] f25128h;

    /* renamed from: i */
    private final float[] f25129i;

    /* renamed from: j */
    private float f25130j;

    /* renamed from: k */
    private float f25131k;

    /* renamed from: l */
    private float f25132l;

    /* renamed from: m */
    private int f25133m;

    /* renamed from: n */
    private int f25134n;

    /* renamed from: o */
    private SurfaceTexture f25135o;

    /* renamed from: p */
    private SurfaceTexture f25136p;

    /* renamed from: q */
    private int f25137q;

    /* renamed from: r */
    private int f25138r;

    /* renamed from: s */
    private int f25139s;

    /* renamed from: t */
    private FloatBuffer f25140t = ByteBuffer.allocateDirect(f25119a.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: u */
    private final CountDownLatch f25141u;

    /* renamed from: v */
    private final Object f25142v;

    /* renamed from: w */
    private EGL10 f25143w;

    /* renamed from: x */
    private EGLDisplay f25144x;

    /* renamed from: y */
    private EGLContext f25145y;

    /* renamed from: z */
    private EGLSurface f25146z;

    public zzbdd(Context context) {
        super("SphericalVideoProcessor");
        this.f25140t.put(f25119a).position(0);
        this.f25123c = new float[9];
        this.f25124d = new float[9];
        this.f25125e = new float[9];
        this.f25126f = new float[9];
        this.f25127g = new float[9];
        this.f25128h = new float[9];
        this.f25129i = new float[9];
        this.f25130j = Float.NaN;
        this.f25122b = new C8743Ad(context);
        this.f25122b.mo28001a((C8785Cd) this);
        this.f25141u = new CountDownLatch(1);
        this.f25142v = new Object();
    }

    /* renamed from: a */
    public final void mo30424a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f25134n = i;
        this.f25133m = i2;
        this.f25136p = surfaceTexture;
    }

    /* renamed from: a */
    public final void mo30423a(int i, int i2) {
        synchronized (this.f25142v) {
            this.f25134n = i;
            this.f25133m = i2;
            this.f25120A = true;
            this.f25142v.notifyAll();
        }
    }

    /* renamed from: b */
    public final void mo30425b() {
        synchronized (this.f25142v) {
            this.f25121B = true;
            this.f25136p = null;
            this.f25142v.notifyAll();
        }
    }

    /* renamed from: c */
    public final SurfaceTexture mo30426c() {
        if (this.f25136p == null) {
            return null;
        }
        try {
            this.f25141u.await();
        } catch (InterruptedException e) {
        }
        return this.f25135o;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f25139s++;
        synchronized (this.f25142v) {
            this.f25142v.notifyAll();
        }
    }

    /* renamed from: a */
    public final void mo28071a() {
        synchronized (this.f25142v) {
            this.f25142v.notifyAll();
        }
    }

    public final void run() {
        boolean z;
        String str;
        int i;
        String str2;
        EGLConfig eGLConfig;
        if (this.f25136p == null) {
            zzbad.m26355b("SphericalVideoProcessor started with no output texture.");
            this.f25141u.countDown();
            return;
        }
        this.f25143w = (EGL10) EGLContext.getEGL();
        this.f25144x = this.f25143w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        EGLDisplay eGLDisplay = this.f25144x;
        if (eGLDisplay == EGL10.EGL_NO_DISPLAY) {
            z = false;
        } else {
            if (!this.f25143w.eglInitialize(eGLDisplay, new int[2])) {
                z = false;
            } else {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!this.f25143w.eglChooseConfig(this.f25144x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) {
                    eGLConfig = null;
                } else {
                    eGLConfig = eGLConfigArr[0];
                }
                if (eGLConfig == null) {
                    z = false;
                } else {
                    this.f25145y = this.f25143w.eglCreateContext(this.f25144x, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    EGLContext eGLContext = this.f25145y;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        z = false;
                    } else {
                        this.f25146z = this.f25143w.eglCreateWindowSurface(this.f25144x, eGLConfig, this.f25136p, null);
                        EGLSurface eGLSurface = this.f25146z;
                        if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                            z = false;
                        } else if (!this.f25143w.eglMakeCurrent(this.f25144x, eGLSurface, eGLSurface, this.f25145y)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                }
            }
        }
        zzacj<String> zzacj = zzacu.f23958Kb;
        if (!((String) zzyt.m31536e().mo29599a(zzacj)).equals(zzacj.mo29592c())) {
            str = (String) zzyt.m31536e().mo29599a(zzacj);
        } else {
            str = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
        }
        int a = m26503a(35633, str);
        if (a == 0) {
            i = 0;
        } else {
            zzacj<String> zzacj2 = zzacu.f23964Lb;
            if (!((String) zzyt.m31536e().mo29599a(zzacj2)).equals(zzacj2.mo29592c())) {
                str2 = (String) zzyt.m31536e().mo29599a(zzacj2);
            } else {
                str2 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
            }
            int a2 = m26503a(35632, str2);
            if (a2 == 0) {
                i = 0;
            } else {
                i = GLES20.glCreateProgram();
                m26504a("createProgram");
                if (i != 0) {
                    GLES20.glAttachShader(i, a);
                    m26504a("attachShader");
                    GLES20.glAttachShader(i, a2);
                    m26504a("attachShader");
                    GLES20.glLinkProgram(i);
                    m26504a("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(i, 35714, iArr2, 0);
                    m26504a("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(i));
                        GLES20.glDeleteProgram(i);
                        m26504a("deleteProgram");
                        i = 0;
                    } else {
                        GLES20.glValidateProgram(i);
                        m26504a("validateProgram");
                    }
                }
            }
        }
        this.f25137q = i;
        GLES20.glUseProgram(this.f25137q);
        m26504a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f25137q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.f25140t);
        m26504a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        m26504a("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        m26504a("genTextures");
        int i2 = iArr3[0];
        GLES20.glBindTexture(36197, i2);
        m26504a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        m26504a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        m26504a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        m26504a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        m26504a("texParameteri");
        this.f25138r = GLES20.glGetUniformLocation(this.f25137q, "uVMat");
        GLES20.glUniformMatrix3fv(this.f25138r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        boolean z2 = this.f25137q != 0;
        if (!z || !z2) {
            String str3 = "EGL initialization failed: ";
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.f25143w.eglGetError()));
            String concat = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
            zzbad.m26355b(concat);
            zzk.zzlk().mo30168a(new Throwable(concat), "SphericalVideoProcessor.run.1");
            m26508d();
            this.f25141u.countDown();
            return;
        }
        this.f25135o = new SurfaceTexture(i2);
        this.f25135o.setOnFrameAvailableListener(this);
        this.f25141u.countDown();
        this.f25122b.mo28000a();
        try {
            this.f25120A = true;
            while (!this.f25121B) {
                while (this.f25139s > 0) {
                    this.f25135o.updateTexImage();
                    this.f25139s--;
                }
                if (this.f25122b.mo28002a(this.f25123c)) {
                    if (Float.isNaN(this.f25130j)) {
                        float[] fArr = this.f25123c;
                        float[] fArr2 = {0.0f, 1.0f, 0.0f};
                        float[] fArr3 = {(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[8] * fArr2[2])};
                        this.f25130j = -(((float) Math.atan2((double) fArr3[1], (double) fArr3[0])) - 1.5707964f);
                    }
                    m26507b(this.f25128h, this.f25130j + this.f25131k);
                } else {
                    m26505a(this.f25123c, -1.5707964f);
                    m26507b(this.f25128h, this.f25131k);
                }
                m26505a(this.f25124d, 1.5707964f);
                m26506a(this.f25125e, this.f25128h, this.f25124d);
                m26506a(this.f25126f, this.f25123c, this.f25125e);
                m26505a(this.f25127g, this.f25132l);
                m26506a(this.f25129i, this.f25127g, this.f25126f);
                GLES20.glUniformMatrix3fv(this.f25138r, 1, false, this.f25129i, 0);
                GLES20.glDrawArrays(5, 0, 4);
                m26504a("drawArrays");
                GLES20.glFinish();
                this.f25143w.eglSwapBuffers(this.f25144x, this.f25146z);
                if (this.f25120A) {
                    GLES20.glViewport(0, 0, this.f25134n, this.f25133m);
                    m26504a("viewport");
                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.f25137q, "uFOVx");
                    int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f25137q, "uFOVy");
                    if (this.f25134n > this.f25133m) {
                        GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
                        GLES20.glUniform1f(glGetUniformLocation2, (((float) this.f25133m) * 0.87266463f) / ((float) this.f25134n));
                    } else {
                        GLES20.glUniform1f(glGetUniformLocation, (((float) this.f25134n) * 0.87266463f) / ((float) this.f25133m));
                        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                    }
                    this.f25120A = false;
                }
                try {
                    synchronized (this.f25142v) {
                        if (!this.f25121B && !this.f25120A && this.f25139s == 0) {
                            this.f25142v.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            zzbad.m26359d("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            zzbad.m26356b("SphericalVideoProcessor died.", th);
            zzk.zzlk().mo30168a(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.f25122b.mo28003b();
            this.f25135o.setOnFrameAvailableListener(null);
            this.f25135o = null;
            m26508d();
        }
    }

    /* renamed from: a */
    public final void mo30422a(float f, float f2) {
        float f3;
        float f4;
        int i = this.f25134n;
        int i2 = this.f25133m;
        if (i > i2) {
            f4 = (f * 1.7453293f) / ((float) i);
            f3 = (f2 * 1.7453293f) / ((float) i);
        } else {
            f4 = (f * 1.7453293f) / ((float) i2);
            f3 = (f2 * 1.7453293f) / ((float) i2);
        }
        this.f25131k -= f4;
        this.f25132l -= f3;
        if (this.f25132l < -1.5707964f) {
            this.f25132l = -1.5707964f;
        }
        if (this.f25132l > 1.5707964f) {
            this.f25132l = 1.5707964f;
        }
    }

    /* renamed from: a */
    private static void m26506a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    /* renamed from: a */
    private static void m26505a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    /* renamed from: b */
    private static void m26507b(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    /* renamed from: a */
    private static int m26503a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m26504a("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        m26504a("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        m26504a("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        m26504a("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        String str2 = "SphericalVideoRenderer";
        Log.e(str2, sb.toString());
        Log.e(str2, GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        m26504a("deleteShader");
        return 0;
    }

    @VisibleForTesting
    /* renamed from: d */
    private final boolean m26508d() {
        EGLSurface eGLSurface = this.f25146z;
        boolean z = false;
        if (eGLSurface != null) {
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                z = this.f25143w.eglDestroySurface(this.f25144x, this.f25146z) | this.f25143w.eglMakeCurrent(this.f25144x, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT) | false;
                this.f25146z = null;
            }
        }
        EGLContext eGLContext = this.f25145y;
        if (eGLContext != null) {
            z |= this.f25143w.eglDestroyContext(this.f25144x, eGLContext);
            this.f25145y = null;
        }
        EGLDisplay eGLDisplay = this.f25144x;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.f25143w.eglTerminate(eGLDisplay);
        this.f25144x = null;
        return eglTerminate;
    }

    /* renamed from: a */
    private static void m26504a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }
}
