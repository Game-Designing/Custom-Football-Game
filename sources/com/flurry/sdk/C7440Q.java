package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.Q */
public class C7440Q {

    /* renamed from: a */
    private static final String f14603a = C7440Q.class.getName();

    /* renamed from: b */
    public int f14604b;

    /* renamed from: c */
    public long f14605c;

    /* renamed from: d */
    public long f14606d;

    /* renamed from: e */
    public boolean f14607e;

    /* renamed from: f */
    public int f14608f;

    /* renamed from: g */
    public C7450S f14609g;

    /* renamed from: h */
    public String f14610h;

    /* renamed from: i */
    public int f14611i;

    /* renamed from: j */
    public long f14612j;

    /* renamed from: k */
    public boolean f14613k;

    /* renamed from: l */
    public long f14614l = 0;

    /* renamed from: m */
    public C7423N f14615m;

    /* renamed from: com.flurry.sdk.Q$a */
    public static class C7441a implements C7493ad<C7440Q> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            InputStream inputStream2 = inputStream;
            if (inputStream2 == null) {
                return null;
            }
            C7434P p = new C7434P(this, inputStream2);
            int readInt = p.readInt();
            long readLong = p.readLong();
            long readLong2 = p.readLong();
            boolean readBoolean = p.readBoolean();
            int readInt2 = p.readInt();
            C7450S a = C7450S.m16492a(p.readInt());
            String readUTF = p.readUTF();
            int readInt3 = p.readInt();
            long readLong3 = p.readLong();
            boolean readBoolean2 = p.readBoolean();
            long j = readLong;
            long readLong4 = p.readLong();
            boolean z = readBoolean2;
            C7440Q q = new C7440Q(null, j, readLong2, readInt);
            q.f14607e = readBoolean;
            q.f14608f = readInt2;
            q.f14609g = a;
            q.f14610h = readUTF;
            q.f14611i = readInt3;
            q.f14612j = readLong3;
            q.f14613k = z;
            q.f14614l = readLong4;
            return q;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7440Q q = (C7440Q) obj;
            if (outputStream != null && q != null) {
                C7429O o = new C7429O(this, outputStream);
                o.writeInt(q.f14604b);
                o.writeLong(q.f14605c);
                o.writeLong(q.f14606d);
                o.writeBoolean(q.f14607e);
                o.writeInt(q.f14608f);
                o.writeInt(q.f14609g.f14652f);
                String str = q.f14610h;
                if (str != null) {
                    o.writeUTF(str);
                } else {
                    o.writeUTF("");
                }
                o.writeInt(q.f14611i);
                o.writeLong(q.f14612j);
                o.writeBoolean(q.f14613k);
                o.writeLong(q.f14614l);
                o.flush();
            }
        }
    }

    public C7440Q(C7423N n, long j, long j2, int i) {
        this.f14615m = n;
        this.f14605c = j;
        this.f14606d = j2;
        this.f14604b = i;
        this.f14608f = 0;
        this.f14609g = C7450S.PENDING_COMPLETION;
    }

    /* renamed from: a */
    public final void mo23880a() {
        this.f14615m.f14557m.add(this);
        if (this.f14607e) {
            this.f14615m.f14564t = true;
        }
    }
}
