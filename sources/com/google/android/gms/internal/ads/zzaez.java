package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzaez extends NativeAppInstallAd {

    /* renamed from: a */
    private final zzaew f24283a;

    /* renamed from: b */
    private final List<Image> f24284b = new ArrayList();

    /* renamed from: c */
    private final zzael f24285c;

    /* renamed from: d */
    private final VideoController f24286d = new VideoController();

    /* renamed from: e */
    private final AdChoicesInfo f24287e;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e A[Catch:{ RemoteException -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0022 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaez(com.google.android.gms.internal.ads.zzaew r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.f24284b = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.f24286d = r1
            r5.f24283a = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzaew r1 = r5.f24283a     // Catch:{ RemoteException -> 0x005a }
            java.util.List r1 = r1.mo29664q()     // Catch:{ RemoteException -> 0x005a }
            if (r1 == 0) goto L_0x0059
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x005a }
        L_0x0022:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x0059
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x005a }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005a }
            if (r3 == 0) goto L_0x004a
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x004a
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005a }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaei     // Catch:{ RemoteException -> 0x005a }
            if (r4 == 0) goto L_0x0043
            r2 = r3
            com.google.android.gms.internal.ads.zzaei r2 = (com.google.android.gms.internal.ads.zzaei) r2     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004b
        L_0x0043:
            com.google.android.gms.internal.ads.zzaek r3 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x005a }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005a }
            r2 = r3
            goto L_0x004b
        L_0x004a:
            r2 = r6
        L_0x004b:
            if (r2 == 0) goto L_0x0058
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.f24284b     // Catch:{ RemoteException -> 0x005a }
            com.google.android.gms.internal.ads.zzael r4 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x005a }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x005a }
            r3.add(r4)     // Catch:{ RemoteException -> 0x005a }
        L_0x0058:
            goto L_0x0022
        L_0x0059:
            goto L_0x005e
        L_0x005a:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
        L_0x005e:
            com.google.android.gms.internal.ads.zzaew r1 = r5.f24283a     // Catch:{ RemoteException -> 0x0070 }
            com.google.android.gms.internal.ads.zzaei r1 = r1.mo29665t()     // Catch:{ RemoteException -> 0x0070 }
            if (r1 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x0070 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x0070 }
            goto L_0x006e
        L_0x006d:
            r2 = r6
        L_0x006e:
            goto L_0x0075
        L_0x0070:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
            r2 = r6
        L_0x0075:
            r5.f24285c = r2
            com.google.android.gms.internal.ads.zzaew r1 = r5.f24283a     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzaea r1 = r1.mo29659l()     // Catch:{ RemoteException -> 0x008d }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzaed r1 = new com.google.android.gms.internal.ads.zzaed     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzaew r2 = r5.f24283a     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzaea r2 = r2.mo29659l()     // Catch:{ RemoteException -> 0x008d }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x008d }
            r6 = r1
        L_0x008c:
            goto L_0x0091
        L_0x008d:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
        L_0x0091:
            r5.f24287e = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaez.<init>(com.google.android.gms.internal.ads.zzaew):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final IObjectWrapper mo26460a() {
        try {
            return this.f24283a.mo29667v();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.f24283a.mo29652d(bundle);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f24283a.mo29650b(bundle);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f24283a.mo29651c(bundle);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.f24283a.mo29662o();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final List<Image> getImages() {
        return this.f24284b;
    }

    public final CharSequence getBody() {
        try {
            return this.f24283a.mo29663p();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Image getIcon() {
        return this.f24285c;
    }

    public final CharSequence getCallToAction() {
        try {
            return this.f24283a.mo29660m();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double j = this.f24283a.mo29658j();
            if (j == -1.0d) {
                return null;
            }
            return Double.valueOf(j);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final CharSequence getStore() {
        try {
            return this.f24283a.getStore();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final CharSequence getPrice() {
        try {
            return this.f24283a.mo29666u();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.f24283a.getVideoController() != null) {
                this.f24286d.zza(this.f24283a.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.m26356b("Exception occurred while getting video controller", e);
        }
        return this.f24286d;
    }

    public final AdChoicesInfo getAdChoicesInfo() {
        return this.f24287e;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.f24283a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.f24283a.getExtras();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.f24283a.destroy();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
