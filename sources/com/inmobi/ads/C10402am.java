package com.inmobi.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.am */
/* compiled from: NativeContainerAsset */
public final class C10402am extends C10400ak implements Iterable<C10400ak> {

    /* renamed from: A */
    int f31644A;
    /* access modifiers changed from: 0000 */

    /* renamed from: B */
    public C10400ak[] f31645B;
    /* access modifiers changed from: 0000 */

    /* renamed from: C */
    public int f31646C;

    /* renamed from: z */
    long f31647z;

    /* renamed from: com.inmobi.ads.am$a */
    /* compiled from: NativeContainerAsset */
    private class C10403a implements Iterator<C10400ak> {

        /* renamed from: b */
        private int f31649b = 0;

        public final /* synthetic */ Object next() {
            C10400ak[] b = C10402am.this.f31645B;
            int i = this.f31649b;
            this.f31649b = i + 1;
            return b[i];
        }

        public C10403a() {
        }

        public final boolean hasNext() {
            return this.f31649b < C10402am.this.f31646C;
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public final Iterator<C10400ak> iterator() {
        return new C10403a();
    }

    public C10402am(String str, String str2, C10401al alVar, int i, JSONObject jSONObject, int i2) {
        this(str, str2, alVar, new LinkedList(), i, jSONObject, i2);
    }

    public C10402am(String str, String str2, C10401al alVar, List<NativeTracker> list, int i, JSONObject jSONObject, int i2) {
        super(str, str2, "CONTAINER", alVar, list);
        this.f31647z = 0;
        this.f31613f = jSONObject;
        this.f31645B = new C10400ak[1];
        this.f31616i = i;
        this.f31646C = 0;
        this.f31644A = i2;
    }

    /* renamed from: a */
    public final C10400ak mo34098a(int i) {
        if (i < 0 || i >= this.f31646C) {
            return null;
        }
        return this.f31645B[i];
    }
}
