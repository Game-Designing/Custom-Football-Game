package com.bumptech.glide.load.p111b;

import com.bumptech.glide.load.p111b.C6091c.C6093b;
import com.bumptech.glide.load.p111b.C6091c.C6095d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.d */
/* compiled from: ByteArrayLoader */
class C6096d implements C6093b<InputStream> {

    /* renamed from: a */
    final /* synthetic */ C6095d f10773a;

    C6096d(C6095d this$0) {
        this.f10773a = this$0;
    }

    /* renamed from: a */
    public InputStream m11492a(byte[] model) {
        return new ByteArrayInputStream(model);
    }

    /* renamed from: a */
    public Class<InputStream> mo18912a() {
        return InputStream.class;
    }
}
