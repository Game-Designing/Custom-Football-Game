package com.bumptech.glide.load.p111b.p112a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.p110a.C6034b;
import com.bumptech.glide.load.p109a.p110a.C6035c;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6136y;
import com.bumptech.glide.p106g.C6000c;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a.c */
/* compiled from: MediaStoreImageThumbLoader */
public class C6084c implements C6128u<Uri, InputStream> {

    /* renamed from: a */
    private final Context f10764a;

    /* renamed from: com.bumptech.glide.load.b.a.c$a */
    /* compiled from: MediaStoreImageThumbLoader */
    public static class C6085a implements C6130v<Uri, InputStream> {

        /* renamed from: a */
        private final Context f10765a;

        public C6085a(Context context) {
            this.f10765a = context;
        }

        /* renamed from: a */
        public C6128u<Uri, InputStream> mo18893a(C6136y multiFactory) {
            return new C6084c(this.f10765a);
        }
    }

    public C6084c(Context context) {
        this.f10764a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C6129a<InputStream> mo18889a(Uri model, int width, int height, C6349k options) {
        if (C6034b.m11317a(width, height)) {
            return new C6129a<>(new C6000c(model), C6035c.m11322a(this.f10764a, model));
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo18891a(Uri model) {
        return C6034b.m11318a(model);
    }
}
