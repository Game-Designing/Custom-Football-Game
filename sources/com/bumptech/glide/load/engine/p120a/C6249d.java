package com.bumptech.glide.load.engine.p120a;

import com.bumptech.glide.load.engine.p120a.C6263m;
import com.bumptech.glide.p107h.C6026k;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.engine.a.d */
/* compiled from: BaseKeyPool */
abstract class C6249d<T extends C6263m> {

    /* renamed from: a */
    private final Queue<T> f11056a = C6026k.m11280a(20);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract T mo19144a();

    C6249d() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public T mo19147b() {
        T result = (C6263m) this.f11056a.poll();
        if (result == null) {
            return mo19144a();
        }
        return result;
    }

    /* renamed from: a */
    public void mo19146a(T key) {
        if (this.f11056a.size() < 20) {
            this.f11056a.offer(key);
        }
    }
}
