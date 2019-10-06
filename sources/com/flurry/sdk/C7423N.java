package com.flurry.sdk;

import com.flurry.sdk.C7440Q.C7441a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.N */
public class C7423N extends C7589rc {

    /* renamed from: g */
    private static final String f14551g = C7423N.class.getName();
    /* access modifiers changed from: 0000 */

    /* renamed from: h */
    public final long f14552h;
    /* access modifiers changed from: 0000 */

    /* renamed from: i */
    public final int f14553i;
    /* access modifiers changed from: 0000 */

    /* renamed from: j */
    public final int f14554j;
    /* access modifiers changed from: 0000 */

    /* renamed from: k */
    public final C7546ka f14555k;
    /* access modifiers changed from: 0000 */

    /* renamed from: l */
    public final Map<String, String> f14556l;

    /* renamed from: m */
    public ArrayList<C7440Q> f14557m = new ArrayList<>();

    /* renamed from: n */
    public C7505da f14558n;
    /* access modifiers changed from: 0000 */

    /* renamed from: o */
    public long f14559o = 30000;
    /* access modifiers changed from: 0000 */

    /* renamed from: p */
    public int f14560p;
    /* access modifiers changed from: 0000 */

    /* renamed from: q */
    public int f14561q;
    /* access modifiers changed from: 0000 */

    /* renamed from: r */
    public String f14562r;
    /* access modifiers changed from: 0000 */

    /* renamed from: s */
    public String f14563s;
    /* access modifiers changed from: 0000 */

    /* renamed from: t */
    public boolean f14564t;

    /* renamed from: com.flurry.sdk.N$a */
    public static class C7424a implements C7493ad<C7423N> {

        /* renamed from: a */
        C7488_c<C7440Q> f14565a = new C7488_c<>(new C7441a());

        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            String str;
            Map map;
            String str2;
            InputStream inputStream2 = inputStream;
            if (inputStream2 == null) {
                return null;
            }
            C7417M m = new C7417M(this, inputStream2);
            String readUTF = m.readUTF();
            String str3 = "";
            if (readUTF.equals(str3)) {
                str = null;
            } else {
                str = readUTF;
            }
            String readUTF2 = m.readUTF();
            long readLong = m.readLong();
            int readInt = m.readInt();
            long readLong2 = m.readLong();
            int readInt2 = m.readInt();
            int readInt3 = m.readInt();
            C7546ka a = C7546ka.m16708a(m.readInt());
            int readInt4 = m.readInt();
            if (readInt4 != 0) {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (i < readInt4) {
                    int i2 = readInt4;
                    hashMap.put(m.readUTF(), m.readUTF());
                    i++;
                    InputStream inputStream3 = inputStream;
                    readInt4 = i2;
                }
                map = hashMap;
            } else {
                map = null;
            }
            long readLong3 = m.readLong();
            int readInt5 = m.readInt();
            int readInt6 = m.readInt();
            String readUTF3 = m.readUTF();
            if (readUTF3.equals(str3)) {
                str2 = null;
            } else {
                str2 = readUTF3;
            }
            boolean readBoolean = m.readBoolean();
            C7423N n = new C7423N(str, readLong2, readUTF2, readLong, readInt2, readInt3, a, map, readInt5, readInt6, str2);
            n.f14559o = readLong3;
            n.f14564t = readBoolean;
            n.f15061c = readInt;
            n.f14557m = (ArrayList) this.f14565a.mo23855a(inputStream);
            n.mo23862c();
            return n;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7423N n = (C7423N) obj;
            if (outputStream != null && n != null) {
                C7410L l = new C7410L(this, outputStream);
                String str = "";
                if (n.f14563s != null) {
                    l.writeUTF(n.f14563s);
                } else {
                    l.writeUTF(str);
                }
                String str2 = n.f15063e;
                if (str2 != null) {
                    l.writeUTF(str2);
                } else {
                    l.writeUTF(str);
                }
                l.writeLong(n.f15059a);
                l.writeInt(n.f15061c);
                l.writeLong(n.f14552h);
                l.writeInt(n.f14553i);
                l.writeInt(n.f14554j);
                l.writeInt(n.f14555k.f14907f);
                Map f = n.f14556l;
                if (f != null) {
                    l.writeInt(n.f14556l.size());
                    for (String str3 : n.f14556l.keySet()) {
                        l.writeUTF(str3);
                        l.writeUTF((String) f.get(str3));
                    }
                } else {
                    l.writeInt(0);
                }
                l.writeLong(n.f14559o);
                l.writeInt(n.f14560p);
                l.writeInt(n.f14561q);
                if (n.f14562r != null) {
                    l.writeUTF(n.f14562r);
                } else {
                    l.writeUTF(str);
                }
                l.writeBoolean(n.f14564t);
                l.flush();
                this.f14565a.mo23856a(outputStream, (List<T>) n.f14557m);
            }
        }
    }

    public C7423N(String str, long j, String str2, long j2, int i, int i2, C7546ka kaVar, Map<String, String> map, int i3, int i4, String str3) {
        this.f15062d = str2;
        this.f15063e = str2;
        this.f15059a = j2;
        mo23860a();
        this.f14563s = str;
        this.f14552h = j;
        this.f15064f = i;
        this.f14553i = i;
        this.f14554j = i2;
        this.f14555k = kaVar;
        this.f14556l = map;
        this.f14560p = i3;
        this.f14561q = i4;
        this.f14562r = str3;
    }

    /* renamed from: a */
    public final void mo23860a() {
        super.mo23860a();
        if (this.f15061c != 1) {
            this.f14559o *= 3;
        }
    }

    /* renamed from: b */
    public final synchronized void mo23861b() {
        this.f14558n.mo23943c();
    }

    /* renamed from: c */
    public final void mo23862c() {
        Iterator it = this.f14557m.iterator();
        while (it.hasNext()) {
            ((C7440Q) it.next()).f14615m = this;
        }
    }
}
