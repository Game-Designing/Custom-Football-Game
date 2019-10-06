package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzaqd {

    /* renamed from: a */
    private static final Object f24583a = new Object();
    @VisibleForTesting

    /* renamed from: b */
    private static boolean f24584b = false;
    @VisibleForTesting

    /* renamed from: c */
    private static boolean f24585c = false;
    @VisibleForTesting

    /* renamed from: d */
    private zzdah f24586d;

    /* renamed from: b */
    public final boolean mo30001b(Context context) {
        synchronized (f24583a) {
            if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue()) {
                return false;
            }
            if (f24584b) {
                return true;
            }
            try {
                m25666c(context);
                boolean g = this.f24586d.mo31347g(ObjectWrapper.m22188a(context));
                f24584b = g;
                return g;
            } catch (RemoteException e) {
                e = e;
                zzbad.m26360d("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzbad.m26360d("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private final void m25666c(Context context) {
        synchronized (f24583a) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue() && !f24585c) {
                try {
                    f24585c = true;
                    this.f24586d = (zzdah) zzbae.m26364a(context, "com.google.android.gms.ads.omid.DynamiteOmid", C9596nb.f22798a);
                } catch (zzbag e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    /* renamed from: a */
    public final String mo29997a(Context context) {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue()) {
            return null;
        }
        try {
            m25666c(context);
            String str = "a.";
            String valueOf = String.valueOf(this.f24586d.getVersion());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (RemoteException | NullPointerException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return null;
        }
    }

    /* renamed from: a */
    public final IObjectWrapper mo29995a(String str, WebView webView, String str2, String str3, String str4) {
        return mo29996a(str, webView, str2, str3, str4, "Google");
    }

    /* renamed from: a */
    public final IObjectWrapper mo29996a(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (f24583a) {
            try {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue()) {
                    if (f24584b) {
                        try {
                            return this.f24586d.mo31345a(str, ObjectWrapper.m22188a(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzbad.m26360d("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void mo29998a(IObjectWrapper iObjectWrapper) {
        synchronized (f24583a) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue()) {
                if (f24584b) {
                    try {
                        this.f24586d.mo31349p(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbad.m26360d("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo30000b(IObjectWrapper iObjectWrapper) {
        synchronized (f24583a) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue()) {
                if (f24584b) {
                    try {
                        this.f24586d.mo31350q(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbad.m26360d("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo29999a(IObjectWrapper iObjectWrapper, View view) {
        synchronized (f24583a) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue()) {
                if (f24584b) {
                    try {
                        this.f24586d.mo31346a(iObjectWrapper, ObjectWrapper.m22188a(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzbad.m26360d("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }
}
