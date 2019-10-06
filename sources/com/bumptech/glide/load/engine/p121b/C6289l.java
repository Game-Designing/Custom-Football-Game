package com.bumptech.glide.load.engine.p121b;

import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.p107h.C6021f;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.p107h.p108a.C6008d;
import com.bumptech.glide.p107h.p108a.C6008d.C6011c;
import com.bumptech.glide.p107h.p108a.C6015g;
import java.security.MessageDigest;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.b.l */
/* compiled from: SafeKeyGenerator */
public class C6289l {

    /* renamed from: a */
    private final C6021f<C6344g, String> f11126a = new C6021f<>(1000);

    /* renamed from: b */
    private final C1269m<C6290a> f11127b = C6008d.m11225b(10, new C6288k(this));

    /* renamed from: com.bumptech.glide.load.engine.b.l$a */
    /* compiled from: SafeKeyGenerator */
    private static final class C6290a implements C6011c {

        /* renamed from: a */
        final MessageDigest f11128a;

        /* renamed from: b */
        private final C6015g f11129b = C6015g.m11235a();

        C6290a(MessageDigest messageDigest) {
            this.f11128a = messageDigest;
        }

        /* renamed from: e */
        public C6015g mo18779e() {
            return this.f11129b;
        }
    }

    /* renamed from: a */
    public String mo19199a(C6344g key) {
        String safeKey;
        synchronized (this.f11126a) {
            safeKey = (String) this.f11126a.mo18812a(key);
        }
        if (safeKey == null) {
            safeKey = m12068b(key);
        }
        synchronized (this.f11126a) {
            this.f11126a.mo18818b(key, safeKey);
        }
        return safeKey;
    }

    /* renamed from: b */
    private String m12068b(C6344g key) {
        Object a = this.f11127b.mo9148a();
        C6024i.m11264a(a);
        C6290a container = (C6290a) a;
        try {
            key.updateDiskCacheKey(container.f11128a);
            return C6026k.m11277a(container.f11128a.digest());
        } finally {
            this.f11127b.mo9149a(container);
        }
    }
}
