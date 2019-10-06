package com.unity3d.services.p265ar.view;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.unity3d.services.ar.view.GLSurfaceView */
public class GLSurfaceView extends SurfaceView implements Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    /* access modifiers changed from: private */
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private final WeakReference<GLSurfaceView> mThisWeakRef = new WeakReference<>(this);

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$BaseConfigChooser */
    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        /* access modifiers changed from: 0000 */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] configSpec) {
            this.mConfigSpec = filterConfigSpec(configSpec);
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] num_config = new int[1];
            if (egl.eglChooseConfig(display, this.mConfigSpec, null, 0, num_config)) {
                int numConfigs = num_config[0];
                if (numConfigs > 0) {
                    EGLConfig[] configs = new EGLConfig[numConfigs];
                    if (egl.eglChooseConfig(display, this.mConfigSpec, configs, numConfigs, num_config)) {
                        EGLConfig config = chooseConfig(egl, display, configs);
                        if (config != null) {
                            return config;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] configSpec) {
            if (GLSurfaceView.this.mEGLContextClientVersion != 2 && GLSurfaceView.this.mEGLContextClientVersion != 3) {
                return configSpec;
            }
            int len = configSpec.length;
            int[] newConfigSpec = new int[(len + 2)];
            System.arraycopy(configSpec, 0, newConfigSpec, 0, len - 1);
            newConfigSpec[len - 1] = 12352;
            if (GLSurfaceView.this.mEGLContextClientVersion == 2) {
                newConfigSpec[len] = 4;
            } else {
                newConfigSpec[len] = 64;
            }
            newConfigSpec[len + 1] = 12344;
            return newConfigSpec;
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$ComponentSizeChooser */
    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
            super(new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344});
            this.mRedSize = redSize;
            this.mGreenSize = greenSize;
            this.mBlueSize = blueSize;
            this.mAlphaSize = alphaSize;
            this.mDepthSize = depthSize;
            this.mStencilSize = stencilSize;
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            EGLConfig[] eGLConfigArr;
            for (EGLConfig config : configs) {
                EGL10 egl10 = egl;
                EGLDisplay eGLDisplay = display;
                EGLConfig eGLConfig = config;
                int d = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int s = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (d >= this.mDepthSize && s >= this.mStencilSize) {
                    EGL10 egl102 = egl;
                    EGLDisplay eGLDisplay2 = display;
                    EGLConfig eGLConfig2 = config;
                    int r = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12324, 0);
                    int g = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12323, 0);
                    int b = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12322, 0);
                    int a = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12321, 0);
                    if (r == this.mRedSize && g == this.mGreenSize && b == this.mBlueSize && a == this.mAlphaSize) {
                        return config;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            if (egl.eglGetConfigAttrib(display, config, attribute, this.mValue)) {
                return this.mValue[0];
            }
            return defaultValue;
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$DefaultContextFactory */
    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig config) {
            return egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, GLSurfaceView.this.mEGLContextClientVersion != 0 ? new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceView.this.mEGLContextClientVersion, 12344} : null);
        }

        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
            if (!egl.eglDestroyContext(display, context)) {
                StringBuilder sb = new StringBuilder();
                sb.append("display:");
                sb.append(display);
                sb.append(" context: ");
                sb.append(context);
                Log.e("DefaultContextFactory", sb.toString());
                EglHelper.throwEglException("eglDestroyContex", egl.eglGetError());
                throw null;
            }
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$DefaultWindowSurfaceFactory */
    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display, EGLConfig config, Object nativeWindow) {
            try {
                return egl.eglCreateWindowSurface(display, config, nativeWindow, null);
            } catch (IllegalArgumentException e) {
                Log.e(GLSurfaceView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl, EGLDisplay display, EGLSurface surface) {
            egl.eglDestroySurface(display, surface);
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EGLConfigChooser */
    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EGLContextFactory */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EGLWindowSurfaceFactory */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EglHelper */
    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLSurfaceView> glSurfaceViewWeakRef) {
            this.mGLSurfaceViewWeakRef = glSurfaceViewWeakRef;
        }

        public void start() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eGLDisplay, new int[2])) {
                    GLSurfaceView view = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                    if (view == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = view.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = view.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                        throw null;
                    }
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GLSurfaceView view = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (view != null) {
                    this.mEglSurface = view.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, view.getHolder());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                    return true;
                } else {
                    logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: 0000 */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLSurfaceView view = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
            if (view == null) {
                return gl;
            }
            if (view.mGLWrapper != null) {
                gl = view.mGLWrapper.wrap(gl);
            }
            if ((view.mDebugFlags & 3) == 0) {
                return gl;
            }
            int configFlags = 0;
            Writer log = null;
            if ((view.mDebugFlags & 1) != 0) {
                configFlags = 0 | 1;
            }
            if ((view.mDebugFlags & 2) != 0) {
                log = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, configFlags, log);
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return 12288;
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null) {
                EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
                if (eGLSurface != eGLSurface2) {
                    this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                    GLSurfaceView view = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                    if (view != null) {
                        view.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                    }
                    this.mEglSurface = null;
                }
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                GLSurfaceView view = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (view != null) {
                    view.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String function) {
            throwEglException(function, this.mEgl.eglGetError());
            throw null;
        }

        public static void throwEglException(String function, int error) {
            throw new RuntimeException(formatEglError(function, error));
        }

        public static void logEglErrorAsWarning(String tag, String function, int error) {
            Log.w(tag, formatEglError(function, error));
        }

        public static String formatEglError(String function, int error) {
            return "";
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$GLThread */
    static class GLThread extends Thread {
        private boolean mDidDraw;
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private Runnable mFinishDrawingRunnable = null;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mRequestSwap;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;

        GLThread(WeakReference<GLSurfaceView> glSurfaceViewWeakRef) {
            this.mGLSurfaceViewWeakRef = glSurfaceViewWeakRef;
        }

        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("GLThread ");
            sb.append(getId());
            setName(sb.toString());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                GLSurfaceView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLSurfaceView.sGLThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:121:0x015c, code lost:
            if (r14 == null) goto L_0x0166;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
            r14.run();
            r14 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x0166, code lost:
            if (r4 == false) goto L_0x019f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x016e, code lost:
            if (r1.mEglHelper.createSurface() == false) goto L_0x0186;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0170, code lost:
            r15 = com.unity3d.services.p265ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x0174, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            com.unity3d.services.p265ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x017f, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0180, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0186, code lost:
            r15 = com.unity3d.services.p265ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x018a, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            r1.mSurfaceIsBad = true;
            com.unity3d.services.p265ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0197, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x01a1, code lost:
            if (r11 == false) goto L_0x01e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x01a5, code lost:
            if (r1.mDidDraw == false) goto L_0x01e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x01a7, code lost:
            r1.mDidDraw = false;
            r11 = false;
            r19 = r2;
            r2 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x01b7, code lost:
            if (r2 == 12288) goto L_0x01e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x01bb, code lost:
            if (r2 == 12302) goto L_0x01d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x01bd, code lost:
            com.unity3d.services.p265ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r2);
            r15 = com.unity3d.services.p265ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x01c8, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
            r1.mSurfaceIsBad = true;
            com.unity3d.services.p265ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x01d3, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x01d8, code lost:
            r6 = true;
            r2 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x01e0, code lost:
            r2 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x01e6, code lost:
            r19 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x01e8, code lost:
            if (r5 == false) goto L_0x01f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x01ea, code lost:
            r5 = false;
            r2 = (javax.microedition.khronos.opengles.GL10) r1.mEglHelper.createGL();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x01f6, code lost:
            r2 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x01f8, code lost:
            if (r3 == false) goto L_0x0216;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x01fa, code lost:
            r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0202, code lost:
            if (r0 == null) goto L_0x0212;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0204, code lost:
            r19 = r0;
            com.unity3d.services.p265ar.view.GLSurfaceView.access$1000(r0).onSurfaceCreated(r2, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0212, code lost:
            r19 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x0214, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0216, code lost:
            if (r7 == false) goto L_0x022a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0218, code lost:
            r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0220, code lost:
            if (r0 == null) goto L_0x0229;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0222, code lost:
            com.unity3d.services.p265ar.view.GLSurfaceView.access$1000(r0).onSurfaceChanged(r2, r12, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0229, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x022a, code lost:
            r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0232, code lost:
            if (r0 == null) goto L_0x0246;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0234, code lost:
            com.unity3d.services.p265ar.view.GLSurfaceView.access$1000(r0).onDrawFrame(r2);
            r1.mDidDraw = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x023e, code lost:
            if (r16 == null) goto L_0x0246;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0240, code lost:
            r16.run();
            r16 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0249, code lost:
            if (r1.mRenderMode != 1) goto L_0x0280;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x024b, code lost:
            r11 = false;
            r15 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0255, code lost:
            if (r15 == 12288) goto L_0x027d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x0259, code lost:
            if (r15 == 12302) goto L_0x0278;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x025b, code lost:
            r17 = r2;
            com.unity3d.services.p265ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r15);
            r2 = com.unity3d.services.p265ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0268, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
            r1.mSurfaceIsBad = true;
            com.unity3d.services.p265ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0273, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x0278, code lost:
            r17 = r2;
            r6 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x027d, code lost:
            r17 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x0280, code lost:
            r17 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x0282, code lost:
            if (r8 == false) goto L_0x028c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x0284, code lost:
            r9 = true;
            r8 = false;
            r2 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x028c, code lost:
            r2 = r17;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r20 = this;
                r1 = r20
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = new com.unity3d.services.ar.view.GLSurfaceView$EglHelper
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r2 = r1.mGLSurfaceViewWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r1.mWantRenderNotification = r0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = r15
            L_0x0022:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r17 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02ba }
                monitor-enter(r17)     // Catch:{ all -> 0x02ba }
            L_0x0027:
                boolean r15 = r1.mShouldExit     // Catch:{ all -> 0x02b3 }
                if (r15 == 0) goto L_0x0041
                monitor-exit(r17)     // Catch:{ all -> 0x003c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r15)
                r20.stopEglSurfaceLocked()     // Catch:{ all -> 0x0039 }
                r20.stopEglContextLocked()     // Catch:{ all -> 0x0039 }
                monitor-exit(r15)     // Catch:{ all -> 0x0039 }
                return
            L_0x0039:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0039 }
                throw r0
            L_0x003c:
                r0 = move-exception
                r19 = r2
                goto L_0x02b6
            L_0x0041:
                java.util.ArrayList<java.lang.Runnable> r15 = r1.mEventQueue     // Catch:{ all -> 0x02b3 }
                boolean r15 = r15.isEmpty()     // Catch:{ all -> 0x02b3 }
                if (r15 != 0) goto L_0x0056
                java.util.ArrayList<java.lang.Runnable> r15 = r1.mEventQueue     // Catch:{ all -> 0x003c }
                r0 = 0
                java.lang.Object r15 = r15.remove(r0)     // Catch:{ all -> 0x003c }
                java.lang.Runnable r15 = (java.lang.Runnable) r15     // Catch:{ all -> 0x003c }
                r0 = r15
                r14 = r0
                goto L_0x015b
            L_0x0056:
                r0 = 0
                boolean r15 = r1.mPaused     // Catch:{ all -> 0x02b3 }
                r18 = r0
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x02b3 }
                if (r15 == r0) goto L_0x006e
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x003c }
                boolean r15 = r1.mRequestPaused     // Catch:{ all -> 0x003c }
                r1.mPaused = r15     // Catch:{ all -> 0x003c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r15.notifyAll()     // Catch:{ all -> 0x003c }
                r18 = r0
            L_0x006e:
                boolean r0 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x02b3 }
                if (r0 == 0) goto L_0x007c
                r20.stopEglSurfaceLocked()     // Catch:{ all -> 0x003c }
                r20.stopEglContextLocked()     // Catch:{ all -> 0x003c }
                r0 = 0
                r1.mShouldReleaseEglContext = r0     // Catch:{ all -> 0x003c }
                r10 = 1
            L_0x007c:
                if (r6 == 0) goto L_0x0086
                r20.stopEglSurfaceLocked()     // Catch:{ all -> 0x003c }
                r20.stopEglContextLocked()     // Catch:{ all -> 0x003c }
                r0 = 0
                r6 = r0
            L_0x0086:
                if (r18 == 0) goto L_0x008f
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x003c }
                if (r0 == 0) goto L_0x008f
                r20.stopEglSurfaceLocked()     // Catch:{ all -> 0x003c }
            L_0x008f:
                if (r18 == 0) goto L_0x00ab
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x003c }
                if (r0 == 0) goto L_0x00ab
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x003c }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003c }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x003c }
                if (r0 != 0) goto L_0x00a1
                r15 = 0
                goto L_0x00a5
            L_0x00a1:
                boolean r15 = r0.mPreserveEGLContextOnPause     // Catch:{ all -> 0x003c }
            L_0x00a5:
                if (r15 != 0) goto L_0x00ab
                r20.stopEglContextLocked()     // Catch:{ all -> 0x003c }
            L_0x00ab:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x02b3 }
                if (r0 != 0) goto L_0x00c7
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x003c }
                if (r0 != 0) goto L_0x00c7
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x003c }
                if (r0 == 0) goto L_0x00ba
                r20.stopEglSurfaceLocked()     // Catch:{ all -> 0x003c }
            L_0x00ba:
                r0 = 1
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x003c }
                r0 = 0
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x003c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r0.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x00c7:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x02b3 }
                if (r0 == 0) goto L_0x00d9
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x003c }
                if (r0 == 0) goto L_0x00d9
                r0 = 0
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x003c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r0.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x00d9:
                if (r9 == 0) goto L_0x00e9
                r0 = 0
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x003c }
                r9 = 0
                r0 = 1
                r1.mRenderComplete = r0     // Catch:{ all -> 0x003c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r0.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x00e9:
                java.lang.Runnable r0 = r1.mFinishDrawingRunnable     // Catch:{ all -> 0x02b3 }
                if (r0 == 0) goto L_0x00f5
                java.lang.Runnable r0 = r1.mFinishDrawingRunnable     // Catch:{ all -> 0x003c }
                r16 = r0
                r0 = 0
                r1.mFinishDrawingRunnable = r0     // Catch:{ all -> 0x003c }
                goto L_0x00f6
            L_0x00f5:
                r0 = 0
            L_0x00f6:
                boolean r15 = r20.readyToDraw()     // Catch:{ all -> 0x02b3 }
                if (r15 == 0) goto L_0x0295
                boolean r15 = r1.mHaveEglContext     // Catch:{ all -> 0x02b3 }
                if (r15 != 0) goto L_0x0120
                if (r10 == 0) goto L_0x0104
                r10 = 0
                goto L_0x0120
            L_0x0104:
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r15 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x0116 }
                r15.start()     // Catch:{ RuntimeException -> 0x0116 }
                r15 = 1
                r1.mHaveEglContext = r15     // Catch:{ all -> 0x003c }
                r3 = 1
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r15.notifyAll()     // Catch:{ all -> 0x003c }
                goto L_0x0120
            L_0x0116:
                r0 = move-exception
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r15.releaseEglContextLocked(r1)     // Catch:{ all -> 0x003c }
                throw r0     // Catch:{ all -> 0x003c }
            L_0x0120:
                boolean r15 = r1.mHaveEglContext     // Catch:{ all -> 0x02b3 }
                if (r15 == 0) goto L_0x012e
                boolean r15 = r1.mHaveEglSurface     // Catch:{ all -> 0x003c }
                if (r15 != 0) goto L_0x012e
                r15 = 1
                r1.mHaveEglSurface = r15     // Catch:{ all -> 0x003c }
                r4 = 1
                r5 = 1
                r7 = 1
            L_0x012e:
                boolean r15 = r1.mHaveEglSurface     // Catch:{ all -> 0x02b3 }
                if (r15 == 0) goto L_0x0292
                boolean r15 = r1.mSizeChanged     // Catch:{ all -> 0x02b3 }
                if (r15 == 0) goto L_0x0144
                r7 = 1
                int r15 = r1.mWidth     // Catch:{ all -> 0x003c }
                r12 = r15
                int r15 = r1.mHeight     // Catch:{ all -> 0x003c }
                r13 = r15
                r15 = 1
                r1.mWantRenderNotification = r15     // Catch:{ all -> 0x003c }
                r4 = 1
                r15 = 0
                r1.mSizeChanged = r15     // Catch:{ all -> 0x003c }
            L_0x0144:
                r15 = 0
                r1.mRequestRender = r15     // Catch:{ all -> 0x02b3 }
                boolean r0 = r1.mRequestSwap     // Catch:{ all -> 0x02b3 }
                if (r0 == 0) goto L_0x014e
                r1.mRequestSwap = r15     // Catch:{ all -> 0x003c }
                r11 = 1
            L_0x014e:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02b3 }
                r0.notifyAll()     // Catch:{ all -> 0x02b3 }
                boolean r0 = r1.mWantRenderNotification     // Catch:{ all -> 0x02b3 }
                if (r0 == 0) goto L_0x015b
                r0 = 1
                r8 = r0
            L_0x015b:
                monitor-exit(r17)     // Catch:{ all -> 0x02b3 }
                if (r14 == 0) goto L_0x0166
                r14.run()     // Catch:{ all -> 0x02ba }
                r14 = 0
                r0 = 0
                r15 = 0
                goto L_0x0022
            L_0x0166:
                if (r4 == 0) goto L_0x019f
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x02ba }
                boolean r0 = r0.createSurface()     // Catch:{ all -> 0x02ba }
                if (r0 == 0) goto L_0x0186
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02ba }
                monitor-enter(r15)     // Catch:{ all -> 0x02ba }
                r0 = 1
                r1.mFinishedCreatingEglSurface = r0     // Catch:{ all -> 0x0183 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0183 }
                r0.notifyAll()     // Catch:{ all -> 0x0183 }
                monitor-exit(r15)     // Catch:{ all -> 0x0183 }
                r0 = 0
                r4 = r0
                goto L_0x019f
            L_0x0183:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0183 }
                throw r0     // Catch:{ all -> 0x02ba }
            L_0x0186:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02ba }
                monitor-enter(r15)     // Catch:{ all -> 0x02ba }
                r0 = 1
                r1.mFinishedCreatingEglSurface = r0     // Catch:{ all -> 0x019c }
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x019c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x019c }
                r0.notifyAll()     // Catch:{ all -> 0x019c }
                monitor-exit(r15)     // Catch:{ all -> 0x019c }
                r0 = 0
                r15 = 0
                goto L_0x0022
            L_0x019c:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x019c }
                throw r0     // Catch:{ all -> 0x02ba }
            L_0x019f:
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r11 == 0) goto L_0x01e6
                boolean r0 = r1.mDidDraw     // Catch:{ all -> 0x02ba }
                if (r0 == 0) goto L_0x01e6
                r0 = 0
                r1.mDidDraw = r0     // Catch:{ all -> 0x02ba }
                r11 = 0
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x02ba }
                int r0 = r0.swap()     // Catch:{ all -> 0x02ba }
                r18 = r0
                r19 = r2
                r2 = r18
                if (r2 == r15) goto L_0x01df
                r0 = 12302(0x300e, float:1.7239E-41)
                if (r2 == r0) goto L_0x01d8
                java.lang.String r0 = "GLThread"
                java.lang.String r15 = "eglSwapBuffers"
                com.unity3d.services.p265ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning(r0, r15, r2)     // Catch:{ all -> 0x02ba }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r15 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02ba }
                monitor-enter(r15)     // Catch:{ all -> 0x02ba }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x01d5 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x01d5 }
                r0.notifyAll()     // Catch:{ all -> 0x01d5 }
                monitor-exit(r15)     // Catch:{ all -> 0x01d5 }
                goto L_0x01e0
            L_0x01d5:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x01d5 }
                throw r0     // Catch:{ all -> 0x02ba }
            L_0x01d8:
                r6 = 1
                r2 = r19
                r0 = 0
                r15 = 0
                goto L_0x0022
            L_0x01df:
            L_0x01e0:
                r2 = r19
                r0 = 0
                r15 = 0
                goto L_0x0022
            L_0x01e6:
                r19 = r2
                if (r5 == 0) goto L_0x01f6
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x02ba }
                javax.microedition.khronos.opengles.GL r0 = r0.createGL()     // Catch:{ all -> 0x02ba }
                javax.microedition.khronos.opengles.GL10 r0 = (javax.microedition.khronos.opengles.GL10) r0     // Catch:{ all -> 0x02ba }
                r2 = 0
                r5 = r2
                r2 = r0
                goto L_0x01f8
            L_0x01f6:
                r2 = r19
            L_0x01f8:
                if (r3 == 0) goto L_0x0216
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x02ba }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x02ba }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x02ba }
                if (r0 == 0) goto L_0x0212
                com.unity3d.services.ar.view.GLSurfaceView$Renderer r15 = r0.mRenderer     // Catch:{ all -> 0x02ba }
                r19 = r0
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x02ba }
                javax.microedition.khronos.egl.EGLConfig r0 = r0.mEglConfig     // Catch:{ all -> 0x02ba }
                r15.onSurfaceCreated(r2, r0)     // Catch:{ all -> 0x02ba }
                goto L_0x0214
            L_0x0212:
                r19 = r0
            L_0x0214:
                r0 = 0
                r3 = r0
            L_0x0216:
                if (r7 == 0) goto L_0x022a
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x02ba }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x02ba }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x02ba }
                if (r0 == 0) goto L_0x0229
                com.unity3d.services.ar.view.GLSurfaceView$Renderer r15 = r0.mRenderer     // Catch:{ all -> 0x02ba }
                r15.onSurfaceChanged(r2, r12, r13)     // Catch:{ all -> 0x02ba }
            L_0x0229:
                r7 = 0
            L_0x022a:
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x02ba }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x02ba }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p265ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x02ba }
                if (r0 == 0) goto L_0x0246
                com.unity3d.services.ar.view.GLSurfaceView$Renderer r15 = r0.mRenderer     // Catch:{ all -> 0x02ba }
                r15.onDrawFrame(r2)     // Catch:{ all -> 0x02ba }
                r15 = 1
                r1.mDidDraw = r15     // Catch:{ all -> 0x02ba }
                if (r16 == 0) goto L_0x0246
                r16.run()     // Catch:{ all -> 0x02ba }
                r15 = 0
                r16 = r15
            L_0x0246:
                int r0 = r1.mRenderMode     // Catch:{ all -> 0x02ba }
                r15 = 1
                if (r0 != r15) goto L_0x0280
                r11 = 0
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x02ba }
                int r0 = r0.swap()     // Catch:{ all -> 0x02ba }
                r15 = r0
                r0 = 12288(0x3000, float:1.7219E-41)
                if (r15 == r0) goto L_0x027d
                r0 = 12302(0x300e, float:1.7239E-41)
                if (r15 == r0) goto L_0x0278
                java.lang.String r0 = "GLThread"
                r17 = r2
                java.lang.String r2 = "eglSwapBuffers"
                com.unity3d.services.p265ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning(r0, r2, r15)     // Catch:{ all -> 0x02ba }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02ba }
                monitor-enter(r2)     // Catch:{ all -> 0x02ba }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0275 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0275 }
                r0.notifyAll()     // Catch:{ all -> 0x0275 }
                monitor-exit(r2)     // Catch:{ all -> 0x0275 }
                goto L_0x0282
            L_0x0275:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0275 }
                throw r0     // Catch:{ all -> 0x02ba }
            L_0x0278:
                r17 = r2
                r0 = 1
                r6 = r0
                goto L_0x0282
            L_0x027d:
                r17 = r2
                goto L_0x0282
            L_0x0280:
                r17 = r2
            L_0x0282:
                if (r8 == 0) goto L_0x028c
                r9 = 1
                r8 = 0
                r2 = r17
                r0 = 0
                r15 = 0
                goto L_0x0022
            L_0x028c:
                r2 = r17
                r0 = 0
                r15 = 0
                goto L_0x0022
            L_0x0292:
                r19 = r2
                goto L_0x02a6
            L_0x0295:
                r19 = r2
                if (r16 == 0) goto L_0x02a6
                java.lang.String r0 = "GLSurfaceView"
                java.lang.String r2 = "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished."
                android.util.Log.w(r0, r2)     // Catch:{ all -> 0x02b8 }
                r16.run()     // Catch:{ all -> 0x02b8 }
                r0 = 0
                r16 = r0
            L_0x02a6:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02b8 }
                r0.wait()     // Catch:{ all -> 0x02b8 }
                r2 = r19
                r0 = 0
                r15 = 0
                goto L_0x0027
            L_0x02b3:
                r0 = move-exception
                r19 = r2
            L_0x02b6:
                monitor-exit(r17)     // Catch:{ all -> 0x02b8 }
                throw r0     // Catch:{ all -> 0x02ba }
            L_0x02b8:
                r0 = move-exception
                goto L_0x02b6
            L_0x02ba:
                r0 = move-exception
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r2)
                r20.stopEglSurfaceLocked()     // Catch:{ all -> 0x02c8 }
                r20.stopEglContextLocked()     // Catch:{ all -> 0x02c8 }
                monitor-exit(r2)     // Catch:{ all -> 0x02c8 }
                throw r0
            L_0x02c8:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x02c8 }
                goto L_0x02cc
            L_0x02cb:
                throw r0
            L_0x02cc:
                goto L_0x02cb
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p265ar.view.GLSurfaceView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int renderMode) {
            if (renderMode < 0 || renderMode > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRenderMode = renderMode;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (GLSurfaceView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestRender = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void swapBuffers() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestSwap = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndNotify(Runnable finishDrawing) {
            synchronized (GLSurfaceView.sGLThreadManager) {
                if (Thread.currentThread() != this) {
                    this.mWantRenderNotification = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.mFinishDrawingRunnable = finishDrawing;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                }
            }
        }

        public void surfaceCreated() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                GLSurfaceView.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        GLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mHasSurface = false;
                GLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        GLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestPaused = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        GLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        GLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r4, int r5) {
            /*
                r3 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r3.mWidth = r4     // Catch:{ all -> 0x0045 }
                r3.mHeight = r5     // Catch:{ all -> 0x0045 }
                r1 = 1
                r3.mSizeChanged = r1     // Catch:{ all -> 0x0045 }
                r3.mRequestRender = r1     // Catch:{ all -> 0x0045 }
                r1 = 0
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0045 }
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0045 }
                if (r1 != r3) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0019:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0045 }
                r1.notifyAll()     // Catch:{ all -> 0x0045 }
            L_0x0020:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                boolean r1 = r3.ableToDraw()     // Catch:{ all -> 0x0045 }
                if (r1 == 0) goto L_0x0043
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p265ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x003a }
                r1.wait()     // Catch:{ InterruptedException -> 0x003a }
            L_0x0039:
                goto L_0x0020
            L_0x003a:
                r1 = move-exception
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0045 }
                r2.interrupt()     // Catch:{ all -> 0x0045 }
                goto L_0x0039
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0045:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                goto L_0x0049
            L_0x0048:
                throw r1
            L_0x0049:
                goto L_0x0048
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p265ar.view.GLSurfaceView.GLThread.onWindowResize(int, int):void");
        }

        public void requestExitAndWait() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mShouldExit = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        GLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable r) {
            if (r != null) {
                synchronized (GLSurfaceView.sGLThreadManager) {
                    this.mEventQueue.add(r);
                    GLSurfaceView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager */
    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread thread) {
            thread.mExited = true;
            notifyAll();
        }

        public void releaseEglContextLocked(GLThread thread) {
            notifyAll();
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$GLWrapper */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$LogWriter */
    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] buf, int offset, int count) {
            for (int i = 0; i < count; i++) {
                char c = buf[offset + i];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GLSurfaceView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$Renderer */
    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$SimpleEGLConfigChooser */
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean withDepthBuffer) {
            super(8, 8, 8, 0, withDepthBuffer ? 16 : 0, 0);
        }
    }

    public GLSurfaceView(Context context) {
        super(context);
        init();
    }

    public GLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(GLWrapper glWrapper) {
        this.mGLWrapper = glWrapper;
    }

    public void setDebugFlags(int debugFlags) {
        this.mDebugFlags = debugFlags;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean preserveOnPause) {
        this.mPreserveEGLContextOnPause = preserveOnPause;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory factory) {
        checkRenderThreadState();
        this.mEGLContextFactory = factory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory factory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = factory;
    }

    public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = configChooser;
    }

    public void setEGLConfigChooser(boolean needDepth) {
        setEGLConfigChooser((EGLConfigChooser) new SimpleEGLConfigChooser(needDepth));
    }

    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        ComponentSizeChooser componentSizeChooser = new ComponentSizeChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize);
        setEGLConfigChooser((EGLConfigChooser) componentSizeChooser);
    }

    public void setEGLContextClientVersion(int version) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = version;
    }

    public void setRenderMode(int renderMode) {
        this.mGLThread.setRenderMode(renderMode);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void surfaceCreated(SurfaceHolder holder) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        this.mGLThread.onWindowResize(w, h);
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder holder, Runnable finishDrawing) {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestRenderAndNotify(finishDrawing);
        }
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder holder) {
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable r) {
        this.mGLThread.queueEvent(r);
    }

    public void swapBuffers() {
        this.mGLThread.swapBuffers();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            int renderMode = 1;
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                renderMode = gLThread.getRenderMode();
            }
            this.mGLThread = new GLThread(this.mThisWeakRef);
            if (renderMode != 1) {
                this.mGLThread.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
