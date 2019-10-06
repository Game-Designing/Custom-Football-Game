package com.flurry.sdk;

import android.annotation.SuppressLint;
import com.flurry.sdk.C7423N.C7424a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.sdk.da */
public final class C7505da {

    /* renamed from: a */
    private static final String f14785a = C7523ga.class.getName();

    /* renamed from: b */
    public long f14786b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f14787c = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f14788d;
    /* access modifiers changed from: 0000 */

    /* renamed from: e */
    public C7552la f14789e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14790f;
    /* access modifiers changed from: 0000 */

    /* renamed from: g */
    public int f14791g;

    /* renamed from: h */
    public String f14792h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f14793i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AtomicInteger f14794j;
    /* access modifiers changed from: 0000 */

    /* renamed from: k */
    public Map<Long, C7423N> f14795k;

    /* renamed from: com.flurry.sdk.da$a */
    public static class C7506a implements C7493ad<C7505da> {

        /* renamed from: a */
        C7488_c<C7423N> f14796a = new C7488_c<>(new C7424a());

        @SuppressLint({"UseSparseArrays"})
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            InputStream inputStream2 = inputStream;
            if (inputStream2 == null) {
                return null;
            }
            C7500ca caVar = new C7500ca(this, inputStream2);
            long readLong = caVar.readLong();
            long readLong2 = caVar.readLong();
            long readLong3 = caVar.readLong();
            C7552la a = C7552la.m16730a(caVar.readInt());
            boolean readBoolean = caVar.readBoolean();
            int readInt = caVar.readInt();
            String readUTF = caVar.readUTF();
            int readInt2 = caVar.readInt();
            int readInt3 = caVar.readInt();
            C7505da daVar = r3;
            C7505da daVar2 = new C7505da(readUTF, readBoolean, readLong, readLong3, a, null);
            daVar.f14787c = readLong2;
            daVar.f14791g = readInt;
            daVar.f14793i = readInt2;
            daVar.f14794j = new AtomicInteger(readInt3);
            C7505da daVar3 = daVar;
            List<C7423N> b = this.f14796a.mo23855a(inputStream);
            if (b != null) {
                daVar3.f14795k = new HashMap();
                for (C7423N n : b) {
                    n.f14558n = daVar3;
                    daVar3.f14795k.put(Long.valueOf(n.f14552h), n);
                }
            }
            return daVar3;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7505da daVar = (C7505da) obj;
            if (outputStream != null && daVar != null) {
                C7495ba baVar = new C7495ba(this, outputStream);
                baVar.writeLong(daVar.f14786b);
                baVar.writeLong(daVar.f14787c);
                baVar.writeLong(daVar.f14788d);
                baVar.writeInt(daVar.f14789e.f14931f);
                baVar.writeBoolean(daVar.f14790f);
                baVar.writeInt(daVar.f14791g);
                if (daVar.f14792h != null) {
                    baVar.writeUTF(daVar.f14792h);
                } else {
                    baVar.writeUTF("");
                }
                baVar.writeInt(daVar.f14793i);
                baVar.writeInt(daVar.f14794j.intValue());
                baVar.flush();
                this.f14796a.mo23856a(outputStream, daVar.mo23941a());
            }
        }
    }

    public C7505da(String str, boolean z, long j, long j2, C7552la laVar, Map<Long, C7423N> map) {
        this.f14792h = str;
        this.f14790f = z;
        this.f14786b = j;
        this.f14788d = j2;
        this.f14789e = laVar;
        this.f14795k = map;
        if (map != null) {
            for (Long l : map.keySet()) {
                ((C7423N) map.get(l)).f14558n = this;
            }
            this.f14793i = map.size();
        } else {
            this.f14793i = 0;
        }
        this.f14794j = new AtomicInteger(0);
    }

    /* renamed from: a */
    public final List<C7423N> mo23941a() {
        Map<Long, C7423N> map = this.f14795k;
        if (map != null) {
            return new ArrayList(map.values());
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public final synchronized boolean mo23942b() {
        return this.f14794j.intValue() >= this.f14793i;
    }

    /* renamed from: c */
    public final synchronized void mo23943c() {
        this.f14794j.incrementAndGet();
    }

    /* renamed from: d */
    public final byte[] mo23944d() throws IOException {
        DataOutputStream dataOutputStream;
        IOException e;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f14789e.f14931f);
                dataOutputStream.writeLong(this.f14786b);
                dataOutputStream.writeLong(this.f14788d);
                dataOutputStream.writeBoolean(this.f14790f);
                if (this.f14790f) {
                    dataOutputStream.writeShort(this.f14791g);
                    dataOutputStream.writeUTF(this.f14792h);
                }
                dataOutputStream.writeShort(this.f14795k.size());
                if (this.f14795k != null) {
                    for (Entry entry : this.f14795k.entrySet()) {
                        C7423N n = (C7423N) entry.getValue();
                        dataOutputStream.writeLong(((Long) entry.getKey()).longValue());
                        dataOutputStream.writeUTF(n.f15063e);
                        dataOutputStream.writeShort(n.f14557m.size());
                        Iterator it = n.f14557m.iterator();
                        while (it.hasNext()) {
                            C7440Q q = (C7440Q) it.next();
                            dataOutputStream.writeShort(q.f14604b);
                            dataOutputStream.writeLong(q.f14605c);
                            dataOutputStream.writeLong(q.f14606d);
                            dataOutputStream.writeBoolean(q.f14607e);
                            dataOutputStream.writeShort(q.f14608f);
                            dataOutputStream.writeShort(q.f14609g.f14652f);
                            if ((q.f14608f < 200 || q.f14608f >= 400) && q.f14610h != null) {
                                byte[] bytes = q.f14610h.getBytes();
                                dataOutputStream.writeShort(bytes.length);
                                dataOutputStream.write(bytes);
                            }
                            dataOutputStream.writeShort(q.f14611i);
                            dataOutputStream.writeInt((int) q.f14614l);
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C7354Ad.m16261a((Closeable) dataOutputStream);
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                try {
                    C7513ec.m16640a(6, f14785a, "Error when generating report", e);
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
            C7513ec.m16640a(6, f14785a, "Error when generating report", e);
            throw e;
        } catch (Throwable th2) {
            dataOutputStream = null;
            th = th2;
            C7354Ad.m16261a((Closeable) dataOutputStream);
            throw th;
        }
    }
}
