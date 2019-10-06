package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzauq implements zzavb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static List<Future<Void>> f24832a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private static ScheduledExecutorService f24833b = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zzdsj f24834c;

    /* renamed from: d */
    private final LinkedHashMap<String, zzdsp> f24835d;

    /* renamed from: e */
    private final List<String> f24836e = new ArrayList();

    /* renamed from: f */
    private final List<String> f24837f = new ArrayList();

    /* renamed from: g */
    private final Context f24838g;

    /* renamed from: h */
    private final zzavd f24839h;

    /* renamed from: i */
    private boolean f24840i;

    /* renamed from: j */
    private final zzauy f24841j;

    /* renamed from: k */
    private final C8783Cb f24842k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f24843l = new Object();

    /* renamed from: m */
    private HashSet<String> f24844m = new HashSet<>();

    /* renamed from: n */
    private boolean f24845n = false;

    /* renamed from: o */
    private boolean f24846o = false;

    /* renamed from: p */
    private boolean f24847p = false;

    public zzauq(Context context, zzbai zzbai, zzauy zzauy, String str, zzavd zzavd) {
        Preconditions.m21858a(zzauy, (Object) "SafeBrowsing config is not present.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f24838g = context;
        this.f24835d = new LinkedHashMap<>();
        this.f24839h = zzavd;
        this.f24841j = zzauy;
        for (String lowerCase : this.f24841j.f24853e) {
            this.f24844m.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.f24844m.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzdsj zzdsj = new zzdsj();
        zzdsj.f28212c = Integer.valueOf(8);
        zzdsj.f28214e = str;
        zzdsj.f28215f = str;
        zzdsj.f28217h = new zzdsk();
        zzdsj.f28217h.f28230c = this.f24841j.f24849a;
        zzdsq zzdsq = new zzdsq();
        zzdsq.f28252c = zzbai.f25057a;
        zzdsq.f28254e = Boolean.valueOf(Wrappers.m22139a(this.f24838g).mo27945a());
        long b = (long) GoogleApiAvailabilityLight.getInstance().mo27314b(this.f24838g);
        if (b > 0) {
            zzdsq.f28253d = Long.valueOf(b);
        }
        zzdsj.f28227r = zzdsq;
        this.f24834c = zzdsj;
        this.f24842k = new C8783Cb(this.f24838g, this.f24841j.f24856h, this);
    }

    /* renamed from: d */
    public final zzauy mo30112d() {
        return this.f24841j;
    }

    /* renamed from: a */
    public final void mo30105a(String str) {
        synchronized (this.f24843l) {
            this.f24834c.f28219j = str;
        }
    }

    /* renamed from: c */
    public final boolean mo30111c() {
        return PlatformVersion.m22112f() && this.f24841j.f24851c && !this.f24846o;
    }

    /* renamed from: a */
    public final void mo30104a(View view) {
        if (this.f24841j.f24851c && !this.f24846o) {
            zzk.zzlg();
            Bitmap b = zzaxi.m26120b(view);
            if (b == null) {
                zzava.m25883a("Failed to capture the webview bitmap.");
                return;
            }
            this.f24846o = true;
            zzaxi.m26113a((Runnable) new C9850zb(this, b));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30106a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f24843l
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.f24847p = r2     // Catch:{ all -> 0x00c7 }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r2 = r6.f24835d     // Catch:{ all -> 0x00c7 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00c7 }
            if (r2 == 0) goto L_0x0023
            if (r9 != r1) goto L_0x0021
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r8 = r6.f24835d     // Catch:{ all -> 0x00c7 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzdsp r7 = (com.google.android.gms.internal.ads.zzdsp) r7     // Catch:{ all -> 0x00c7 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00c7 }
            r7.f28250k = r8     // Catch:{ all -> 0x00c7 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x0023:
            com.google.android.gms.internal.ads.zzdsp r1 = new com.google.android.gms.internal.ads.zzdsp     // Catch:{ all -> 0x00c7 }
            r1.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00c7 }
            r1.f28250k = r9     // Catch:{ all -> 0x00c7 }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r9 = r6.f24835d     // Catch:{ all -> 0x00c7 }
            int r9 = r9.size()     // Catch:{ all -> 0x00c7 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00c7 }
            r1.f28243d = r9     // Catch:{ all -> 0x00c7 }
            r1.f28244e = r7     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzdsm r9 = new com.google.android.gms.internal.ads.zzdsm     // Catch:{ all -> 0x00c7 }
            r9.<init>()     // Catch:{ all -> 0x00c7 }
            r1.f28245f = r9     // Catch:{ all -> 0x00c7 }
            java.util.HashSet<java.lang.String> r9 = r6.f24844m     // Catch:{ all -> 0x00c7 }
            int r9 = r9.size()     // Catch:{ all -> 0x00c7 }
            if (r9 <= 0) goto L_0x00c0
            if (r8 == 0) goto L_0x00c0
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00c7 }
            r9.<init>()     // Catch:{ all -> 0x00c7 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00c7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00c7 }
        L_0x005a:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00c7 }
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00c7 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00c7 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            if (r3 == 0) goto L_0x0073
            java.lang.Object r3 = r2.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            goto L_0x0075
        L_0x0073:
            java.lang.String r3 = ""
        L_0x0075:
            java.lang.Object r4 = r2.getValue()     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            if (r4 == 0) goto L_0x0082
            java.lang.Object r2 = r2.getValue()     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            goto L_0x0084
        L_0x0082:
            java.lang.String r2 = ""
        L_0x0084:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            java.util.HashSet<java.lang.String> r5 = r6.f24844m     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            boolean r4 = r5.contains(r4)     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            if (r4 != 0) goto L_0x0093
            goto L_0x005a
        L_0x0093:
            com.google.android.gms.internal.ads.zzdsl r4 = new com.google.android.gms.internal.ads.zzdsl     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            java.lang.String r5 = "UTF-8"
            byte[] r3 = r3.getBytes(r5)     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            r4.f28232d = r3     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            java.lang.String r3 = "UTF-8"
            byte[] r2 = r2.getBytes(r3)     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            r4.f28233e = r2     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            r9.add(r4)     // Catch:{ UnsupportedEncodingException -> 0x00ac }
            goto L_0x005a
        L_0x00ac:
            r2 = move-exception
            java.lang.String r2 = "Cannot convert string to bytes, skip header."
            com.google.android.gms.internal.ads.zzava.m25883a(r2)     // Catch:{ all -> 0x00c7 }
            goto L_0x005a
        L_0x00b3:
            int r8 = r9.size()     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzdsl[] r8 = new com.google.android.gms.internal.ads.zzdsl[r8]     // Catch:{ all -> 0x00c7 }
            r9.toArray(r8)     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzdsm r9 = r1.f28245f     // Catch:{ all -> 0x00c7 }
            r9.f28235d = r8     // Catch:{ all -> 0x00c7 }
        L_0x00c0:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r8 = r6.f24835d     // Catch:{ all -> 0x00c7 }
            r8.put(r7, r1)     // Catch:{ all -> 0x00c7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x00c7:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            goto L_0x00cb
        L_0x00ca:
            throw r7
        L_0x00cb:
            goto L_0x00ca
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauq.mo30106a(java.lang.String, java.util.Map, int):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo30109b(String str) {
        synchronized (this.f24843l) {
            this.f24836e.add(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo30110c(String str) {
        synchronized (this.f24843l) {
            this.f24837f.add(str);
        }
    }

    /* renamed from: a */
    public final String[] mo30107a(String[] strArr) {
        return (String[]) this.f24842k.mo28069a(strArr).toArray(new String[0]);
    }

    /* renamed from: b */
    public final void mo30108b() {
        this.f24845n = true;
    }

    /* renamed from: e */
    private final zzdsp m25866e(String str) {
        zzdsp zzdsp;
        synchronized (this.f24843l) {
            zzdsp = (zzdsp) this.f24835d.get(str);
        }
        return zzdsp;
    }

    /* renamed from: a */
    public final void mo30103a() {
        synchronized (this.f24843l) {
            zzbbh a = zzbar.m26379a(this.f24839h.mo30113a(this.f24838g, this.f24835d.keySet()), (zzbal<? super A, ? extends B>) new C9808xb<Object,Object>(this), zzbbm.f25065b);
            zzbbh a2 = zzbar.m26378a(a, 10, TimeUnit.SECONDS, f24833b);
            zzbar.m26383a(a, (zzban<? super V>) new C8741Ab<Object>(this, a2), zzbbm.f25065b);
            f24832a.add(a2);
        }
    }

    /* renamed from: f */
    private final zzbbh<Void> m25868f() {
        zzbbh<Void> a;
        zzdsp[] zzdspArr;
        if (!((this.f24840i && this.f24841j.f24855g) || (this.f24847p && this.f24841j.f24854f) || (!this.f24840i && this.f24841j.f24852d))) {
            return zzbar.m26376a(null);
        }
        synchronized (this.f24843l) {
            this.f24834c.f28218i = new zzdsp[this.f24835d.size()];
            this.f24835d.values().toArray(this.f24834c.f28218i);
            this.f24834c.f28228s = (String[]) this.f24836e.toArray(new String[0]);
            this.f24834c.f28229t = (String[]) this.f24837f.toArray(new String[0]);
            if (zzava.m25884a()) {
                String str = this.f24834c.f28214e;
                String str2 = this.f24834c.f28219j;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzdsp zzdsp : this.f24834c.f28218i) {
                    sb2.append("    [");
                    sb2.append(zzdsp.f28251l.length);
                    sb2.append("] ");
                    sb2.append(zzdsp.f28244e);
                }
                zzava.m25883a(sb2.toString());
            }
            zzbbh a2 = new zzayu(this.f24838g).mo30294a(1, this.f24841j.f24850b, null, zzdrw.m30019a((zzdrw) this.f24834c));
            if (zzava.m25884a()) {
                a2.mo28811a(new C8762Bb(this), zzaxg.f24958a);
            }
            a = zzbar.m26380a(a2, C9829yb.f23514a, zzbbm.f25065b);
        }
        return a;
    }

    /* renamed from: d */
    static final /* synthetic */ Void m25865d(String str) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo30102a(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.f24843l) {
                            int length = optJSONArray.length();
                            zzdsp e = m25866e(str);
                            if (e == null) {
                                String str2 = "Cannot find the corresponding resource object for ";
                                String valueOf = String.valueOf(str);
                                zzava.m25883a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                            } else {
                                e.f28251l = new String[length];
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    e.f28251l[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                boolean z2 = this.f24840i;
                                if (length > 0) {
                                    z = true;
                                }
                                this.f24840i = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24140nd)).booleanValue()) {
                    zzbad.m26353a("Failed to get SafeBrowsing metadata", e2);
                }
                return zzbar.m26375a((Throwable) new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.f24840i) {
            synchronized (this.f24843l) {
                this.f24834c.f28212c = Integer.valueOf(9);
            }
        }
        return m25868f();
    }
}
