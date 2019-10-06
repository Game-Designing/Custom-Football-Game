package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

@zzard
public final class zzafh implements NativeCustomTemplateAd {

    /* renamed from: a */
    private static WeakHashMap<IBinder, zzafh> f24295a = new WeakHashMap<>();

    /* renamed from: b */
    private final zzafe f24296b;

    /* renamed from: c */
    private final MediaView f24297c;

    /* renamed from: d */
    private final VideoController f24298d = new VideoController();

    @VisibleForTesting
    private zzafh(zzafe zzafe) {
        Context context;
        String str = "";
        this.f24296b = zzafe;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.m22187H(zzafe.mo29690la());
        } catch (RemoteException | NullPointerException e) {
            zzbad.m26356b(str, e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.f24296b.mo29689j(ObjectWrapper.m22188a(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzbad.m26356b(str, e2);
            }
        }
        this.f24297c = mediaView;
    }

    /* renamed from: a */
    public static zzafh m24940a(zzafe zzafe) {
        synchronized (f24295a) {
            zzafh zzafh = (zzafh) f24295a.get(zzafe.asBinder());
            if (zzafh != null) {
                return zzafh;
            }
            zzafh zzafh2 = new zzafh(zzafe);
            f24295a.put(zzafe.asBinder(), zzafh2);
            return zzafh2;
        }
    }

    /* renamed from: a */
    public final zzafe mo29696a() {
        return this.f24296b;
    }

    public final CharSequence getText(String str) {
        try {
            return this.f24296b.mo29691m(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Image getImage(String str) {
        try {
            zzaei o = this.f24296b.mo29692o(str);
            if (o != null) {
                return new zzael(o);
            }
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return null;
    }

    public final VideoController getVideoController() {
        try {
            zzaar videoController = this.f24296b.getVideoController();
            if (videoController != null) {
                this.f24298d.zza(videoController);
            }
        } catch (RemoteException e) {
            zzbad.m26356b("Exception occurred while getting video controller", e);
        }
        return this.f24298d;
    }

    public final MediaView getVideoMediaView() {
        return this.f24297c;
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.f24296b.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.f24296b.getCustomTemplateId();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.f24296b.performClick(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.f24296b.recordImpression();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void destroy() {
        try {
            this.f24296b.destroy();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
