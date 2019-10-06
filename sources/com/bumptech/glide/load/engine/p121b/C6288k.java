package com.bumptech.glide.load.engine.p121b;

import com.bumptech.glide.p107h.p108a.C6008d.C6009a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bumptech.glide.load.engine.b.k */
/* compiled from: SafeKeyGenerator */
class C6288k implements C6009a<C6290a> {

    /* renamed from: a */
    final /* synthetic */ C6289l f11125a;

    C6288k(C6289l this$0) {
        this.f11125a = this$0;
    }

    public C6290a create() {
        try {
            return new C6290a(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
