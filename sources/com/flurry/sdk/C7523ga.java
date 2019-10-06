package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.zip.CRC32;

/* renamed from: com.flurry.sdk.ga */
public class C7523ga {

    /* renamed from: a */
    public static final String f14851a = C7523ga.class.getName();

    /* renamed from: b */
    private static C7523ga f14852b = null;

    /* renamed from: c */
    public String f14853c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C7443Qb<List<C7540ja>> f14854d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<C7540ja> f14855e;

    /* renamed from: f */
    private boolean f14856f;

    private C7523ga() {
    }

    /* renamed from: a */
    public static synchronized C7523ga m16673a() {
        C7523ga gaVar;
        synchronized (C7523ga.class) {
            if (f14852b == null) {
                C7523ga gaVar2 = new C7523ga();
                f14852b = gaVar2;
                Context context = C7379Fb.m16300a().f14432d;
                StringBuilder sb = new StringBuilder(".yflurrypulselogging.");
                sb.append(Long.toString(C7354Ad.m16269f(C7379Fb.m16300a().f14436h), 16));
                gaVar2.f14854d = new C7443Qb<>(context.getFileStreamPath(sb.toString()), ".yflurrypulselogging.", 1, new C7511ea(gaVar2));
                gaVar2.f14856f = ((Boolean) C7602td.m16825a().mo24023a("UseHttps")).booleanValue();
                String str = f14851a;
                StringBuilder sb2 = new StringBuilder("initSettings, UseHttps = ");
                sb2.append(gaVar2.f14856f);
                C7513ec.m16639a(4, str, sb2.toString());
                gaVar2.f14855e = (List) gaVar2.f14854d.mo23881a();
                if (gaVar2.f14855e == null) {
                    gaVar2.f14855e = new ArrayList();
                }
            }
            gaVar = f14852b;
        }
        return gaVar;
    }

    /* renamed from: a */
    public final synchronized void mo23952a(C7505da daVar) {
        try {
            this.f14855e.add(new C7540ja(daVar.mo23944d()));
            C7513ec.m16639a(4, f14851a, "Saving persistent Pulse logging data.");
            this.f14854d.mo23882a(this.f14855e);
        } catch (IOException e) {
            C7513ec.m16639a(6, f14851a, "Error when generating pulse log report in addReport part");
        }
    }

    /* renamed from: b */
    public final synchronized void mo23953b() {
        try {
            m16675a(m16678d());
        } catch (IOException e) {
            C7513ec.m16639a(6, f14851a, "Report not send due to exception in generate data");
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [byte[], RequestObjectType] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r6v0, types: [byte[], RequestObjectType] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m16675a(byte[] r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.flurry.sdk.ob r0 = com.flurry.sdk.C7570ob.m16755a()     // Catch:{ all -> 0x0085 }
            boolean r0 = r0.f14971d     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0013
            r6 = 5
            java.lang.String r0 = f14851a     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = "Reports were not sent! No Internet connection!"
            com.flurry.sdk.C7513ec.m16639a(r6, r0, r1)     // Catch:{ all -> 0x0085 }
            monitor-exit(r5)
            return
        L_0x0013:
            if (r6 == 0) goto L_0x007b
            int r0 = r6.length     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0019
            goto L_0x007b
        L_0x0019:
            java.lang.String r0 = r5.f14853c     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r5.f14853c     // Catch:{ all -> 0x0085 }
            goto L_0x0023
        L_0x0021:
            java.lang.String r0 = "https://data.flurry.com/pcr.do"
        L_0x0023:
            r1 = 4
            java.lang.String r2 = f14851a     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = "PulseLoggingManager: start upload data "
            r3.<init>(r4)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = java.util.Arrays.toString(r6)     // Catch:{ all -> 0x0085 }
            r3.append(r4)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = " to "
            r3.append(r4)     // Catch:{ all -> 0x0085 }
            r3.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0085 }
            com.flurry.sdk.C7513ec.m16639a(r1, r2, r3)     // Catch:{ all -> 0x0085 }
            com.flurry.sdk.lc r1 = new com.flurry.sdk.lc     // Catch:{ all -> 0x0085 }
            r1.<init>()     // Catch:{ all -> 0x0085 }
            r1.f15002i = r0     // Catch:{ all -> 0x0085 }
            r0 = 100000(0x186a0, float:1.4013E-40)
            r1.f14426d = r0     // Catch:{ all -> 0x0085 }
            com.flurry.sdk.pc$a r0 = com.flurry.sdk.C7577pc.C7578a.kPost     // Catch:{ all -> 0x0085 }
            r1.f15003j = r0     // Catch:{ all -> 0x0085 }
            r0 = 1
            r1.f15008o = r0     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r2 = "application/octet-stream"
            r1.mo23988a(r0, r2)     // Catch:{ all -> 0x0085 }
            com.flurry.sdk.Vc r0 = new com.flurry.sdk.Vc     // Catch:{ all -> 0x0085 }
            r0.<init>()     // Catch:{ all -> 0x0085 }
            r1.f14937F = r0     // Catch:{ all -> 0x0085 }
            r1.f14935D = r6     // Catch:{ all -> 0x0085 }
            com.flurry.sdk.fa r6 = new com.flurry.sdk.fa     // Catch:{ all -> 0x0085 }
            r6.<init>(r5)     // Catch:{ all -> 0x0085 }
            r1.f14934C = r6     // Catch:{ all -> 0x0085 }
            com.flurry.sdk.zb r6 = com.flurry.sdk.C7633zb.m16869a()     // Catch:{ all -> 0x0085 }
            r6.mo23939a(r5, r1)     // Catch:{ all -> 0x0085 }
            monitor-exit(r5)
            return
        L_0x007b:
            r6 = 3
            java.lang.String r0 = f14851a     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = "No report need be sent"
            com.flurry.sdk.C7513ec.m16639a(r6, r0, r1)     // Catch:{ all -> 0x0085 }
            monitor-exit(r5)
            return
        L_0x0085:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7523ga.m16675a(byte[]):void");
    }

    /* renamed from: d */
    private byte[] m16678d() throws IOException {
        DataOutputStream dataOutputStream;
        IOException e;
        byte[] byteArray;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                if (this.f14855e != null) {
                    if (!this.f14855e.isEmpty()) {
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeLong(System.currentTimeMillis());
                        dataOutputStream.writeUTF(C7379Fb.m16300a().f14436h);
                        dataOutputStream.writeUTF(C7588rb.m16810a().mo24014d());
                        dataOutputStream.writeShort(C7384Gb.m16351a());
                        dataOutputStream.writeShort(3);
                        C7588rb.m16810a();
                        dataOutputStream.writeUTF(C7588rb.m16812c());
                        dataOutputStream.writeBoolean(C7517fb.m16656a().mo23950e());
                        ArrayList<C7522g> arrayList = new ArrayList<>();
                        for (Entry entry : Collections.unmodifiableMap(C7517fb.m16656a().f14832d).entrySet()) {
                            C7522g gVar = new C7522g();
                            gVar.f14849a = ((C7583qb) entry.getKey()).f15034e;
                            if (((C7583qb) entry.getKey()).f15035f) {
                                gVar.f14850b = new String((byte[]) entry.getValue());
                            } else {
                                gVar.f14850b = C7354Ad.m16259a((byte[]) entry.getValue());
                            }
                            arrayList.add(gVar);
                        }
                        dataOutputStream.writeShort(arrayList.size());
                        for (C7522g gVar2 : arrayList) {
                            dataOutputStream.writeShort(gVar2.f14849a);
                            byte[] bytes = gVar2.f14850b.getBytes();
                            dataOutputStream.writeShort(bytes.length);
                            dataOutputStream.write(bytes);
                        }
                        dataOutputStream.writeShort(6);
                        dataOutputStream.writeShort(C7387H.f14471b - 1);
                        dataOutputStream.writeUTF(Build.MODEL);
                        dataOutputStream.writeShort(C7387H.f14472c - 1);
                        dataOutputStream.writeUTF(Build.BOARD);
                        dataOutputStream.writeShort(C7387H.f14473d - 1);
                        dataOutputStream.writeUTF(Build.ID);
                        dataOutputStream.writeShort(C7387H.f14474e - 1);
                        dataOutputStream.writeUTF(Build.DEVICE);
                        dataOutputStream.writeShort(C7387H.f14475f - 1);
                        dataOutputStream.writeUTF(Build.PRODUCT);
                        dataOutputStream.writeShort(C7387H.f14476g - 1);
                        dataOutputStream.writeUTF(VERSION.RELEASE);
                        dataOutputStream.writeShort(this.f14855e.size());
                        for (C7540ja jaVar : this.f14855e) {
                            dataOutputStream.write(jaVar.f14895a);
                        }
                        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                        CRC32 crc32 = new CRC32();
                        crc32.update(byteArray2);
                        dataOutputStream.writeInt((int) crc32.getValue());
                        byteArray = byteArrayOutputStream.toByteArray();
                        C7354Ad.m16261a((Closeable) dataOutputStream);
                        return byteArray;
                    }
                }
                byteArray = byteArrayOutputStream.toByteArray();
                C7354Ad.m16261a((Closeable) dataOutputStream);
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                try {
                    C7513ec.m16640a(6, f14851a, "Error when generating report", e);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    C7354Ad.m16261a((Closeable) dataOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            dataOutputStream = null;
            e = e3;
            C7513ec.m16640a(6, f14851a, "Error when generating report", e);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
            C7354Ad.m16261a((Closeable) dataOutputStream);
            throw th;
        }
    }
}
