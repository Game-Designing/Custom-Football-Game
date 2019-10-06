package com.bumptech.glide.load.p111b;

import android.net.Uri;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.mopub.common.Constants;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.E */
/* compiled from: UrlUriLoader */
public class C6074E<Data> implements C6128u<Uri, Data> {

    /* renamed from: a */
    private static final Set<String> f10752a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{Constants.HTTP, "https"})));

    /* renamed from: b */
    private final C6128u<C6114l, Data> f10753b;

    /* renamed from: com.bumptech.glide.load.b.E$a */
    /* compiled from: UrlUriLoader */
    public static class C6075a implements C6130v<Uri, InputStream> {
        /* renamed from: a */
        public C6128u<Uri, InputStream> mo18893a(C6136y multiFactory) {
            return new C6074E(multiFactory.mo18959a(C6114l.class, InputStream.class));
        }
    }

    public C6074E(C6128u<C6114l, Data> urlLoader) {
        this.f10753b = urlLoader;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(Uri uri, int width, int height, C6349k options) {
        return this.f10753b.mo18889a(new C6114l(uri.toString()), width, height, options);
    }

    /* renamed from: a */
    public boolean mo18891a(Uri uri) {
        return f10752a.contains(uri.getScheme());
    }
}
