package com.google.zxing.p196a.p197a;

import com.google.zxing.p198b.C10208a;

/* renamed from: com.google.zxing.a.a.h */
/* compiled from: Token */
abstract class C10206h {

    /* renamed from: a */
    static final C10206h f30923a = new C10204f(null, 0, 0);

    /* renamed from: b */
    private final C10206h f30924b;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo33495a(C10208a aVar, byte[] bArr);

    C10206h(C10206h previous) {
        this.f30924b = previous;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C10206h mo33511a() {
        return this.f30924b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C10206h mo33512a(int value, int bitCount) {
        return new C10204f(this, value, bitCount);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C10206h mo33513b(int start, int byteCount) {
        return new C10200b(this, start, byteCount);
    }
}
