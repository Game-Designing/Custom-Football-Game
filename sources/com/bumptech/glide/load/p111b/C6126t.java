package com.bumptech.glide.load.p111b;

import com.bumptech.glide.load.model.ModelCache.ModelKey;
import com.bumptech.glide.p107h.C6021f;
import com.bumptech.glide.p107h.C6026k;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.b.t */
/* compiled from: ModelCache */
public class C6126t<A, B> {

    /* renamed from: a */
    private final C6021f<C6127a<A>, B> f10809a;

    /* renamed from: com.bumptech.glide.load.b.t$a */
    /* compiled from: ModelCache */
    static final class C6127a<A> {

        /* renamed from: a */
        private static final Queue<C6127a<?>> f10810a = C6026k.m11280a(0);

        /* renamed from: b */
        private int f10811b;

        /* renamed from: c */
        private int f10812c;

        /* renamed from: d */
        private A f10813d;

        /* renamed from: a */
        static <A> C6127a<A> m11567a(A model, int width, int height) {
            C6127a<A> aVar;
            synchronized (f10810a) {
                aVar = (C6127a) f10810a.poll();
            }
            if (aVar == null) {
                aVar = new C6127a<>();
            }
            aVar.m11568b(model, width, height);
            return aVar;
        }

        private C6127a() {
        }

        /* renamed from: b */
        private void m11568b(A model, int width, int height) {
            this.f10813d = model;
            this.f10812c = width;
            this.f10811b = height;
        }

        /* renamed from: a */
        public void mo18949a() {
            synchronized (f10810a) {
                f10810a.offer(this);
            }
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (!(o instanceof C6127a)) {
                return false;
            }
            ModelKey<A> other = (C6127a) o;
            if (this.f10812c == other.f10812c && this.f10811b == other.f10811b && this.f10813d.equals(other.f10813d)) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return (((this.f10811b * 31) + this.f10812c) * 31) + this.f10813d.hashCode();
        }
    }

    public C6126t(long size) {
        this.f10809a = new C6125s(this, size);
    }

    /* renamed from: a */
    public B mo18947a(A model, int width, int height) {
        ModelKey<A> key = C6127a.m11567a(model, width, height);
        B result = this.f10809a.mo18812a(key);
        key.mo18949a();
        return result;
    }

    /* renamed from: a */
    public void mo18948a(A model, int width, int height, B value) {
        this.f10809a.mo18818b(C6127a.m11567a(model, width, height), value);
    }
}
