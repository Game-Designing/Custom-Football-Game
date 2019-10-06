package com.bumptech.glide.load.p111b.p112a;

import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p111b.C6114l;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6136y;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.bumptech.glide.load.b.a.e */
/* compiled from: UrlLoader */
public class C6088e implements C6128u<URL, InputStream> {

    /* renamed from: a */
    private final C6128u<C6114l, InputStream> f10768a;

    /* renamed from: com.bumptech.glide.load.b.a.e$a */
    /* compiled from: UrlLoader */
    public static class C6089a implements C6130v<URL, InputStream> {
        /* renamed from: a */
        public C6128u<URL, InputStream> mo18893a(C6136y multiFactory) {
            return new C6088e(multiFactory.mo18959a(C6114l.class, InputStream.class));
        }
    }

    public C6088e(C6128u<C6114l, InputStream> glideUrlLoader) {
        this.f10768a = glideUrlLoader;
    }

    /* renamed from: a */
    public C6129a<InputStream> mo18889a(URL model, int width, int height, C6349k options) {
        return this.f10768a.mo18889a(new C6114l(model), width, height, options);
    }

    /* renamed from: a */
    public boolean mo18891a(URL model) {
        return true;
    }
}
