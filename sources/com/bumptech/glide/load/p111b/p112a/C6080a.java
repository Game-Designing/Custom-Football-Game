package com.bumptech.glide.load.p111b.p112a;

import com.bumptech.glide.load.C6347j;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6052k;
import com.bumptech.glide.load.p111b.C6114l;
import com.bumptech.glide.load.p111b.C6126t;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6136y;
import com.mopub.volley.DefaultRetryPolicy;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a.a */
/* compiled from: HttpGlideUrlLoader */
public class C6080a implements C6128u<C6114l, InputStream> {

    /* renamed from: a */
    public static final C6347j<Integer> f10759a = C6347j.m12245a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS));

    /* renamed from: b */
    private final C6126t<C6114l, C6114l> f10760b;

    /* renamed from: com.bumptech.glide.load.b.a.a$a */
    /* compiled from: HttpGlideUrlLoader */
    public static class C6081a implements C6130v<C6114l, InputStream> {

        /* renamed from: a */
        private final C6126t<C6114l, C6114l> f10761a = new C6126t<>(500);

        /* renamed from: a */
        public C6128u<C6114l, InputStream> mo18893a(C6136y multiFactory) {
            return new C6080a(this.f10761a);
        }
    }

    public C6080a(C6126t<C6114l, C6114l> modelCache) {
        this.f10760b = modelCache;
    }

    /* renamed from: a */
    public C6129a<InputStream> mo18889a(C6114l model, int width, int height, C6349k options) {
        C6114l url = model;
        C6126t<C6114l, C6114l> tVar = this.f10760b;
        if (tVar != null) {
            url = (C6114l) tVar.mo18947a(model, 0, 0);
            if (url == null) {
                this.f10760b.mo18948a(model, 0, 0, model);
                url = model;
            }
        }
        return new C6129a<>(url, new C6052k(url, ((Integer) options.mo19310a(f10759a)).intValue()));
    }

    /* renamed from: a */
    public boolean mo18891a(C6114l model) {
        return true;
    }
}
