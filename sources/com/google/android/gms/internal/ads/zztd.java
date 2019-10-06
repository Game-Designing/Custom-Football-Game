package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
public final class zztd extends Surface {

    /* renamed from: a */
    private static boolean f29364a;

    /* renamed from: b */
    private static boolean f29365b;

    /* renamed from: c */
    private final boolean f29366c;

    /* renamed from: d */
    private final C9306_s f29367d;

    /* renamed from: e */
    private boolean f29368e;

    /* renamed from: a */
    public static synchronized boolean m31164a(Context context) {
        boolean z;
        synchronized (zztd.class) {
            if (!f29365b) {
                if (zzsy.f29345a >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzsy.f29345a == 24 && (zzsy.f29348d.startsWith("SM-G950") || zzsy.f29348d.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    f29364a = z2;
                }
                f29365b = true;
            }
            z = f29364a;
        }
        return z;
    }

    /* renamed from: a */
    public static zztd m31163a(Context context, boolean z) {
        if (zzsy.f29345a >= 17) {
            zzsk.m31082b(!z || m31164a(context));
            return new C9306_s().mo28839a(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    private zztd(C9306_s _sVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f29367d = _sVar;
        this.f29366c = z;
    }

    public final void release() {
        super.release();
        synchronized (this.f29367d) {
            if (!this.f29368e) {
                this.f29367d.mo28840a();
                this.f29368e = true;
            }
        }
    }
}
