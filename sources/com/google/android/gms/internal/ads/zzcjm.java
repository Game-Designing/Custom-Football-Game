package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt.zza.C15016zza;
import com.google.android.gms.internal.ads.zzwt.zzg;
import com.google.android.gms.internal.ads.zzwt.zzg.zza;
import com.google.android.gms.internal.ads.zzwt.zzg.zzb;
import com.google.android.gms.internal.ads.zzwt.zzi;
import com.google.android.gms.internal.ads.zzwt.zzi.zza.C15017zza;
import com.google.android.gms.internal.ads.zzwt.zzi.zzc;
import java.util.ArrayList;

public final class zzcjm {

    /* renamed from: a */
    private static final SparseArray<zzc> f26709a;

    /* renamed from: b */
    private final Context f26710b;

    /* renamed from: c */
    private final zzbbh<Bundle> f26711c;

    /* renamed from: d */
    private final TelephonyManager f26712d;

    /* renamed from: e */
    private final zzcji f26713e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzcjc f26714f;

    /* renamed from: g */
    private zzwx f26715g;

    zzcjm(Context context, zzbbh<Bundle> zzbbh, zzcji zzcji, zzcjc zzcjc) {
        this.f26710b = context;
        this.f26711c = zzbbh;
        this.f26713e = zzcji;
        this.f26714f = zzcjc;
        this.f26712d = (TelephonyManager) context.getSystemService("phone");
    }

    /* renamed from: b */
    private static zzwx m28497b(boolean z) {
        return z ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final zzg m28491a(Bundle bundle) {
        zzb zzb;
        zza l = zzg.m31366l();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.f26715g = zzwx.ENUM_TRUE;
        } else {
            this.f26715g = zzwx.ENUM_FALSE;
            if (i == 0) {
                l.mo32336a(zzg.zzc.CELL);
            } else if (i != 1) {
                l.mo32336a(zzg.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                l.mo32336a(zzg.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb = zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb = zzb.THREE_G;
                    break;
                case 13:
                    zzb = zzb.LTE;
                    break;
                default:
                    zzb = zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            l.mo32335a(zzb);
        }
        return (zzg) l.mo31612g();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static zzc m28495b(Bundle bundle) {
        return (zzc) f26709a.get(zzcxz.m28989a(zzcxz.m28989a(bundle, "device"), "network").getInt("active_network_state", -1), zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzwt.zza.C15016zza> m28499c(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto L_0x000e
            java.util.List r7 = (java.util.List) r7
            goto L_0x0018
        L_0x000e:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003e
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L_0x0018:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0025:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0038
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
        L_0x0038:
            goto L_0x0025
        L_0x0039:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0042
        L_0x003e:
            java.util.List r7 = java.util.Collections.emptyList()
        L_0x0042:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x004c:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00a6
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L_0x0083;
                case -1052618729: goto L_0x0079;
                case -239580146: goto L_0x006f;
                case 604727084: goto L_0x0065;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x008c
        L_0x0065:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            r2 = 1
            goto L_0x008c
        L_0x006f:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            r2 = 3
            goto L_0x008c
        L_0x0079:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            r2 = 2
            goto L_0x008c
        L_0x0083:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            r2 = 0
        L_0x008c:
            if (r2 == 0) goto L_0x00a0
            if (r2 == r6) goto L_0x009d
            if (r2 == r5) goto L_0x009a
            if (r2 == r4) goto L_0x0097
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C15016zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x00a2
        L_0x0097:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C15016zza.REWARD_BASED_VIDEO_AD
            goto L_0x00a2
        L_0x009a:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C15016zza.NATIVE_APP_INSTALL
            goto L_0x00a2
        L_0x009d:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C15016zza.INTERSTITIAL
            goto L_0x00a2
        L_0x00a0:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C15016zza.BANNER
        L_0x00a2:
            r0.add(r1)
            goto L_0x004c
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjm.m28499c(android.os.Bundle):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final byte[] m28494a(boolean z, ArrayList<C15016zza> arrayList, zzg zzg, zzc zzc) {
        boolean z2 = true;
        C15017zza a = zzi.zza.m31419l().mo32342a((Iterable<? extends C15016zza>) arrayList).mo32346c(m28497b(zzk.zzli().mo30256b(this.f26710b.getContentResolver()) != 0)).mo32347d(zzk.zzli().mo30248a(this.f26710b, this.f26712d)).mo32343b(this.f26713e.mo31177b()).mo32345c(this.f26713e.mo31181d()).mo32337a(this.f26713e.mo31174a()).mo32340a(zzc).mo32339a(zzg).mo32348e(this.f26715g).mo32341a(m28497b(z)).mo32338a(zzk.zzln().mo27935b());
        if (zzk.zzli().mo30244a(this.f26710b.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zzi.zza) a.mo32344b(m28497b(z2)).mo31612g()).toByteArray();
    }

    /* renamed from: a */
    public final void mo31182a(boolean z) {
        zzbar.m26383a(this.f26711c, (zzban<? super V>) new C9690rj<Object>(this, z), zzbbm.f25065b);
    }

    static {
        SparseArray<zzc> sparseArray = new SparseArray<>();
        f26709a = sparseArray;
        sparseArray.put(DetailedState.CONNECTED.ordinal(), zzc.CONNECTED);
        f26709a.put(DetailedState.AUTHENTICATING.ordinal(), zzc.CONNECTING);
        f26709a.put(DetailedState.CONNECTING.ordinal(), zzc.CONNECTING);
        f26709a.put(DetailedState.OBTAINING_IPADDR.ordinal(), zzc.CONNECTING);
        f26709a.put(DetailedState.DISCONNECTING.ordinal(), zzc.DISCONNECTING);
        f26709a.put(DetailedState.BLOCKED.ordinal(), zzc.DISCONNECTED);
        f26709a.put(DetailedState.DISCONNECTED.ordinal(), zzc.DISCONNECTED);
        f26709a.put(DetailedState.FAILED.ordinal(), zzc.DISCONNECTED);
        f26709a.put(DetailedState.IDLE.ordinal(), zzc.DISCONNECTED);
        f26709a.put(DetailedState.SCANNING.ordinal(), zzc.DISCONNECTED);
        f26709a.put(DetailedState.SUSPENDED.ordinal(), zzc.SUSPENDED);
        if (VERSION.SDK_INT >= 17) {
            f26709a.put(DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzc.CONNECTING);
        }
        if (VERSION.SDK_INT >= 16) {
            f26709a.put(DetailedState.VERIFYING_POOR_LINK.ordinal(), zzc.CONNECTING);
        }
    }
}
