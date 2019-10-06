package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
public final class zzacy {
    @VisibleForTesting

    /* renamed from: a */
    private BlockingQueue<zzadi> f24218a = new ArrayBlockingQueue(100);
    @VisibleForTesting

    /* renamed from: b */
    private ExecutorService f24219b;
    @VisibleForTesting

    /* renamed from: c */
    private LinkedHashMap<String, String> f24220c = new LinkedHashMap<>();
    @VisibleForTesting

    /* renamed from: d */
    private Map<String, zzadc> f24221d = new HashMap();
    @VisibleForTesting

    /* renamed from: e */
    private String f24222e;
    @VisibleForTesting

    /* renamed from: f */
    private Context f24223f;
    @VisibleForTesting

    /* renamed from: g */
    private String f24224g;

    /* renamed from: h */
    private AtomicBoolean f24225h;

    /* renamed from: i */
    private File f24226i;

    /* renamed from: a */
    public final void mo29609a(Context context, String str, String str2, Map<String, String> map) {
        this.f24223f = context;
        this.f24224g = str;
        this.f24222e = str2;
        this.f24225h = new AtomicBoolean(false);
        this.f24225h.set(((Boolean) zzyt.m31536e().mo29599a(zzacu.f24095ga)).booleanValue());
        if (this.f24225h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f24226i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f24220c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f24219b = Executors.newSingleThreadExecutor();
        this.f24219b.execute(new C9722t(this));
        this.f24221d.put("action", zzadc.f24228b);
        this.f24221d.put("ad_format", zzadc.f24228b);
        this.f24221d.put("e", zzadc.f24229c);
    }

    /* renamed from: a */
    public final boolean mo29610a(zzadi zzadi) {
        return this.f24218a.offer(zzadi);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1 A[SYNTHETIC, Splitter:B:32:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af A[SYNTHETIC, Splitter:B:37:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0002 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m24791a() {
        /*
            r6 = this;
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
        L_0x0002:
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzadi> r1 = r6.f24218a     // Catch:{ InterruptedException -> 0x00cd }
            java.lang.Object r1 = r1.take()     // Catch:{ InterruptedException -> 0x00cd }
            com.google.android.gms.internal.ads.zzadi r1 = (com.google.android.gms.internal.ads.zzadi) r1     // Catch:{ InterruptedException -> 0x00cd }
            java.lang.String r2 = r1.mo29618a()     // Catch:{ InterruptedException -> 0x00cd }
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0002
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r3 = r6.f24220c
            java.util.Map r1 = r1.mo29622b()
            java.util.Map r1 = r6.mo29608a(r3, r1)
            java.lang.String r3 = r6.f24222e
            android.net.Uri r3 = android.net.Uri.parse(r3)
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0031:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x004d
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            r3.appendQueryParameter(r5, r4)
            goto L_0x0031
        L_0x004d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            android.net.Uri r3 = r3.build()
            java.lang.String r3 = r3.toString()
            r1.<init>(r3)
            java.lang.String r3 = "&it="
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.util.concurrent.atomic.AtomicBoolean r2 = r6.f24225h
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x00c1
            java.io.File r2 = r6.f24226i
            if (r2 == 0) goto L_0x00ba
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0099 }
            r5 = 1
            r4.<init>(r2, r5)     // Catch:{ IOException -> 0x0099 }
            byte[] r1 = r1.getBytes()     // Catch:{ IOException -> 0x0094, all -> 0x0091 }
            r4.write(r1)     // Catch:{ IOException -> 0x0094, all -> 0x0091 }
            r1 = 10
            r4.write(r1)     // Catch:{ IOException -> 0x0094, all -> 0x0091 }
            r4.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x0002
        L_0x008b:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26358c(r0, r1)
            goto L_0x0002
        L_0x0091:
            r1 = move-exception
            r3 = r4
            goto L_0x00ad
        L_0x0094:
            r1 = move-exception
            r3 = r4
            goto L_0x009a
        L_0x0097:
            r1 = move-exception
            goto L_0x00ad
        L_0x0099:
            r1 = move-exception
        L_0x009a:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzbad.m26358c(r2, r1)     // Catch:{ all -> 0x0097 }
            if (r3 == 0) goto L_0x00ab
            r3.close()     // Catch:{ IOException -> 0x00a5 }
            goto L_0x00ab
        L_0x00a5:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26358c(r0, r1)
            goto L_0x0002
        L_0x00ab:
            goto L_0x0002
        L_0x00ad:
            if (r3 == 0) goto L_0x00b8
            r3.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b8
        L_0x00b3:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26358c(r0, r2)
            goto L_0x00b9
        L_0x00b8:
        L_0x00b9:
            throw r1
        L_0x00ba:
            java.lang.String r1 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.ads.zzbad.m26359d(r1)
            goto L_0x0002
        L_0x00c1:
            com.google.android.gms.ads.internal.zzk.zzlg()
            android.content.Context r2 = r6.f24223f
            java.lang.String r3 = r6.f24224g
            com.google.android.gms.internal.ads.zzaxi.m26111a(r2, r3, r1)
            goto L_0x0002
        L_0x00cd:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter:reporter interrupted"
            com.google.android.gms.internal.ads.zzbad.m26358c(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacy.m24791a():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Map<String, String> mo29608a(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, mo29607a(str).mo29196a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public final zzadc mo29607a(String str) {
        zzadc zzadc = (zzadc) this.f24221d.get(str);
        return zzadc != null ? zzadc : zzadc.f24227a;
    }
}
