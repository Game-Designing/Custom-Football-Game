package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.H */
/* compiled from: ProgressNoopOutputStream */
class C6550H extends OutputStream implements C6553K {

    /* renamed from: a */
    private final Map<GraphRequest, C6555M> f11828a = new HashMap();

    /* renamed from: b */
    private final Handler f11829b;

    /* renamed from: c */
    private GraphRequest f11830c;

    /* renamed from: d */
    private C6555M f11831d;

    /* renamed from: e */
    private int f11832e;

    C6550H(Handler callbackHandler) {
        this.f11829b = callbackHandler;
    }

    /* renamed from: a */
    public void mo19714a(GraphRequest currentRequest) {
        this.f11830c = currentRequest;
        this.f11831d = currentRequest != null ? (C6555M) this.f11828a.get(currentRequest) : null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo19713a() {
        return this.f11832e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<GraphRequest, C6555M> mo19715b() {
        return this.f11828a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo19716h(long size) {
        if (this.f11831d == null) {
            this.f11831d = new C6555M(this.f11829b, this.f11830c);
            this.f11828a.put(this.f11830c, this.f11831d);
        }
        this.f11831d.mo19728b(size);
        this.f11832e = (int) (((long) this.f11832e) + size);
    }

    public void write(byte[] buffer) {
        mo19716h((long) buffer.length);
    }

    public void write(byte[] buffer, int offset, int length) {
        mo19716h((long) length);
    }

    public void write(int oneByte) {
        mo19716h(1);
    }
}
