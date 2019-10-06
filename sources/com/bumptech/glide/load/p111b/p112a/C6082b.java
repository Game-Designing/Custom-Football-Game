package com.bumptech.glide.load.p111b.p112a;

import android.net.Uri;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p111b.C6114l;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6136y;
import com.mopub.common.Constants;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.a.b */
/* compiled from: HttpUriLoader */
public class C6082b implements C6128u<Uri, InputStream> {

    /* renamed from: a */
    private static final Set<String> f10762a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{Constants.HTTP, "https"})));

    /* renamed from: b */
    private final C6128u<C6114l, InputStream> f10763b;

    /* renamed from: com.bumptech.glide.load.b.a.b$a */
    /* compiled from: HttpUriLoader */
    public static class C6083a implements C6130v<Uri, InputStream> {
        /* renamed from: a */
        public C6128u<Uri, InputStream> mo18893a(C6136y multiFactory) {
            return new C6082b(multiFactory.mo18959a(C6114l.class, InputStream.class));
        }
    }

    public C6082b(C6128u<C6114l, InputStream> urlLoader) {
        this.f10763b = urlLoader;
    }

    /* renamed from: a */
    public C6129a<InputStream> mo18889a(Uri model, int width, int height, C6349k options) {
        return this.f10763b.mo18889a(new C6114l(model.toString()), width, height, options);
    }

    /* renamed from: a */
    public boolean mo18891a(Uri model) {
        return f10762a.contains(model.getScheme());
    }
}
