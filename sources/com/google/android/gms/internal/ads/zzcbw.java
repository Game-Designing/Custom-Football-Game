package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcbw extends zzajb implements OnGlobalLayoutListener, OnScrollChangedListener, zzadv {

    /* renamed from: b */
    private View f26327b;

    /* renamed from: c */
    private zzaar f26328c;

    /* renamed from: d */
    private zzbyn f26329d;

    /* renamed from: e */
    private boolean f26330e = false;

    /* renamed from: f */
    private boolean f26331f = false;

    public zzcbw(zzbyn zzbyn, zzbyt zzbyt) {
        this.f26327b = zzbyt.mo31019q();
        this.f26328c = zzbyt.mo31015m();
        this.f26329d = zzbyn;
        if (zzbyt.mo31020r() != null) {
            zzbyt.mo31020r().mo28720a((zzadv) this);
        }
    }

    /* renamed from: a */
    public final void mo29764a(IObjectWrapper iObjectWrapper, zzajc zzajc) throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        if (this.f26330e) {
            zzbad.m26355b("Instream ad is destroyed already.");
            m28202a(zzajc, 2);
        } else if (this.f26327b == null || this.f26328c == null) {
            String str = "Instream internal error: ";
            String valueOf = String.valueOf(this.f26327b == null ? "can not get video view." : "can not get video controller.");
            zzbad.m26355b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            m28202a(zzajc, 0);
        } else if (this.f26331f) {
            zzbad.m26355b("Instream ad should not be used again.");
            m28202a(zzajc, 1);
        } else {
            this.f26331f = true;
            m28203jb();
            ((ViewGroup) ObjectWrapper.m22187H(iObjectWrapper)).addView(this.f26327b, new LayoutParams(-1, -1));
            zzk.zzmd();
            zzbbz.m26408a(this.f26327b, (OnGlobalLayoutListener) this);
            zzk.zzmd();
            zzbbz.m26409a(this.f26327b, (OnScrollChangedListener) this);
            m28204kb();
            try {
                zzajc.mo29767fb();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    public final zzaar getVideoController() throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        if (!this.f26330e) {
            return this.f26328c;
        }
        zzbad.m26355b("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void destroy() throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        m28203jb();
        zzbyn zzbyn = this.f26329d;
        if (zzbyn != null) {
            zzbyn.mo30853a();
        }
        this.f26329d = null;
        this.f26327b = null;
        this.f26328c = null;
        this.f26330e = true;
    }

    /* renamed from: jb */
    private final void m28203jb() {
        View view = this.f26327b;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f26327b);
            }
        }
    }

    public final void onGlobalLayout() {
        m28204kb();
    }

    public final void onScrollChanged() {
        m28204kb();
    }

    /* renamed from: hb */
    public final void mo29638hb() {
        zzaxi.f24961a.post(new C9317ai(this));
    }

    /* renamed from: kb */
    private final void m28204kb() {
        zzbyn zzbyn = this.f26329d;
        if (zzbyn != null) {
            View view = this.f26327b;
            if (view != null) {
                zzbyn.mo30967a(view, Collections.emptyMap(), Collections.emptyMap(), zzbyn.m27957b(this.f26327b));
            }
        }
    }

    /* renamed from: a */
    private static void m28202a(zzajc zzajc, int i) {
        try {
            zzajc.mo29768m(i);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final /* synthetic */ void mo31106ib() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
