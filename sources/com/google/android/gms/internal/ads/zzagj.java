package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzagj extends UnifiedNativeAd {

    /* renamed from: a */
    private final zzagg f24305a;

    /* renamed from: b */
    private final List<Image> f24306b = new ArrayList();

    /* renamed from: c */
    private final zzael f24307c;

    /* renamed from: d */
    private final VideoController f24308d = new VideoController();

    /* renamed from: e */
    private final AdChoicesInfo f24309e;

    /* renamed from: f */
    private final List<MuteThisAdReason> f24310f = new ArrayList();

    /* renamed from: g */
    private final zza f24311g;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[Catch:{ RemoteException -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagj(com.google.android.gms.internal.ads.zzagg r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.f24306b = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.f24308d = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.f24310f = r1
            r5.f24305a = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzagg r1 = r5.f24305a     // Catch:{ RemoteException -> 0x0061 }
            java.util.List r1 = r1.mo29729q()     // Catch:{ RemoteException -> 0x0061 }
            if (r1 == 0) goto L_0x0060
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0061 }
        L_0x0029:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0061 }
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0061 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0061 }
            if (r3 == 0) goto L_0x0051
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0061 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x0061 }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaei     // Catch:{ RemoteException -> 0x0061 }
            if (r4 == 0) goto L_0x004a
            r2 = r3
            com.google.android.gms.internal.ads.zzaei r2 = (com.google.android.gms.internal.ads.zzaei) r2     // Catch:{ RemoteException -> 0x0061 }
            goto L_0x0052
        L_0x004a:
            com.google.android.gms.internal.ads.zzaek r3 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x0061 }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x0061 }
            r2 = r3
            goto L_0x0052
        L_0x0051:
            r2 = r6
        L_0x0052:
            if (r2 == 0) goto L_0x005f
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.f24306b     // Catch:{ RemoteException -> 0x0061 }
            com.google.android.gms.internal.ads.zzael r4 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x0061 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0061 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0061 }
        L_0x005f:
            goto L_0x0029
        L_0x0060:
            goto L_0x0065
        L_0x0061:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
        L_0x0065:
            com.google.android.gms.internal.ads.zzagg r1 = r5.f24305a     // Catch:{ RemoteException -> 0x0097 }
            java.util.List r1 = r1.mo29710Qa()     // Catch:{ RemoteException -> 0x0097 }
            if (r1 == 0) goto L_0x0096
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0097 }
        L_0x0071:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0097 }
            if (r2 == 0) goto L_0x0096
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0097 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0097 }
            if (r3 == 0) goto L_0x0087
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0097 }
            com.google.android.gms.internal.ads.zzaak r2 = com.google.android.gms.internal.ads.zzaal.m24510a(r2)     // Catch:{ RemoteException -> 0x0097 }
            goto L_0x0088
        L_0x0087:
            r2 = r6
        L_0x0088:
            if (r2 == 0) goto L_0x0095
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.f24310f     // Catch:{ RemoteException -> 0x0097 }
            com.google.android.gms.internal.ads.zzaan r4 = new com.google.android.gms.internal.ads.zzaan     // Catch:{ RemoteException -> 0x0097 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0097 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0097 }
        L_0x0095:
            goto L_0x0071
        L_0x0096:
            goto L_0x009b
        L_0x0097:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
        L_0x009b:
            com.google.android.gms.internal.ads.zzagg r1 = r5.f24305a     // Catch:{ RemoteException -> 0x00ad }
            com.google.android.gms.internal.ads.zzaei r1 = r1.mo29731t()     // Catch:{ RemoteException -> 0x00ad }
            if (r1 == 0) goto L_0x00aa
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x00ad }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x00ad }
            goto L_0x00ab
        L_0x00aa:
            r2 = r6
        L_0x00ab:
            goto L_0x00b2
        L_0x00ad:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
            r2 = r6
        L_0x00b2:
            r5.f24307c = r2
            com.google.android.gms.internal.ads.zzagg r1 = r5.f24305a     // Catch:{ RemoteException -> 0x00cb }
            com.google.android.gms.internal.ads.zzaea r1 = r1.mo29724l()     // Catch:{ RemoteException -> 0x00cb }
            if (r1 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzaed r1 = new com.google.android.gms.internal.ads.zzaed     // Catch:{ RemoteException -> 0x00cb }
            com.google.android.gms.internal.ads.zzagg r2 = r5.f24305a     // Catch:{ RemoteException -> 0x00cb }
            com.google.android.gms.internal.ads.zzaea r2 = r2.mo29724l()     // Catch:{ RemoteException -> 0x00cb }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x00cb }
            goto L_0x00ca
        L_0x00c9:
            r1 = r6
        L_0x00ca:
            goto L_0x00d0
        L_0x00cb:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
            r1 = r6
        L_0x00d0:
            r5.f24309e = r1
            com.google.android.gms.internal.ads.zzagg r1 = r5.f24305a     // Catch:{ RemoteException -> 0x00e8 }
            com.google.android.gms.internal.ads.zzaee r1 = r1.mo29709Ha()     // Catch:{ RemoteException -> 0x00e8 }
            if (r1 == 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzaeh r1 = new com.google.android.gms.internal.ads.zzaeh     // Catch:{ RemoteException -> 0x00e8 }
            com.google.android.gms.internal.ads.zzagg r2 = r5.f24305a     // Catch:{ RemoteException -> 0x00e8 }
            com.google.android.gms.internal.ads.zzaee r2 = r2.mo29709Ha()     // Catch:{ RemoteException -> 0x00e8 }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x00e8 }
            r6 = r1
        L_0x00e7:
            goto L_0x00ec
        L_0x00e8:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
        L_0x00ec:
            r5.f24311g = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagj.<init>(com.google.android.gms.internal.ads.zzagg):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final IObjectWrapper mo26573a() {
        try {
            return this.f24305a.mo29734v();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Object zzkv() {
        try {
            IObjectWrapper n = this.f24305a.mo29726n();
            if (n != null) {
                return ObjectWrapper.m22187H(n);
            }
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return null;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.f24305a.mo29717d(bundle);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f24305a.mo29715b(bundle);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f24305a.mo29716c(bundle);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final String getHeadline() {
        try {
            return this.f24305a.mo29727o();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final List<Image> getImages() {
        return this.f24306b;
    }

    public final String getBody() {
        try {
            return this.f24305a.mo29728p();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Image getIcon() {
        return this.f24307c;
    }

    public final String getCallToAction() {
        try {
            return this.f24305a.mo29725m();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double j = this.f24305a.mo29723j();
            if (j == -1.0d) {
                return null;
            }
            return Double.valueOf(j);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.f24305a.getStore();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final String getPrice() {
        try {
            return this.f24305a.mo29732u();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.f24305a.getVideoController() != null) {
                this.f24308d.zza(this.f24305a.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.m26356b("Exception occurred while getting video controller", e);
        }
        return this.f24308d;
    }

    public final AdChoicesInfo getAdChoicesInfo() {
        return this.f24309e;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.f24305a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.f24305a.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return new Bundle();
    }

    public final void enableCustomClickGesture() {
        try {
            this.f24305a.mo29736y();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.f24305a.mo29733ua();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.f24310f;
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.f24305a.mo29711X();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return false;
        }
    }

    public final void destroy() {
        try {
            this.f24305a.destroy();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void setUnconfirmedClickListener(UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.f24305a.mo29714a((zzagd) new zzagt(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzbad.m26356b("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbad.m26355b("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.f24305a.mo29713a((zzaak) null);
            } else if (muteThisAdReason instanceof zzaan) {
                this.f24305a.mo29713a(((zzaan) muteThisAdReason).mo29362a());
            } else {
                zzbad.m26355b("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.f24305a.mo29712a((zzaag) new zzaaj(muteThisAdListener));
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.f24305a.mo29730r();
        } catch (RemoteException e) {
            zzbad.m26356b("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final String getAdvertiser() {
        try {
            return this.f24305a.mo29735x();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            return null;
        }
    }
}
