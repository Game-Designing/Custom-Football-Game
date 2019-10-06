package com.facebook;

import android.os.Handler;
import com.facebook.C6814y.C6815a;
import com.facebook.C6814y.C6816b;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* renamed from: com.facebook.J */
/* compiled from: ProgressOutputStream */
class C6552J extends FilterOutputStream implements C6553K {

    /* renamed from: a */
    private final Map<GraphRequest, C6555M> f11835a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C6814y f11836b;

    /* renamed from: c */
    private final long f11837c = C6787r.m13825o();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f11838d;

    /* renamed from: e */
    private long f11839e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f11840f;

    /* renamed from: g */
    private C6555M f11841g;

    C6552J(OutputStream out, C6814y requests, Map<GraphRequest, C6555M> progressMap, long maxProgress) {
        super(out);
        this.f11836b = requests;
        this.f11835a = progressMap;
        this.f11840f = maxProgress;
    }

    /* renamed from: h */
    private void m12959h(long size) {
        C6555M m = this.f11841g;
        if (m != null) {
            m.mo19727a(size);
        }
        this.f11838d += size;
        long j = this.f11838d;
        if (j >= this.f11839e + this.f11837c || j >= this.f11840f) {
            m12956a();
        }
    }

    /* renamed from: a */
    private void m12956a() {
        if (this.f11838d > this.f11839e) {
            for (C6815a callback : this.f11836b.mo20218g()) {
                if (callback instanceof C6816b) {
                    Handler callbackHandler = this.f11836b.mo20217f();
                    C6816b progressCallback = (C6816b) callback;
                    if (callbackHandler == null) {
                        progressCallback.mo20226a(this.f11836b, this.f11838d, this.f11840f);
                    } else {
                        callbackHandler.post(new C6551I(this, progressCallback));
                    }
                }
            }
            this.f11839e = this.f11838d;
        }
    }

    /* renamed from: a */
    public void mo19714a(GraphRequest request) {
        this.f11841g = request != null ? (C6555M) this.f11835a.get(request) : null;
    }

    public void write(byte[] buffer) throws IOException {
        this.out.write(buffer);
        m12959h((long) buffer.length);
    }

    public void write(byte[] buffer, int offset, int length) throws IOException {
        this.out.write(buffer, offset, length);
        m12959h((long) length);
    }

    public void write(int oneByte) throws IOException {
        this.out.write(oneByte);
        m12959h(1);
    }

    public void close() throws IOException {
        super.close();
        for (C6555M p : this.f11835a.values()) {
            p.mo19726a();
        }
        m12956a();
    }
}
