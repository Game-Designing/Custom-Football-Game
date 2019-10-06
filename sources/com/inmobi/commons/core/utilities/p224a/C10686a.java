package com.inmobi.commons.core.utilities.p224a;

import com.inmobi.commons.core.p221d.C10657c;

/* renamed from: com.inmobi.commons.core.utilities.a.a */
/* compiled from: EncryptionDao */
public final class C10686a {

    /* renamed from: a */
    C10657c f32610a = C10657c.m34974b("aes_key_store");

    /* renamed from: a */
    public final void mo34520a(String str) {
        this.f32610a.mo34479a("aes_public_key", str);
        this.f32610a.mo34478a("last_generated_ts", System.currentTimeMillis() / 1000);
    }
}
